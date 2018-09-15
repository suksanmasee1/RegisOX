import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;


public class Register {

    private JPanel mainPanel;
    private JPasswordField txtRePassword;
    private JPasswordField txtPassword;
    private JTextField txtUsername;
    private JButton btnSubmit;
    private JButton btnClear;
    private JTextField txtEmail;
    private JLabel lblUsername;
    private JLabel lblPassword;
    private JLabel lblRePassword;
    private JLabel lblEmail;

    public Register() {
        btnSubmit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                PreparedStatement pst;

                if (txtUsername.getText().equals("") || txtEmail.getText().equals("") ||
                        new String(txtPassword.getPassword()).equals("") ||
                        new String(txtRePassword.getPassword()).equals("")) {
                    JOptionPane.showMessageDialog(null, "กรุณากรอกข้อมูลให้ครบ !");
                } else {
                    if (new String(txtPassword.getPassword()).equals(new String(txtRePassword.getPassword()))) {

                        try {
                            String serverName = "sql12.freemysqlhosting.net";
                            String mydatabase = "sql12255832";
                            String url = "jdbc:mysql://" + serverName + "/" + mydatabase;
                            String username = "sql12255832";
                            String password = "VqusRaY3qH";
                            Connection connection = DriverManager.getConnection(url, username, password);
                            connection.createStatement();
//เช็คว่ามี user นี้หรือยัง
                            String CheckUser = txtUsername.getText();
                            String sql = "SELECT User_Name FROM sql12255832.User where User_Name=?";
                            pst = connection.prepareStatement(sql);
                            pst.setString(1, CheckUser);
                            ResultSet rs = pst.executeQuery();

///

                            boolean russ = rs.next();
                            if (russ == true) {
                                JOptionPane.showMessageDialog(null, "คุณได้เคยสมัครไว้แล้ว");
                            } else {
                                InsertUser();
                            }


                        } catch (Exception String) {
                            JOptionPane.showMessageDialog(null, e);

                        }


                    } else {
                        JOptionPane.showMessageDialog(null, "รหัสผ่านไม่ตรงกัน");

                    }
                }


            }
        });
        btnClear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtUsername.setText("");
                txtRePassword.setText("");
                txtPassword.setText("");
                txtEmail.setText("");
            }
        });
    }

    public void InsertUser() {
        PreparedStatement pst;
        try {
            String serverName = "sql12.freemysqlhosting.net";
            String mydatabase = "sql12255832";
            String url = "jdbc:mysql://" + serverName + "/" + mydatabase;
            String username = "sql12255832";
            String password = "VqusRaY3qH";
            Connection connection = DriverManager.getConnection(url, username, password);
            connection.createStatement();

            String sql = "Insert into User(User_Name, User_Email, User_Password) values (?,?,?)";

            pst = connection.prepareStatement(sql);
            pst.setString(1, txtUsername.getText());
            pst.setString(2, txtEmail.getText());
            pst.setString(3, new String(txtPassword.getPassword()));
            pst.execute();
            JOptionPane.showMessageDialog(null, "finish");
            txtUsername.setText("");
            txtRePassword.setText("");
            txtPassword.setText("");
            txtEmail.setText("");
        } catch (Exception String) {

        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        Register register = new Register();
        frame.setContentPane(register.mainPanel);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setMinimumSize(new Dimension(800, 800));
        frame.setVisible(true);
    }
}

