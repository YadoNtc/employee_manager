    /**
     * Class chứa thông tin thuộc tính của manager và kế thừa thuộc tính của lớp
     * Staff, implements interface Icalculator
     */
public class Manager extends Staff implements ICalculator {
    private String position;

    //Contructor, phương thức khởi tạo
    public Manager(String idEmployee, String name, String departments, int age, int inDate, double takeLeaveDate, double coefficientsSalary, String position) {
        super(idEmployee, name, departments, age, inDate, takeLeaveDate, coefficientsSalary);
        this.position = position;
    }

    //Tính lương của Manager
    @Override
    public long calculatorSalary() {
        long salary = 0;
        if (getPosition().equalsIgnoreCase("Trưởng phòng kinh doanh")) {
            salary = (long) (getCoefficientsSalary() * 5000000 + 8000000);
        } else if (getPosition().equalsIgnoreCase("Trưởng phòng dự án")) {
            salary = (long) (getCoefficientsSalary() * 5000000 + 5000000);
        } else if (getPosition().equalsIgnoreCase("Trưởng phòng kỹ thuật")) {
            salary = (long) (getCoefficientsSalary() * 5000000 + 6000000);
        }
        setSalary(salary);
        return getSalary();
    }

    //Thông tin của Manager
    @Override
    public String toString() {
        return "===Thông tin nhân viên quản lý=== "
                + "\nChức danh\t\t\t\t: " + this.getPosition()
                + "\nTên nhân viên \t\t\t: " + this.getName()
                + "\nMã nhân viên \t\t\t: " + this.getIdEmployee()
                + "\nTuổi nhân viên \t\t\t: " + this.getAge()
                + "\nBộ phận\t\t\t\t\t: " + this.getDepartments()
                + "\nNgày bắt đầu làm việc\t: " + this.getInDate()
                + "\nHệ số lương\t\t\t\t: " + this.getCoefficientsSalary()
                + "\nSố ngày nghỉ phép\t\t: " + this.getTakeLeaveDate();
    }

    //So sánh, sắp xếp bảng lương tăng dần
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

    //Getter&setter
    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }


}
