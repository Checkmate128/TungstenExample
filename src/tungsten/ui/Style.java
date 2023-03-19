package ui;

import java.awt.*;

public class Style {
    protected Color primaryColor;
    protected Color secondaryColor;
    protected Color tertiaryColor;
    protected Color borderColor;
    protected Color hoverColor;
    protected Color unClickableColor;
    protected Font font;
    protected Color fontColor;

    public Style() {

    }

    public Color getPrimaryColor() {
        return primaryColor;
    }

    public Color getSecondaryColor() {
        return secondaryColor;
    }

    public Color getTertiaryColor() {
        return tertiaryColor;
    }

    public Color getBorderColor() {
        return borderColor;
    }

    public Color getHoverColor() {
        return hoverColor;
    }

    public Color getUnClickableColor() {
        return unClickableColor;
    }

    public Color getFontColor() {
        return fontColor;
    }

    public Font getFont() {
        return font;
    }
}
