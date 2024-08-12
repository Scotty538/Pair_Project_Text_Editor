import org.fife.ui.rsyntaxtextarea.RSyntaxTextArea;

import javax.swing.*;
import java.awt.*;

public class ChildWindow extends JFrame {
    // Constructor
    ChildWindow (boolean b) {
        JFrame newWindow = new JFrame("New Text Document");
        RSyntaxTextArea newPage = new RSyntaxTextArea();
        newPage.setCurrentLineHighlightColor(Color.lightGray);

        Font font = new Font("Monospaced",Font.PLAIN,14);
        newPage.setFont(font);

        // Adding scrollable panel with the editor page
        JScrollPane scrollPage = new JScrollPane(newPage);
        newPage.setLineWrap(true); // displays text on new line once reaching end of window
        newPage.setWrapStyleWord(true); // ensures the full word enters new line (instead of single char)

        // Setting background/foreground colours to match the main window
        if (b) {
           newPage.setForeground(new Color(224, 224, 224));
           newPage.setBackground(new Color(88, 88, 88));
        } else {
           newPage.setForeground(new Color(88, 88, 88));
           newPage.setBackground(new Color(224, 224, 224));
        }

        // Creating menu bar
        JMenuBar menuBar = new JMenuBar();
        newWindow.setJMenuBar(menuBar);

        // Creating file menu button
        JMenu fileButton = new JMenu("File");

        // Creating file menu dropdown items
        JMenuItem fileNew = new JMenuItem("New");
        JMenuItem openItem = new JMenuItem("Open");
        JMenuItem saveItem = new JMenuItem("Save As");
        JMenuItem closeItem = new JMenuItem("Close");

        // Adding action listeners
        fileNew.addActionListener(e -> MenuBarActionListener.action(newPage, e));
        openItem.addActionListener(e -> MenuBarActionListener.action(newPage, e));
        saveItem.addActionListener(e -> MenuBarActionListener.action(newPage, e));
        closeItem.addActionListener(e -> newWindow.dispose());

        // Adding dropdown items to file
        fileButton.add(fileNew);
        fileButton.add(openItem);
        fileButton.add(saveItem);
        fileButton.add(closeItem);

        // Creating edit menu button
        JMenu editButton = new JMenu("Edit");

        // Creating edit dropdown items
        JMenuItem editSelectAll = new JMenuItem("Select All");
        JMenuItem editCut = new JMenuItem("Cut");
        JMenuItem editCopy = new JMenuItem("Copy");
        JMenuItem editPaste = new JMenuItem("Paste");

        // Adding action listeners
        editSelectAll.addActionListener(e -> MenuBarActionListener.action(newPage, e));
        editCut.addActionListener(e -> MenuBarActionListener.action(newPage, e));
        editCopy.addActionListener(e -> MenuBarActionListener.action(newPage, e));
        editPaste.addActionListener(e -> MenuBarActionListener.action(newPage, e));

        // Adding dropdown items to edit
        editButton.add(editSelectAll);
        editButton.add(editCut);
        editButton.add(editCopy);
        editButton.add(editPaste);

        // Creating view menu button
        JMenu viewButton = new JMenu("View");

        // Creating view dropdown items
        JMenuItem viewLightMode = new JMenuItem("Light Mode");
        JMenuItem viewDarkMode = new JMenuItem("Dark Mode");

        // Adding action listeners
        viewLightMode.addActionListener(e -> MenuBarActionListener.action(newPage, e));
        viewDarkMode.addActionListener(e -> MenuBarActionListener.action(newPage, e));

        // Adding dropdown items to view button
        viewButton.add(viewLightMode);
        viewButton.add(viewDarkMode);

        // Adding file, edit, and view buttons to menuBar
        menuBar.add(fileButton);
        menuBar.add(editButton);
        menuBar.add(viewButton);

        newWindow.add(scrollPage);
        newWindow.setSize(600, 400);
        newWindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        newWindow.setLocation(TextEditor.frame.getX() + 50, TextEditor.frame.getY() + 50);

        newWindow.setVisible(true);
    }
}
