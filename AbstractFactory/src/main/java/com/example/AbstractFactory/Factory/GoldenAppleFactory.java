package com.example.AbstractFactory.Factory;


import com.example.AbstractFactory.IFruit.*;
import com.example.AbstractFactory.V3.*;

public class GoldenAppleFactory implements AppleFactory<Apple<?>>{
    static final long serialVersionUID = -19L; // 0001-0011
    /**
     * Creates a type of fruit
     *
     * @return a type of fruit
     */
    @Override
    public Apple<?> factoryMethod() {
        return new GoldenApple();
    }
}
