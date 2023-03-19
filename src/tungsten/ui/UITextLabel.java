package ui;

import util.TextRenderer;

import java.awt.*;

public class UITextLabel extends UIComponent{
    private String text;
    private Color color;
    private Font font;

    public UITextLabel(int x, int y, int width, int height, String text, Color color, Font font) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.text = text;
        this.color = color;
        this.font = font;
    }

    public UITextLabel(int x, int y, int width, int height, String text, Style style) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.text = text;
        this.color = style.getPrimaryColor();
        this.font = style.getFont();
    }

    @Override
    public void render(Graphics2D g, Shape containerShape, int offsetX, int offsetY) {
        int x = this.x + (int) containerShape.getBounds().getX() + offsetX;
        int y = this.y + (int) containerShape.getBounds().getY() + offsetY;
        g.setColor(color);
        TextRenderer.drawCenteredString(g, x, y, width, height, text, font);
    }

    @Override
    public void tick(Shape containerShape, int offsetX, int offsetY) {
        baseTick(containerShape, offsetX, offsetY);
    }
}
