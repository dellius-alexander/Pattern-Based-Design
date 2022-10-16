package com.example.SimpleFactory.V1;

import com.example.SimpleFactory.IFruit.Fruit;

public class Apple implements Fruit<Object> {
    private int treeAge;
    private String taste;

    /**
     * Grows your fruit
     */
    @Override
    public void grow() {
        System.out.println("Apple is growing...");
    }


    /**
     * Get the fruit data.
     * @return the fruit data
     */
    @Override
    public String getData() {
        return "\nData{\n" +
                "\t\"Fruit_Name\":\"Apple\"" +
                "\n}\n";
    }
}
