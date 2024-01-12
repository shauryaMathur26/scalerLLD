package Factory;

import Factory.components.buttons.AndroidButton;
import Factory.components.buttons.Button;
import Factory.components.menu.AndroidMenu;
import Factory.components.menu.Menu;

public class AndroidUIComponentFactory implements UIComponentFactory{
    @Override
    public Button createButton() {
        return new AndroidButton();
    }

    @Override
    public Menu createMenu() {
        return new AndroidMenu();
    }
}
