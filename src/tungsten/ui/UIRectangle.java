package ui;

import java.awt.*;

public class UIRectangle extends UIComponent {

    private Color color;

    public UIRectangle(int x, int y, int width, int height, Color color) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.color = color;
    }

    public UIRectangle(int x, int y, int width, int height, Style style) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.color = style.primaryColor;
    }

    @Override
    public void render(Graphics2D g, Shape containerShape, int offsetX, int offsetY) {
        int x = this.x + (int) containerShape.getBounds().getX() + offsetX;
        int y = this.y + (int) containerShape.getBounds().getY() + offsetY;
        g.setColor(color);
        g.fillRect(x, y, width, height);
    }

    @Override
    public void tick(Shape containerShape, int offsetX, int offsetY) {
        baseTick(containerShape, offsetX, offsetY);
    }
}
