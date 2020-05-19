import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class test{
    public static void main(String[] args) {
        new Thread(()-> System.out.println("Printing from Runnable")).start();

        new Thread(()-> {
            System.out.println("Printing from second thread");
            System.out.println("Line 2");
            System.out.println("This is line 3");
        }).start();


        Employee jenish = new Employee("Jenish Thanki", 19);
        Employee bob = new Employee("Bob smith",22);
        Employee anand = new Employee("Anand Thanki",24);
        Employee parth = new Employee("Parth Thanki",17);

        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(jenish);
        employeeList.add(bob);
        employeeList.add(anand);
        employeeList.add(parth);


        employeeList.forEach(employee -> {
            System.out.println(employee.getName());
            System.out.println(employee.getAge());
        });



//        for(Employee employee : employeeList) {
//            System.out.println(employee.getName());
//            System.out.println(employee.getAge());
//        }




        //Sort the List in order using regular way
//        Collections.sort(employeeList, new Comparator<Employee>() {
//            @Override
//            public int compare(Employee employee1, Employee employee2) {
//                return employee1.getName().compareTo(employee2.getName());
//            }
//        });

        //Sort the list using lambda expresssions

        Collections.sort(employeeList, (Employee employee1, Employee employee2) ->
                        employee1.getName().compareTo(employee2.getName()));





        //REGULAR WAY OF DOING IT
//        for(Employee e : employeeList) {
//            System.out.println(e.getName());
//        }
//
//        String sillyString = doStringStuff(new UpperConcat() {
//            @Override
//            public String upperAndConcat(String s1, String s2) {
//                return s1.toUpperCase() + " " + s2.toUpperCase();
//            }
//        },
//        employeeList.get(0).getName(),employeeList.get(1).getName());
//        System.out.println(sillyString);

        //USING LAMBDA EXP


//        String sillyString = doStringStuff((s1, s2) -> s1.toUpperCase() + s2.toUpperCase(), employeeList.get(0).getName(), employeeList.get(1).getName());
//
//        System.out.println(sillyString);






    }

    public final static String doStringStuff(UpperConcat uc,String s1, String s2) {
        return uc.upperAndConcat(s1,s2);
    }

}


//class Employee {
//    private String name;
//    private int age;
//
//    public Employee(String name, int age) {
//        this.name = name;
//        this.age = age;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public int getAge() {
//        return age;
//    }
//
//    public void setAge(int age) {
//        this.age = age;
//    }
//}

interface UpperConcat {
    public String upperAndConcat(String s1, String s2);
}





class CodeToRun implements Runnable {
    @Override
    public void run() {
        System.out.println("From Runnable");
    }
}