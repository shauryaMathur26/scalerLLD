package DecoratorLecture.addOns;

import DecoratorLecture.Addon;
import DecoratorLecture.Beverage;

public class Whip implements Addon {

    Beverage currentBeverage;

    public Whip(Beverage currentBeverage){
        this.currentBeverage = currentBeverage;
    }
    @Override
    public int getCost() {
        return 30 + currentBeverage.getCost();
    }
}
