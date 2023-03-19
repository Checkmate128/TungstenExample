package ui;

import java.awt.*;

public interface Clickable {
    /**
     * Called whenever the UI element is clicked. Clicking occurs whenever the mouse button is pressed.
     */
    void onClick(Shape containerShape, int offsetX, int offsetY);

    /**
     * Called whenever the UI element is un-clicked. Un-clicking occurs when the mouse button is unpressed.
     */
    void onUnClick(Shape containerShape, int offsetX, int offsetY);

    /**
     * Called whenever the UI element is hovered on by the mouse cursor.
     */
    void onHover(Shape containerShape, int offsetX, int offsetY);

    /**
     * Called whenever the UI element is un-hovered on by the mouse cursor.
     */
    void onUnHover(Shape containerShape, int offsetX, int offsetY);
}
