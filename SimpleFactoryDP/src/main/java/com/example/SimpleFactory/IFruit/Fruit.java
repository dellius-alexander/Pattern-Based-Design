package com.example.SimpleFactory.IFruit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Base Case Fruit implementation.
 * @param <Metadata> the metadata about the fruit
 */
public interface Fruit<Metadata> extends Serializable {
    long serialVersionUID = -1L;

    /**
     * This interface contains a data object to encapsulate
     * data about each fruit across instances. Access to inner class
     * via {@linkplain #getData()}.
     * @param <Metadata> the data object
     */
    class Data<Metadata> {
        Metadata name;
        Metadata price;
        Fruit.Type type;

        /**
         * For adding metadata about the fruit..
         * @param name the name of the fruit
         * @param price the price of the fruit represented by a unit of measurement
         * @param type OPTIONS[SIMPLE, AGGREGATE, MULTIPLE, ACCESSORY]
         */
        public Data(
                Metadata name,
                Metadata price,
                Fruit.Type type
        ){
            setData(name, price, type);
        }

        /**
         * Assign metadata to object
         * @param name the name of the fruit
         * @param price the price of the fruit represented by a unit of measurement
         * @param type OPTIONS[SIMPLE, AGGREGATE, MULTIPLE, ACCESSORY]
         */
        public void setData(
                Metadata name,
                Metadata price,
                Fruit.Type type
        ){
            this.name = name;
            this.price = price;
            this.type = type;
        }

        /**
         * Retrieve the data object.
         * @return the metadata
         */
        public Data<Metadata> getData(){
            return this;
        }

        /**
         * The json representation of this object.
         * @return a json representation of this object.
         */
        public String toString(){
            return "{\n" +
                    "\t\"name\":\"" + this.name + "\"\n" +
                    "\t\"price\":\"" + this.price + "\"\n" +
                    "\t\"type\":\"" + this.type + "\"" +
                    "\n}\n";
        }
    }

    /**
     * Enumeration of Fruit Types
     */
    enum Type
    {
        SIMPLE("SIMPLE"),
        AGGREGATE("AGGREGATE"),
        MULTIPLE("MULTIPLE"),
        ACCESSORY("ACCESSORY");
        private static final Logger log = LoggerFactory.getLogger(Type.class);
        private final Type label;
        // static inference
        private static final Map<String, Type> BY_LABEL = new HashMap<>();

        /**
         * Create new UserRole with label = label
         * @param label the type label
         */
        Type(String label) {
            this.label = valueOfLabel(label);
        }

        /*
         * static inference collection of ROLES
         */
        static {
            for (Type e : values()) {
                BY_LABEL.put(String.valueOf(e.label), e);
            }
            log.info(new ArrayList<>(BY_LABEL.values()).toString());
        }
        /**
         * Static inference: Creates a UserRole Object with label = label.
         * @param label the type label
         * @return {@link Type}
         */
        public static Type valueOfLabel(String label) {
            Type r = null;
            for (Type role : values()) {
                if (String.valueOf(role.label).equals(label)) {
                    log.info(String.valueOf(role.label));
                    r = role;
                }
            }
            return r;
        }
    }

    /**
     * Grows your fruit
     */
    void grow();

    /**
     * Get the fruit data. This can be represented
     * according to implementation. <br>
     * Note: Update documentation
     * according to implementation.
     * @return the fruit data
     */
    Data<Metadata> getData();

}
