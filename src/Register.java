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
            public void actionPerformed(ActionEvent actionEvent) {
                        PreparedStatement pst;

                if (new  String(txtPassword.getPassword()).equals(new String(txtRePassword.getPassword()))){
                    try {

                        String serverName = "sql12.freemysqlhosting.net";
                        String mydatabase = "sql12255832";
                        String url = "jdbc:mysql://" + serverName + "/" + mydatabase;
                        String username = "sql12255832";
                        String password = "VqusRaY3qH";
                        Connection connection = DriverManager.getConnection(url, username, password);
                        connection.createStatement();
                        String sql ="Insert into User(User_Name, User_Email, User_Password) values (?,?,?)";

                        pst=connection.prepareStatement(sql);
                        pst.setString(1, txtUsername.getText());
                        pst.setString(2, txtEmail.getText());
                        pst.setString(3,  new String(txtPassword.getPassword()));
                        pst.execute();
                        JOptionPane.showMessageDialog(null, "ลงทะเบียนสำเร็จ");
                    }
                    catch(Exception String) {
                    JOptionPane.showMessageDialog(null,"error");

                    }

                }
                else{
                    JOptionPane.showMessageDialog(null, "รหัสผ่านไม่ตรงกัน");

                }

            }

        });

        btnClear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

    public static void main(String[] args) throws SQLException {
        JFrame frame = new JFrame();
        Register register = new Register();
        frame.setContentPane(register.mainPanel);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setMinimumSize(new Dimension(500,500));
        frame.setVisible(true);

        String serverName = "sql12.freemysqlhosting.net";
        String mydatabase = "sql12255832";
        String url = "jdbc:mysql://" + serverName + "/" + mydatabase;
        String username = "sql12255832";
        String password = "VqusRaY3qH";
        Connection connection = DriverManager.getConnection(url, username, password);
        connection.createStatement();
        Statement s =    connection.createStatement();
    }
    public JPanel getMainPanel() {
        return mainPanel;
    }
    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
