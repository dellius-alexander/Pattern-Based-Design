package com.example.SimpleFactory.IFruit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

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
        Metadata name = null;
        Metadata price = null;
        Fruit.Type type = null;

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
        public Metadata getName() {
            return this.name;
        }
        public Metadata getPrice() {
            return this.price;
        }
        public Type getType() {
            return this.type;
        }
        public void setName(Metadata name) {
            this.name = name;
        }
        public void setPrice(Metadata price) {
            this.price = price;
        }
        public void setType(Type type) { this.type = type; }
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
            setName(name);
            setPrice(price);
            setType(type);
        }

        /**
         * The json representation of this object.
         * @return a json representation of this object.
         */
        public String toString(){
            return "{\n" +
                    "\t\"name\":\"" + getName() + "\"\n" +
                    "\t\"price\":\"" + getPrice() + "\"\n" +
                    "\t\"type\":\"" + getType() + "\"" +
                    "\n}\n";
        }
        public boolean equals(final Object o) {
            if (o == this) return true;
            if (!(o instanceof Fruit.Data)) return false;
            final Data<?> other = (Data<?>) o;
            if (!other.canEqual(this)) return false;
            final Object this$name = this.getName();
            final Object other$name = other.getName();
            if (!Objects.equals(this$name, other$name)) return false;
            final Object this$price = this.getPrice();
            final Object other$price = other.getPrice();
            if (!Objects.equals(this$price, other$price)) return false;
            final Object this$type = this.getType();
            final Object other$type = other.getType();
            return Objects.equals(this$type, other$type);
        }

        protected boolean canEqual(final Object other) {
            return other instanceof Fruit.Data;
        }

        public int hashCode() {
            final int PRIME = 59;
            int result = 1;
            final Object $name = this.getName();
            result = result * PRIME + ($name == null ? 43 : $name.hashCode());
            final Object $price = this.getPrice();
            result = result * PRIME + ($price == null ? 43 : $price.hashCode());
            final Object $type = this.getType();
            result = result * PRIME + ($type == null ? 43 : $type.hashCode());
            return result;
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
        private final String label;
        // static inference
        private static final Map<String, Type> BY_LABEL = new HashMap<>();

        /**
         * Create new UserRole with label = label
         * @param label the type label
         */
        Type(String label) {
            this.label = label;
        }

        /*
         * static inference collection of ROLES
         */
        static {
            for (Type e : values()) {
                BY_LABEL.put(e.label, e);
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
                if (role.label.equals(label)) {
                    log.info(role.label);
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
