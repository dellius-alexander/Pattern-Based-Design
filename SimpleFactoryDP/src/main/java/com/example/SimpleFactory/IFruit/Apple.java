package com.example.SimpleFactory.IFruit;

/**
 * Base Case Apple Implementation
 * @param <Data> fruit data of type Object
 */
public interface Apple<Data> extends Fruit<Data> {
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
