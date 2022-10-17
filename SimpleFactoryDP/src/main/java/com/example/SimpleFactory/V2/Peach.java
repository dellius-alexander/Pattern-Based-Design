package com.example.SimpleFactory.V2;

import com.example.SimpleFactory.IFruit.Fruit;
import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Data
public class Peach implements Fruit<Object> {
    private static final Logger log = LoggerFactory.getLogger(Peach.class);
    static final long serialVersionUID = -13L;

    private String taste;
    public void grow(){
        log.info("\nPeach is growing...");
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
