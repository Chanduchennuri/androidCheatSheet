package com.example.bare;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        // build model (database)
        int defAvaResId = R.drawable.ic_launcher_background;
        String phoDesc = "Vietnamese soup dish consisting of broth, rice noodles, herbs, and meat (usually beef)";
        Order pho = new Order("Pho", phoDesc, defAvaResId,10);
        String pizzaDesc = "Italian dish consisting of a flat round bread base with cheese, tomatoes, vegetables, meat, etc. on top";
        Order pizza = new Order("Pizza", pizzaDesc, defAvaResId,5);
        String sushiDesc = "Small pieces of raw fish that are wrapped in rice and seaweed";
        Order sushi = new Order("Sushi", sushiDesc, defAvaResId,12);
        String kebabDesc = "Sliced lamb, beef, or chicken, slowly roasted on a vertical rotating spit";
        Order kebab = new Order("Doner kebab", kebabDesc, defAvaResId,7);
        String pastelDesc = "Portuguese egg custard tart pastry dusted with cinnamon";
        Order pastel = new Order("Pastel de nata", pastelDesc, defAvaResId,2);
        String hamDesc = "Fast food";
        Order ham = new Order("Hamburger", hamDesc, defAvaResId,4);
        Order[] orders = new Order[]{pho, pizza, sushi, kebab, pastel, ham};

        // binding view
        ListView listView = this.findViewById(R.id.listViewOrder);
        listView.setAdapter(new OrderAdapter(this, R.layout.list_item_order, orders));


        listView.setOnItemClickListener((parent, view, position, id) -> {
            Order order = (Order) listView.getItemAtPosition(position);
            Toast.makeText(this, order.getName(), Toast.LENGTH_SHORT).show();
        });
    }
}