package Factory;

import Factory.components.buttons.Button;
import Factory.components.menu.Menu;

//abstract factory````````
public interface UIComponentFactory {
    public Button createButton();

    public Menu createMenu();
}
