import javax.swing.*;

public class TextEditor extends JFrame {
    // Initialising frame and page
    public static JFrame frame;
    public static JTextArea page;


    // Constructor
    TextEditor()
    {
        frame = new JFrame("Alex and Scott's Editor");

        // Adding text area
        page = new JTextArea();

        // Create and display menu bar component
        frame.setJMenuBar(MenuBar.createMenuBar());


        frame.add(page);
        frame.setSize(600, 600);
        frame.setLocation(100, 50);
        frame.show();
    }
}
