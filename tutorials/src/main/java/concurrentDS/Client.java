package concurrentDS;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Client {
    public static void main(String[] args) {

            // Create a HashMap
//            Map<String, String> map = new HashMap<>(); // ERROR : Throws ConcurrentModificationException

            Map<String, String> map = new ConcurrentHashMap<>();// Works well; thread safe data-structure

        // Add some key-value pairs
            map.put("1", "One");
            map.put("2", "Two");
            map.put("3", "Three");

            // Create a separate thread for modification
            Thread modifierThread = new Thread(() -> {
                // Introduce a delay to ensure the iterator is running concurrently
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                // Attempt to modify the map during iteration
                map.put("4", "Four");
            });

            // Start the modifier thread
            modifierThread.start();

            // Iterate over the map in the main thread
            try{
                Iterator<Map.Entry<String, String>> iterator = map.entrySet().iterator();
                while (iterator.hasNext()) {
                    Map.Entry<String, String> entry = iterator.next();
                    System.out.println(entry.getKey() + ": " + entry.getValue());

                    // Introduce a delay to make it more likely to encounter the issue
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }catch (Exception e){
                e.printStackTrace();
                System.out.println(e.getMessage());
            }
        }

}