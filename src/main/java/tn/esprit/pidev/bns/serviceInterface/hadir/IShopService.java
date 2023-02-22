package tn.esprit.pidev.bns.serviceInterface.hadir;

import tn.esprit.pidev.bns.entity.hadir.Category;
import tn.esprit.pidev.bns.entity.hadir.Shop;

import java.util.List;

public interface IShopService {
    public List<Shop> retrieveAllShops();

    public boolean updateShop (Shop  shop);

    public  Shop addShop (Shop shop);

    public Shop retrieveShop (Integer  idShop);

    public  boolean removeShop(Integer idShop);
    public Shop affecterProductToShop(Integer idShop, List<Integer> idProduct);
}
