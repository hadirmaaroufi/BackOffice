package tn.esprit.pidev.bns.serviceInterface.hadir;

import tn.esprit.pidev.bns.entity.hadir.ConversionCurrency;
import tn.esprit.pidev.bns.entity.hadir.Currency;
import tn.esprit.pidev.bns.entity.hadir.Product;

import java.util.List;
import java.util.Optional;

public interface IProductService {
    public List<Product> retrieveAllProducts();

    public boolean updateProduct(Product product);

    public Product addProduct(Product product, Integer idCategorie);

    //Currency currencyConverter(Currency currencyRequest, Currency currencyResponse);
    public List<Currency> getAllCurrencies();
    public Optional<Double> convert(ConversionCurrency conversionCurrency);


    public Product retrieveProduct(Integer idProduct);

    public boolean removeProduct(Integer idProduct);
    // public  void affcterProductToShop(Integer idShop, Integer idProduct);
}
