package tn.esprit.pidev.bns.service.hadir;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;
import tn.esprit.pidev.bns.client.ExchangeRateClient;
import tn.esprit.pidev.bns.client.Rates;
import tn.esprit.pidev.bns.entity.hadir.*;
import tn.esprit.pidev.bns.repository.hadir.CategorieRep;
import tn.esprit.pidev.bns.repository.hadir.CurrencyRepository;
import tn.esprit.pidev.bns.repository.hadir.ProductRep;
import tn.esprit.pidev.bns.repository.hadir.ShopRep;
import tn.esprit.pidev.bns.serviceInterface.hadir.IProductService;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService implements IProductService {
    @Autowired
    ProductRep productRep;
    @Autowired
    CategorieRep categorieRep;
    @Autowired
    ShopRep shopRep;

    @Autowired
    ExchangeRateClient exchangeRateClient;
    @Autowired
    CurrencyRepository currencyRepository;

    @Override
    public List<Product> retrieveAllProducts() {
        return (List<Product>) productRep.findAll();
    }

    @Override
    public boolean updateProduct(Product product) {
        if (productRep.existsById(product.getIdProduct())) {
            productRep.save(product);
            return true;
        }
        return false;
    }

    @Override
    public Product addProduct(Product product, Integer idCategorie) {
        Category category = categorieRep.findById(idCategorie).orElseThrow(() -> new NotFoundException("Catégorie non trouvée"));
        category.getProducts();
        product.setCategory(category);

        categorieRep.save(category);
        return productRep.save(product);
    }

    @Override
    public List<Currency> getAllCurrencies() {
        List<Currency> currencyList = this.currencyRepository.findAll();
        currencyList.sort(Comparator.comparing(Currency::getLabel));
        return currencyList;
    }

    @Override
    public Optional<Double> convert(ConversionCurrency conversionCurrency) {
        Optional<Currency> toOptional = this.currencyRepository.findByLabel(conversionCurrency.getTo().toUpperCase());
        Optional<Currency> fromOptional = this.currencyRepository.findByLabel(conversionCurrency.getFrom().toUpperCase());

        if(toOptional.isPresent() && fromOptional.isPresent()) {

            if(conversionCurrency.getValue() < 0) {
                return Optional.empty();
            }

            Currency to = toOptional.get();
            Currency from = fromOptional.get();
            Double toValue = to.getValueInEuros();
            Double fromValue = from.getValueInEuros();

            Double result = toValue * conversionCurrency.getValue() / fromValue;

            return Optional.of(result);

        }

        return Optional.empty();
    }

    /*@Override
    public Currency currencyConverter(Currency currencyRequest, Currency currencyResponse) {
        Rates rates = exchangeRateClient.getCurrencyResponse();
        rates.getRates().get(currencyRequest.getLabel());


        Currency currencyOutput = new Currency();


        return null;
    }*/

    @Override
    public Product retrieveProduct(Integer idProduct) {
        return productRep.findById(idProduct).orElse(null);
    }

    @Override
    public boolean removeProduct(Integer idProduct) {
        if (productRep.existsById(idProduct)) {
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
