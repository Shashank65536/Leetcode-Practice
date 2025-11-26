package javapract;

import DesignPatterns.Prototype.Clone;
import com.sun.tools.javac.Main;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MainClass implements Serializable {

    public static void main(String[] args) throws CloneNotSupportedException {

        //Annonymous  inner class
//        AbstractG abstractG = new AbstractG() {
//            @Override
//            void b() {
//                System.out.println("imple of B in abstrace b");
//            }
//        };
//
//        MainClass mc = new MainClass();
//        mc.clone();

        Parent p = new Child();

        Parent.staticMethodParent();
        System.out.println(p.p);
        p.show();
        p.parentHello();
        List<Integer>list = new ArrayList<>();
        ArrayList<Integer> arrayList = new ArrayList<>();


    }
}
