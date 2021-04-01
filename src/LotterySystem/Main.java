/*
 RMIT University- Sem A- 2019
  COSC2081-Programming 1
  Student 1 : Nguyen Quang Linh
  Id: s3697110
  Student 2: Phung Hai Tuan
  Id: s3695295
  Work division:
  Linh: - CRUD of Customer and Shop(Vendor)
         - Singleton and command pattern
  Tuan: - Lottery stimulation
        - Decorator and Subscriber pattern
 */
package LotterySystem;

import LotterySystem.CommandPattern.RollbackShop;
import LotterySystem.DecoratorPattern.Award;
import LotterySystem.DecoratorPattern.Decorator;
import LotterySystem.DecoratorPattern.Win;
import LotterySystem.SubcribersPattern.Subscriber;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;

import static java.util.Arrays.sort;

public class Main {

    public static void main(String[] args) {

        int begin = 0;
        // the menu
        String greet = "Welcome to Vietlott";
        String enter = "Please enter your choice 1-11:";
        String choice1 = "1. Add shop";
        String choice2 = "2. Edit shop";
        String choice3 = "3. Delete shop";
        String choice4 = "4. View list of shops";
        String choice5 = "5. Add customer";
        String choice6 = "6. Edit customer";
        String choice7 = "7. Delete customer";
        String choice8 = "8. View list of customer";
        String choice9 = "9. Buy a Vietlott ticket";
        String choice10 = "10. Begin Vietlott";
        String choice11 = "11. Rollback shop's information";
        //print the menu options
        try {
            while (begin != 10) {
                System.out.println(greet);
                System.out.println(enter);
                System.out.println(choice1);
                System.out.println(choice2);
                System.out.println(choice3);
                System.out.println(choice4);
                System.out.println(choice5);
                System.out.println(choice6);
                System.out.println(choice7);
                System.out.println(choice8);
                System.out.println(choice9);
                System.out.println(choice10);
                System.out.println(choice11);


                //input
                Scanner input = new Scanner(System.in);
                int choice = input.nextInt();


                // Shops and Customer CRUD
                //add shop
                if (choice == 1) {
                    System.out.println("Your choice is: " + choice1);
                    try {
                        //input
                        Shop shopAdd = new Shop();
                        Scanner inputAdd = new Scanner(System.in);

                        System.out.println("Please add shop code: ");
                        int code = Integer.parseInt(inputAdd.nextLine());
                        shopAdd.setCode(code);

                        System.out.println("Please add address: ");
                        String address = inputAdd.nextLine();
                        shopAdd.setAddress(address);

                        System.out.println("Please add owner: ");
                        String owner = inputAdd.nextLine();
                        shopAdd.setOwner(owner);

                        System.out.println("Please add phone: ");
                        int phone = Integer.parseInt(inputAdd.nextLine());
                        shopAdd.setPhone(phone);

                        System.out.println("Please add email: ");
                        String email = inputAdd.nextLine();
                        shopAdd.setEmail(email);

                        System.out.println("Please add Account Balance: ");
                        double AccountBalance = Integer.parseInt(inputAdd.nextLine());
                        shopAdd.setAccountBalance(AccountBalance);


                        ShopListSingleton shopManagerAdd = ShopListSingleton.getInstance();       // creat a new object without using 'new'
                        shopManagerAdd.add(shopAdd);

                        System.out.println("The shop added recently: " + shopManagerAdd.viewList());
                    } catch (Exception ex) {
                        System.out.println("You input wrong format");
                    }
                }

                //edit shop
                if (choice == 2) {
                    System.out.println("Your choice is: " + choice2);

                    try {
                        Scanner inputEdit = new Scanner(System.in);

                        //input for the shop's order ( 1,2,3,...)
                        System.out.println("Enter the shop's position you want to edit(1,2,3,..n): ");
                        int codeShop = Integer.parseInt(inputEdit.nextLine());

                        //code, address, owner, phone, email, account balance
                        System.out.println("Please enter new code: ");
                        int newCode = Integer.parseInt(inputEdit.nextLine());

                        System.out.println("Please enter new address: ");
                        String newAddress = inputEdit.nextLine();

                        System.out.println("Please enter new owner: ");
                        String newOwner = inputEdit.nextLine();

                        System.out.println("Please add new phone: ");
                        int newPhone = Integer.parseInt(inputEdit.nextLine());

                        System.out.println("Please add new email: ");
                        String newEmail = inputEdit.nextLine();

                        System.out.println("Please add new Account Balance: ");
                        double newAccountBalance = Integer.parseInt(inputEdit.nextLine());

                        ShopListSingleton shopEdit = ShopListSingleton.getInstance();

                        Shop editShop = ShopListSingleton.getInstance().getShops().get(codeShop - 1);        // take out the added shop based on its index
                        // that is input by user

                        editShop.setCode(newCode);
                        editShop.setAddress(newAddress);
                        editShop.setOwner(newOwner);
                        editShop.setPhone(newPhone);
                        editShop.setEmail(newEmail);
                        editShop.setAccountBalance(newAccountBalance);

                        shopEdit.edit(editShop);
                    } catch (Exception ex) {
                        System.out.println("You enter wrong code shop!");
                    }
                }

                //delete shop
                if (choice == 3) {
                    System.out.println("Your choice is: " + choice3);

                    Scanner delInput = new Scanner(System.in);
                    System.out.println("Enter the shop's position that you want to delete(1,2,3...n): ");
                    int shopToDel = Integer.parseInt(delInput.nextLine());

                    ShopListSingleton.getInstance().getShops().remove(shopToDel - 1);


                }
                //view list of shop
                // provide an order for shop list in order to help user to easily to use
                if (choice == 4) {
                    System.out.println("Your choice is: " + choice4);

                    // sorting for shop list
                    int order = 0;

                    Iterator shopList = ShopListSingleton.getInstance().getShops().iterator();
                    while (shopList.hasNext()) {
                        Object shop = shopList.next();
                        if (shop instanceof Shop) {
                            order++;
                            Shop shoplist = (Shop) shop;
                            System.out.println(" ");
                            System.out.println("Shop " + order);
                            System.out.println("Shop's code: " + shoplist.getCode());
                            System.out.println("Shop's address:  " + shoplist.getAddress());
                            System.out.println("Shop's owner: " + shoplist.getOwner());
                            System.out.println("Shop's phone: " + shoplist.getPhone());
                            System.out.println("Shop's email: " + shoplist.getEmail());
                            System.out.println("Shop's Account Balance: " + shoplist.getAccountBalance());

                        }
                    }
                }
                //add customer
                if (choice == 5) {
                    System.out.println("Your choice is: " + choice5);
                    try {
                        Scanner inputAdd = new Scanner(System.in);

                        Customer cusAdd = new Customer();

                        System.out.println("Please add customer's name: ");
                        String name = inputAdd.nextLine();
                        cusAdd.setName(name);

                        System.out.println("Please add customer's birthday");
                        String birthday = inputAdd.nextLine();
                        cusAdd.setBirthday(birthday);

                        System.out.println("Please add address: ");
                        String address = inputAdd.nextLine();
                        cusAdd.setAddress(address);

                        System.out.println("Please add phone: ");
                        int phone = Integer.parseInt(inputAdd.nextLine());
                        cusAdd.setPhone(phone);

                        System.out.println("Please add email: ");
                        String email = inputAdd.nextLine();
                        cusAdd.setEmail(email);

                        CustomerListSingleton customerManagerAdd = CustomerListSingleton.getInstance();
                        customerManagerAdd.add(cusAdd);
                    } catch (Exception ex) {
                        System.out.println("You input wrong format");
                    }
                }
                //edit customer
                if (choice == 6) {
                    System.out.println("Your choice: " + choice6);

                    try {
                        Scanner inputEditCus = new Scanner(System.in);

                        System.out.println("Enter the customer's position you want to edit(1,2,3,..n): ");
                        int codeCustomer = Integer.parseInt(inputEditCus.nextLine());


                        System.out.println("Please enter new name: ");
                        String newName = inputEditCus.nextLine();

                        System.out.println("Please enter new birth day: ");
                        String newBirthday = inputEditCus.nextLine();

                        System.out.println("Please enter new address: ");
                        String newAddressOfCus = inputEditCus.nextLine();

                        System.out.println("Please add new phone: ");
                        int newPhoneOfCus = Integer.parseInt(inputEditCus.nextLine());

                        System.out.println("Please add new email: ");
                        String newEmailOfCus = inputEditCus.nextLine();


                        CustomerListSingleton customerList = CustomerListSingleton.getInstance();

                        Customer editCus = CustomerListSingleton.getInstance().getCustomers().get(codeCustomer - 1);
                        // String name, birth of date, address, int phone, email

                        editCus.setName(newName);
                        editCus.setBirthday(newBirthday);
                        editCus.setAddress(newAddressOfCus);
                        editCus.setPhone(newPhoneOfCus);
                        editCus.setEmail(newEmailOfCus);

                        customerList.edit(editCus);
                    } catch (Exception ex) {
                        System.out.println("You enter wrong code shop!");
                    }
                }
                //delete customer
                if (choice == 7) {
                    System.out.println("Your choice: " + choice7);

                    Scanner delInputCus = new Scanner(System.in);
                    System.out.println("Enter the customer's position that you want to delete(1,2,3...n): ");
                    int cusToDel = Integer.parseInt(delInputCus.nextLine());

                    ShopListSingleton.getInstance().getShops().remove(cusToDel - 1);
                }
                //view list of customer
                //the same function and method with choice 4
                if (choice == 8) {
                    System.out.println("Your choice is: " + choice8);

                    // sorting for customer list
                    int order = 0;

                    Iterator customerList = CustomerListSingleton.getInstance().getCustomers().iterator();
                    while (customerList.hasNext()) {
                        Object customer = customerList.next();
                        if (customer instanceof Customer) {
                            order++;
                            Customer customer1ist = (Customer) customer;
                            // String name, birth of date, address, int phone, email
                            System.out.println(" ");
                            System.out.println("Customer " + order);
                            System.out.println("Customer's name: " + customer1ist.getName());
                            System.out.println("Customer's birthday:  " + customer1ist.getBirthday());
                            System.out.println("Customer's address: " + customer1ist.getAddress());
                            System.out.println("Customer's phone: " + customer1ist.getPhone());
                            System.out.println("Customer's email: " + customer1ist.getEmail());

                        }
                    }
                }
                // buying ticket function
                if (choice == 9) {
                    System.out.println("Your choice is: " + choice9);

                    int max = 45;
                    int min = 0;
                    int[] lottery = new int[6];
                    int randomNum;

                    for (int i = 0; i < 6; i++) {
                        randomNum = (int) (Math.random() * ((max - min) + 1)) + min;
                        lottery[i] = randomNum;
                    }
                    System.out.println("Here is you number");
                    for (int i = 0; i < lottery.length; i++)
                        System.out.print(lottery[i] + " ");
                    System.out.println(" ");
                }

                // start stimulation for lottery drawing
                if (choice == 10) {
                    System.out.println("You choose: " + choice10);
                    begin = choice;
                }
                if (choice == 11) {
                    System.out.println("Your choice is: " + choice11);

                    System.out.println("Please enter the shop's position that you want to rollback(1,2,3,...n: ");
                    Scanner inputRollback = new Scanner(System.in);
                    int input11 = Integer.parseInt(inputRollback.nextLine());

                    Shop rollbackShop1 = ShopListSingleton.getInstance().getShops().get(input11 - 1);

                    RollbackShop rollbackShop2 = new RollbackShop(rollbackShop1.getCode(), rollbackShop1.getAddress(),
                            rollbackShop1.getOwner(), rollbackShop1.getPhone(),
                            rollbackShop1.getEmail(), rollbackShop1.getAccountBalance(),
                            rollbackShop1);
                    rollbackShop2.execute();
                    rollbackShop2.undo();
                    System.out.println(rollbackShop2);
                }
            }

        }
        catch (Exception ex){
            System.out.println("Out of choice!!!");
        }
            System.out.println("Lottery simulation");
            System.out.println("Begin lottery:");
            int[] num = {0, 0, 0, 0, 0};
            for (int j = 1; j < 6; j++) {
                System.out.println("Week " + j);
                int[] jackpot = new int[6];
                for (int i = 0; i < jackpot.length; i++) {
                    jackpot[i] = Math_random();
                }
                System.out.println("The jackpot number is: " + Arrays.toString(jackpot));
                System.out.println("Here come the draw. Do you want to notify your subscriber ? (y/n) ? ");
                Scanner input = new Scanner(System.in);
                char choice = input.next().charAt(0);
                // notify subcribers about lottery award
                while (choice == 'y') {
                    Scanner inputAdd2 = new Scanner(System.in);
                    Subscriber cusAdd = new Subscriber();
                    System.out.println("Enter name of customer you want to get notified in next jackpot result");
                    String name = inputAdd2.nextLine();
                    cusAdd.setName(name);
                    cusAdd.getInform(Arrays.toString(jackpot));
                    System.out.println("Do you want to continue to notify ? (y/n)");
                    Scanner input1 = new Scanner(System.in);
                    System.out.println("Input answer: ");
                    Scanner input2 = new Scanner(System.in);
                    char question = input1.next().charAt(0);
                    choice = question;
                }

                int[] Early_Jackpot = new int[jackpot.length];
                for (int i = 0; i < jackpot.length; i++) {
                    Early_Jackpot[i] = jackpot[i];
                }
                sort(jackpot);
                int[] yourNumber = new int[jackpot.length];
                int[] Early_Jackpot1 = new int[yourNumber.length];
                boolean x = false;
                while (Equal_Array(jackpot, yourNumber) == false) {
                    for (int i = 0; i < jackpot.length; i++) {
                        yourNumber[i] = Math_random();
                        Early_Jackpot[i] = yourNumber[i];

                    }

                    num[j - 1]++;
                    //System.out.println("Your numbers are: "+ Arrays.toString(yourNumber));
                    sort(yourNumber);
                }
                System.out.println("The winning number is: " + Arrays.toString(Early_Jackpot));
                System.out.println("Number of times until Jackpot: " + num[j - 1]);
                System.out.println(" ");
            }
            double sum = 0;
            for (int i = 0; i < 5; i++) {
                sum = sum + num[i];
            }
            System.out.println("The average number of times until Jackpot is " + sum / 5);
            Decorator award = new Award(new Win());
            award.decorate();

        }

        //method used for choice 10
        public static int Math_random () {
            int max = 45;
            int min = 0;
            return (int) (Math.random() * ((max - min) + 1)) + min;
        }

        public static boolean Equal_Array ( int[] a, int[] b){
            if (a.length != b.length) return false;
            for (int i = 0; i < a.length; i++) {
                if (a[i] != b[i]) return false;
            }
            return true;
        }
        public static boolean Equal_Array_new ( int[] a, int[] b){
            if (a.length != b.length) return false;
            for (int i = 0; i < a.length; i++) {
                if (a[i] != b[i]) return false;
            }
            return true;
        }
    }





