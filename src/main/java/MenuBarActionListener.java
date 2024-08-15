import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.*;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.text.Document;
import javax.swing.text.rtf.RTFEditorKit;

import org.fife.ui.rsyntaxtextarea.RSyntaxTextArea;
import org.fife.ui.rsyntaxtextarea.SyntaxConstants;
import org.fife.ui.rsyntaxtextarea.Theme;
import org.fife.ui.rtextarea.Gutter;

public class MenuBarActionListener {
    // Adding events for when a menu button is clicked
    public static void action(RSyntaxTextArea textArea, ActionEvent e, Gutter gutter, JFrame newWindow) {
        String s = e.getActionCommand();

        if (s.equals("New")) {
            ChildWindow newOne = new ChildWindow();
        } else if (s.equals("Open")) {
            // Creating a new JFileChooser object
            JFileChooser fileChooser = new JFileChooser();

            // Adding multiple file filters
            fileChooser.setFileFilter(new FileNameExtensionFilter("Text Files", "txt"));
            fileChooser.setFileFilter(new FileNameExtensionFilter("Rich Text Format", "rtf"));
            fileChooser.setFileFilter(new FileNameExtensionFilter("OpenDocument Text", "odt"));

            // Calling showOpenDialog method to open file browser and select file
            int returnValue = fileChooser.showOpenDialog(null);

            if (returnValue == JFileChooser.APPROVE_OPTION) {
                File selectedFile = fileChooser.getSelectedFile();
                String filePath = selectedFile.getAbsolutePath();

                // Selecting appropriate read method depending on file type
                try {
                    if (filePath.endsWith(".txt")) {
                        // Reading plain text file
                        textArea.setSyntaxEditingStyle(SyntaxConstants.SYNTAX_STYLE_NONE);
                        textArea.setText(readTxtFile(selectedFile, newWindow));
                    } else if (filePath.endsWith(".rtf")) {
                        // Reading RTF file
                        textArea.setSyntaxEditingStyle(SyntaxConstants.SYNTAX_STYLE_NONE);
                        textArea.setText(readRTFFile(selectedFile, newWindow));
                    } else {
                        textArea.setText("Cannot open file. Unknown file type.");
                    }
                } catch (IOException eReading) {
                    JOptionPane.showMessageDialog(newWindow, "Error reading file: " + eReading.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
                // Updating window title to the file name
                newWindow.setTitle(selectedFile.getName());
            }
        } else if (s.equals("Save As")) {
            // Creating a new JFileChooser object with relevant header
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setDialogTitle("Specify location to save file");
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
                } catch (Exception eSaving) {
                    JOptionPane.showMessageDialog(newWindow, "Error saving file: " + eSaving.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
                // Updating window title to the file name
                newWindow.setTitle(filePath.getName());
            }
        } else if (s.equals("Print")) {
            try {
                // In case there is a problem with printing
                textArea.print();
            } catch (Exception ePrinting) {
                JOptionPane.showMessageDialog(newWindow, "Error printing file: " + ePrinting.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else if (s.equals("Exit All")) {
            System.exit(0); // Close all windows
        }
        else if (s.equals("Select All")) {
            textArea.selectAll();
        } else if (s.equals("Cut")) {
            textArea.cut();
        } else if (s.equals("Copy")) {
            textArea.copy();
        } else if (s.equals("Paste")) {
            textArea.paste();
        } else if (s.equals("Light Mode")) {
            // Setting menuBar color to light theme
            try {
                UIManager.setLookAndFeel("com.formdev.flatlaf.FlatLightLaf");
            } catch (Exception ex) {
                System.err.println("Failed to initialize LaF");
            }
            // Changing syntax highlighting color scheme to match changing mode
            try {
                Theme theme = Theme.load(MenuBarActionListener.class.getResourceAsStream(
                        "/org/fife/ui/rsyntaxtextarea/themes/default.xml"));
                theme.apply(textArea);
            } catch (IOException eRSyntax) {
                JOptionPane.showMessageDialog(newWindow, "Error setting theme for light mode: " + eRSyntax.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
            SwingUtilities.updateComponentTreeUI(newWindow);

            Font font = new Font("Consolas", Font.PLAIN, 14);
            textArea.setFont(font);

            textArea.setForeground(new Color(58, 58, 58));
            textArea.setBackground(new Color(214, 214, 214));
            ChildWindow.newPage.setCurrentLineHighlightColor(new Color(189, 189, 189)); // Change colour of highlighted line
            ChildWindow.darkMode = false;
            gutter.setBackground(new Color(214, 214, 214));
        } else if (s.equals("Dark Mode")) {
            // Setting menuBar color to dark theme
            try {
                UIManager.setLookAndFeel("com.formdev.flatlaf.FlatDarkLaf");
            } catch (Exception ex) {
                System.err.println("Failed to initialize LaF");
            }
            SwingUtilities.updateComponentTreeUI(newWindow);

            // Changing syntax highlighting color scheme to match change in mode
            try {
                Theme theme = Theme.load(MenuBarActionListener.class.getResourceAsStream(
                        "/org/fife/ui/rsyntaxtextarea/themes/monokai.xml"));
                theme.apply(textArea);
            } catch (IOException eRSyntax) {
                JOptionPane.showMessageDialog(newWindow, "Error setting theme for light mode: " + eRSyntax.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
            Font font = new Font("Consolas", Font.PLAIN, 14);
            textArea.setFont(font);

            textArea.setForeground(new Color(204, 204, 204));
            textArea.setBackground(new Color(58, 58, 58));
            gutter.setBackground(new Color(58, 58, 58));
            ChildWindow.newPage.setCurrentLineHighlightColor(new Color(84, 84, 84)); // Change colour of highlighted line
            ChildWindow.darkMode = true;
        } else if (s.equals("About")) {
            JOptionPane.showMessageDialog(ChildWindow.newWindow, "Made by Scott and Alex \nThis text editor was created for an assignment.\n2024");

        }
    }

    private static String readTxtFile(File file, JFrame newWindow) throws IOException {
        String line, page = "";
        try {
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            page = br.readLine();
            while ((line = br.readLine()) != null) {
                page = page + "\n" + line;
            }
        } catch (Exception eTxt) {
            JOptionPane.showMessageDialog(newWindow, "Error reading text file: " + eTxt.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return page;
    }
    private static String readRTFFile(File file, JFrame newWindow) throws IOException {
        RTFEditorKit rtfEditorKit = new RTFEditorKit();
        StringWriter writer = new StringWriter();
        try {
            InputStream inputStream = new FileInputStream(file);
            Document document = rtfEditorKit.createDefaultDocument();
            rtfEditorKit.read(inputStream, document, 0);
            writer.write(document.getText(0, document.getLength()));
        } catch (Exception eRTF) {
            JOptionPane.showMessageDialog(newWindow, "Error reading RTF file: " + eRTF.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return writer.toString();
    }
}


