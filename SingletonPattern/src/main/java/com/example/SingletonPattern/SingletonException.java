package com.example.SingletonPattern;

public class SingletonException extends Exception {
    static final long serialVersionUID = -3387516993124229950L; // incremented original serialUID by +1
    public SingletonException(String msg){ super(msg); }
    public String message() { return String.format("%s\n", super.getMessage()); }

}
