package DesignPatterns.AbstractFactory;

public class Main {
// The factory desing pattern is used when we have a superclass and multiple sub classes and based on the input
    //we need to return the object of one of the subclass
    public static void main(String[] args) {
        SwiftFactory swiftFactory = new SwiftFactory();

        Car mySwift =  swiftFactory.getCar();
        System.out.println(mySwift.getPrice() + " " + mySwift.getEngineCC());
    }
}
