package DesignPatterns.Singleton;



//Private constructor
// Private static variable


/*When a Static Member or Method is Accessed: If you call any static method (e.g., SingletonEagerInitializn.getInstance() or SingletonEagerInitializn.helloWorld()), the class will be loaded into memory if it hasn’t been already. During this loading process, static variables are initialized.

When an Instance of the Class is Created: If you create an instance of the class (e.g., new SingletonEagerInitializn()), the JVM will load the class first (if it hasn’t been loaded already) and then proceed with instance creation.

When a Static Field is Accessed: Any access to a static field will also trigger class loading. In the eager initialization pattern, the class loads, and the singleton instance is created as a static field initialization.*/
public class SingletonEagerInitializn {

    private static final SingletonEagerInitializn singleton = new SingletonEagerInitializn();
    private SingletonEagerInitializn(){
        System.out.println("in constructor");
    }

    public static SingletonEagerInitializn getInstance(){
        return singleton;
    }

    public static void helloWOrld(){
        System.out.println("jello");
    }
}
