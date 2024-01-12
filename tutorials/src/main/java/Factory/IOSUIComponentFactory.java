package Factory;

import Factory.components.buttons.Button;
import Factory.components.buttons.IOSButton;
import Factory.components.menu.IOSMenu;
import Factory.components.menu.Menu;

public class IOSUIComponentFactory implements UIComponentFactory{
    @Override
    public Button createButton() {
        return new IOSButton();
    }

    @Override
    public Menu createMenu() {
        return new IOSMenu();
    }
}
