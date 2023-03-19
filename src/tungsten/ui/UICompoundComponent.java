package ui;

import java.awt.*;
import java.util.ArrayList;

public class UICompoundComponent extends UIComponent{
    protected ArrayList<UIComponent> components = new ArrayList<>();
    protected Shape boundingShape;

    public UICompoundComponent(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.boundingShape = new Rectangle(x, y, width, height);
    }

    public void componentsRender(Graphics2D g, int offsetX, int offsetY) {
        Shape previousClip = g.getClip();

        g.setClip(getBoundingShape());

        for(int i = 0; i < components.size(); i++) {
            components.get(i).render(g, getBoundingShape(), offsetX, offsetY);
        }

        g.setClip(previousClip);
    }

    public void componentsTick(int offsetX, int offsetY) {
        for(int i = components.size() - 1; i > -1; i--) {
            components.get(i).tick(getBoundingShape(), offsetX, offsetY);
        }
    }

    public ArrayList<UIComponent> getComponents() {
        return components;
    }

    public void addComponent(UIComponent uic) {
        components.add(uic);
    }

    public Shape getBoundingShape() {
        return boundingShape;
    }

    @Override
    public void render(Graphics2D g, Shape containerShape, int offsetX, int offsetY) {
        componentsRender(g, offsetX, offsetY);
    }

    @Override
    public void tick(Shape containerShape, int offsetX, int offsetY) {
        componentsTick(offsetX, offsetY);
        baseTick(containerShape, offsetX, offsetY);
    }
}
