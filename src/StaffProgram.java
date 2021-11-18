import java.util.*;

/**
 * Class StaffProgram chứa những phương thức, hàm tính toán được gọi và thực thi
 * bởi class HumanResources
 */
public class StaffProgram {
    private static final ArrayList<Staff> staffList = new ArrayList<>();
    private static final ArrayList<Department> deptList = new ArrayList<>();

    /**
     * Danh mục điều hướng
     */
    public static void showMenu() {
        System.out.println("-----------------------------------------------");
        System.out.println("=============== Công Ty TNHH ABC ==============");
        System.out.println("=================== Xin chào ==================");
        System.out.println("*Đây là danh mục quản lý nhân viên của Công ty*");
        System.out.println("    1.Danh sách nhân viên");
        System.out.println("    2.Danh sách các bộ phận của công ty");
        System.out.println("    3.Danh sách nhân viên theo từng bộ phận");
        System.out.println("    4.Thêm nhân viên mới vào công ty");
        System.out.println("    5.Tìm kiếm nhân viên theo tên hoặc ID");
        System.out.println("    6.Bảng lương của nhân viên công ty");
        System.out.println("    7.Bảng lương theo thứ tự tăng dần");
        System.out.println("    8.Exit");
        System.out.println("-----------------------------------------------");
        System.out.println("Xin mời chọn số bạn muốn thao tác [1-8:]");
    }

    /**
     * 1. Hien thị thông tin nhân viên chung
     */
    public static void displayInfo() {
        if (!checkEmpty()) {
            for (Staff staff : staffList) {
                if (staff instanceof Employee) {
                    System.out.println(((Employee) staff).toString());
                } else {
                    System.out.println(((Manager) staff).toString());
                }
            }
        } else {
            System.out.println("Vui lòng chọn mục 4 thêm nhân viên trước");
        }

    }

    /**
     * 2. Hiển thị các bộ phận cty
     */
    public static void displayDepartment() {
        if (!checkEmpty()) {
            for (Department deptObj : deptList) {
                System.out.println(deptObj.toString());
            }
        } else {
            System.out.println("Vui lòng chọn mục 4 thêm nhân viên trước");
        }
    }

    /**
     * 3. Hiển thị nhân viên theo bộ phận
     */
    public static void displayStaffOfDepartment() {
        if (!checkEmpty()) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Nhập tên hoặc Id của bộ phận");
            String id = sc.nextLine();

            //Tìm đôi tượng Department theo id hoặc name
            Department dept = null;
            for (Department deptObj : deptList) {
                if (deptObj.getDeptId().equalsIgnoreCase(id) || deptObj.getDeptName().equalsIgnoreCase(id)) {
                    dept = deptObj;
                }
            }
            //Hiển thị danh sách nhan viên theo tên bộ phận
            for (Staff staff : staffList) {
                if (staff.getDepartments().equalsIgnoreCase(dept.getDeptName())) {
                    if (staff instanceof Employee) {
                        System.out.println(((Employee) staff).toString());
                    } else {
                        System.out.println(((Manager) staff).toString());
                    }
                }
            }
        } else {
            System.out.println("Vui lòng chọn mục 4 thêm nhân viên trước");
        }
    }

    /**
     * 4. Thêm mới nhân viên
     */
    public static void addEmployee() {
        //Tạo các phòng ban mặc định trong mảng
        ArrayList<String> arrayData = new ArrayList<>();
        arrayData.add("Phòng kinh doanh");
        arrayData.add("Phòng dự án");
        arrayData.add("Phòng kỹ thuật");

        Scanner sc = new Scanner(System.in);
        Scanner nb = new Scanner(System.in);
        System.out.println("Thêm nhân viên mới vào hệ thống công ty");
        System.out.println("Chọn 1-Thêm nhân viên thường");
        System.out.println("Chọn 2-Thêm nhân viên là cấp quản lý ");
        System.out.print("Chọn số: ");
        int inputNumber = Integer.parseInt(sc.nextLine());
        while (inputNumber != 1 && inputNumber != 2) {
            System.out.print("Vui lòng chọn số chính xác: ");
            inputNumber = Integer.parseInt(sc.nextLine());
        }
        //Thêm mới nhân viên
        if (inputNumber == 1) {
            System.out.print("Tên nhân viên: ");
            String name = nb.nextLine();
            System.out.print("Id nhân viên. Id có dạng [A-z]-[0-5]. vd: a-1:  ");
            String idEmployee = sc.next();
            sc.nextLine();
            System.out.print("Tuổi: ");
            int age = Integer.parseInt(sc.nextLine());
            System.out.print("Ngày bắt đầu làm việc: ");
            int inDate = Integer.parseInt(sc.nextLine());
            System.out.println("Bộ phận làm việc. Chọn và viết chính xác một trong những bộ phận sau: ");
            System.out.print("  Phòng kinh doanh | Phòng dự án | Phòng kỹ thuật   ");
            String departments = nb.nextLine();
            System.out.print("Id bộ phận. Id có dạng [A-z]-[0-5]. vd: a-1:  ");
            String departmentsId = sc.next();

            //Kiểm tra sự tồn tại của bộ phận
            for (String strObj : arrayData) {
                if (!(arrayData.get(0).equalsIgnoreCase(departments))
                        && !(arrayData.get(1).equalsIgnoreCase(departments))
                        && !(arrayData.get(2).equalsIgnoreCase(departments))) {
                    System.out.println("Bộ phận đã nhập không tồn tại. Nhập tên các bộ phận như sau:");
                    System.out.println("Phòng kinh doanh | Phòng dự án | Phòng kỹ thuật");
                    departments = nb.nextLine();
                }
            }
            Department deptData = new Department(departments, departmentsId);
            deptList.add(deptData);
            //Kiểm tra gán giá trị id vào biến mới
            String deptId = "";
            for (Department deptObj : deptList) {
                if (deptObj.getDeptName().equalsIgnoreCase(departments)) {
                    deptId = deptObj.getDeptId();
                }
            }
            //Thêm nhân viên vào bộ phận
            Department dept = findDepartment(deptId);
            if (dept != null) {
                dept.setCount(dept.getCount() + 1);
            }
            System.out.print("Số ngày nghỉ: ");
            double takeLeaveDate = sc.nextDouble();
            System.out.print("Hệ số lương: ");
            double factory = sc.nextDouble();
            System.out.print("Giờ làm thêm: ");
            double overTime = sc.nextDouble();
            //Validate dữ liệu nhập vào
            Validate validateObj = new Validate();
            boolean validateName = validateObj.checkName(name);
            boolean validateId = validateObj.checkIdName(idEmployee);
            boolean validateDeptName = validateObj.checkNameDept(departments);
            boolean validateIdDept = validateObj.checkIdDept(departmentsId);
            boolean validateDate = validateObj.checkDate(inDate);
            if (validateId && validateName && validateDeptName && validateIdDept && validateDate) {
                Employee employeeObj = new Employee(idEmployee, name, departments, age, inDate, takeLeaveDate, factory, overTime);
                staffList.add(employeeObj);
                //Kiểm tra dữ liệu nhập vào và trả thông báo
            } else if (!validateObj.getError()) {
                System.out.println("Thêm nhân viên thất bại");
            }

            //Thêm mới quản lý
        } else if (inputNumber == 2) {
            System.out.print("Tên nhân viên quản lý: ");
            String name = nb.nextLine();
            System.out.print("Id nhân viên. Id có dạng [A-z]-[0-5]. vd: a-1:  ");
            String idEmployee = sc.next();
            sc.nextLine();
            String position;
            String position1 = "Trưởng phòng kinh doanh";
            String position2 = "Trưởng phòng dự án";
            String position3 = "Trưởng phòng kỹ thuật";
            do {
                System.out.print("Chức danh Chọn: Trưởng phòng kinh doanh | Trưởng phòng dự án | Trưởng phòng kỹ thuật  ");
                position = nb.nextLine();
            } while (!position.equals(position1) && (!position.equals(position2)) && (!position.equals(position3)));
            System.out.print("Tuổi: ");
            int age = Integer.parseInt(sc.nextLine());
            System.out.print("Ngày bắt đầu làm việc: ");
            int inDate = Integer.parseInt(sc.nextLine());
            System.out.println("Bộ phận làm việc. Chọn và viết chính xác một trong những bộ phận sau: ");
            System.out.print("  Phòng kinh doanh | Phòng dự án | Phòng kỹ thuật   ");
            String departments = nb.nextLine();
            System.out.print("Id bộ phận. Id có dạng [A-z]-[0-5]. vd: a-1:  ");
            String departmentsId = sc.next();
            sc.nextLine();

            //Kiểm tra sự tồn tại của các bộ phận
            for (Department deptObj : deptList) {
                if (!(arrayData.get(0).equalsIgnoreCase(departments))
                        && !(arrayData.get(1).equalsIgnoreCase(departments))
                        && !(arrayData.get(2).equalsIgnoreCase(departments))) {
                    System.out.println("Bộ phận đã nhập không tồn tại. Nhập các bộ phận như sau:");
                    System.out.println("Phòng kinh doanh | Phòng dự án | Phòng kỹ thuật");
                    departments = nb.nextLine();
                }
            }
            //Thêm bộ phận vào mảng
            Department deptData = new Department(departments, departmentsId);
            deptList.add(deptData);
            String deptId = "";
            for (Department deptObj : deptList) {
                if (deptObj.getDeptName().equalsIgnoreCase(departments)) {
                    deptId = deptObj.getDeptId();
                }
            }
            //Thêm nhân viên vào bộ phận
            Department dept = findDepartment(deptId);
            if (dept != null)
                dept.setCount(dept.getCount() + 1);
            System.out.print("Số ngày nghỉ: ");
            double takeLeaveDate = sc.nextDouble();
            sc.nextLine();
            System.out.print("Hệ số lương: ");
            double factory = sc.nextDouble();
            //Validate giá trị nhập vào
            Validate validateObj = new Validate();
            boolean validateName = validateObj.checkNameDept(name);
            boolean validateId = validateObj.checkIdName(idEmployee);
            boolean validateDeptName = validateObj.checkNameDept(departments);
            boolean validateIdDept = validateObj.checkIdDept(departmentsId);
            if (validateId && validateName && validateDeptName && validateIdDept) {
                Manager managerObj = new Manager(idEmployee, name, departments, age, inDate, takeLeaveDate, factory, position);
                staffList.add(managerObj);
            } else if (!validateObj.getError()) {
                System.out.println("Thêm nhân viên thất bại");
            }
        }
    }

    //checkEmpty, kiểm tra xem đã thêm nhân viên hay chưa
    public static boolean checkEmpty() {
        return staffList.isEmpty();
    }

    //Tìm bộ phận theo Id, dùng để thêm nhân viên vào bộ phận
    public static Department findDepartment(String id) {
        for (Department deptObj : deptList) {
            if (deptObj.getDeptId().equalsIgnoreCase(id)) {
                return deptObj;
            }
        }
        return null;
    }

    /**
     * 5. Tìm kiếm nhân viên theo tên hoặc id
     */
    public static void findStaff() {
        if (!checkEmpty()) {
            Scanner sc = new Scanner(System.in);
            Scanner nb = new Scanner(System.in);
            String name = "";
            String idEmployee = "";
            System.out.println("Nhập tên hoặc mã nhân viên: ");
            System.out.println("1-Tìm theo tên nhân viên: ");
            System.out.println("2-Tìm theo mã nhân viên: ");
            int numberChoose = sc.nextInt();
            while (numberChoose != 1 && numberChoose != 2) {
                System.out.println("Vui lòng nhập đúng số 1 hoặc 2");
                numberChoose = sc.nextInt();
            }
            if (numberChoose == 1) {
                System.out.print("Nhập tên nhân viên: ");
                name = nb.nextLine();
            } else if (numberChoose == 2) {
                System.out.print("Nhập mã nhân viên: ");
                idEmployee = sc.next();
            }

            find(name, idEmployee);
        } else {
            System.out.println("Vui lòng chọn mục 4 thêm nhân viên trước");
        }
    }

    public static void find(String name, String idEmployee) {
        int staffPosition = getPosition(name, idEmployee);
        if (staffPosition == -1) {
            System.out.println("Không có nhân viên đã tìm");
        } else {
            System.out.println(staffList.get(staffPosition));
        }
    }

    public static int getPosition(String name, String idEmployee) {
        Iterator itr = staffList.iterator();
        int i = 0;
        while (itr.hasNext()) {
            Staff staffObj = (Staff) itr.next();
            if (name.equals(staffObj.getName())) {
                return i;
            } else if (idEmployee.equals(staffObj.getIdEmployee())) {
                return i;
            }
            i++;
        }
        return -1;
    }

    /**
     * 6. Hiển thị bảng lương của nhân viên toàn công ty
     */
    public static void displaySalaryTable() {
        //Duyệt qua mảng tính lương của nhân viên
        if (!checkEmpty()) {
            for (Staff staff : staffList) {
                if (staff instanceof Employee) {
                    ((Employee) staff).calculatorSalary();
                } else {
                    ((Manager) staff).calculatorSalary();
                }
            }
            //Hiển thị bảng lương
            for (Staff staffObj : staffList) {
                System.out.println(staffObj.toString2());
            }
        } else {
            System.out.println("Vui lòng chọn mục 4 thêm nhân viên trước");
        }
    }

    /**
     * 7. Hiển thị bảng lương nhân viên tăng dần
     */
    public static void showSalaryTableUp() {
        if (!checkEmpty()) {
            Collections.sort(staffList);

            for (Staff staffObj : staffList) {
                if (staffObj instanceof Employee) {
                    ((Employee) staffObj).calculatorSalary();
                } else {
                    ((Manager) staffObj).calculatorSalary();
                }
            }
            for (Staff staffObj : staffList) {
                System.out.println(staffObj.toString2());
            }
        } else {
            System.out.println("Vui lòng chọn mục 4 thêm nhân viên trước");
        }
    }

}