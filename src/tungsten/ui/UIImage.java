package ui;

import util.ImageLoader;

import java.awt.*;
import java.awt.image.BufferedImage;

public class UIImage extends UIComponent{
    private BufferedImage image;
    private ImageLoader loader = new ImageLoader();

    public UIImage(int x, int y, int width, int height, String fileName) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        image = loader.loadImage(fileName);
    }

    @Override
    public void render(Graphics2D g, Shape containerShape, int offsetX, int offsetY) {
        int x = this.x + containerShape.getBounds().x + offsetX;
        int y = this.y + containerShape.getBounds().y + offsetY;
        g.drawImage(image, x, y, width, height, null);
    }

    @Override
    public void tick(Shape containerShape, int offsetX, int offsetY) {
        baseTick(containerShape, offsetX, offsetY);
    }
}
