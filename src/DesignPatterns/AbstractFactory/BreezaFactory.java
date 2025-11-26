package DesignPatterns.AbstractFactory;

public class BreezaFactory extends MarutiCarFactory{

    @Override
    public Car getCar() {
        return new Brezza();
    }
}
