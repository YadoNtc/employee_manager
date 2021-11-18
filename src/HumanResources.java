
import java.util.Scanner;
/**
 * Class HumanResources chứa hàm main thực thi luồng chính của chương trình
 */
public class HumanResources {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int menuId = 0;
        do {
            StaffProgram.showMenu();
            try {
                menuId = Integer.parseInt(sc.nextLine());
                //Điều hướng người dùng
                switch (menuId) {
                    case 1:
                        StaffProgram.displayInfo();
                        break;
                    case 2:
                        StaffProgram.displayDepartment();
                        break;
                    case 3:
                        StaffProgram.displayStaffOfDepartment();
                        break;
                    case 4:
                        StaffProgram.addEmployee();
                        break;
                    case 5:
                        StaffProgram.findStaff();
                        break;
                    case 6:
                        StaffProgram.displaySalaryTable();
                        break;
                    case 7:
                        StaffProgram.showSalaryTableUp();
                        break;
                    case 8:
                    default:
                        break;
                }
            } catch (Exception e) {
                System.out.println("Đã có lỗi! Vui lòng thử lại");
                System.out.println("Lỗi: " + e.getMessage());
            }
        } while (menuId != 8);
    }

}
