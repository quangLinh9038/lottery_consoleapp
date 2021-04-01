package LotterySystem;

import java.util.ArrayList;
import java.util.List;

public class CustomerListSingleton implements CustomerManager {

    private List<Customer> customers = new ArrayList<>();


    //singleton pattern
    private static CustomerListSingleton instance = new CustomerListSingleton();


    public CustomerListSingleton(){}

    public static CustomerListSingleton getInstance() {
        return instance;
    }

    public static void setInstance(CustomerListSingleton instance) {
        CustomerListSingleton.instance = instance;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }


    // name, birth of date, address, phone, email

    @Override
    public void add(Customer customer) {
        this.customers.add(customer);
    }

    @Override
    public void edit(Customer customer) {
        for (Customer c : customers) {
            if (c.getName() == customer.getName()){
                c.setName(customer.getName());
                c.setBirthday(customer.getBirthday());
                c.setAddress(customer.getAddress());
                c.setPhone(customer.getPhone());
                c.setEmail(customer.getEmail());

            }
        }
    }

    @Override
    public void delete(String name) {
        this.customers.remove(get(name));
    }

    @Override
    public List<Customer> viewList() {
        return this.customers;
    }

    @Override
    public Customer get(String name) {
        for(Customer c : customers){
            if(c.getName() == name) return c;
        }
        return null;
    }
}
