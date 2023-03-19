package ui;

import java.awt.*;

public class UICheckBox extends UIComponent implements Clickable{
    private boolean isChecked = false;
    private ClickAction clickAction;
    private Color color;

    public UICheckBox(int x, int y, int width, int height, Color color, ClickAction clickAction) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.color = color;
        this.clickAction = clickAction;
    }

    public UICheckBox(int x, int y, int width, int height, Color color, boolean isChecked, ClickAction clickAction) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.color = color;
        this.isChecked = isChecked;
        this.clickAction = clickAction;
    }

    public UICheckBox(int x, int y, int width, int height, Style style, ClickAction clickAction) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.color = style.getPrimaryColor();
        this.clickAction = clickAction;
    }

    public UICheckBox(int x, int y, int width, int height, boolean isChecked, Style style, ClickAction clickAction) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.color = style.getPrimaryColor();
        this.isChecked = isChecked;
        this.clickAction = clickAction;
    }

    @Override
    public void onClick(Shape containerShape, int offsetX, int offsetY) {

    }

    @Override
    public void onUnClick(Shape containerShape, int offsetX, int offsetY) {
        isChecked = !isChecked;
        clickAction.onClick(this);
    }

    @Override
    public void onHover(Shape containerShape, int offsetX, int offsetY) {

    }

    @Override
    public void onUnHover(Shape containerShape, int offsetX, int offsetY) {

    }

    @Override
    public void render(Graphics2D g, Shape containerShape, int offsetX, int offsetY) {
        int x = this.x + (int) containerShape.getBounds().getX() + offsetX;
        int y = this.y + (int) containerShape.getBounds().getY() + offsetY;
        g.setColor(color);
        g.drawRect(x, y, width, height);
        if(isChecked) {
            g.drawLine(x + 5, y + 5, x + width - 5, y + height - 5);
            g.drawLine(x + width - 5, y + 5, x + 5, y + height - 5);
        }
    }

    @Override
    public void tick(Shape containerShape, int offsetX, int offsetY) {
        baseTick(containerShape, offsetX, offsetY);
    }

    public interface ClickAction {
        void onClick(UICheckBox checkBox);
    }
}
