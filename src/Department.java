    /**
     * Class chứa thông tin và thuộc tính của bộ phận
     */
public class Department {
    private String deptId, deptName;
    private int count = 0; //số lượng nhân viên

    //Contructor, phương thức khởi tạo
    public Department(String deptName, String deptId) {
        this.deptName = deptName;
        this.deptId = deptId;
    }
    /**
     * Getter & setter
     */
    public String getDeptId() {
        return deptId;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    //Hiển thị thông tin bộ phận
    @Override
    public String toString() {
        return "Các bộ phận của công ty"
                + "\nTên bộ phận\t\t\t: " + getDeptName()
                + "\nID bộ phận\t\t\t: " + getDeptId()
                + "\nSố lượng nhân viên\t: " + getCount();
    }

}
