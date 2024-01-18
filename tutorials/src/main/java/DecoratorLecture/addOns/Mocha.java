package DecoratorLecture.addOns;

import DecoratorLecture.Addon;
import DecoratorLecture.Beverage;

public class Mocha implements Addon {

    Beverage currentBeverage;

    public Mocha(Beverage currentBeverage){
        this.currentBeverage=currentBeverage;
    }
    @Override
    public int getCost() {
        return 20 + currentBeverage.getCost();
    }
}
