package com.example.SimpleFactory.V1;

import com.example.SimpleFactory.IFruit.Fruit;

public class Peach implements Fruit<Object> {
    private String taste;

    /**
     * Grows your fruit
     */
    @Override
    public void grow(){
        System.out.println("Peach is growing...");
    }
    /**
     * Get the fruit data.
     * @return the fruit data
     */
    @Override
    public String getData() {
        return "\nData{\n" +
                "\t\"Fruit_Name\":\"Peach\"" +
                "\n}\n";
    }
}
