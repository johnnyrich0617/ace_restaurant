package edu.snhu633.jhrichardson.acerestuarant;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[] menuItemsStrings = getResources().getStringArray(R.array.main_menu_items);

        // Create the main menu
        ArrayList<MainMenuItem> menuItems = new ArrayList<>();
        int index = 0;
        for (String menuItem : menuItemsStrings) {
            int menuItemIconId = this.getMenuIcon(menuItem);
            menuItems.add(index, new MainMenuItem(menuItemIconId, menuItem, R.drawable.menuaction));
            index ++;
        }

        MenuItemListAdapter miAdapter = new MenuItemListAdapter(this, menuItems);
        ListView listView = (ListView) findViewById(R.id.menu_list_view);
        listView.setAdapter(miAdapter);

        /*
          Set the onClickListener on the entire list
          we will use Intent someIntent = new Intent(MainActivity.this, SomeMenuAction.class);
                                  startActivity(someIntent);
          to create and start the correct activity
         */
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch(i) {
                    case 0:
                        Toast.makeText(getApplicationContext(),"Our Menu",Toast.LENGTH_SHORT).show();
                        break;
                    case 1:
                        Toast.makeText(getApplicationContext(),"Mobile Ordering",Toast.LENGTH_SHORT).show();
                        break;
                    case 2:
                        Toast.makeText(getApplicationContext(),"Make a Reservation",Toast.LENGTH_SHORT).show();
                        break;
                    case 3:
                        Toast.makeText(getApplicationContext(),"Mix A Beverage",Toast.LENGTH_SHORT).show();
                        break;
                    case 4:
                        Toast.makeText(getApplicationContext(),"Counting Calories",Toast.LENGTH_SHORT).show();
                        break;
                    case 5:
                        Toast.makeText(getApplicationContext(),"We Do Cater Too",Toast.LENGTH_SHORT).show();
                        break;
                    case 6:
                        if(googleServicesAvailable()) {
                            try {
                                double restLat = Double.parseDouble(getResources().getString(R.string.main_location_lat));
                                double restLong = Double.parseDouble(getResources().getString(R.string.main_location_long));
                                Intent mapIntent = new Intent(MainActivity.this, DirectionsActivity.class);
                                mapIntent.putExtra(getResources().getString(R.string.const_lat_key), restLat);
                                mapIntent.putExtra(getResources().getString(R.string.const_long_key), restLong);
                                startActivity(mapIntent);
                            }
                            catch (NumberFormatException nfe){
                                Toast.makeText(getApplicationContext(),
                                        getResources().getString(R.string.error_latlong_parse_exception),
                                        Toast.LENGTH_LONG).show();
                                nfe.printStackTrace();
                            }
                        }
                        break;
                    case 7:
                        Toast.makeText(getApplicationContext(),"Who Are We",Toast.LENGTH_SHORT).show();
                        break;
                    case 8:
                        Toast.makeText(getApplicationContext(),"Logging Out",Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });

    }

    /**
     * Check to see if Google Play Services are installed and available
     * @return true if available
     */
    private boolean googleServicesAvailable() {
        GoogleApiAvailability api = GoogleApiAvailability.getInstance();
        int isAvailable = api.isGooglePlayServicesAvailable(this);
        if(isAvailable == ConnectionResult.SUCCESS){
            return true;
        }
        else if(api.isUserResolvableError(isAvailable)) {
            Dialog dialog = api.getErrorDialog(this, isAvailable,0);
            dialog.show();
        }
        else {
            Toast.makeText(this,
                    R.string.error_text_no_google_services,
                    Toast.LENGTH_LONG).show();
        }
        return false;
    }

    /**
     * Get the correct menuItemIcon that
     * corresponds to the menuItemText
     * @param menuItem The menuItemText for this menu item
     * @return Return the resource ID for the corresponding icon as integer (int)
     */
    private int getMenuIcon(String menuItem) {

        if(menuItem.contains("View")){
            return R.drawable.menu;
        }
        else if(menuItem.contains("Mobile")){
            return R.drawable.mobileorder;
        }
        else if(menuItem.contains("Reservation")) {
            return R.drawable.reservations;
        }
        else if(menuItem.contains("Beverage")){
            return R.drawable.berverage;
        }
        else if(menuItem.contains("Calories")) {
            return R.drawable.calorie;
        }
        else if(menuItem.contains("Cater")) {
            return R.drawable.catering;
        }
        else if(menuItem.contains("Directions")) {
            return R.drawable.directions;
        }
        else if(menuItem.contains("Who We Are")) {
            return R.drawable.aboutus;
        }
        else if(menuItem.contains("Log Out")) {
            return R.drawable.logout;
        }
        else
            return R.drawable.menuaction;
    }
}