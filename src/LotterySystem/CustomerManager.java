package LotterySystem;

import java.util.List;

public interface CustomerManager {
    void add(Customer customer);
    void edit (Customer customer);
    void delete(String name);
    List<Customer> viewList();
    Customer get(String name);
}


