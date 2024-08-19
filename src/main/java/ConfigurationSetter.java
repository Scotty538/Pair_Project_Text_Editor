import org.yaml.snakeyaml.Yaml;
import java.io.InputStream;
import java.io.IOException;

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
