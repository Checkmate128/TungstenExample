package ui;

import java.awt.*;

public class UIScrollArea extends UICompoundComponent{
    private int maxY;
    private UIVerticalScrollBar verticalScrollBar;

    public UIScrollArea(int x, int y, int width, int height, int maxY, int scrollBarThickness, Color scrollBarBackgroundColor, Color scrollBarFillColor) {
        super(x, y, width, height);
        this.maxY = maxY;
        verticalScrollBar = new UIVerticalScrollBar(x + width - scrollBarThickness, y, scrollBarThickness, height, scrollBarBackgroundColor, scrollBarFillColor, (int)(height * (double)(height / maxY)));
        addComponent(verticalScrollBar);
    }

    public UIScrollArea(int x, int y, int width, int height, int maxY, int scrollBarThickness, Style style) {
        super(x, y, width, height);
        this.maxY = maxY;
        verticalScrollBar = new UIVerticalScrollBar(width - scrollBarThickness, 0, scrollBarThickness, height, style.primaryColor, style.secondaryColor, (height * height) / maxY);
        addComponent(verticalScrollBar);
    }

    @Override
    public void componentsTick(int offsetX, int offsetY) {
        for(int i = components.size() - 1; i > -1; i--) {
            if(components.get(i) == verticalScrollBar) {
                if(maxY > height) {
                    components.get(i).tick(getBoundingShape(), offsetX, offsetY);
                }
            } else {
                components.get(i).tick(getBoundingShape(), offsetX, (int) (offsetY - verticalScrollBar.getValue() * maxY));
            }
        }
    }

    @Override
    public void componentsRender(Graphics2D g, int offsetX, int offsetY) {
        Shape previousClip = g.getClip();

        g.setClip(getBoundingShape());

        for(int i = 0; i < components.size(); i++) {
            if(components.get(i) == verticalScrollBar) {
                if(maxY > height) {
                    components.get(i).render(g, getBoundingShape(), offsetX, offsetY);
                }
            } else {
                components.get(i).render(g, getBoundingShape(), offsetX, (int) (offsetY - verticalScrollBar.getValue() * maxY));
            }
        }

        g.setClip(previousClip);
    }
}
