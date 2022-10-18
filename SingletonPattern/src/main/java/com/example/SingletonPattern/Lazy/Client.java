package com.example.SingletonPattern.Lazy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Client {
    private static final Logger log = LoggerFactory.getLogger(Client.class);
    public static void main(String[] args)
    {
        Singleton singleton = Singleton.getInstance();
        log.info("\nSingleton Pattern\n\n{}", singleton.toString());
        singleton = Singleton.getInstance();
        singleton.setData(8888);
        log.info("\nFirst Reference: {}, Class: {}", singleton, singleton.getClass().hashCode());
        singleton = Singleton.getInstance();
        singleton.setData(9999);
        log.info("\nSecond Reference: {}, Class: {}", singleton, singleton.getClass().hashCode());

    }
}
