import javax.swing.*;

public class MenuBar {
    // Method to create manu bar
    public static JMenuBar createMenuBar() {
        // Creating menu bar
        JMenuBar menuBar = new JMenuBar();

        // Creating file menu button
        JMenu fileButton = new JMenu("File");

        // Creating file menu dropdown items
        JMenuItem fileNew = new JMenuItem("New");
        JMenuItem fileOpen = new JMenuItem("Open");
        JMenuItem fileSave = new JMenuItem("Save As");
        JMenuItem filePrint = new JMenuItem("Print");

        // Adding action listener
        fileNew.addActionListener(new MenuBarActionListener());
        fileOpen.addActionListener(new MenuBarActionListener());
        fileSave.addActionListener(new MenuBarActionListener());
        filePrint.addActionListener(new MenuBarActionListener());

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

        // Adding action listener
        editSelectAll.addActionListener(new MenuBarActionListener());
        editCut.addActionListener(new MenuBarActionListener());
        editCopy.addActionListener(new MenuBarActionListener());
        editPaste.addActionListener(new MenuBarActionListener());

        // Adding dropdown items to edit
        editButton.add(editSelectAll);
        editButton.add(editCut);
        editButton.add(editCopy);
        editButton.add(editPaste);

        // Creating mode menu button
        JMenu viewButton = new JMenu("View");

        // Creating edit dropdown items
        JMenuItem viewLightMode = new JMenuItem("Light Mode");
        JMenuItem viewDarkMode = new JMenuItem("Dark Mode");

        // Adding action listener
        viewLightMode.addActionListener(new MenuBarActionListener());
        viewDarkMode.addActionListener(new MenuBarActionListener());

        // Adding dropdown items to edit
        viewButton.add(viewLightMode);
        viewButton.add(viewDarkMode);

        // Adding file, edit, and mode buttons to menu
        menuBar.add(fileButton);
        menuBar.add(editButton);
        menuBar.add(viewButton);

        return menuBar;
    }


}
