package javapract;

class MyException1 extends Exception {}
class MyException2 extends Exception {}

public class ExceptionHandling {



    public static void main(String[] args) {

        int i  = 0;
        System.out.println("helo");
        try {
            System.out.println("1");
            method1();
            System.out.println("2");
        }catch (MyException1 e){
            e.printStackTrace();
            System.out.println("3");
//            throw new MyException2();
        }catch (MyException2 e){
            e.printStackTrace();
        }catch (Exception er){
            er.printStackTrace();
        }finally {
            System.out.println("4");
//            throw new MyException1();
        }
    }

    public static void method1() throws Exception{
        try{
            System.out.println("5");
            throw new MyException1();
        }catch (Exception e){
            System.out.println("6");
            throw new MyException2();
        }finally {
            System.out.println("7");
//            throw new MyException1();
        }
    }

}
