
import org.assertj.swing.core.Robot;
import org.assertj.swing.fixture.FrameFixture;
import org.fife.ui.rsyntaxtextarea.RSyntaxTextArea;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class Tests {
    private FrameFixture fixture;
    private Robot robot;
    public ChildWindow cWindow = new ChildWindow(); // Instantiate ChildWindow to test

    // Method to return a text area's font name
    // Alex actually authored these methods - I removed them while searching for a fix
    // to the GitHub workflow problem and then re-added them.
    public String checkFont(RSyntaxTextArea textArea) {
        return textArea.getFont().getName();
    }

    // Tests that ChildWindow uses the expected font
    @Test
    public void checkFont() {
        assertEquals("Consolas", checkFont(cWindow.newPage));
    }
}

