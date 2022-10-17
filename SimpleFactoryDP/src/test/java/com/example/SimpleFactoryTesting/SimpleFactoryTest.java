package com.example.SimpleFactoryTesting;


import com.example.SimpleFactory.IFruit.Fruit;
import com.example.SimpleFactory.V2.FruitFactory;
import com.example.SimpleFactory.V2.GoldenApple;
import com.example.SimpleFactory.V2.Peach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.List;

public class SimpleFactoryTest {

    @Test
    void simpleFactoryTest(){
        String[] requests;
        List<Fruit<?>> fruits;
        try {
            // list of requested fruit
            requests = new String[]{
                    "Golden Apple",
                    "Mango",
                    "Peach",
                    "Fuji Apple",
                    "Orange"
            };
            // request fruit classes from FruitFactory
            fruits = FruitFactory.factoryMethod(requests);
            // grow each fruit or skip on null
            for (Fruit<?> value : fruits)
            {
                value.grow();
                System.out.println((String) value.getData());
            }
            Assertions.assertEquals(GoldenApple.class, fruits.get(0).getClass());
            Assertions.assertEquals(Peach.class, fruits.get(1).getClass());
            Assertions.assertEquals(3, fruits.size());
        } catch (Exception e){
            System.err.println(e.getLocalizedMessage());
            // do nothing on null exception
        }
    }
}
