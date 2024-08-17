import javax.swing.*;

public class TETextEditor {
    public static void main(String args[]) {

        // Setting menu bar color to dark theme
        try {
            UIManager.setLookAndFeel("com.formdev.flatlaf.FlatDarkLaf");
        } catch (Exception ex) {
            System.err.println("Failed to initialize LaF");
        }

        ChildWindow window = new ChildWindow();
    }
}
