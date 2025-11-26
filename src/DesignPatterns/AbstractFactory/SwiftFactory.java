package DesignPatterns.AbstractFactory;

public class SwiftFactory extends MarutiCarFactory{
    @Override
    public Car getCar() {
        return new SwiftCar();
    }
}
