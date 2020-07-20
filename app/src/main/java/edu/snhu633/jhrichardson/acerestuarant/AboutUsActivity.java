package edu.snhu633.jhrichardson.acerestuarant;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class AboutUsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);

        String[] aboutUsItemTags = getResources().
                getStringArray(R.array.aboutus_list_item_tags);

        // Create the about us list
        ArrayList<AboutUsListItem> aboutUsItems = new ArrayList<>();
        int index = 0;
        for (String listItem : aboutUsItemTags) {
            int iconId = this.getMenuIcon(listItem);
            aboutUsItems.add(index, new AboutUsListItem(listItem, iconId));
            index ++;
        }
        AboutUsItemListAdapter aboutUsAdapter = new AboutUsItemListAdapter
                (this,aboutUsItems);
        ListView listView = findViewById(R.id.aboutuslistview);
        listView.setAdapter(aboutUsAdapter);

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
                    Toast.makeText(getApplicationContext(),
                            "Our Manager info",
                            Toast.LENGTH_LONG).show();
                    break;
                case 1:
                    Toast.makeText(getApplicationContext(),
                            "Our Assistant Manager info",
                            Toast.LENGTH_SHORT).show();
                    break;
                case 2:
                    Toast.makeText(getApplicationContext(),
                            "Our Head Chef Info",
                            Toast.LENGTH_SHORT).show();
                    break;
                case 3:
                    Toast.makeText(getApplicationContext(),
                            "Our Hostess info",
                            Toast.LENGTH_SHORT).show();
                    break;
                case 4:
                    Toast.makeText(getApplicationContext(),
                            "Our Mixologist Info",
                            Toast.LENGTH_SHORT).show();
                    break;
                case 5:
                    Toast.makeText(getApplicationContext(),
                            "Our Employee Of The Month",
                            Toast.LENGTH_SHORT).show();
                    break;
            }
            }
        });

    }

    private int getMenuIcon(String listItem) {
        if(listItem.contains("General Manager")){
            return R.drawable.general_manager;
        }
        else if(listItem.contains("Asst. Manager")) {
            return R.drawable.asst_manager;
        }
        else if(listItem.contains("Head Chef")) {
            return R.drawable.head_chef;
        }
        else if(listItem.contains("Hostess")) {
            return R.drawable.hostess;
        }
        else if(listItem.contains("Mixologist")) {
            return R.drawable.mixologist_of_the_month;
        }
        else if(listItem.contains("Employee of the Month")) {
            return R.drawable.employee_of_month;
        }
        else {
            return R.drawable.ace_logo;
        }
    }
}