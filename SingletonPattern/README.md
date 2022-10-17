# Singleton Design Pattern

Definition: Singleton is an implementation of a class that only allows one instantiation.

## Where to use

Singleton should be considered only if all three of the following criteria are satisfied:
  - Ownership of the single instance cannot be reasonably assigned
  - Lazy initialization is desirable
  - Eager initialization is possible
  - No client can instantiate a Singleton object!
  - Global access is not otherwise provided for 
  - e.g.
    - When you need to ensure there's one instance of an object, available to a number of other classes.
    - When you need to provide a registry, or something like a thread pool. Logging is also another popular use 
    of Singletons, providing one single access point to an applications log file.sd


## Class Diagram

A simple implementation of the Singleton pattern looks like:

```java
class Singleton {
    private static Singleton UID = null;
    Object data = null;
    private Singleton(){}
    public  synchronized static Singleton getInstance(){
        if (UID == null){UID = new Singleton();}
        return UID;
    }

}

class Client {
    private static final Logger log = LoggerFactory.getLogger(Client.class);
    public static void main(String[] args)
    {
        Singleton singleton = Singleton.getInstance();
        System.out.printf("\n%s", singleton.data);
    }
}
```

The class diagram representation of this pattern looks like:


[![Class Diagram](./images/Singleton.Lazy.png "./images/Singleton.Lazy.png")](./images/Singleton.Lazy.png)

### Notes:

- Note that the singleton instance is only created when needed. 
  This is called lazy instantiation.