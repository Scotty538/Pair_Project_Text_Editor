import org.fife.ui.rsyntaxtextarea.RSyntaxTextArea;
import org.junit.Test;

import javax.swing.*;

import java.awt.*;

import static org.junit.Assert.assertEquals;

public class FontTest {
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

//    @Test
//    public void checkBackgroundColor() {
//        AlexScott window = new AlexScott(); // Instantiate ChildWindow to test
//        assertEquals(new Color(58, 58, 58), ChildWindow.newPage.getBackground());
//    }

}
