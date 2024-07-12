public class LC443StringCompression {
    public int compress(char[] chars) {

        char z = '0';
        int count = 1;
        int index = 0;
        char[] res = new char[chars.length];
        System.out.println("default val is : " + res[0]);
        for(int i = 1;i < chars.length;i++){
            if(chars[i] == chars[i-1]){
                count++;
            }else{
                res[index++] = chars[i-1];
                if(count>1){
                    res[index++] =  (char) ('0' + count);
                }
                count = 1;
            }

        }

        res[index++] = chars[chars.length-1];
        if(count>1){
            res[index] =  (char)('0' + count);
        }

        for (int i = 0; i < res.length; i++) {
            if(res[i] != '\0'){
                chars[i] = res[i];
            }

        }
        System.out.println(res);
        return res.length;

    }

    public static void main(String[] args) {

        char ch = 'A'; // Example char
        int count = 1; // Example integer
        char result = (char) (ch + count); // Add int to char and cast back to char
        System.out.println(result); // Outputs: B


        char [] str = {'a','a','b','b','b','c','c'};
        LC443StringCompression compression = new LC443StringCompression();
        int x = compression.compress(str);
        System.out.println(x);
     }


}
