package com.example.SimpleFactoryTesting;


import com.example.SimpleFactory.IFruit.Fruit;
import com.example.SimpleFactory.V2.FruitFactory;
import com.example.SimpleFactory.V2.GoldenApple;
import com.example.SimpleFactory.V2.Peach;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


@Slf4j
public class SimpleFactoryTest {
    @Test
    void simpleFactoryTest(){
        Fruit<?> peach;
        Fruit<?> goldenApple;
        try {
            // request fruit classes from FruitFactory
            peach = FruitFactory.factoryMethod("Peach");
            assert peach != null;
            log.info("\n{}",peach.getData());
            goldenApple = FruitFactory.factoryMethod("Golden Apple");
            assert goldenApple != null;
            log.info("\n{}",goldenApple.getData());
            Assertions.assertEquals(GoldenApple.class, goldenApple.getClass());
            Assertions.assertEquals(Peach.class, peach.getClass());
        } catch (Exception e){
            System.err.println(e.getLocalizedMessage());
            // do nothing on null exception
        }
    }
}
