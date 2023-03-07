package tn.esprit.pidev.bns.controller.hadir;

import com.fasterxml.jackson.core.JsonParser;
import com.maxmind.geoip2.DatabaseReader;
import com.maxmind.geoip2.exception.GeoIp2Exception;
import com.maxmind.geoip2.model.CityResponse;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jackson.JsonObjectDeserializer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;
import tn.esprit.pidev.bns.entity.hadir.*;
import tn.esprit.pidev.bns.entity.hadir.Currency;
import tn.esprit.pidev.bns.repository.hadir.ProductRep;
import tn.esprit.pidev.bns.serviceInterface.hadir.IProductService;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.URL;
import java.net.URLConnection;
import java.net.UnknownHostException;
import java.nio.charset.StandardCharsets;
import java.util.*;

@RestController
@AllArgsConstructor
@RequestMapping("/Product")
public class ProductController {
    IProductService productService;
    @Autowired
    ProductRep productRep;

    @GetMapping("/retrieve-all-Products")
    public List<Product> getProducts(@RequestParam(name = "currency", required = false)String currency,HttpServletRequest request) throws IOException, GeoIp2Exception {
        Map<String, String> location = productService.getClientLocation(request);
        String DeviseLoc = location.get("DeviseLoc");
        List<Product> listProducts = productService.retrieveAllProducts();
        if (currency != null) {
            for(Product product : listProducts) {
                ConversionCurrency convCurr = new ConversionCurrency();
                convCurr.setFrom(DeviseLoc);
                convCurr.setTo(currency);
                convCurr.setValue(product.getPrice());
                product.setPrice(convertCurrencies(convCurr).getBody());
            }
        }
        return listProducts;
    }

    @GetMapping("/retrieve-Product/{product-id}")
    public Product retrieveProduct(@PathVariable("Product-id") Integer productId) {
        return productService.retrieveProduct(productId);
    }

    @PostMapping("/add-product/{idCategorie}")
    public Product addProduct(@RequestParam("name") String name,
                              @RequestParam("description") String description,
                              @RequestParam("price") int price,
                              @RequestParam("stock") int stock,
                              @PathVariable Integer idCategorie,
                              @RequestParam("image") MultipartFile image) throws IOException {

        Product product = new Product();
        product.setName(name);
        product.setDescription(description);
        product.setPrice(price);
        product.setStock(stock);

        // Enregistrer l'image dans l'objet de produit
        product.setImage(image.getBytes());
        Product p = productService.addProduct(product, idCategorie);
        return p;
    }

    @DeleteMapping("/remove-Product/{Product-id}")
    public void removeProduct(@PathVariable("Product-id") Integer idProduct) {
        productService.removeProduct(idProduct);
    }

    @PutMapping("/update-Product")
    public boolean updateProduct(@RequestBody Product product) {
        return productService.updateProduct(product);
    }
   /* @PostMapping("/{idCategorie}/produits/{idProduit}")
    public void affecterProduitACategorie(@PathVariable Integer idCategorie, @PathVariable Integer idProduit) {
        productService.affcterProduitACategorie(idCategorie, idProduit);
    }*/

    @RequestMapping(value = "/currency-converter", produces = { "application/json" }, method = RequestMethod.POST)
    public ResponseEntity<Double> convertCurrencies(@RequestBody ConversionCurrency conversionCurrency) {
        Optional<Double> resultOptional = this.productService.convert(conversionCurrency);
        if (resultOptional.isPresent()) {
            return new ResponseEntity<>(resultOptional.get(), HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
    @RequestMapping(value = "/currencies", produces = { "application/json" }, method = RequestMethod.GET)
    public ResponseEntity<List<Currency>> getAllCurrencies() {
        return new ResponseEntity<>(this.productService.getAllCurrencies(), HttpStatus.OK);
    }
    @PutMapping("/promotion/{id}/{pourcentage}")
    @ResponseBody
    public void promotion(@PathVariable("id") Integer id, @PathVariable("pourcentage") int pourcentage) {
        Product productpromotion = productService.retrieveProduct(id);
        double price = (double) productpromotion.getPrice();
        double newprice= price*(100-pourcentage)/100;
        productpromotion.setPrice(newprice);
        productService.updateProduct(productpromotion);
    }
    @GetMapping("/client-location")
    public Map<String, String> getClientLocation(HttpServletRequest request) throws IOException, GeoIp2Exception {

        return productService.getClientLocation(request);
    }


}
