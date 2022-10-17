package com.example.SimpleFactory.V1;

import com.example.SimpleFactory.V2.FruitFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Client {
    private static final Logger log = LoggerFactory.getLogger(Client.class);


    /**
     * Driver
     * @param args CLi arguments
     */
    public static void main(String[] args)
    {
        Apple apple = new Apple();
        apple.grow();
        log.info("{}",apple.getData());
    }
}
