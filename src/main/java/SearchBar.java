import org.fife.ui.rsyntaxtextarea.RSyntaxTextArea;

import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Highlighter;
import java.awt.*;

public class SearchBar {
    // Creating search bar UI component
    public static JTextField createSearchBar(RSyntaxTextArea textArea, JFrame newWindow) {
        JTextField searchBar = new JTextField();

        searchBar.setPreferredSize(new Dimension(100, 22)); // Set preferred size of search bar
        searchBar.setMaximumSize(new Dimension(125, 22)); // Set maximum size of search bar

        searchBar.addActionListener(e -> {
            String targetWord = searchBar.getText().toLowerCase();
            findWord(targetWord, textArea, newWindow);
        });

        return searchBar;
    }

    public static void findWord(String targetWord, RSyntaxTextArea textArea, JFrame newWindow) {
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
            JOptionPane.showMessageDialog(newWindow, "Target word could not be found in this file.");
        }

        // Searching for instances of target word
        while (index >= 0) {
            int endIndex = index + targetWord.length();
            try {
                highlighter.addHighlight(index, endIndex, painter);
            } catch (BadLocationException eHighlighting) {
                JOptionPane.showMessageDialog(newWindow, "Error highlighting file: " + eHighlighting.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
            index = text.indexOf(targetWord, endIndex);
        }
    }
}

