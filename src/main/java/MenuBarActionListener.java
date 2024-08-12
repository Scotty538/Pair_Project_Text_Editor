import org.fife.ui.rsyntaxtextarea.RSyntaxTextArea;
import org.fife.ui.rsyntaxtextarea.Theme;
import org.fife.ui.rtextarea.Gutter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.*;

public class MenuBarActionListener {
    // Adding events for when a menu button is clicked
    public static void action(RSyntaxTextArea textArea, ActionEvent e, Gutter gutter) {
        String s = e.getActionCommand();

        if (s.equals("New")) {
            ChildWindow newOne = new ChildWindow();
        } else if (s.equals("Open")) {
            // Creating a new JFileChooser object
            JFileChooser fileChooser = new JFileChooser("F:");

            // Calling showOpenDialog method to open file browser and select file
            int fileSelection = fileChooser.showOpenDialog(null);

            if (fileSelection == JFileChooser.APPROVE_OPTION) {
                // Obtaining the path to the selected file
                File filePath = new File(fileChooser.getSelectedFile().getAbsolutePath());
                try {
                    // Declaring variables to read and write text
                    String line;
                    String page;

                    // File reader
                    FileReader fr = new FileReader(filePath);

                    // Buffered reader
                    BufferedReader br = new BufferedReader(fr);

                    // Initializing page
                    page = br.readLine();

                    // Reading from the selected file
                    while ((line = br.readLine()) != null) {
                        page = page + "\n" + line;
                    }

                    // Setting the text to the JTextArea
                    textArea.setText(page);
                } catch (Exception eOpen) {
                    JOptionPane.showMessageDialog(ChildWindow.newWindow, eOpen.getMessage());
                }
            }
        } else if (s.equals("Save As")) {
            // Creating a new JFileChooser object
            JFileChooser fileChooser = new JFileChooser("F:");

            // Calling showOpenDialog method to open file browser and select directory
            int directorySelection = fileChooser.showSaveDialog(null);

            if (directorySelection == JFileChooser.APPROVE_OPTION) {

                // Obtaining the path to the selected directory
                File filePath = new File(fileChooser.getSelectedFile().getAbsolutePath());

                try {
                    // Creating file writer
                    FileWriter writer = new FileWriter(filePath, false);

                    // Creating buffered writer
                    BufferedWriter bw = new BufferedWriter(writer);

                    // Write file to new location
                    bw.write(textArea.getText());

                    bw.flush();
                    bw.close();
                } catch (Exception eSave) {
                    JOptionPane.showMessageDialog(ChildWindow.newWindow, eSave.getMessage());
                }
            }
        } else if (s.equals("Print")) {
            try {
                // In case there is a problem with printing
                textArea.print();
            } catch (Exception ePrint) {
                JOptionPane.showMessageDialog(ChildWindow.newWindow, ePrint.getMessage());
            }
        } else if (s.equals("Select All")) {
            textArea.selectAll();
        } else if (s.equals("Cut")) {
            textArea.cut();
        } else if (s.equals("Copy")) {
            textArea.copy();
        } else if (s.equals("Paste")) {
            textArea.paste();
        } else if (s.equals("Light Mode")) {
            // Changing syntax highlighting color scheme to match change in mode
            try {
                Theme theme = Theme.load(MenuBarActionListener.class.getResourceAsStream(
                        "/org/fife/ui/rsyntaxtextarea/themes/default.xml"));
                theme.apply(textArea);
            } catch (IOException eRSyntax) {
                System.out.println("There is a problem with the first RSyntaxTextArea syntax highlighting theme in MenuBarActionListener");
            }

            Font font = new Font("Consolas",Font.PLAIN,14);
            textArea.setFont(font);

            textArea.setForeground(new Color(58, 58, 58));
            textArea.setBackground(new Color(204, 204, 204));
            ChildWindow.newPage.setCurrentLineHighlightColor(new Color(189, 189, 189)); // Change colour of highlighted line
            ChildWindow.darkMode = false;
            gutter.setBackground(new Color(204, 204, 204));

        } else if (s.equals("Dark Mode")) {
            // Changing syntax highlighting color scheme to match change in mode
            try {
                Theme theme = Theme.load(MenuBarActionListener.class.getResourceAsStream(
                        "/org/fife/ui/rsyntaxtextarea/themes/monokai.xml"));
                theme.apply(textArea);
            } catch (IOException eRSyntax) {
                System.out.println("There is a problem with the second RSyntaxTextArea syntax highlighting theme in MenuBarActionListener");
            }

            Font font = new Font("Consolas",Font.PLAIN,14);
            textArea.setFont(font);

            textArea.setForeground(new Color(204, 204, 204));
            textArea.setBackground(new Color(58, 58, 58));
            gutter.setBackground(new Color(58, 58, 58));
            ChildWindow.newPage.setCurrentLineHighlightColor(new Color(84, 84, 84)); // Change colour of highlighted line
            ChildWindow.darkMode = true;
        }
    }
}

