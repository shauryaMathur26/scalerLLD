package DecoratorLecture;

import DecoratorLecture.addOns.Chocolate;
import DecoratorLecture.addOns.Mocha;
import DecoratorLecture.addOns.MyAddon;
import DecoratorLecture.addOns.Whip;

public class Client {
    public static void main(String[] args) {

        //ORDER : Latte
        Beverage latte = new Latte();
        System.out.println("Cost - " + latte.getCost());

        //ORDER : Espresso with Mocha and Whip
        Beverage b = new Espresso();

        //Addons
        b = new Mocha(b);
        b = new Whip(b);
//        b = new MyAddon(b);

        System.out.println("Cost - " + b.getCost());

    }
}
