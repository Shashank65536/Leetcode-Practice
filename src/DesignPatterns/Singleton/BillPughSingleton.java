package DesignPatterns.Singleton;

public class BillPughSingleton {

    private BillPughSingleton(){
        System.out.println("constructor");
    }

    private static class innerClass{   //Static inner class to avoid concurrency issues.
        private static final BillPughSingleton obj = new BillPughSingleton();
    }

    public  static BillPughSingleton getInstance(){
        return innerClass.obj;
    }
}
