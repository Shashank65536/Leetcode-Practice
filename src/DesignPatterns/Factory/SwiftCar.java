package DesignPatterns.Factory;

public class SwiftCar extends  Car{
    @Override
    public int getEngineCC() {
        return 2000;
    }

    @Override
    public int getPrice() {
        return 50000;
    }
}
