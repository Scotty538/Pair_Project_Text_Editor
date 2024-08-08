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

        // Creating menu bar
        JMenuBar menuBar = new JMenuBar();

        // Creating file menu button
        JMenu fileButton = new JMenu("File");

        // Creating file menu dropdown items
        JMenuItem fileNew = new JMenuItem("New");
        JMenuItem fileOpen = new JMenuItem("Open");
        JMenuItem fileSave = new JMenuItem("Save");
        JMenuItem filePrint = new JMenuItem("Print");

        // Adding dropdown items to file
        fileButton.add(fileNew);
        fileButton.add(fileOpen);
        fileButton.add(fileSave);
        fileButton.add(filePrint);

        // Creating edit menu button
        JMenu editButton = new JMenu("Edit");

        // Creating edit dropdown items
        JMenuItem editSelectAll = new JMenuItem("Select All");
        JMenuItem editCut = new JMenuItem("Cut");
        JMenuItem editCopy = new JMenuItem("Copy");
        JMenuItem editPaste = new JMenuItem("Paste");

        // Adding dropdown items to edit
        editButton.add(editSelectAll);
        editButton.add(editCut);
        editButton.add(editCopy);
        editButton.add(editPaste);

        // Adding file and edit buttons to menu
        menuBar.add(fileButton);
        menuBar.add(editButton);

        frame.setJMenuBar(menuBar);
        frame.add(page);
        frame.setSize(600, 700);
        frame.show();
    }
}
