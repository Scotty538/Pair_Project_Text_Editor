import javax.swing.*;

public class AlexScott {
    public static void main(String args[]) {
        // Setting menuBar color to dark theme
        try {
            UIManager.setLookAndFeel("com.formdev.flatlaf.FlatDarkLaf");
        } catch (Exception ex) {
            System.err.println("Failed to initialize LaF");
        }

        ChildWindow window = new ChildWindow();
    }
}
