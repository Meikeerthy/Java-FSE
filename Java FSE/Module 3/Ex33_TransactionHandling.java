import java.sql.*;

public class Ex33_TransactionHandling {

    public static void transferMoney(int fromAccountId, int toAccountId, double amount) {
        Connection conn = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); 
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank", "root", "your_password");

            conn.setAutoCommit(false);

            String debitSQL = "UPDATE accounts SET balance = balance - ? WHERE id = ?";
            String creditSQL = "UPDATE accounts SET balance = balance + ? WHERE id = ?";

            try (
                PreparedStatement debitStmt = conn.prepareStatement(debitSQL);
                PreparedStatement creditStmt = conn.prepareStatement(creditSQL)
            ) {
                
                debitStmt.setDouble(1, amount);
                debitStmt.setInt(2, fromAccountId);
                int debitRows = debitStmt.executeUpdate();

                
                creditStmt.setDouble(1, amount);
                creditStmt.setInt(2, toAccountId);
                int creditRows = creditStmt.executeUpdate();

                if (debitRows == 1 && creditRows == 1) {
                    conn.commit();
                    System.out.println("Transaction successful!");
                } else {
                    conn.rollback();
                    System.out.println("Transaction failed. Rolled back.");
                }
            }

        } catch (Exception e) {
            try {
                if (conn != null) {
                    conn.rollback();
                    System.out.println("Error occurred. Transaction rolled back.");
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            try {
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        transferMoney(1, 2, 200.0);
    }
}
