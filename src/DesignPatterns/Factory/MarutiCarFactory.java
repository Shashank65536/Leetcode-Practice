package DesignPatterns.Factory;

public class MarutiCarFactory {

    public Car getCar(CarType car ){

        switch (car){
            case SWIFT -> {
                return new SwiftCar();
            }
            case BREEZA -> {
                return new Brezza();
            }
        }
        return null;
    }
}
