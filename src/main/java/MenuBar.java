import org.fife.ui.rsyntaxtextarea.RSyntaxTextArea;
import org.fife.ui.rtextarea.Gutter;

import javax.swing.*;

public class MenuBar {
    public static JMenuBar createMenuBar(RSyntaxTextArea page, Gutter gutter) {
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
        fileNew.addActionListener(e -> MenuBarActionListener.action(page, e, gutter));
        fileOpen.addActionListener(e -> MenuBarActionListener.action(page, e, gutter));
        fileSave.addActionListener(e -> MenuBarActionListener.action(page, e, gutter));
        filePrint.addActionListener(e -> MenuBarActionListener.action(page, e, gutter));

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
        editSelectAll.addActionListener(e -> MenuBarActionListener.action(page, e, gutter));
        editCut.addActionListener(e -> MenuBarActionListener.action(page, e, gutter));
        editCopy.addActionListener(e -> MenuBarActionListener.action(page, e, gutter));
        editPaste.addActionListener(e -> MenuBarActionListener.action(page, e, gutter));

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
        viewLightMode.addActionListener(e -> MenuBarActionListener.action(page, e, gutter));
        viewDarkMode.addActionListener(e -> MenuBarActionListener.action(page, e, gutter));

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
