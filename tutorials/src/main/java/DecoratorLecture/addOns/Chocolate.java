package DecoratorLecture.addOns;

import DecoratorLecture.Addon;

public class Chocolate implements Addon {

    @Override
    public int getCost() {
        return 50;
    }
}
