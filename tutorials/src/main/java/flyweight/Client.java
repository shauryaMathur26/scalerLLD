package flyweight;

import java.util.ArrayList;
import java.util.List;

public class Client {
    public static void main(String[] args) {
        List<Tree> trees = new ArrayList<>();

        TreeFactory treeFactory = new TreeFactory();
        trees.add(new Tree(1.0,1.0,treeFactory.getTreeType("Pine","Green","Rugged")));
        trees.add(new Tree(2.0,2.0,treeFactory.getTreeType("Pine","Green","Rugged")));
        trees.add(new Tree(3.0,3.0,treeFactory.getTreeType("Coconut","Brown","Pointy")));

        for(Tree tree : trees){
            tree.draw();
        }

        System.out.println("DEBUG");
    }
}
