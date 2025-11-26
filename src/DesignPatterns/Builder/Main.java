package DesignPatterns.Builder;

public class Main {

    public static void main(String[] args) {
        Car.CarBuilder builder = new Car.CarBuilder(5000,1000);
        builder.setModelyear(2023);


        Car car = builder.build();
        System.out.println(car.getModelYear());
    }
}
