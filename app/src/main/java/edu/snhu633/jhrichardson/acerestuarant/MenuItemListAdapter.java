package edu.snhu633.jhrichardson.acerestuarant;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


public class MenuItemListAdapter extends ArrayAdapter<MainMenuItem>{
    private static final String LOG_TAG = MenuItemListAdapter.class.getSimpleName();

    /**
     * This is our own custom constructor (it doesn't mirror a superclass constructor).
     * The context is used to inflate the layout file, and the list is the data we want
     * to populate into the lists.
     *
     * @param context  The current context. Used to inflate the layout file.
     * @param mainMenuItems A List of Dessert objects to display in a list
     */
    public MenuItemListAdapter(Activity context, ArrayList<MainMenuItem> mainMenuItems) {

        // Here, we initialize the ArrayAdapter's internal storage for the context and the list.
        // the second argument is used when the ArrayAdapter is populating a single TextView.
        // Because this is a custom adapter for two ImageView and a TextView, the adapter is not
        // going to use this second argument, so it can be any value. Here, we used 0.
        super(context, 0, mainMenuItems);
    }

    /**
     * Provides a view for an AdapterView (ListView, GridView, etc.)
     *
     * @param position The position in the list of data that should be displayed in the
     *                 list item view.
     * @param convertView The recycled view to populate.
     * @param parent The parent ViewGroup that is used for inflation.
     * @return The View for the position in the AdapterView.
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.main_menu_item, parent, false);
        }
        //Get the {@link MainMenuItem} object located at this position in the list
        MainMenuItem currentMenuItem = getItem(position);

        // Find the ImageView in the list_item.xml layout with the ID list_item_icon
        ImageView menuIconView = (ImageView) listItemView.findViewById(R.id.menu_item_icon);

        // set the image to iconView
        menuIconView.setImageResource(currentMenuItem.getMenuItemResourceId());

        // Find the TextView in the list_item.xml layout with the ID version_name
        TextView nameTextView = (TextView) listItemView.findViewById(R.id.menu_item_name);

        //set the Menu Item Name
        nameTextView.setText(currentMenuItem.getMenuItemText());

        // Find the ImageView in the list_item.xml layout with the ID list_item_icon
        ImageView actionIconView = (ImageView) listItemView.findViewById(R.id.list_item_action_icon);

        // set the image to iconView
        actionIconView.setImageResource(currentMenuItem.getMenuActionResourceId());

        return listItemView;
    }


}
