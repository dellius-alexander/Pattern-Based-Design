package com.example.SimpleFactory.V2;

import com.example.SimpleFactory.IFruit.Fruit;
import lombok.Data;

@Data
public class Peach implements Fruit<Object> {
    private String taste;
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
