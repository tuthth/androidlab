package com.example.myapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class CustomListViewL3 extends AppCompatActivity {
    ListView lvPlayers;
    EditText txtSearch;
    ArrayList<Player> players;
    wc22_tott_adapter adapter;
    Button btnAdd;
    Button btnDelete;
    Button btnSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_list_view_l3);
        players = new ArrayList<>();
        AnhXa();
        adapter = new wc22_tott_adapter(this, R.layout.myplayerlist, players);
        lvPlayers.setAdapter(adapter);

        btnAdd = (Button)findViewById(R.id.btnAdd);
        btnDelete = (Button) findViewById(R.id.btnDelete);
        btnSearch = (Button) findViewById(R.id.btnSearch);
        txtSearch = (EditText) findViewById(R.id.txtSearch);

        btnAdd.setOnClickListener(v -> {

            AlertDialog.Builder builder = new AlertDialog.Builder(CustomListViewL3.this);
            builder.setTitle("Add Player");

            // Set up the input
            final EditText inputName = new EditText(CustomListViewL3.this);
            final EditText inputTeam = new EditText(CustomListViewL3.this);
            final EditText inputDesc = new EditText(CustomListViewL3.this);

            LinearLayout layout = new LinearLayout(CustomListViewL3.this);
            layout.setOrientation(LinearLayout.VERTICAL);
            layout.addView(inputName);
            layout.addView(inputTeam);
            layout.addView(inputDesc);
            builder.setView(layout);

            // Set up the buttons
            builder.setPositiveButton("Add", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    // Get user input
                    String name = inputName.getText().toString();
                    String team = inputTeam.getText().toString();
                    String desc = inputDesc.getText().toString();
                    if(team.isEmpty()||desc.isEmpty() || name.isEmpty()){
                        Toast.makeText(CustomListViewL3.this, "Missing fields", Toast.LENGTH_SHORT).show();
                    }

                    if(name.contains("ronaldo")) {

                        Toast.makeText(CustomListViewL3.this, "Cannot add this player due to his disaster contribution in WC22", Toast.LENGTH_SHORT).show();

                    } else {

                        Player player = new Player(name, team, desc, R.drawable.null_player_image);

                        players.add(player);

                        adapter.notifyDataSetChanged();

                    }
                }
            });

            builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();
                }
            });

            builder.show();
        });
        btnDelete.setOnClickListener(v -> {
            // Get selected player
            int position = lvPlayers.getCheckedItemPosition();
            Player player = players.get(position);

            // Remove player from list
            players.remove(player);

            // Notify adapter
            adapter.notifyDataSetChanged();
        });
        btnSearch.setOnClickListener(v -> {
            // Get search query
            String query = txtSearch.getText().toString();
            ArrayList<Player> filteredList = new ArrayList<>();
            for(Player player : players) {
                if(player.getName().contains(query) || player.getDescription().contains(query) || player.getNationality().contains(query)) {
                    filteredList.add(player);
                }
            }
            adapter.setPlayers(filteredList);
            adapter.notifyDataSetChanged();
        });

    }
    private void AnhXa(){
        lvPlayers = (ListView) findViewById(R.id.lvPLayers);
        players.add(new Player("Lionel Messi", "Argentina", "GOAT", R.drawable.messi));

        players.add(new Player("Kylian Mbappe", "France", "Young Star", R.drawable.mbappe));

        players.add(new Player("Achraf Hakimi", "Morocco", "Versatile Defender", R.drawable.hakimi));

        players.add(new Player("Jude Bellingham", "England", "Midfield Dynamo", R.drawable.bellingham));

        players.add(new Player("Antoine Griezmann", "France", "Playmaker", R.drawable.griezmann));

        players.add(new Player("Josko Gvardiol", "Croatia", "Defensive Rock", R.drawable.gvardiol));

        players.add(new Player("Bruno Fernandes", "Portugal", "Mentality", R.drawable.bruno));
    }
}