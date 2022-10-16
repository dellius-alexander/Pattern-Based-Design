package com.example.SimpleFactory.V1;

public class Client {

    /**
     * Driver
     * @param args CLi arguments
     */
    public static void main(String[] args) {
        Apple apple = new Apple();
        apple.grow();
        System.out.println(apple.getData());
    }
}
