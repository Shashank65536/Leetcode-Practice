package DesignPatterns.Singleton;

import DesignPatterns.Singleton.BillPughSingleton;
import DesignPatterns.Singleton.LazyInit;
import DesignPatterns.Singleton.SingletonEagerInitializn;

public class MainExe {

    public static void main(String[] args) {

/*        SingletonEagerInitializn.helloWOrld();
        System.out.println(SingletonEagerInitializn.getInstance());*/

        System.out.println(LazyInit.getInstance());

        System.out.println(BillPughSingleton.getInstance());
        System.out.println(BillPughSingleton.getInstance());
    }
}
