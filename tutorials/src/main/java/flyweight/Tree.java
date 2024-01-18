package flyweight;

public class Tree {
    double x;
    double y;

    TreeType treeType;

    public Tree(double x, double y, TreeType treeType) {
        this.x = x;
        this.y = y;
        this.treeType = treeType;
    }

    public void draw(){
        treeType.draw(this.x,this.y);
    }

}
