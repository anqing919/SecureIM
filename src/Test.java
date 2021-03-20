class Employee{
    private int id;
    public static int serialNum = 1;
    Employee(){ id=serialNum ++; }
}

public class Test{
    public static void main(String[] args){
        System.out.println(Employee.serialNum);
        Employee e=new Employee();
        System.out.println(e.serialNum);
    }
}
