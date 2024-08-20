import org.assertj.swing.core.BasicRobot;
import org.assertj.swing.core.Robot;
import org.assertj.swing.fixture.FrameFixture;
import org.assertj.swing.fixture.JMenuItemFixture;
import org.fife.ui.rsyntaxtextarea.RSyntaxTextArea;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
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

//
//    @Before
//    public void setUp() {
//        // Start Xvfb
//        runXvfb();
//
//        // Initialize the Swing GUI and AssertJ Swing
//        robot = BasicRobot.robotWithCurrentAwtHierarchy();
//        fixture = new FrameFixture(robot, cWindow.getFrame());
//        fixture.show(); // Shows the window
//    }
//
//    @Test
//    public void checkOpen() {
//        // Simulating clicking on the "File" menu button
//        JMenuItemFixture fileMenu = fixture.menuItem("File");
//        fileMenu.click();
//
//        // Simulating clicking  on the "Open" drop down item
//        JMenuItemFixture openMenuItem = fixture.menuItem("Open");
//        openMenuItem.click();
//
//        // Getting this far was incredibly hard, all I can do now is check the button actually exists
//        assertThat(openMenuItem).isNotNull();
//    }
//
//    @After
//    public void tearDown() {
//        // Cleaning up the test environment
//        fixture.cleanUp();
//        stopXvfb();
//    }
//
//    private void runXvfb() {
//        try {
//            ProcessBuilder pBuilder = new ProcessBuilder("Xvfb", ":99", "-screen", "0", "1024x768x24");
//            pBuilder.redirectErrorStream(true);
//            Process process = pBuilder.start();
//            process.waitFor();
//            System.setProperty("java.awt.headless", "false");
//            System.setProperty("DISPLAY", ":99");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    private void stopXvfb() {
//        try {
//            ProcessBuilder pBuilder = new ProcessBuilder("pkill", "Xvfb");
//            pBuilder.redirectErrorStream(true);
//            Process process = pBuilder.start();
//            process.waitFor();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
}

