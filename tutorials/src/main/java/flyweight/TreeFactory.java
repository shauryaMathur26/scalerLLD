package flyweight;

import java.util.HashMap;
import java.util.Map;

public class TreeFactory {

    private Map<String,TreeType> map = new HashMap<>();

    public TreeType getTreeType(String name,String colour, String texture){
        if(map.containsKey(name)){
            return map.get(name);
        }else{
            TreeType newType = new TreeType(name,colour,texture);
            map.put(name,newType);
            return newType;
        }
    }

    public void register(String type,TreeType treeType){
        map.put(type,treeType);
    }
}
