    /**
     * Class chứa thông tin thuộc tính của nhân viên và kế thừa thuộc tính của lớp
     * Staff, implements interface Icalculator
     */
public class Employee extends Staff implements ICalculator {
    private double overTime;

    //Contructor hàm khởi tạo
    public Employee(String idEmployee, String name, String departments, int age, int inDate, double takeLeaveDate, double coefficientsSalary, double overTime) {
        super(idEmployee, name, departments, age, inDate, takeLeaveDate, coefficientsSalary);
        this.overTime = overTime;
    }

    //Tính lương của nhân viên, ghi đè phương thức ko thân hàm của interface
    @Override
    public long calculatorSalary() {
        long salary = 0;
        salary = (long) (getCoefficientsSalary() * 3000000 + getOverTime());
        setSalary(salary);
        return getSalary();
    }

    //Hiển thị thông tin của nhân viên, manager
    @Override
    public String toString() {
        return "===Thông tin nhân viên=== "
                + "\nTên nhân viên \t\t\t: " + this.getName()
                + "\nMã nhân viên \t\t\t: " + this.getIdEmployee()
                + "\nTuổi nhân viên \t\t\t: " + this.getAge()
                + "\nBộ phận\t\t\t\t\t: " + this.getDepartments()
                + "\nNgày bắt đầu làm việc\t: " + this.getInDate()
                + "\nHệ số lương\t\t\t\t: " + this.getCoefficientsSalary()
                + "\nSố giờ làm thêm\t\t\t: " + this.getOverTime()
                + "\nSố ngày nghỉ phép\t\t: " + this.getTakeLeaveDate();
    }

    //So sánh và sắp xếp bảng lương
    @Override
    public int compareTo(Staff staffObj) {
        if (getSalary() > staffObj.getSalary()) {
            return 1;
        } else if (getSalary() < staffObj.getSalary()) {
            return -1;
        } else {
            return 0;
        }
    }

    /**
     * Các phương thức getter & setter
     */
    public double getOverTime() {
        return overTime;
    }

    public void setOverTime(double overTime) {
        this.overTime = overTime;
    }

}

