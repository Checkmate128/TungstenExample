package ui;

import input.MouseInput;

import java.awt.*;

public class UIHorizontalSlider extends UIComponent implements Clickable, Draggable{

    private Color mainColor;
    private Color filledAreaColor;
    private double value = 0.0;
    private ClickAction action;
    private int thickness;

    public UIHorizontalSlider(int x, int y, int width, int thickness, Color mainColor, Color filledAreaColor, ClickAction action) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.thickness = thickness;
        this.height = thickness * 2;
        this.mainColor = mainColor;
        this.filledAreaColor = filledAreaColor;
        this.action = action;
    }

    public UIHorizontalSlider(int x, int y, int width, int thickness, Color mainColor, Color filledAreaColor, double value, ClickAction action) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.thickness = thickness;
        this.height = thickness * 2;
        this.mainColor = mainColor;
        this.filledAreaColor = filledAreaColor;
        this.value = value;
        this.action = action;
    }

    public UIHorizontalSlider(int x, int y, int width, int thickness, Style style, ClickAction action) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.thickness = thickness;
        this.height = thickness * 2;
        this.mainColor = style.primaryColor;
        this.filledAreaColor = style.secondaryColor;
        this.action = action;
    }

    public UIHorizontalSlider(int x, int y, int width, int thickness, Style style, double value, ClickAction action) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.thickness = thickness;
        this.height = thickness * 2;
        this.mainColor = style.primaryColor;
        this.filledAreaColor = style.secondaryColor;
        this.value = value;
        this.action = action;
    }

    @Override
    public void onClick(Shape containerShape, int offsetX, int offsetY) {
        int x = this.x + (int) containerShape.getBounds().getX() + offsetX;
        int y = this.y + (int) containerShape.getBounds().getY() + offsetY;
        value = ((double)(MouseInput.x - x)) / width;
    }

    @Override
    public void onUnClick(Shape containerShape, int offsetX, int offsetY) {
        action.onClick(this);
    }

    @Override
    public void onHover(Shape containerShape, int offsetX, int offsetY) {

    }

    @Override
    public void onUnHover(Shape containerShape, int offsetX, int offsetY) {

    }

    public void setValue(double value) {
        this.value = value;
    }

    public double getValue() {
        return value;
    }

    @Override
    public void onDrag(int dx, int dy, Shape containerShape, int offsetX, int offsetY) {
        int x = this.x + (int) containerShape.getBounds().getX() + offsetX;
        int y = this.y + (int) containerShape.getBounds().getY() + offsetY;
        value = ((double)(MouseInput.x - x)) / width;
        action.onClick(this);
    }

    @Override
    public void render(Graphics2D g, Shape containerShape, int offsetX, int offsetY) {
        int x = this.x + (int) containerShape.getBounds().getX() + offsetX;
        int y = this.y + (int) containerShape.getBounds().getY() + offsetY;
        g.setColor(mainColor);
        g.fillRect(x, y + thickness / 2, width, thickness);
        g.setColor(filledAreaColor);
        g.fillRect(x, y + thickness / 2, (int) (value * width + thickness / 2), thickness);
        g.fillOval((int) (x + value * width - thickness), y, 2 * thickness, 2 * thickness);
    }

    @Override
    public void tick(Shape containerShape, int offsetX, int offsetY) {
        baseTick(containerShape, offsetX, offsetY);
        if(value > 1.0) {
            value = 1.0;
        }

        if(value < 0.0) {
            value = 0.0;
        }
    }

    public interface ClickAction {
        void onClick(UIHorizontalSlider button);
    }
}
