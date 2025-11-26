package DesignPatterns.Singleton;

public class LazyInit {

    private static  LazyInit obj = null;

    private LazyInit(){
        System.out.println("in lazy constructor");
    }
    public static LazyInit getInstance(){

        if(obj == null){
            obj = new LazyInit();
        }
        return obj;
    }
}
