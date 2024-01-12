package Factory.components.buttons;

public class AndroidButton implements Button{
    @Override
    public void render() {
        System.out.println("Android Button rendered");
    }
}
