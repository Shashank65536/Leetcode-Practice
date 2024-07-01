import java.util.*;

public class Leetcode690 {

    static  class Employee {
        public int id;
        public int importance;
        public List<Integer> subordinates;
    };
    public static int getImportance(List<Employee> employees, int id) {

        Map<Integer, Employee> map = new HashMap<>();

        for(Employee emp:employees){
            map.put(emp.id,emp);

        }
        int imp = map.get(id).importance;
        return dfs(id, map);
    }

    static int  dfs(int id, Map<Integer,Employee> map){

        if(map.get(id).subordinates == null || map.get(id).subordinates.size() == 0)return map.get(id).importance;
        int imp = map.get(id).importance;
        for(Integer i: map.get(id).subordinates){

            imp  = imp + dfs(i,map);
        }
        return imp;
    }

    public static void main(String[] args) {
        Map<Integer, Employee> map = new HashMap<>();
        Employee e1 = new Employee();
        Employee e2 = new Employee();
        Employee e3 = new Employee();
        Employee e4 = new Employee();


        e1.id = 1;
        e1.importance = 5;
        List<Integer>list = new ArrayList<>();
        list.add(2);
        list.add(3);
        e1.subordinates = list;

        e2.id = 2;
        e2.importance = 1;
        list = new ArrayList<>();
        list.add(4);
        e2.subordinates = list;

        e3.id = 3;
        e3.importance = 2;
        list = new ArrayList<>();
        e3.subordinates = list;

        e4.id = 4;
        e4.importance = 3;
        list = new ArrayList<>();
        e4.subordinates = list;
        List<Employee> lis = new ArrayList<>();
        lis.add(e1);
        lis.add(e2);
        lis.add(e3);
        lis.add(e4);
        int x = getImportance(lis,2);


    }

}
