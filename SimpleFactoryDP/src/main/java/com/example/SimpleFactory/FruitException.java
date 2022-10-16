package com.example.SimpleFactory;

public class FruitException extends Exception {
    static final long serialVersionUID = -3387516993124229949L; // incremented original serialUID by +1
    public FruitException(String msg){ super(msg); }
    public String message() { return String.format("%s\n", super.getMessage()); }

}
