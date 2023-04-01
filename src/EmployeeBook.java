import java.util.Arrays;
import java.util.Objects;

public class EmployeeBook {
    private static Employee[] employees;

    private int realSize;
    //private static int counter = 0;

    public EmployeeBook() {
        this.employees = new Employee[10];
        //this.counter = counter++;

    }


    public void addEmployee(String employeesFIO, String department, int salary) {
        //this.counter = counter++;
        if (realSize >= employees.length) {
            System.out.println("Нельзя добавить сотрудника, закончилось место");
        }
        Employee newEmployee = new Employee(employeesFIO, department, salary);
        employees[realSize++] = newEmployee;

    }

    public void printAllSalary() {
        int sum = 0;


        for (int i = 0; i < realSize; i++)
            sum += employees[i].getSalary();
        System.out.println("Сумма затрат на зарплаты в месяц " + sum + " рублей");
        //this.counter = counter++;
    }


    public void findEmployee(String employeeFIO) {
        for (int i = 0; i < realSize; i++) {
            Employee employee = employees[i];
            if (employee.getFIO().equals(employeeFIO)) {
                System.out.println(employee.getFIO() + employee.getDepartment() + employee.getSalary());
                return;
            }
        }
        System.out.println(employeeFIO + " не найден");
        //this.counter = counter++;
    }

    public void printAllEmployee() {
        for (int i = 0; i < realSize; i++) {
            Employee employee = employees[i];
            System.out.println(employee.getFIO() + " " + "отдел : " + employee.getDepartment() + " " + "Зарплата " + employee.getSalary());
        }
        //this.counter = counter++;
    }


    public void printMinSalary() {
        int min = employees[0].getSalary();

        for (int i = 0; i < realSize; i++) {
            if (employees[i].getSalary() < min) {
                min = employees[i].getSalary();
            }

        }
        System.out.println("Минимальня зарплата " + min + " рублей");
    }

    public void printMaxSalary() {
        int max = employees[0].getSalary();

        for (int i = 0; i < realSize; i++) {
            if (employees[i].getSalary() > max) {
                max = employees[i].getSalary();
            }
        }
        System.out.println("Максимальная заплата " + max + " рублей");
    }

    public void printAverageSalary() {
        double avarage = 0;
        for (int i = 0; i < realSize; i++) {

            avarage += employees[i].getSalary() / realSize;
        }
        System.out.println("Средняя зарплата составляет " + avarage + " рублей");
    }

    public void printAllFIO() {
        for (int i = 0; i < realSize; i++) {
            Employee employee = employees[i];
            System.out.println(i + "." + " ФИО сотрудника " + employee.getFIO());
        }
    }

    public void printIndexSalary() {
        double index = 0.15;

        for (int i = 0; i < realSize; i++) {
            int indexSalary = employees[i].getSalary();
            Employee employee = employees[i];
            indexSalary += employees[i].getSalary() * index;
            System.out.println("После идексации зарплата составляет " + indexSalary);
        }
    }

    public static void calculateAverageSalary (String department) {
        int departmentBudget = 0;
        int employeeCount = 0;
        for (Employee employee: employees){
            if (employee != null){
            if (department == employee.getDepartment()){
                departmentBudget+=employee.getSalary();
                employeeCount++;
            }
        }}
        System.out.println("Средняя зарплата по отделу составляет " + departmentBudget/employeeCount);

    }
    public  static void calculateIndexSalaryWithDepartment (double index){
        double needIndex = index/100;
        for (Employee employee: employees){
            if (employee != null){
                double salaryNew = employee.getSalary();
                salaryNew += employee.getSalary() * needIndex;
                System.out.println("Новая зарплата, увеличеная на 50 % " + salaryNew);
            }
        }
    }
    public void printAllEmployeeWithDep(String department) {
        for (Employee employee : employees) {
            if (employee != null) {
                if (department == employee.getDepartment()) {
                    System.out.println(employee.getFIO() + " " + "Зарплата " + employee.getSalary());
                }
            }
        }
    }
    public void printEmployeeMinSalary(int reference){
        for (Employee employee: employees){
          if (employee != null) {
              if (reference> employee.getSalary()){
                  System.out.println("У сотрудника " + employee.getFIO() + "из отдела " + employee.getDepartment()+ " зарплата "
                          + employee.getSalary() +  " и она меньеше чем указанное значение" );
              }
          }
        }
    }
    public void printEmployeeMaxSalary(int reference){
        for (Employee employee: employees){
            if (employee != null) {
                if (reference<= employee.getSalary()){
                    System.out.println("У сотрудника " + employee.getFIO() + "из отдела " + employee.getDepartment()+ " зарплата "
                            + employee.getSalary() +  " и она больше или равна чем указанное значение" );
                }
            }
        }
    }





    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmployeeBook that = (EmployeeBook) o;
        return realSize == that.realSize && Arrays.equals(employees, that.employees);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(realSize);
        result = 31 * result + Arrays.hashCode(employees);
        return result;
    }

    @Override
    public String toString() {
        return "EmployeeBook{" +
                "employees=" + Arrays.toString(employees) +
                ", id=" + realSize +
                '}';
    }
}