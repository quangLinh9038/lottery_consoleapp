package LotterySystem.DecoratorPattern;

public class Award implements Decorator {
    private Decorator decorator;

    public Award(Decorator decorator) {
        this.decorator = decorator;
    }
    @Override
    public void decorate() {
        decorator.decorate();
        System.out.println("Give away the award");


    }
}
