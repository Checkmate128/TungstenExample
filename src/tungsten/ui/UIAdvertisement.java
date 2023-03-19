package ui;

import util.TextRenderer;

import java.awt.*;

public class UIAdvertisement extends UIComponent implements Clickable{

    public UIAdvertisement(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }
    @Override
    public void onClick(Shape containerShape, int offsetX, int offsetY) {

    }

    @Override
    public void onUnClick(Shape containerShape, int offsetX, int offsetY) {

    }

    @Override
    public void onHover(Shape containerShape, int offsetX, int offsetY) {

    }

    @Override
    public void onUnHover(Shape containerShape, int offsetX, int offsetY) {

    }

    @Override
    public void render(Graphics2D g, Shape containerShape, int offsetX, int offsetY) {
        g.setColor(new Color(120, 120, 120));
        g.fillRect(x, y, width, height);
        TextRenderer.drawCenteredString(g, x, y, width, height, "Ad", new Font("Arial", 0, 40));
    }

    @Override
    public void tick(Shape containerShape, int offsetX, int offsetY) {

    }
}
