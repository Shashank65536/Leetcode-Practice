package javapract;

public class Parent {

    int p = 100;

     void show(){
        System.out.println("I am in parent class");
    }
    public boolean parentHello(){
        System.out.println("hello from parent class");
        return false;
    }

    public static void staticMethodParent(){
        System.out.println("I am in staticc method in parent class");
    }
}
