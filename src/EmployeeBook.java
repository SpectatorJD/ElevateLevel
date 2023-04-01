import java.util.Arrays;
import java.util.Objects;

public class EmployeeBook {
    private static Employee[] employees;

    private int id;
    private static int counter = 0;

    public EmployeeBook() {
        this.employees = new Employee[10];

    }


    public void addEmployee(String employeesFIO, String department, int salary) {
        if (id >= employees.length) {
            System.out.println("Нельзя добавить cотрудника, закончилось место");
        }
        Employee newEmployee = new Employee(employeesFIO, department, salary);
        employees[id++] = newEmployee;
        this.counter = counter++;
    }

    public void printAllSalary() {
        int sum = 0;


        for (int i = 0; i < id; i++)
            sum += employees[i].getSalary();
        System.out.println("Сумма затрат на зарплаты в месяц " + sum + " рублей");

    }


    public void findEmployee(String employeeFIO) {
        for (int i = 0; i < id; i++) {
            Employee employee = employees[i];
            if (employee.getFIO().equals(employeeFIO)) {
                System.out.println(employee.getFIO() + employee.getDepartment() + employee.getSalary());
                return;
            }
        }
        System.out.println(employeeFIO + " не найден");
    }

    public void printAllEmployee() {
        for (int i = 0; i < id; i++) {
            Employee employee = employees[i];
            System.out.println(employee.getFIO() + " " + "отдел : " + employee.getDepartment() + " " + "Зарплата " + employee.getSalary());
        }
    }


    public void printMinSalary() {
        int min = employees[0].getSalary();

        for (int i = 0; i < id; i++) {
            if (employees[i].getSalary() < min) {
                min = employees[i].getSalary();
            }

        }
        System.out.println("Минимальня зарплата " + min + " рублей");
    }

    public void printMaxSalary() {
        int max = employees[0].getSalary();

        for (int i = 0; i < id; i++) {
            if (employees[i].getSalary() > max) {
                max = employees[i].getSalary();
            }
        }
        System.out.println("Максимальная заплата " + max + " рублей");
    }

    public void printAverageSalary() {
        double avarage = 0;
        for (int i = 0; i < id; i++) {

            avarage += employees[i].getSalary() / employees.length;
        }
        System.out.println("Средняя зарплата составляет " + avarage + " рублей");
    }

    public void printAllFIO() {
        for (int i = 0; i < id; i++) {
            Employee employee = employees[i];
            System.out.println(i + "." + " ФИО сотрудника " + employee.getFIO());
        }
    }

    public void printIndexSalary() {
        double index = 0.15;

        for (int i = 0; i < id; i++) {
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
                System.out.println("новая зп на +50 % " + salaryNew);
            }
        }

        
    }





    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmployeeBook that = (EmployeeBook) o;
        return id == that.id && Arrays.equals(employees, that.employees);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(id);
        result = 31 * result + Arrays.hashCode(employees);
        return result;
    }

    @Override
    public String toString() {
        return "EmployeeBook{" +
                "employees=" + Arrays.toString(employees) +
                ", id=" + id +
                '}';
    }
}