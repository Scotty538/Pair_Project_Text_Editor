import org.fife.ui.rsyntaxtextarea.RSyntaxTextArea;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Tests {
    // Method to return a text area's font name
    // Alex actually authored these methods - I removed them while searching for a fix
    // to the GitHub workflow problem and then re-added them.
    public ChildWindow window = new ChildWindow(); // Instantiate ChildWindow to test

    public String checkFont(RSyntaxTextArea textArea) {
        return textArea.getFont().getName();
    }

    // Tests that ChildWindow uses the expected font
    @Test
    public void checkFont() {
        assertEquals("Consolas", checkFont(ChildWindow.newPage));
    }

    // Tests that ChildWindow is the expected size
    @Test
    public void checkWindowSize() {
        assertEquals(600, ChildWindow.newWindow.getWidth());
        assertEquals(400, ChildWindow.newWindow.getHeight());
    }
}
