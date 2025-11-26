package DesignPatterns.Prototype;

public class Breeza  extends  Car{

    public Breeza(){
        super();
        System.out.println("In default constructor of breeza");
    }

    public Breeza(Car car){
        super(car);

        System.out.println("in copy constructor");
    }
    @Override
    public Car clone(Car car) {
        return new Breeza(car);
    }

    @Override
    public int getPrice() {
        return 400000;
    }

    @Override
    public int getcc() {
        return 2000;
    }
}
