package tn.esprit.pidev.bns.service.hadir;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.pidev.bns.entity.hadir.Category;
import tn.esprit.pidev.bns.entity.hadir.Product;
import tn.esprit.pidev.bns.entity.hadir.Shop;
import tn.esprit.pidev.bns.repository.hadir.ProductRep;
import tn.esprit.pidev.bns.repository.hadir.ShopRep;
import tn.esprit.pidev.bns.serviceInterface.hadir.IShopService;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Set;

@Service
public class ShopService implements IShopService {
    @Autowired
    ShopRep shopRep;
    @Autowired
    ProductRep productRep;
    @Override
    public List<Shop> retrieveAllShops() {
        return (List<Shop>) shopRep.findAll();
    }

    @Override
    public boolean updateShop(Shop shop) {
        if(shopRep.existsById(shop.getIdShop())){
            shopRep.save(shop);
            return true;
        }
        return false;
    }

    @Override
    public Shop addShop(Shop shop) {
        return shopRep.save(shop);
    }

    @Override
    public Shop retrieveShop(Integer idShop) {
        return shopRep.findById(idShop).orElse(null);
    }

    @Override
    public boolean removeShop(Integer idShop) {
        if(shopRep.existsById(idShop)) {
            shopRep.deleteById(idShop);
            return true;
        }
        return false;
    }

    @Override
    public Shop affecterProductToShop(Integer idShop, List<Integer> idProduct) {
        Shop shop = shopRep.findById(idShop).orElseThrow(() -> new EntityNotFoundException("shop non trouvée"));
        List<Product> products = productRep.findAllById(idProduct);
        shop.getProducts().addAll(products); // Ajoute les nouveaux produits à la liste existante
        shopRep.save(shop);
        return shop;

    }
}
