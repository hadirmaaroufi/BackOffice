package tn.esprit.pidev.bns.serviceInterface.hadir;

import tn.esprit.pidev.bns.entity.hadir.Product;
import tn.esprit.pidev.bns.entity.hadir.Shop;

import java.util.List;

public interface IProductService {
    public List<Product> retrieveAllProducts();

    public boolean updateProduct (Product product);

    public  Product addProduct (Product product,Integer idCategorie);

    public Product retrieveProduct (Integer  idProduct);

    public  boolean removeProduct(Integer idProduct);
   // public  void affcterProductToShop(Integer idShop, Integer idProduct);
}
