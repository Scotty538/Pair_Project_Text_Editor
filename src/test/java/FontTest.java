import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FontTest {

    @Test
    public void checkFont() {
        FontSetter window = new FontSetter(); // Instantiate FontSetter to test
        assertEquals("Consolas", FontSetter.consolas().getFontName());
    }

}
