import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        JFrame ry = new JFrame();
        Register loginPanel  = new Register();
        ry.setContentPane(new Register().getMainPanel());
        ry.pack();
        ry.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ry.setVisible(true);
        ry.setMinimumSize(new Dimension(800,800));

    }
}
