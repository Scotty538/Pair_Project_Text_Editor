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
        page.setLineWrap(true); // displays text on new line once reaching end of window
        page.setWrapStyleWord(true); // ensures the full word enters new line (instead of single char)

        // Adding scrollable panel with the editor page
        JScrollPane scrollPage = new JScrollPane(page);
        scrollPage.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED); // Makes scrollbar only appear when needed
        scrollPage.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        // Create and display menu bar component
        frame.setJMenuBar(MenuBar.createMenuBar());

        frame.add(scrollPage);
        frame.setSize(600, 600);
        frame.setLocation(100, 50);
        frame.show();
    }
}
