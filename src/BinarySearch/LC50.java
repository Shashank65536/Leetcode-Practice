package BinarySearch;

public class LC50 {


    double temp = 1;
    public double pow(int x, int n){

        System.out.println(n);
        if(n == 0){
            return temp;
        }
        temp = temp * x;
        double res = pow(x,--n);
        return res;
    }

    public static void main(String[] args) {

        LC50 lc50 = new LC50();
        System.out.println(lc50.pow(2,10));

    }
}
