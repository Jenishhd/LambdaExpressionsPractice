import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;

public class Employee {
    private String name;
    private int age;

    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

class main {
    public static void main(String[] args) {
        Employee jenish = new Employee("Jenish Thanki", 19);
        Employee bob = new Employee("Bob smith",22);
        Employee anand = new Employee("Anand Thanki",24);
        Employee parth = new Employee("Parth Thanki",7);
        Employee tim = new Employee("Tim Bunchlka",32);
        Employee john = new Employee("John Doe",45);

        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(jenish);
        employeeList.add(bob);
        employeeList.add(anand);
        employeeList.add(parth);
        employeeList.add(tim);
        employeeList.add(john);


        Function<Employee, String> getLastName = (Employee employee) -> {
            return employee.getName().substring(employee.getName().indexOf(' ') + 1);
        };

        Function<Employee,String> getFirstName = (Employee employee) -> {
            return employee.getName().substring(0,employee.getName().indexOf(' '));
        };

        Random random1 = new Random();
        for(Employee e : employeeList) {
            if(random1.nextBoolean()) {
                System.out.println(getAName(getFirstName,e));
            }
            else {
                System.out.println(getAName(getLastName,e));
            }
        }

        Function<Employee,String> upperCase = employee -> employee.getName().toUpperCase();
        Function<String,String> firstName = name -> name.substring(0,name.indexOf(' '));
        Function chainedFunction = upperCase.andThen(firstName);


        BiFunction<String,Employee,String> concatAge = (String name, Employee employee) -> {
            return name.concat(" " + employee.getAge());
        };

        String upperName = upperCase.apply(employeeList.get(0));
        System.out.println(concatAge.apply(upperName,employeeList.get(0)));

//        System.out.println(chainedFunction.apply(employeeList.get(0)));



//        printEmployeesByAge(employeeList,"Employees over 30", employee -> employee.getAge() > 30);
//
//        printEmployeesByAge(employeeList,"Employees 30 and under", employee -> employee.getAge() <= 30);
//
//
//        printEmployeesByAge(employeeList, "\nEmployees under the age of 25", new Predicate<Employee>() {
//            @Override
//            public boolean test(Employee employee) {
//                return employee.getAge() < 25;
//            }
//        });
//
//        IntPredicate intp = i -> i < 15;
//
//        printEmployeesByAge(employeeList,"\nEmployees under the age of 15",employee -> intp.test(employee.getAge()) );
//
//
//        Random random = new Random();
//        Supplier<Integer> randomSupplier = () -> random.nextInt(1000);
//        for(int i =0; i<10; i++) {
//            System.out.println(randomSupplier.get());
//        }
//
//
//        //Print last name of each employee
//        employeeList.forEach(employee -> {
//            String lastName = employee.getName().substring(employee.getName().indexOf(' ')+ 1);
//            System.out.println("Last name is: " + lastName);
//        });
//
    }

    private static String getAName(Function<Employee,String> getName, Employee employee) {
        return getName.apply(employee);
    }

    private static void printEmployeesByAge(List<Employee> employeeList,
                                            String ageText,
                                            Predicate<Employee> ageCondition) {
        System.out.println(ageText);
        for(Employee employee : employeeList) {
            if(ageCondition.test(employee)){
                System.out.println(employee.getName());
            }
        }

//        employeeList.forEach(employee -> {
//            if(employee.getAge() > 30){
//                System.out.println(employee.getName());
//            }
//        });
    }
}
