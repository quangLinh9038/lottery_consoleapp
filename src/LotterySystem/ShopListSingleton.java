package LotterySystem;


import java.util.ArrayList;
import java.util.List;


public class ShopListSingleton implements ShopManager {


    private List<Shop> shops = new ArrayList<>();

    //singleton pattern
    private static ShopListSingleton instance = new ShopListSingleton();

    public ShopListSingleton(){}


    //getter
    public List<Shop> getShops() {
        return this.shops;
    }

    public static ShopListSingleton getInstance() {
        return instance;
    }



    // method implemented from Manager
    @Override
    public void add(Shop shop) {
        this.shops.add(shop);
    }

    @Override
    public void edit(Shop shop) {

        for (Shop s : shops) {
            if (s.getCode() == shop.getCode()){
                s.setCode(shop.getCode());
                s.setAddress(shop.getAddress());
                s.setOwner(shop.getOwner());
                s.setPhone(shop.getPhone());
                s.setEmail(shop.getEmail());
                s.setAccountBalance(shop.getAccountBalance());
            }
        }
    }



    @Override
    public void delete(int code) {
        this.shops.remove(get(code));
    }


    @Override
    public List<Shop> viewList() {
        return this.shops;
    }

    @Override
    public Shop get(int code) {
        for(Shop s: shops){
            if(s.getCode() == code) return s;
        }
        return null;
    }



}







