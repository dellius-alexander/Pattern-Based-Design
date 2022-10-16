package com.example.SimpleFactory.V2;

import com.example.SimpleFactory.IFruit.Fruit;
import java.util.List;

public class Client {

    /**
     * Driver
     * @param args CLi arguments
     */
    public static void main(String[] args) {
        // container for fruits
        List<Fruit<?>> fruits;
        try {
            assert args == null;
            args = new String[]{
                    "Golden Apple",
                    "Mango",
                    "Peach",
                    "Fuji Apple",
                    "Orange"
            };
            // request fruit classes from FruitFactory
            fruits = FruitFactory.get(args);
            // grow each fruit or skip on null
            for(Fruit<?> fruit : fruits)
            {
                fruit.grow();
                System.out.printf("%s\n\n", fruit.getData());
            }
        } catch (Exception e){
            // do nothing on null exception
        }
    }
}
