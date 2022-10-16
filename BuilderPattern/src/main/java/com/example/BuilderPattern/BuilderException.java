package com.example.BuilderPattern;

public class BuilderException extends Exception {
    static final long serialVersionUID = -3387516993124229951L; // incremented original serialUID by +1
    public BuilderException(String msg){ super(msg); }
    public String message() { return String.format("%s\n", super.getMessage()); }

}
