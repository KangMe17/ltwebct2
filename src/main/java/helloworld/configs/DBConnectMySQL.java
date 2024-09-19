package helloworld.configs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectMySQL {
    private static final String USERNAME = "root";
    private static final String PASSWORD = "11892456Ko4!";
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/ltwebct2";

    public static Connection getDatabaseConnection() throws SQLException, ClassNotFoundException {
        Connection connection = null;
        try {
            // Tải Driver
            Class.forName(DRIVER);
            // Kết nối tới cơ sở dữ liệu
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            System.out.println("Kết nối thành công!");
        } catch (SQLException e) {
            System.out.println("Lỗi kết nối cơ sở dữ liệu: " + e.getMessage());
            throw e;  // Ném lại ngoại lệ để xử lý ở nơi khác
        } catch (ClassNotFoundException e) {
            System.out.println("Driver không tìm thấy: " + e.getMessage());
            throw e;  // Ném lại ngoại lệ để xử lý ở nơi khác
        }
        return connection;
    }

    // Test chương trình. Kích phải chuột chọn run as->java application
    public static void main(String[] args) {
        try {
            Connection conn = DBConnectMySQL.getDatabaseConnection();
            if (conn != null) {
                System.out.println("Kết nối cơ sở dữ liệu thành công.");
            }
        } catch (Exception e) {
            e.printStackTrace();  // In chi tiết lỗi để gỡ lỗi
        }
    }
}
