package javapract;

import java.io.FileNotFoundException;
import java.sql.SQLException;

public interface DemoInteface {

    static void  a() throws SQLException {
        System.out.println("GG");
        throw new SQLException();
    }

     default void  b(int a){
        System.out.println(a * 5);
    }

    //cannot have private abstrace methods
    public abstract void g();

    public static void main(String[] args) {

    }
}
