package edu.snhu633.jhrichardson.acerestuarant;

public class AboutUsListItem {

    private int listItemIconId;
    private String listItemTitle;

    public AboutUsListItem ( String listItemTitle, int listItemIcon) {
        this.listItemIconId = listItemIcon;
        this.listItemTitle = listItemTitle;
    }

    public int getListItemIconId() {
        return listItemIconId;
   }

    public String getListItemTitle() {
        return listItemTitle;
    }
}
