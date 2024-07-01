class MyHashMap {

    class Node{
        int key,value;
        Node next;
    }
    Node[] arr = new Node[10000];
    public MyHashMap() {

    }

    public void put(int key, int value) {
        int hashedKey = getHashKey(key);
        Node node = new  Node();
        node.key = key;
        node.value = value;
        node.next = null;
        if(arr[hashedKey] == null){

            arr[hashedKey] = node;
        }else{
            Node temp = getLastNode(arr[hashedKey]);
            temp.next = node;
        }

    }

    public int get(int key) {
        int index = getHashKey(key);
        if(arr[index] != null){
            Node temp = arr[index];
            while(temp != null){
                if(temp.key == key)
                    return temp.value;
                else
                    temp = temp.next;
            }
        }
        return -1;
    }

    public void remove(int key) {
        int index = getHashKey(key);
        boolean flag = false;
        if(arr[index] != null){
            Node temp = arr[index];
            while(temp.next != null){
                if(temp.next.key == key){
                    temp.next = temp.next.next;
                    break;
                }else
                    temp = temp.next;
            }
            if(temp.next == null && temp.key == key){
                arr[index] = null;
            }



        }
    }
    public int getHashKey(int val){
        return val % 10000;
    }

    public Node getLastNode(Node node){
        Node temp  = node;
        while(temp.next!=null){
            temp = temp.next;
        }
        return temp;

    }

    public void transpose() {
        int [][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        System.out.println(matrix.length);

        int rows = matrix.length;
        int cols = matrix[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = i + 1; j < cols; j++) {
                // Swap the elements across the main diagonal
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }

    public int[][] transpose1() {
        int [][] matrix = {{1,2,3},{4,5,6}};

        int rows = matrix.length;
        int cols = matrix[0].length;
        int [][]res = new int[cols][rows];

        for(int i = 0;i<rows;i++){
            for(int j = 0;j< cols;j++){

                res[i][j] = matrix[j][i];
            }
        }

        return res;
    }

    public static void main(String args[]){
//        MyHashMap hashMap = new MyHashMap();
//        hashMap.put(1,100);
//        hashMap.put(11,100);
//        hashMap.put(21,100);
//        hashMap.put(2,200);
//
//        hashMap.remove(1);
//        System.out.println(hashMap.get(11));
        MyHashMap hashMap = new MyHashMap();
        hashMap.transpose1();


    }
}