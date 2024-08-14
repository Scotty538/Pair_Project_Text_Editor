import org.fife.ui.rsyntaxtextarea.RSyntaxTextArea;
import org.fife.ui.rtextarea.Gutter;

import javax.swing.*;

public class MenuBar {
    public static JMenuBar createMenuBar(RSyntaxTextArea page, Gutter gutter, JFrame newWindow) {
        // Creating menu bar
        JMenuBar menuBar = new JMenuBar();

        // Creating file menu button
        JMenu fileButton = new JMenu("File");

        // Creating file menu dropdown items
        JMenuItem fileNew = new JMenuItem("New");
        JMenuItem fileOpen = new JMenuItem("Open");
        JMenuItem fileSave = new JMenuItem("Save As");
        JMenuItem fileExportAsPDF = new JMenuItem("Export As PDF");
        JMenuItem filePrint = new JMenuItem("Print");
        JMenuItem fileExitAll = new JMenuItem("Exit All");

        // Adding action listener
        fileNew.addActionListener(e -> MenuBarActionListener.action(page, e, gutter, newWindow));
        fileOpen.addActionListener(e -> MenuBarActionListener.action(page, e, gutter, newWindow));
        fileSave.addActionListener(e -> MenuBarActionListener.action(page, e, gutter, newWindow));
        fileExportAsPDF.addActionListener(e -> MenuBarActionListener.action(page, e, gutter, newWindow));
        filePrint.addActionListener(e -> MenuBarActionListener.action(page, e, gutter, newWindow));
        fileExitAll.addActionListener(e -> MenuBarActionListener.action(page, e, gutter, newWindow));

        // Adding dropdown items to file
        fileButton.add(fileNew);
        fileButton.add(fileOpen);
        fileButton.add(fileSave);
        fileButton.add(fileExportAsPDF);
        fileButton.add(filePrint);
        fileButton.add(fileExitAll);

        // Creating edit menu button
        JMenu editButton = new JMenu("Edit");

        // Creating edit dropdown items
        JMenuItem editSelectAll = new JMenuItem("Select All");
        JMenuItem editCut = new JMenuItem("Cut");
        JMenuItem editCopy = new JMenuItem("Copy");
        JMenuItem editPaste = new JMenuItem("Paste");

        // Adding action listener
        editSelectAll.addActionListener(e -> MenuBarActionListener.action(page, e, gutter, newWindow));
        editCut.addActionListener(e -> MenuBarActionListener.action(page, e, gutter, newWindow));
        editCopy.addActionListener(e -> MenuBarActionListener.action(page, e, gutter, newWindow));
        editPaste.addActionListener(e -> MenuBarActionListener.action(page, e, gutter, newWindow));

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
        viewLightMode.addActionListener(e -> MenuBarActionListener.action(page, e, gutter, newWindow));
        viewDarkMode.addActionListener(e -> MenuBarActionListener.action(page, e, gutter, newWindow));

        // Adding dropdown items to edit
        viewButton.add(viewLightMode);
        viewButton.add(viewDarkMode);

        // Creating 'About' section
        JMenu helpButton = new JMenu("Help");
        JMenuItem aboutItem = new JMenuItem("About");

        // Adding action listener
        aboutItem.addActionListener(e ->MenuBarActionListener.action(page, e, gutter, newWindow));

        helpButton.add(SearchBar.createSearchBar(page)); // Add search bar to help dropdown
        helpButton.add(aboutItem); // Add about item to help dropdown

        // Adding file, edit, and mode buttons to menu
        menuBar.add(fileButton);
        menuBar.add(editButton);
        menuBar.add(viewButton);
        menuBar.add(helpButton);
        menuBar.add(Box.createHorizontalGlue());
        menuBar.add(new JLabel("Search: "));

        return menuBar;
    }
}
