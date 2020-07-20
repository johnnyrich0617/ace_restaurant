package edu.snhu633.jhrichardson.acerestuarant;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class AboutUsItemListAdapter extends ArrayAdapter<AboutUsListItem> {

    private static final String LOG_TAG = AboutUsItemListAdapter.class.getSimpleName();

    /**
     * This is our own custom constructor (it doesn't mirror a superclass constructor).
     * The context is used to inflate the layout file, and the list is the data we want
     * to populate into the lists.
     *
     * @param context  The current context. Used to inflate the layout file.
     * @param listItems A List of Dessert objects to display in a list
     */
    public AboutUsItemListAdapter(Activity context, ArrayList<AboutUsListItem> listItems) {

        // Here, we initialize the ArrayAdapter's internal storage for the context and the list.
        // the second argument is used when the ArrayAdapter is populating a single TextView.
        // Because this is a custom adapter for two ImageView and a TextView, the adapter is not
        // going to use this second argument, so it can be any value. Here, we used 0.
        super(context, 0, listItems);
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
                    R.layout.aboutus_list_item, parent, false);
        }
        //Get the {@link AboutUsListItem} object located at this position in the list
        AboutUsListItem currentMenuItem = getItem(position);

        // Find the ImageView in the listView
        ImageView employeeIconView = listItemView.findViewById(R.id.employee_image);

        // set the image to iconView
       employeeIconView.setImageResource(currentMenuItem.getListItemIconId());

        // Find the TextView in the for the employee title
        TextView employeeTitleView = listItemView.findViewById(R.id.employee_title);

        //set the employee title text
        employeeTitleView.setText(currentMenuItem.getListItemTitle());

        return listItemView;
    }

}
