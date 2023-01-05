package com.example.AbstractFactory.IFruit;

/**
 * Base Case Apple Implementation
 * @param <Metadata> data about the fruit
 */
public interface Apple<Metadata> extends Fruit<Metadata> {
    static final long serialVersionUID = -2L; // 0000-0010
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
