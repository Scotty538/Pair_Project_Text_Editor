import org.fife.ui.rsyntaxtextarea.RSyntaxTextArea;
import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Highlighter;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class SearchBar {
    // Create search bar UI component
    public static JTextField createSearchBar(RSyntaxTextArea textArea) {
        JTextField searchBar = new JTextField();

        searchBar.addActionListener(e -> {
            String targetWord = searchBar.getText().toLowerCase();
            findWord(targetWord, textArea);
        });

        return searchBar;
    }

    public static void findWord(String targetWord, RSyntaxTextArea textArea) {
        Highlighter highlighter = textArea.getHighlighter();
        Highlighter.HighlightPainter painter = new DefaultHighlighter.DefaultHighlightPainter(Color.orange);

        // If target word is empty, highlights are removed
        if (targetWord.isEmpty()) {
            textArea.getHighlighter().removeAllHighlights();
            return;
        }

        // Locating index
        String text = textArea.getText().toLowerCase();
        int index = text.indexOf(targetWord);

        // If word not found in document
        if (index == -1) {
            JOptionPane.showMessageDialog(ChildWindow.newWindow, "Target word could not be found in this file.");
        }

        // Searching for instances of target word
        while (index >= 0) {
            int endIndex = index + targetWord.length();
            try {
                highlighter.addHighlight(index, endIndex, painter);
            } catch (BadLocationException eHighlighting) {
                JOptionPane.showMessageDialog(ChildWindow.newWindow, "Error highlighting file: " + eHighlighting.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
            index = text.indexOf(targetWord, endIndex);
        }
        }
    }

