package tn.esprit.pidev.bns.serviceInterface.hadir;

import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import tn.esprit.pidev.bns.entity.hadir.Category;
import tn.esprit.pidev.bns.entity.hadir.Shop;
import tn.esprit.pidev.bns.entity.hadir.Tva;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public interface IShopService {
    public List<Shop> retrieveAllShops();

    public boolean updateShop (Shop  shop);

    public  Shop addShop (Shop shop);

    public Shop retrieveShop (Integer  idShop);

    public  boolean removeShop(Integer idShop);
    public Shop affecterProductToShop(Integer idShop, List<Integer> idProduct);
    public List<String> getLocation(String address) throws IOException, JSONException;
    public double beneficeBrut(int idS);
    public Tva addTva (Tva tva);
    public double tauxTVA(int idS);
    public double valeurbeneficeApresTva(int idS);
    public Shop shopRentable();
    public Shop shopMRentable();
    public Map<String, Double> getShopStatistics();
}
