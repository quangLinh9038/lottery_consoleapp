package LotterySystem.DecoratorPattern;

import LotterySystem.SubcribersPattern.Subs;

import java.util.ArrayList;
import java.util.List;

public class Win implements Decorator {
    protected List<Subs> subscribers = new ArrayList<>();
    @Override
    public void decorate() {
        System.out.println("There is somebody get our Jackpot ");
    }

}
