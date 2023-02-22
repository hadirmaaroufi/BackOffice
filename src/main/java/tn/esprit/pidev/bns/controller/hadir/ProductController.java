package tn.esprit.pidev.bns.controller.hadir;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.pidev.bns.entity.hadir.Product;
import tn.esprit.pidev.bns.entity.hadir.Shop;
import tn.esprit.pidev.bns.serviceInterface.hadir.IProductService;

import java.util.List;

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
    public Product addProduct(@RequestBody Product product,@PathVariable Integer idCategorie) {

        Product p= productService.addProduct(product,idCategorie);
        return p;
    }
    @DeleteMapping("/remove-Product/{Product-id}")
    public void removeProduct(@PathVariable("Product-id") Integer idProduct)
    {
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
}
