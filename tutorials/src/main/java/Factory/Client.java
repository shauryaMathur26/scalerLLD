package Factory;


import Factory.components.buttons.Button;
import Factory.components.menu.Menu;

public class Client {
    public static void main(String[] args) {

        Flutter flutter = new Flutter();
        UIComponentFactory uiComponentFactory = flutter.getUIComponentFactory("iOS");
        Button button = uiComponentFactory.createButton();
        Menu menu = uiComponentFactory.createMenu();
        button.render();
    }
}
