package LotterySystem;


public class Shop {
    //code, address, owner, phone, email, account balance
    private int code;
    private String address;
    private String owner;
    private int phone;
    private String email;
    private double AccountBalance;


    //constructor
    private Shop(int code, String address, String owner, int phone, String email, double accountBalance) {
        this.code = code;
        this.address = address;
        this.owner = owner;
        this.phone = phone;
        this.email = email;
        this.AccountBalance = accountBalance;
    }

    public Shop(){}



    //getter and setter

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getAccountBalance() {
        return AccountBalance;
    }

    public void setAccountBalance(double accountBalance) {
        AccountBalance = accountBalance;
    }
    //code, address, owner, phone, email, account balance


    @Override
    public String toString() {
        return "Shop's information{ "
                + "Code: " + code
                + " Address: " + address
                + " Owner: " + owner
                + " Phone: " + phone
                + " Mail: " + email
                + " Account Balance: " + AccountBalance + '\'' + "}";
    }
}


