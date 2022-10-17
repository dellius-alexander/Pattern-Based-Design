package com.example.SingletonPattern.Lazy;

public class Singleton {
    private static Singleton UID = null;
    Object data = null;
    private Singleton(){}
    private Singleton(Object data){
        this.data = data;
    }
    public  synchronized static Singleton getInstance(){
        if (UID == null){UID = new Singleton();}
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
