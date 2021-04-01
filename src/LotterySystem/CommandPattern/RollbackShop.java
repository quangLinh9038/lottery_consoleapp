package LotterySystem.CommandPattern;

import LotterySystem.Shop;

public class RollbackShop implements Command {

    private int newCode;
    private String newAddress;
    private String newOwner;
    private int newPhone;
    private String newEmail;
    private double  newAccountBalance;
    private Shop shop;

    private int backupCode;
    private String backupAddress;
    private String backupOwner;
    private int backupPhone;
    private String backupEmail;
    private double  backupAccountBalance;


    //constructors
    public RollbackShop(int newCode, String newAddress, String newOwner,
                        int newPhone, String newEmail, double newAccountBalance, Shop shop){
        this.newCode = newCode;
        this.newAddress = newAddress;
        this.newOwner = newOwner;
        this.newPhone = newPhone;
        this.newEmail = newEmail;
        this.newAccountBalance = newAccountBalance;
        this.shop = shop;

    }

    @Override
    public void execute() {
        this.backupCode = shop.getCode();
        this.backupAddress = shop.getAddress();
        this.backupOwner = shop.getOwner();
        this.backupPhone = shop.getPhone();
        this.backupEmail = shop.getEmail();
        this.backupAccountBalance = shop.getAccountBalance();

        this.shop.setCode(newCode);
        this.shop.setAddress(newAddress);
        this.shop.setOwner(newOwner);
        this.shop.setPhone(newPhone);
        this.shop.setEmail(newEmail);
        this.shop.setAccountBalance(newAccountBalance);
    }

    @Override
    public void undo() {
        this.shop.setCode(backupCode);
        this.shop.setAddress(backupAddress);
        this.shop.setOwner(backupOwner);
        this.shop.setPhone(backupPhone);
        this.shop.setEmail(backupEmail);
        this.shop.setAccountBalance(backupAccountBalance);

    }


}
