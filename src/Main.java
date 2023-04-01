public class Main {
    public static void main(String[] args) {
        EmployeeBook employeeBook = new EmployeeBook();

        employeeBook.addEmployee("Иванов Иван Иванович", "1", 10000);
        employeeBook.addEmployee("Петров Иван Иванович", "2", 20000);
        employeeBook.addEmployee("Сидоров Иван Иванович", "3", 30000);
        employeeBook.addEmployee("Иванова Татьяна Ивановна", "4", 25000);
        employeeBook.addEmployee("Петрова Наталья Петровна", "5", 35000);
        employeeBook.addEmployee("Сидоров Игорь Николаевич", "5", 50000);
        employeeBook.addEmployee("Кузнецов Иван Иванович", "5", 55000);



        employeeBook.printAllEmployee();
        employeeBook.printAllSalary();
        employeeBook.printMinSalary();
        employeeBook.printMaxSalary();
        employeeBook.printAverageSalary();
        employeeBook.printAllFIO();
        employeeBook.printIndexSalary();
        employeeBook.calculateAverageSalary("5");
        employeeBook.calculateIndexSalaryWithDepartment(50);
        employeeBook.printAllEmployeeWithDep("4");
        employeeBook.printEmployeeMinSalary(11000);
        employeeBook.printEmployeeMaxSalary(30000);



    }
}