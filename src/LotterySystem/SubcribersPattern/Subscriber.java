package LotterySystem.SubcribersPattern;
import LotterySystem.DecoratorPattern.Win;

public class Subscriber extends Win {


    private String name;

    public Subscriber(String name)
    {
        this.name = name;
    }
    public Subscriber()
    {

    }

    public void getInform(String jackpot)
    {

        System.out.println("Hello "+ this.getName() +  " The jackpot number is: "+ jackpot);
    }




    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    public void annoucement(Draws subject) {
//        subject.subscribers.add(this);
//    }
}
