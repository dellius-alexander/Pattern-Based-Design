package com.example.SimpleFactory.V2;

import com.example.SimpleFactory.IFruit.Apple;
import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Data
public class FujiApple implements Apple<Object> {
    private static final Logger log = LoggerFactory.getLogger(FujiApple.class);
    static final long serialVersionUID = -9L;

    private int treeAge;
    private String taste;

    /**
     * The type of apple: Fuji. <br>
     * @return the type of apple
     */
    @Override
    public String type() {
        return "Fuji Apple";
    }

    /**
     * Grows your fruit
     */
    @Override
    public void grow() {
        log.info("\n{} is growing...\n", type());
    }

    /**
     * Get the fruit data.
     * @return the fruit data
     */
    @Override
    public String getData() {
        return "\nData{\n" +
                "\t\"Fruit_Name\":\"Fuji Apple\"" +
                "\n}\n";
    }
}
