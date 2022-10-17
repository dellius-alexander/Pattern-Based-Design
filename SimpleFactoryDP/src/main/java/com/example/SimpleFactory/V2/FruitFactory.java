package com.example.SimpleFactory.V2;


import com.example.SimpleFactory.FruitException;
import com.example.SimpleFactory.IFruit.Fruit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FruitFactory implements Serializable {
    private static final Logger log = LoggerFactory.getLogger(FruitFactory.class);
    static final long serialVersionUID = -8L;
    static GoldenApple createGoldenApple(){return new GoldenApple();}
    static FujiApple createFujiApple(){return new FujiApple();}
    static Peach createPeach(){return new Peach();}
    /**
     * Gets a fruit class from the requested fruit.
     * @param request the requested fruit
     * @return a corresponding fruit class
     */
    public static Fruit<?> factoryMethod(String request)
    {
        try {
            request = request.toLowerCase();
            if (request.contains("fuji"))
                return createFujiApple();
            if (request.contains("golden"))
                return createGoldenApple();
            if (request.contains("peach"))
                return createPeach();
            // error statement if not found
            throw new FruitException(String.format("No match found for %s...",
                    request.toUpperCase()));
        } catch (FruitException e){
            log.error("\n{}\n",e.message());
//            e.printStackTrace();
        }
        return null;
    }

    /**
     * Returns an array of fruit classes from the requested list of fruits.
     * @param requests the requested list of fruits.
     * @return an array of fruit classes matching the requested fruits.
     */
    public static List<Fruit<?>> factoryMethod(String[] requests)
    {
        List<Fruit<?>> fruitList = new ArrayList<>();
        List<String> fruitRequests = Arrays.stream(requests).collect(Collectors.toList());
        try {
            for (String requested : fruitRequests )
            {
                // convert request to lower case
                requested = requested.toLowerCase();
                // get fruit class
                Fruit<?> f = factoryMethod(requested);
                // remove request from queue
                fruitRequests.remove(requested);
                if (f == null) {continue;}
                // add fruit to list
                fruitList.add(f);
            }
        } catch (Exception e){
            log.error("\n{}\n",e.getLocalizedMessage());
            e.printStackTrace();
            // pass the remaining requests back to [ get(requests): Fruits<?> ]
            assert !fruitRequests.isEmpty();
            return  factoryMethod((String[]) fruitRequests.toArray());
        }
        return fruitList;
    }
}
