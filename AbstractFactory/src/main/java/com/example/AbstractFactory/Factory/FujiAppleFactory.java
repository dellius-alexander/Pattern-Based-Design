package com.example.AbstractFactory.Factory;

import com.example.AbstractFactory.IFruit.*;
import com.example.AbstractFactory.V3.*;

public class FujiAppleFactory implements AppleFactory<Apple<?>> {
    static final long serialVersionUID = -18L; // 0001-0010
    /**
     * Creates a type of fruit
     * @return a type of fruit
     */
    @Override
    public Apple<?> factoryMethod() {
        return new FujiApple();
    }
}
