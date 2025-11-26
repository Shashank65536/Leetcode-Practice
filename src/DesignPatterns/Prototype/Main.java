package DesignPatterns.Prototype;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Car> list = new ArrayList<>();
        Breeza b = new Breeza();

        b.setModelYear(2024);

        for(int i =0;i<5;i++){
            list.add(b.clone(b));
        }

        for(Car car : list){
            System.out.println(car);
            System.out.println(car.getModelYear());
        }
    }
}
