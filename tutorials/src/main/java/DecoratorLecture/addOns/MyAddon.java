package DecoratorLecture.addOns;

import DecoratorLecture.Addon2;
import DecoratorLecture.Beverage;

public class MyAddon implements Addon2 {//Can't inject addon to beverage, since Not in hierarchy.

    Beverage beverage;

    public MyAddon(Beverage beverage){
        this.beverage = beverage;
    }

    @Override
    public int getCost() {
        return 50 + beverage.getCost();
    }
}
