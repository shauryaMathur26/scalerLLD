package DecoratorLecture.addOns;

import DecoratorLecture.Addon;
import DecoratorLecture.Beverage;

public class Milk implements Addon {

    Beverage currentBeverage;

    public Milk(Beverage currentBeverage){
        this.currentBeverage = currentBeverage;
    }

    @Override
    public int getCost() {
        return 10 + currentBeverage.getCost();
    }
}
