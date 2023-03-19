package test;

import ui.Style;

import java.awt.*;

public class ButtonStyle extends Style {
    public ButtonStyle() {
        primaryColor = new Color(160, 160, 160);
        hoverColor = new Color(10, 240, 240);
        unClickableColor = new Color(40, 40, 40);
        font = new Font("Arial", 0, 50);
    }
}
