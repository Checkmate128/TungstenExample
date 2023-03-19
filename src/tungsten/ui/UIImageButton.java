package ui;

import util.ImageLoader;

import java.awt.*;
import java.awt.image.BufferedImage;

public class UIImageButton extends UIComponent implements Clickable{
    private BufferedImage image;
    private ImageLoader loader = new ImageLoader();
    private Color hoverOverlay;
    private ClickAction action;

    public UIImageButton(int x, int y, int width, int height, String fileName, Color hoverOverlay, ClickAction action) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        image = loader.loadImage(fileName);
        this.hoverOverlay = hoverOverlay;
        this.action = action;
    }

    public UIImageButton(int x, int y, int width, int height, String fileName, Style style, ClickAction action) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        image = loader.loadImage(fileName);
        this.hoverOverlay = style.hoverColor;
        this.action = action;
    }

    @Override
    public void render(Graphics2D g, Shape containerShape, int offsetX, int offsetY) {
        int x = this.x + containerShape.getBounds().x + offsetX;
        int y = this.y + containerShape.getBounds().y + offsetY;
        g.drawImage(image, x, y, width, height, null);
        if(isHovered) {
            g.setColor(hoverOverlay);
            g.fillRect(x, y, width, height);
        }
    }

    @Override
    public void tick(Shape containerShape, int offsetX, int offsetY) {
        baseTick(containerShape, offsetX, offsetY);
    }

    @Override
    public void onClick(Shape containerShape, int offsetX, int offsetY) {

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

    public interface ClickAction {
        void onClick(UIImageButton button);
    }
}
