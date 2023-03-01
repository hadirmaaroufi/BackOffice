package tn.esprit.pidev.bns.controller.hadir;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import tn.esprit.pidev.bns.entity.hadir.*;
import tn.esprit.pidev.bns.serviceInterface.hadir.IProductService;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/Product")
public class ProductController {
    IProductService productService;

    @GetMapping("/retrieve-all-Products")
    public List<Product> getProducts() {
        List<Product> listProducts = productService.retrieveAllProducts();
        return listProducts;
    }

    @GetMapping("/retrieve-Shop/{product-id}")
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

    /*@PostMapping("/currency")
    public Currency convertCurrency(@RequestBody CurrencyRequest currency) {
        return productService.currencyConverter(
                new Currency(currency.getCurrencyLabelInput(),currency.getCurrencyValueInput()),
                new Currency(currency.getCurrencyLabelOutput(),currency.getCurrencyValueOutput()));
    }*/

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


}
