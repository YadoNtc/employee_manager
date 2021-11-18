import java.text.DecimalFormat;

    /**
     * Abstract Class cha của Employee và Manager
     * implement Comparable để dung Collection ArrayList
     */
public abstract class Staff implements Comparable<Staff> {
    private String idEmployee, name, departments;
    private int age, inDate;
    private long salary;
    private double takeLeaveDate;
    private double coefficientsSalary;

    //Contructor, phương thức khởi tạo
    public Staff(String idEmployee, String name, String departments, int age, int inDate, double takeLeaveDate, double coefficientsSalary) {
        this.idEmployee = idEmployee;
        this.name = name;
        this.departments = departments;
        this.age = age;
        this.inDate = inDate;
        this.takeLeaveDate = takeLeaveDate;
        this.salary = salary;
        this.coefficientsSalary = coefficientsSalary;
    }
    /**
     * Getter & setter
     */
    public double getCoefficientsSalary() {
        return coefficientsSalary;
    }

    public void setCoefficientsSalary(double coefficientsSalary) {
        this.coefficientsSalary = coefficientsSalary;
    }

    public long getSalary() {
        return salary;
    }

    public void setSalary(long salary) {
        this.salary = salary;
    }

    public int getTakeLeaveDate() {
        return (int) takeLeaveDate;
    }

    public void setTakeLeaveDate(int takeLeaveDate) {
        this.takeLeaveDate = takeLeaveDate;
    }

    public int getInDate() {
        return inDate;
    }

    public void setInDate(int inDate) {
        this.inDate = inDate;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getDepartments() {
        return departments;
    }

    public void setDepartments(String departments) {
        this.departments = departments;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(String idEmployee) {
        this.idEmployee = idEmployee;
    }

    //Phương thức abstract
    public abstract String toString();

    //Hiển thị lương nhân viên cho 2 class Employee và Manger
    public String toString2() {
        DecimalFormat formatter = new DecimalFormat("#,###");
        return "===Thông tin nhân viên=== "
                + "\nTên nhân viên \t\t: " + this.getName()
                + "\nMã nhân viên \t\t: " + this.getIdEmployee()
                + "\nBộ phận\t\t\t\t: " + this.getDepartments()
                + "\nLương \t\t\t\t: " + formatter.format(this.getSalary());
    }

}
