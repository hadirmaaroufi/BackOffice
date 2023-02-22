package tn.esprit.pidev.bns.service.hadir;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;
import tn.esprit.pidev.bns.entity.hadir.Category;
import tn.esprit.pidev.bns.entity.hadir.Product;
import tn.esprit.pidev.bns.entity.hadir.Shop;
import tn.esprit.pidev.bns.repository.hadir.CategorieRep;
import tn.esprit.pidev.bns.repository.hadir.ProductRep;
import tn.esprit.pidev.bns.repository.hadir.ShopRep;
import tn.esprit.pidev.bns.serviceInterface.hadir.IProductService;

import java.util.List;

@Service
public class ProductService implements IProductService {
    @Autowired
    ProductRep productRep;
    @Autowired
    CategorieRep categorieRep;
    @Autowired
    ShopRep shopRep;
    @Override
    public List<Product> retrieveAllProducts() {
        return (List<Product>) productRep.findAll();
    }

    @Override
    public boolean updateProduct(Product product) {
        if(productRep.existsById(product.getIdProduct())){
            productRep.save(product);
            return true;
        }
        return false;
    }

    @Override
    public Product addProduct(Product product ,Integer idCategorie) {
        Category category = categorieRep.findById(idCategorie).orElseThrow(() -> new NotFoundException("Catégorie non trouvée"));
        category.getProducts();
        product.setCategory(category);

        categorieRep.save(category);
        return productRep.save(product);
    }

    @Override
    public Product retrieveProduct(Integer idProduct) {
        return productRep.findById(idProduct).orElse(null);
    }

    @Override
    public boolean removeProduct(Integer idProduct) {
        if (productRep.existsById(idProduct)){
             productRep.deleteById(idProduct);
             return true;
        }
        return false;
    }



    /*@Override
    public void affcterProduitACategorie(Integer idCategorie, Integer idProduct) {
        Category category = categorieRep.findById(idCategorie)
                .orElseThrow(() -> new NotFoundException("Catégorie non trouvée"));

        Product product = productRep.findById(idProduct)
                .orElseThrow(() -> new NotFoundException("Produit non trouvé"));

        category.getProducts().add(product);
        product.setCategory(category);

        categorieRep.save(category);
        productRep.save(product);
    }*/

}
