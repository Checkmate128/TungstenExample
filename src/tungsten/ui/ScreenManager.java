package ui;

public class ScreenManager {
    private static UIComponent clickedComponent;
    private static UIComponent typingComponent;

    public static void setClickedComponent(UIComponent uic) {
        clickedComponent = uic;
    }

    public static UIComponent getClickedComponent() {
        return clickedComponent;
    }

    public static void setTypingComponent(UIComponent uic) {
        typingComponent = uic;
    }

    public static UIComponent getTypingComponent() {
        return typingComponent;
    }
}
