import javax.swing.*;

public class TextEditor extends JFrame {
    // Initialising frame and page
    JFrame frame;
    JTextArea page;


    // Constructor
    TextEditor()
    {
        frame = new JFrame("Alex and Scott's Editor");

        // Adding text area
        page = new JTextArea();

        // Create and display menu bar component
        MenuBar menuBar = new MenuBar();
        frame.setJMenuBar(menuBar.createMenuBar());

        frame.add(page);
        frame.setSize(600, 700);
        frame.show();
    }
}
