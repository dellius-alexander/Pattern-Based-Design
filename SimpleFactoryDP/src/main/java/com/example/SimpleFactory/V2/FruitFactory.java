package com.example.SimpleFactory.V2;

import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.stream.Collectors;
import com.example.SimpleFactory.IFruit.Fruit;
import com.example.SimpleFactory.FruitException;

public class FruitFactory {

    public static GoldenApple createGoldenApple(){return new GoldenApple();}
    public static FujiApple createFujiApple(){return new FujiApple();}
    public static Peach createPeach(){return new Peach();}

    /**
     * Gets a fruit class from the requested fruit.
     * @param request the requested fruit
     * @return a corresponding fruit class
     */
    public static Fruit<?> get(String request)
    {
        try {
            request = request.toLowerCase();
            if (request.contains("fuji"))
                return new FujiApple();
            if (request.contains("golden"))
                return new GoldenApple();
            if (request.contains("peach"))
                return new Peach();
            // error statement if not found
            throw new FruitException(String.format("No match found for %s...",
                    request.toUpperCase()));
        } catch (FruitException e){
            System.err.printf("\n%s\n",e.message());
//            e.printStackTrace();
        }
        return null;
    }

    /**
     * Returns an array of fruit classes from the requested list of fruits.
     * @param requests the requested list of fruits.
     * @return an array of fruit classes matching the requested fruits.
     */
    public static List<Fruit<?>> get(String[] requests)
    {
        List<Fruit<?>> fruitList = new ArrayList<>();
        List<String> fruitRequests = Arrays.stream(requests).collect(Collectors.toList());
        try {
            for (String requested : fruitRequests )
            {
                requested = requested.toLowerCase();
                Fruit<?> f = get(requested);
                fruitRequests.remove(requested);
                if (f == null) {continue;}
                fruitList.add(f);
            }
        } catch (Exception e){
            System.err.println(e.getLocalizedMessage());
            e.printStackTrace();
            // pass the remaining requests back to [ get(requests): Fruits<?> ]
            assert ! fruitRequests.isEmpty();
            return  get((String[]) fruitRequests.toArray());
        }
        return fruitList;
    }
}
