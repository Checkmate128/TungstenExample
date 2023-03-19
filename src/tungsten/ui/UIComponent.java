package ui;

import input.MouseInput;

import java.awt.*;

public abstract class UIComponent {
    protected int x;
    protected int y;
    protected int width;
    protected int height;
    protected boolean isClickable = true;
    protected boolean isHovered = false;
    protected boolean lastMouseClickState = false;
    protected int lastMouseX = 0;
    protected int lastMouseY = 0;

    protected void onClick(Shape containerShape, int offsetX, int offsetY) {

    }

    protected void onUnClick(Shape containerShape, int offsetX, int offsetY) {

    }
    protected void onHover(Shape containerShape, int offsetX, int offsetY) {

    }
    protected void onUnHover(Shape containerShape, int offsetX, int offsetY) {

    }

    protected void onDrag(int dx, int dy, Shape containerShape, int offsetX, int offsetY) {

    }
    public abstract void render(Graphics2D g, Shape containerShape, int offsetX, int offsetY);
    public abstract void tick(Shape containerShape, int offsetX, int offsetY);
    protected void baseTick(Shape containerShape, int offsetX, int offsetY) {
        int x = this.x + (int) containerShape.getBounds().getX() + offsetX;
        int y = this.y + (int) containerShape.getBounds().getY() + offsetY;

        if (this instanceof Draggable && ScreenManager.getClickedComponent() == this && isClickable) {
            onDrag(MouseInput.x - lastMouseX, MouseInput.y - lastMouseY, containerShape, offsetX, offsetY);
        }

        if(containerShape.contains(new Point(MouseInput.x, MouseInput.y - 26))) {
            if (this instanceof Clickable && isClickable && MouseInput.x >= x && MouseInput.x <= x + width && MouseInput.y - 26 >= y && MouseInput.y - 26 <= y + height && !isHovered) {
                isHovered = true;
                onHover(containerShape, offsetX, offsetY);
            }

            if (this instanceof Clickable && !(MouseInput.x >= x && MouseInput.x <= x + width && MouseInput.y - 26 >= y && MouseInput.y - 26 <= y + height) && isHovered) {
                isHovered = false;
                onUnHover(containerShape, offsetX, offsetY);
            }

            if (this instanceof Clickable && ScreenManager.getClickedComponent() == null && isClickable && MouseInput.x >= x && MouseInput.x <= x + width && MouseInput.y - 26 >= y && MouseInput.y - 26 <= y + height && !lastMouseClickState && MouseInput.leftClick) {
                ScreenManager.setClickedComponent(this);
                onClick(containerShape, offsetX, offsetY);
            }

            if (this instanceof Clickable && ScreenManager.getClickedComponent() == this && isClickable && MouseInput.x >= x && MouseInput.x <= x + width && MouseInput.y - 26 >= y && MouseInput.y - 26 <= y + height && lastMouseClickState && !MouseInput.leftClick) {
                onUnClick(containerShape, offsetX, offsetY);
            }

            if (this instanceof Typeable && !MouseInput.leftClick && lastMouseClickState) {
                if(MouseInput.x >= x && MouseInput.x <= x + width && MouseInput.y - 26 >= y && MouseInput.y - 26 <= y + height) {
                    ScreenManager.setTypingComponent(this);
                } else {
                    ScreenManager.setTypingComponent(null);
                }
            }
        } else {
            if(isHovered) {
                isHovered = false;
                onUnHover(containerShape, offsetX, offsetY);
            }
        }

        lastMouseClickState = MouseInput.leftClick;
        lastMouseX = MouseInput.x;
        lastMouseY = MouseInput.y;

        if(ScreenManager.getClickedComponent() == this && !MouseInput.leftClick) {
            ScreenManager.setClickedComponent(null);
        }
    }
}
