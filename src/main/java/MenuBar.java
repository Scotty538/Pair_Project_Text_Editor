import org.fife.ui.rsyntaxtextarea.RSyntaxTextArea;
import org.fife.ui.rtextarea.Gutter;

import javax.swing.*;

public class MenuBar {
    public static JMenuBar createMenuBar(RSyntaxTextArea page, Gutter gutter, JFrame newWindow) {
        // Creating menu bar
        JMenuBar menuBar = new JMenuBar();

        // Creating File menu button
        JMenu fileButton = new JMenu("File");
        fileButton.setName("File");  // Naming so automated testing can identify component

        // Creating File menu dropdown items
        JMenuItem fileNew = new JMenuItem("New");
        JMenuItem fileOpen = new JMenuItem("Open");
        fileOpen.setName("Open");  // Naming so automated testing can identify component
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

        // Adding dropdown items to File
        fileButton.add(fileNew);
        fileButton.add(fileOpen);
        fileButton.add(fileSave);
        fileButton.add(fileExportAsPDF);
        fileButton.add(filePrint);
        fileButton.add(fileExitAll);

        // Creating Edit menu button
        JMenu editButton = new JMenu("Edit");

        // Creating Edit dropdown items
        JMenuItem editSelectAll = new JMenuItem("Select All");
        JMenuItem editCut = new JMenuItem("Cut");
        JMenuItem editCopy = new JMenuItem("Copy");
        JMenuItem editPaste = new JMenuItem("Paste");
        JMenuItem editTimeAndDate = new JMenuItem("Date & Time");

        // Adding action listener
        editSelectAll.addActionListener(e -> MenuBarActionListener.action(page, e, gutter, newWindow));
        editCut.addActionListener(e -> MenuBarActionListener.action(page, e, gutter, newWindow));
        editCopy.addActionListener(e -> MenuBarActionListener.action(page, e, gutter, newWindow));
        editPaste.addActionListener(e -> MenuBarActionListener.action(page, e, gutter, newWindow));
        editTimeAndDate.addActionListener(e -> MenuBarActionListener.action(page, e, gutter, newWindow));

        // Adding dropdown items to Edit
        editButton.add(editSelectAll);
        editButton.add(editCut);
        editButton.add(editCopy);
        editButton.add(editPaste);
        editButton.add(editTimeAndDate);

        // Creating View mode menu button
        JMenu viewButton = new JMenu("View");

        // Creating View dropdown items
        JMenuItem viewLightMode = new JMenuItem("Light Mode");
        JMenuItem viewDarkMode = new JMenuItem("Dark Mode");

        // Adding action listener
        viewLightMode.addActionListener(e -> MenuBarActionListener.action(page, e, gutter, newWindow));
        viewDarkMode.addActionListener(e -> MenuBarActionListener.action(page, e, gutter, newWindow));

        // Adding dropdown items to View
        viewButton.add(viewLightMode);
        viewButton.add(viewDarkMode);

        // Creating 'AlexScott' section
        JMenu nameButton = new JMenu("TE");
        JMenuItem aboutItem = new JMenuItem("About");

        // Adding dropdown item to AlexScott
        nameButton.add(aboutItem);

        // Adding action listener
        aboutItem.addActionListener(e -> MenuBarActionListener.action(page, e, gutter, newWindow));

        // Creating 'Search' section
        JMenu searchButton = new JMenu("Search");
        searchButton.add(SearchBar.createSearchBar(page, newWindow)); // Add search bar to help dropdown

        // Adding file, edit, and mode buttons to menu
        menuBar.add(nameButton);
        menuBar.add(fileButton);
        menuBar.add(editButton);
        menuBar.add(viewButton);
        menuBar.add(searchButton);

        return menuBar;
    }
}
