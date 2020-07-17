package edu.snhu633.jhrichardson.acerestuarant;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

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

        //add a click adapter
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                //Dessert dessert = desserts.get(i);
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
                        //Intent pastry = new Intent(MainActivity.this, Pastry.class);
                        //startActivity(pastry);
                        break;
                    case 4:
                        Toast.makeText(getApplicationContext(),"Counting Calories",Toast.LENGTH_SHORT).show();
                        //Intent pastry = new Intent(MainActivity.this, Pastry.class);
                        //startActivity(pastry);
                        break;
                    case 5:
                        Toast.makeText(getApplicationContext(),"We Do Cater Too",Toast.LENGTH_SHORT).show();
                        //Intent pastry = new Intent(MainActivity.this, Pastry.class);
                        //startActivity(pastry);
                        break;
                    case 6:
                        Toast.makeText(getApplicationContext(),"Get Directions",Toast.LENGTH_SHORT).show();
                        //Intent pastry = new Intent(MainActivity.this, Pastry.class);
                        //startActivity(pastry);
                        break;
                    case 7:
                        Toast.makeText(getApplicationContext(),"Who Are We",Toast.LENGTH_SHORT).show();
                        //Intent pastry = new Intent(MainActivity.this, Pastry.class);
                        //startActivity(pastry);
                        break;
                    case 8:
                        Toast.makeText(getApplicationContext(),"Logging Out",Toast.LENGTH_SHORT).show();
                        //Intent pastry = new Intent(MainActivity.this, Pastry.class);
                        //startActivity(pastry);
                        break;
                }
            }
        });

    }

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