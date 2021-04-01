package LotterySystem;

import java.util.List;

public interface ShopManager {

    void add(Shop shop);
    void edit (Shop shop);
    void delete(int code);
    List<Shop>viewList();
    Shop get(int code);
}
