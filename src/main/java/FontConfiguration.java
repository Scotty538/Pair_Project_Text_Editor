import java.util.Map;

public class FontConfiguration {
    private Map<String, FontStyle> appearance;
    public Map<String, FontStyle> getAppearance() {
        return appearance;
    }
    public void setAppearance(Map<String, FontStyle> appearance) {
        this.appearance = appearance;
    }

    public static class FontStyle {
        private String fontName;
        private String fontSize;
        private String fontStyle;

        public String getFontName() {
            return fontName;
        }

        public void setFontName(String fontName) {
            this.fontName = fontName;
        }

        public String getFontSize() {
            return fontSize;
        }

        public void setFontSize(String fontSize) {
            this.fontSize = fontSize;
        }

        public String getFontStyle() {
            return fontStyle;
        }

        public void setFontStyle(String fontStyle) {
            this.fontStyle = fontStyle;
        }
    }
}
