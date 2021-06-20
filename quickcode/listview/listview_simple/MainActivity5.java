package com.example.bareapp;

import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.CheckedTextView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity5 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);

        // build model (database)
        UserAccount tony = new UserAccount("tony", "iron man", true);
        UserAccount steve = new UserAccount("steve", "cap");
        UserAccount thor = new UserAccount("thor", "thor");

        UserAccount[] users = new UserAccount[] {tony, steve, thor, tony, steve, thor, tony};

        ///////////////////// TEXT /////////////////////
//        // binding view
//        ListView listView = this.findViewById(R.id.listView);
//        ArrayAdapter<UserAccount> arrayAdapter = new ArrayAdapter<>(this,
//                android.R.layout.simple_list_item_1, users);
//        listView.setChoiceMode(AbsListView.CHOICE_MODE_NONE);
//        listView.setAdapter(arrayAdapter);
//
//        // action
//        listView.setOnItemClickListener((parent, view, position, id) -> {
//            UserAccount user = (UserAccount) listView.getItemAtPosition(position);
//            Toast.makeText(this, "User " + user.toString(), Toast.LENGTH_SHORT).show();
//        });

        ///////////////////// SINGLE CHOICE /////////////////////
//        // binding view
//        ListView listView = this.findViewById(R.id.listView);
//        ArrayAdapter<UserAccount> arrayAdapter = new ArrayAdapter<>(this,
//                android.R.layout.simple_list_item_single_choice, users);
//        listView.setChoiceMode(AbsListView.CHOICE_MODE_SINGLE);
//        listView.setAdapter(arrayAdapter);
//        for (int i = 0; i < users.length; i++) {
//            listView.setItemChecked(i, users[i].isActive());
//        }
//
//        // action
//        listView.setOnItemClickListener((parent, view, position, id) -> {
//            CheckedTextView v = (CheckedTextView) view;
//            UserAccount user = (UserAccount) listView.getItemAtPosition(position);
//            user.setActive(v.isChecked());
//        });

        ///////////////////// MULTIPLE CHOICE /////////////////////
        // binding view
        ListView listView = this.findViewById(R.id.listView);
        ArrayAdapter<UserAccount> arrayAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_multiple_choice, users);
                //android.R.layout.simple_list_item_checked, users);
        listView.setChoiceMode(AbsListView.CHOICE_MODE_MULTIPLE);
        listView.setAdapter(arrayAdapter);
        for (int i = 0; i < users.length; i++) {
            listView.setItemChecked(i, users[i].isActive());
        }

        // action
        listView.setOnItemClickListener((parent, view, position, id) -> {
            CheckedTextView v = (CheckedTextView) view;
            UserAccount user = (UserAccount) listView.getItemAtPosition(position);
            user.setActive(v.isChecked());
            
            //// Scan View 
//            SparseBooleanArray checkArray = listView.getCheckedItemPositions();
//            StringBuilder countStr = new StringBuilder("All user checked: ");
//            for (int i = 0; i < checkArray.size(); i++) {
//                if (checkArray.valueAt(i)) {
//                    countStr.append(users[i].toString()).append(", ");
//                }
//            }
//            Toast.makeText(this, countStr, Toast.LENGTH_SHORT).show();
        });
    }
}