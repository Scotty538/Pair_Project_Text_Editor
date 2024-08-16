import org.fife.ui.rsyntaxtextarea.RSyntaxTextArea;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FontTest {

//    @Test
//    public void checkFont() {
//        FontSetter window = new FontSetter(); // Instantiate FontSetter to test
//        assertEquals("Consolas", FontSetter.consolas().getFontName());
//    }

    // Method to return a text area's font name
    public String checkFont(RSyntaxTextArea textArea) {
        return textArea.getFont().getName();
    }

    // Tests that ChildWindow uses the expected font
    @Test
    public void checkFont() {
        ChildWindow window = new ChildWindow(); // Instantiate ChildWindow to test
        assertEquals("Consolas", checkFont(ChildWindow.newPage));
    }
}
