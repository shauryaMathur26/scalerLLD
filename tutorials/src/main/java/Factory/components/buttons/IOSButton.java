package Factory.components.buttons;

public class IOSButton implements Button{
    @Override
    public void render() {
        System.out.println("iOS Button rendered");
    }
}
