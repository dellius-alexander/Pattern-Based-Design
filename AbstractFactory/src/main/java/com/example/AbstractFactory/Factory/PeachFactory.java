package com.example.AbstractFactory.Factory;

import com.example.AbstractFactory.V3.*;

public class PeachFactory implements AbstractFactory<Peach> {
    static final long serialVersionUID = -20L; // 0001-0100
    /**
     * Creates a type of fruit
     *
     * @return a type of fruit
     */
    public Peach factoryMethod() {
        return new Peach();
    }
}
