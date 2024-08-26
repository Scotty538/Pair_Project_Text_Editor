import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import org.fife.ui.rsyntaxtextarea.RSyntaxTextArea;
import org.fife.ui.rsyntaxtextarea.SyntaxConstants;
import org.fife.ui.rsyntaxtextarea.Theme;
import org.fife.ui.rtextarea.Gutter;
import org.odftoolkit.simple.TextDocument;
import org.odftoolkit.simple.text.Paragraph;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.text.Document;
import javax.swing.text.rtf.RTFEditorKit;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.*;
import java.util.Date;
import java.util.Iterator;

public class MenuBarActionListener {
    // Adding events for when a menu button is clicked
    public static void action(RSyntaxTextArea textArea, ActionEvent e, Gutter gutter, JFrame newWindow) {
        String s = e.getActionCommand();

        if (s.equals("New")) {
            new ChildWindow();
        } else if (s.equals("Open")) {
            // Creating a new JFileChooser object
            JFileChooser fileChooser = new JFileChooser();

            // Adding multiple file filters
            fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("Text Files", "txt"));
            fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("Rich Text Format", "rtf"));
            fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("OpenDocument Text", "odt"));
            fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("C++", "cpp"));
            fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("Java", "java"));
            fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("Javascript", "js"));
            fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("Python", "py"));

            // Calling showOpenDialog method to open file browser and select file
            int returnValue = fileChooser.showOpenDialog(null);

            if (returnValue == JFileChooser.APPROVE_OPTION) {
                File selectedFile = fileChooser.getSelectedFile();
                String filePath = selectedFile.getAbsolutePath();

                // Selecting appropriate syntax depending on file type
                try {
                    if (filePath.endsWith(".txt")) {
                        textArea.setSyntaxEditingStyle(SyntaxConstants.SYNTAX_STYLE_NONE);
                        textArea.setText(readFile(selectedFile, newWindow));
                    } else if (filePath.endsWith(".rtf")) {
                        textArea.setSyntaxEditingStyle(SyntaxConstants.SYNTAX_STYLE_NONE);
                        textArea.setText(readRTFFile(selectedFile, newWindow));
                    } else if (filePath.endsWith(".odt")) {
                        textArea.setSyntaxEditingStyle(SyntaxConstants.SYNTAX_STYLE_NONE);
                        textArea.setText(readODTFile(selectedFile, newWindow));
                    } else if (filePath.endsWith(".java")) {
                        textArea.setSyntaxEditingStyle(SyntaxConstants.SYNTAX_STYLE_JAVA);
                        textArea.setText(readFile(selectedFile, newWindow));
                    } else if (filePath.endsWith(".py")) {
                        textArea.setSyntaxEditingStyle(SyntaxConstants.SYNTAX_STYLE_PYTHON);
                        textArea.setText(readFile(selectedFile, newWindow));
                    } else if (filePath.endsWith(".cpp")) {
                        textArea.setSyntaxEditingStyle(SyntaxConstants.SYNTAX_STYLE_CPLUSPLUS);
                        textArea.setText(readFile(selectedFile, newWindow));
                    } else if (filePath.endsWith(".js")) {
                        textArea.setSyntaxEditingStyle(SyntaxConstants.SYNTAX_STYLE_JAVASCRIPT);
                        textArea.setText(readFile(selectedFile, newWindow));
                    } else {
                        textArea.setText("Cannot open file. Unknown file type.");
                    }
                } catch (Exception eReading) {
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

                // Obtaining the path to the selected directory and forcing file to be saved as text file.
                String pathName = fileChooser.getSelectedFile().getAbsolutePath();
                if (!pathName.endsWith(".txt")) {
                    pathName = pathName + ".txt";
                }
                File filePath = new File(pathName);

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
        } else if (s.equals("Export As PDF")) {
            exportToPdf(textArea, newWindow);
        } else if (s.equals("Print")) {
            try {
                // In case there is a problem with printing
                textArea.print();
            } catch (Exception ePrinting) {
                JOptionPane.showMessageDialog(newWindow, "Error printing file: " + ePrinting.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else if (s.equals("Exit All")) {
            int result = JOptionPane.showConfirmDialog(ChildWindow.newWindow, "Are you sure you want to quit the programme? Any unsaved changes will be lost.", "Warning", JOptionPane.YES_NO_OPTION);
            if (result == JOptionPane.YES_OPTION) {
                System.exit(0); // Close all windows
            }
        } else if (s.equals("Select All")) {
            textArea.selectAll();
        } else if (s.equals("Cut")) {
            textArea.cut();
        } else if (s.equals("Copy")) {
            textArea.copy();
        } else if (s.equals("Paste")) {
            textArea.paste();
        } else if (s.equals("Date & Time")) {
            String existing = textArea.getText();
            Date timeAndDate = new Date();
            existing = timeAndDate + "\n\n" + existing;

            // Printing to the page
            textArea.setText(existing);
        } else if (s.equals("Light Mode")) {

            // Setting menuBar color to dark theme
            try {
                UIManager.setLookAndFeel("com.formdev.flatlaf.FlatLightLaf");
            } catch (Exception ex) {
                System.err.println("Failed to initialize LaF");
            }
            // Changing syntax highlighting color scheme to match change in mode
            try {
                Theme theme = Theme.load(MenuBarActionListener.class.getResourceAsStream(
                        "/org/fife/ui/rsyntaxtextarea/themes/default.xml"));
                theme.apply(textArea);
            } catch (IOException eRSyntax) {
                JOptionPane.showMessageDialog(newWindow, "Error setting theme for light mode: " + eRSyntax.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }

            // Updating current window
            SwingUtilities.updateComponentTreeUI(newWindow);

            textArea.setFont(new Font(ChildWindow.fontName, ChildWindow.fontStyle, ChildWindow.fontSize));

            textArea.setForeground(new Color(58, 58, 58));
            textArea.setBackground(new Color(214, 214, 214));
            gutter.setBackground(new Color(214, 214, 214));
            textArea.setCurrentLineHighlightColor(new Color(189, 189, 189)); // Change colour of highlighted line
            ChildWindow.darkMode = false;

        } else if (s.equals("Dark Mode")) {

            // Setting menuBar color to dark theme
            try {
                UIManager.setLookAndFeel("com.formdev.flatlaf.FlatDarkLaf");
            } catch (Exception ex) {
                System.err.println("Failed to initialize LaF");
            }
            // Changing syntax highlighting color scheme to match change in mode
            try {
                Theme theme = Theme.load(MenuBarActionListener.class.getResourceAsStream(
                        "/org/fife/ui/rsyntaxtextarea/themes/monokai.xml"));
                theme.apply(textArea);
            } catch (IOException eRSyntax) {
                JOptionPane.showMessageDialog(newWindow, "Error setting theme for light mode: " + eRSyntax.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
            // Updating current window
            SwingUtilities.updateComponentTreeUI(newWindow);

            textArea.setFont(new Font(ChildWindow.fontName, ChildWindow.fontStyle, ChildWindow.fontSize));

            textArea.setForeground(new Color(204, 204, 204));
            textArea.setBackground(new Color(58, 58, 58));
            gutter.setBackground(new Color(58, 58, 58));
            textArea.setCurrentLineHighlightColor(new Color(84, 84, 84)); // Change colour of highlighted line
            ChildWindow.darkMode = true;

        } else if (s.equals("About")) {
            JOptionPane.showMessageDialog(ChildWindow.newWindow, "Created by Alex Malone & Scott O'Connor for Assignment 1 of 159251, 2024");
        }
    }

    private static String readFile(File file, JFrame newWindow) {
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

    private static String readRTFFile(File file, JFrame newWindow) {
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

    private static String readODTFile(File file, JFrame newWindow) {
        try {
            TextDocument document = TextDocument.loadDocument(file);
            String content = "";

            // Using a paragraphIterator() to iterate through paragraphs
            Iterator<Paragraph> paragraphIterator = document.getParagraphIterator();

            while (paragraphIterator.hasNext()) {
                Paragraph paragraph = paragraphIterator.next();
                content = content + "\n" + paragraph.getTextContent();
            }
            return content;
        } catch (Exception eODT) {
            JOptionPane.showMessageDialog(newWindow, "Error reading ODT file: " + eODT.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return ""; // Return empty string if error occurs
    }

    private static void exportToPdf(RSyntaxTextArea textArea, JFrame newWindow) {
        // Creating new file chooser
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Specify location to save PDF file");
        // Calling showOpenDialog method to open file browser
        int directorySelection = fileChooser.showSaveDialog(null);

        if (directorySelection == JFileChooser.APPROVE_OPTION) {
            // Getting path to directory
            File file = fileChooser.getSelectedFile();
            String filePath = file.getAbsolutePath();

            // Make file has .pdf extension
            if (!filePath.toLowerCase().endsWith(".pdf")) {
                filePath += ".pdf";
            }
            try {
                // Creating PDF writer and document
                PdfWriter writer = new PdfWriter(filePath);
                PdfDocument pdfDocument = new PdfDocument(writer);
                com.itextpdf.layout.Document pdfLayoutDocument = new com.itextpdf.layout.Document(pdfDocument); // Must write out entire iText Document path because Swing's Document is already imported

                // Add content from editor to PDF
                pdfLayoutDocument.add(new com.itextpdf.layout.element.Paragraph(textArea.getText()));

                // Close the document
                pdfLayoutDocument.close();
            } catch (Exception eExportPDF) {
                JOptionPane.showMessageDialog(newWindow, "Error saving PDF: " + eExportPDF.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}


