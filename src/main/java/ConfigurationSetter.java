import org.yaml.snakeyaml.Yaml;
import java.io.InputStream;
import java.io.IOException;

// Reads the font specifications in the config.yaml file and loads them into a FontConfiguration object
// from where the font specifications can then be applied to the text editor.
public class ConfigurationSetter {
    private final FontConfiguration configuration;

    public ConfigurationSetter(String filePath) throws IOException {
        Yaml yaml = new Yaml();
        try (InputStream input = getClass().getClassLoader().getResourceAsStream(filePath)) {
            if (input == null) {
                throw new IOException("Configuration file not found: " + filePath);
            }
            configuration = yaml.loadAs(input, FontConfiguration.class);
        }
    }

    public FontConfiguration getConfiguration() {
        return configuration;
    }
}
