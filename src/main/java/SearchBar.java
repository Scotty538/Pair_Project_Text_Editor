import org.fife.ui.rtextarea.SearchContext;
import org.fife.ui.rtextarea.SearchEngine;
import org.fife.ui.rtextarea.SearchResult;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.Dimension;

public class SearchBar {
    public static JTextField createSearchBar() {
        JTextField searchBar = new JTextField();

        // Set preferred size (width, height)
        searchBar.setPreferredSize(new Dimension(100, 20)); // Example size

        // Set minimum and maximum size if needed
        searchBar.setMinimumSize(new Dimension(100, 20));
        searchBar.setMaximumSize(new Dimension(100, 20));

        searchBar.addActionListener(e -> {
            String targetWord = searchBar.getText();
            findWord(targetWord);
        });

        return searchBar;
    }

    public static void findWord(String targetWord) {
        // Make sure target word is not empty
        if (targetWord.isEmpty()) {
            JOptionPane.showMessageDialog(ChildWindow.newWindow, "Please enter a word to search for!");
            return;
        }

        ChildWindow.newPage.setCaretPosition(0); // Set caret to start of document
        SearchContext context = new SearchContext();
        context.setSearchFor(targetWord);

        context.setMatchCase(false); // Allows case insensitive search
        context.setWholeWord(false); // Allows searching multiple word strings

        SearchResult result = SearchEngine.find(ChildWindow.newPage, context);

        // If word not found in document
        if (!result.wasFound()) {
            JOptionPane.showMessageDialog(ChildWindow.newWindow, "Word not found!");
        }
    }

}
