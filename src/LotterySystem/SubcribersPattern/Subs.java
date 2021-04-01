package LotterySystem.SubcribersPattern;
import LotterySystem.Customer;

import java.util.ArrayList;
import java.util.List;

public class Subs {
    private String result;

    public String getResult() {
        return result;
    }

    private List<Customer> subscriber = new ArrayList<>();

    public List<Customer> getSubscriber() {
        return subscriber;
    }

    public void setSubscriber(List<Customer> subscriber) {
        this.subscriber = subscriber;
    }

    public void setResult(String result) {
        this.result = result;
        for(Customer customer: subscriber)
        {
            System.out.println("Hello customer: "+ customer+ " you subscribe to our result "+ result);
        }
    }
    public void add(Customer customer) {
        this.subscriber.add(customer);
    }


    public List<Customer> getCustomers() {
        return subscriber;
    }

    public void setCustomers(List<Customer> customers) {
        this.subscriber = customers;
    }

    @Override
    public String toString() {
        return "Subscriber{" +
                "subscriber=" + subscriber +
                '}';
    }
}
