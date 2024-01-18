package flyweight;

public class TreeType {
    String name;
    String colour;
    String texture;

    public TreeType(String name, String colour, String texture) {
        this.name = name;
        this.colour = colour;
        this.texture = texture;
    }

    public void draw(double x,double y){
        System.out.println("Drawing a " + this.name + " tree " + x + " " + y);
    }
}
