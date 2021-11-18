/**
 * Lớp chứa những phương thức dùng để kiểm tra dữ liệu nhập vào
 */
public class Validate {
    //Sử dụng StringBuilder để không tạo ra các vùng nhớ rác
    private final StringBuilder error = new StringBuilder();

    //Check ID
    public boolean checkIdName(String value) {
        boolean flag = value.matches("[A-z]{1,3}-[0-9]");
        if (flag == false) {
            this.setError("ID tên phải có dang: [A-z]-[0-9]. Vd: a-1");
        }
        return flag;
    }

    //Check id bộ phận
    public boolean checkIdDept(String value) {
        boolean flag = value.matches("[A-z]{1,3}-[0-9]");
        if (flag == false) {
            this.setError("ID bộ phận phải có dang: [A-z]-[0-9]. Vd: a-1");
        }
        return flag;
    }

    //Check tên
    public boolean checkName(String value) {
        boolean flag = value.matches("[A-z][^\\d^\\\\/.`';%!\\[\\]@#$&*()_+}{|\":\\-?<>]{1,25}");
        if (flag == false) {
            this.setError("Tên chỉ bao gồm chữ cái, từ 2 ký tự trở lên, không có chữ số, không có ký tự đặc biệt, chấp nhận khoảng trắng");
        }
        return flag;
    }

    //Check bộ phận
    public boolean checkNameDept(String value) {
        boolean flag = value.matches("[A-z][^\\d^\\\\/.`';%!\\[\\]@#$&*()_+}{|\":\\-?<>]{1,25}");
        if (flag == false) {
            this.setError("Tên bộ phận chỉ bao gồm chữ cái,từ 2 ký tự trở lên, không có chữ số, không có ký tự đặc biệt, chấp nhận khoảng trắng");
        }
        return flag;
    }

    //Check ngày/tháng/năm
    public boolean checkDate(int value) {
        boolean flag = value > 0 && value <= 31;
        if (flag == false) {
            this.setError("Ngày bắt đầu làm việc phải là số lớn hơn 0 và nhỏ hơn hoặc bằng 31");
        }
        return flag;
    }

    public boolean getError() {
        System.out.println(this.error);
        return false;
    }

    public void setError(String error) {
        this.error.append(error).append("\n");//append nối chuỗi của StringBuilder
    }


}
