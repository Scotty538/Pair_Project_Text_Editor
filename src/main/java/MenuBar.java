import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

// Component to define menu bar

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

        // Adding file and edit buttons to menu
        menuBar.add(fileButton);
        menuBar.add(editButton);

        return menuBar;
    }


}
