package javapract;

import com.sun.tools.javac.Main;

import java.io.Serializable;

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
        System.out.println(p.p);
        p.show();

    }
}
