//import static java.lang.System.;
public class Exam {


    void a(){
        int []arr = {4,5,6};
        int diff = arr[0];
        for(int i = 1;i< arr.length;i++){
            diff = Math.abs(arr[i] - diff);
            System.out.println(diff);
        }
    }
    public static void main(String args[]){
        System.out.print("A");
        Exam e = new Exam();
        e.a();

      }
}
