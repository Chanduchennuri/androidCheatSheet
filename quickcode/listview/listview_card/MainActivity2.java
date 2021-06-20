package com.example.bare;

import android.os.Bundle;
import android.widget.AbsListView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        // build model (database)
        int defaultAvatarResId = R.drawable.ic_launcher_background;
        UserAccount green = new UserAccount("Bulbasaur", "Grass", defaultAvatarResId, true);
        UserAccount red = new UserAccount("Charmander", "Fire", defaultAvatarResId);
        UserAccount blue = new UserAccount("Squirtle", "Water", defaultAvatarResId);
        UserAccount[] users = new UserAccount[] {green, red, blue, green, red, blue, green};

        // binding view
        ListView listView = this.findViewById(R.id.listView);
        listView.setChoiceMode(AbsListView.CHOICE_MODE_NONE);
        listView.setAdapter(new CardAdapter(this, R.layout.list_item_card, users));

        // action
        listView.setOnItemClickListener((parent, view, position, id) -> {
            UserAccount user = (UserAccount) listView.getItemAtPosition(position);
            Toast.makeText(this, user.toString(), Toast.LENGTH_SHORT).show();
        });
    }
}