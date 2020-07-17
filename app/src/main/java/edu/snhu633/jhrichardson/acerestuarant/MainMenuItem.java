package edu.snhu633.jhrichardson.acerestuarant;

/**
 * {@link MainMenuItem} represents a single menu item.
 * Each object has 3 properties: menu item icon resource id, menu item text,
 * and menu action icon resource ID.
 */

public class MainMenuItem {
    private int menuItemResourceId;
    private int menuActionResourceId;
    private String menuItemText;

    public MainMenuItem(int menuItemIcon, String menuItemText, int menuActionIcon) {
        this.menuItemResourceId = menuItemIcon;
        this.menuItemText = menuItemText;
        this.menuActionResourceId = menuActionIcon;
    }

    public int getMenuItemResourceId() {
        return menuItemResourceId;
    }

    public String getMenuItemText() {
        return menuItemText;
    }

    public int getMenuActionResourceId() {
        return menuActionResourceId;
    }
}
