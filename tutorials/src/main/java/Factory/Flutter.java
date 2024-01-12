package Factory;

public class Flutter {

    public void setTheme() {
        System.out.println("Setting theme");
    }

    public void setRefreshRate() {
        System.out.println("Setting refresh rate");
    }

    //Factory Method
    public UIComponentFactory getUIComponentFactory(String platform){
        if("Android".equalsIgnoreCase(platform)){
            return new AndroidUIComponentFactory();
        }else if("iOS".equalsIgnoreCase(platform)){
            return new IOSUIComponentFactory();
        }
        return null;
    }

}
