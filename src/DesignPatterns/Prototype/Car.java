package DesignPatterns.Prototype;

public abstract class Car implements Clone,IVehicle {

    private int modelYear;

    public int getModelYear() {
        return modelYear;
    }

    public void setModelYear(int modelYear) {
        this.modelYear = modelYear;
    }

    public Car(){
        System.out.println("in default constructor");
    }

    public Car(Car c){
        this.modelYear = c.getModelYear();
    }

}
