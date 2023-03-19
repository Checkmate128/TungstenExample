package ui;

import util.TextRenderer;

import java.awt.*;

public class UIButton extends UIComponent implements Clickable{
    private String text;
    private Color normalColor;
    private Color hoverColor;
    private Color color;
    private Color unClickableColor;
    private Font font;

    private ClickAction onClick;

    public UIButton(int x, int y, int width, int height, String text, Color normalColor, Color hoverColor, Font font, ClickAction onClick) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.text = text;
        this.normalColor = normalColor;
        this.hoverColor = hoverColor;
        this.onClick = onClick;
        this.color = normalColor;
        this.unClickableColor = new Color(0, 0, 0, 160);
    }

    public UIButton(int x, int y, int width, int height, String text, Color normalColor, Color hoverColor, Font font, boolean isClickable, ClickAction onClick) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.text = text;
        this.normalColor = normalColor;
        this.hoverColor = hoverColor;
        this.isClickable = isClickable;
        this.onClick = onClick;
        this.color = normalColor;
        this.unClickableColor = new Color(0, 0, 0, 160);
    }

    public UIButton(int x, int y, int width, int height, String text, Style style, ClickAction onClick) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.text = text;
        this.normalColor = style.getPrimaryColor();
        this.hoverColor = style.getHoverColor();
        this.onClick = onClick;
        this.color = normalColor;
        this.unClickableColor = style.getUnClickableColor();
        this.font = style.getFont();
    }

    public UIButton(int x, int y, int width, int height, String text, boolean isClickable, Style style, ClickAction onClick) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.text = text;
        this.normalColor = style.getPrimaryColor();
        this.hoverColor = style.getHoverColor();
        this.isClickable = isClickable;
        this.onClick = onClick;
        this.color = normalColor;
        this.unClickableColor = style.getUnClickableColor();
        this.font = style.getFont();
    }

    @Override
    public void onClick(Shape containerShape, int offsetX, int offsetY) {

    }

    @Override
    public void onUnClick(Shape containerShape, int offsetX, int offsetY) {
        this.onClick.onClick(this);
    }

    @Override
    public void onHover(Shape containerShape, int offsetX, int offsetY) {
        this.color = hoverColor;
    }

    @Override
    public void onUnHover(Shape containerShape, int offsetX, int offsetY) {
        this.color = normalColor;
    }

    @Override
    public void render(Graphics2D g, Shape containerShape, int offsetX, int offsetY) {
        int x = this.x + (int) containerShape.getBounds().getX() + offsetX;
        int y = this.y + (int) containerShape.getBounds().getY() + offsetY;
        g.setColor(color);
        g.fillRect(x, y, width, height);
        g.setColor(Color.BLACK);
        if(!isClickable) {
            g.setColor(unClickableColor);
            g.fillRect(x, y, width, height);
        }
        TextRenderer.drawCenteredString(g, x, y, width, height, text, font);
    }

    @Override
    public void tick(Shape containerShape, int offsetX, int offsetY) {
        baseTick(containerShape, offsetX, offsetY);
    }

    public interface ClickAction {
        void onClick(UIButton button);
    }
}
