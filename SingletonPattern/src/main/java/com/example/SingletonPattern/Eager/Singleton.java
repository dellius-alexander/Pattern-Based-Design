package com.example.SingletonPattern.Eager;

public class Singleton {
    private static Singleton UID = new Singleton();
    Object data = null;
    private Singleton(){}
    private Singleton(Object data){
        this.data = data;
    }
    public  synchronized static Singleton getInstance(){
        return UID;
    }
    public synchronized static Singleton getInstance(Object data){
        if (UID == null){
            UID = new Singleton(data);
        }
        return UID;
    }
    public Object getData(){
        return data;
    }
    public void setData(Object data){
        this.data = data;
    }
    public String toString() {
        return "Singleton(data=" + this.getData() + ")";
    }
}
