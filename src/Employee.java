public class  Employee {
    private String FIO;
    private int salary;

    private String department;



    public  Employee(String FIO, String department, int salary) {
        this.FIO = FIO;
        this.department = department;
        this.salary = salary;

    }

    public String getFIO() {
        return FIO;
    }

    public String getDepartment() {
        return department;

    }
    public int getSalary(){
        return salary;
    }

    public void setDepartment(String department) {
        this.department = department;

    }
    public void setSalary(int salary) {
        this.salary = salary;
    }
}