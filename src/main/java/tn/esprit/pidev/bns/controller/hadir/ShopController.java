package tn.esprit.pidev.bns.controller.hadir;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import tn.esprit.pidev.bns.entity.hadir.Category;
import tn.esprit.pidev.bns.entity.hadir.Shop;
import tn.esprit.pidev.bns.serviceInterface.hadir.IShopService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/Shop")
public class ShopController {
    IShopService shopService;
    @GetMapping("/retrieve-all-Shops")
    public List<Shop> getShops() {
        List<Shop> listShops = shopService.retrieveAllShops();
        return listShops;
    }
    @GetMapping("/retrieve-Shop/{Shop-id}")
    public Shop retrieveShop(@PathVariable("Shop-id") Integer shopId) {
        return shopService.retrieveShop(shopId);
    }
    @PostMapping("/add-Shop")
    public Shop addShop(@RequestBody Shop s) {
        Shop shop = shopService.addShop(s);
        return shop;
    }
    @DeleteMapping("/remove-Shop/{Shop-id}")
    public void removeShop(@PathVariable("Shop-id") Integer idShop) {
        shopService.removeShop(idShop);
    }
    @PutMapping("/update-Shop")
    public boolean updateShop(@RequestBody Shop s) {
        return shopService.updateShop(s);
    }
    @PutMapping("/{idBoutique}/produits")
    public Shop affecterProduitsABoutique(@PathVariable Integer idBoutique, @RequestBody List<Integer> idProduits) {
        return shopService.affecterProductToShop(idBoutique, idProduits);
    }
}

