package com.example.SimpleFactory.V2;

import com.example.SimpleFactory.IFruit.Apple;
import lombok.Data;

@Data
public class GoldenApple implements Apple<Object> {

    private int treeAge;
    private String taste;

    /**
     * The type of apple. <br>
     * Such as: <br>
     * Cripps Pink / Pink Lady. <br>
     * Empire. <br>
     * Fuji. <br>
     * Gala. <br>
     * Golden Delicious. <br>
     * Granny Smith. <br>
     * Honeycrisp. <br>
     * McIntosh. <br>
     * @return the type of apple
     */
    @Override
    public String type() {
        return "Golden Apple";
    }

    /**
     * Grows your fruit
     */
    @Override
    public void grow(){
        System.out.printf("%s is growing...\n", type());
    }

    /**
     * Get the fruit data.
     * @return the fruit data
     */
    @Override
    public String getData() {
        return "\nData{\n" +
                "\t\"Fruit_Name\":\"Golden Apple\"" +
                "\n}\n";
    }
}
