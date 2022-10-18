package com.example.SimpleFactory.IFruit;

/**
 * Base Case Apple Implementation
 * @param <Metadata> data about the fruit
 */
public interface Apple<Metadata> extends Fruit<Metadata> {
    long serialVersionUID = -2L;


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
    String type();
}
