import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class MenuBarActionListener implements ActionListener {
    // Adding events for when a menu button is clicked
    public void actionPerformed(ActionEvent e) {
        String s = e.getActionCommand();

        if (s.equals("New")) {
            TextEditor.page.setText("");
        } else if (s.equals("Open")) {
            // Creating a new JFileChooser object
            JFileChooser fileChooser = new JFileChooser("F:");

            // Calling showOpenDialog method to open file browser and select file
            int fileSelection = fileChooser.showOpenDialog(null);

            if (fileSelection == JFileChooser.APPROVE_OPTION) {
                // Obtaining the path to the selected file
                File filePath = new File(fileChooser.getSelectedFile().getAbsolutePath());
                try {
                    // Initialising variables to read and write text
                    String line = "";
                    String page = "";

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

                    // Setting the text to the editor
                    TextEditor.page.setText(page);
                } catch (Exception eOpen) {
                    JOptionPane.showMessageDialog(TextEditor.frame, eOpen.getMessage());
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
                    bw.write(TextEditor.page.getText());

                    bw.flush();
                    bw.close();
                } catch (Exception eSave) {
                    JOptionPane.showMessageDialog(TextEditor.frame, eSave.getMessage());
                }
            }
        } else if (s.equals("Print")) {
            try {
                // In case there is a problem with printing
                TextEditor.page.print();
            } catch (Exception ePrint) {
                JOptionPane.showMessageDialog(TextEditor.frame, ePrint.getMessage());
            }
        } else if (s.equals("Select All")) {
            TextEditor.page.selectAll();
        } else if (s.equals("Cut")) {
            TextEditor.page.cut();
        } else if (s.equals("Copy")) {
            TextEditor.page.copy();
        } else if (s.equals("Paste")) {
            TextEditor.page.paste();
        }
    }
}

