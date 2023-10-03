package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class wc22_tott_adapter extends BaseAdapter
{
    private Context context;
    private int Layout;
    private List<Player> players;

    public wc22_tott_adapter(Context context, int layout, List<Player> players) {
        this.context = context;
        Layout = layout;
        this.players = players;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public int getLayout() {
        return Layout;
    }

    public void setLayout(int layout) {
        Layout = layout;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    @Override
    public int getCount() {
        return players.size();
    }
    @Override
    public Object getItem(int i){
        return null;
    }
    @Override
    public long getItemId(int i){
        return 0;
    }
    @Override
    public View getView(int i, View view, ViewGroup viewGroup){
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(Layout, null);

        TextView txtName = (TextView) view.findViewById(R.id.txtPlayerName);
        TextView txtDesc = (TextView) view.findViewById(R.id.txtDescription);
        TextView txtNationality = (TextView) view.findViewById(R.id.txtNationality);
        ImageView imgPlayer = (ImageView) view.findViewById(R.id.imgPlayer);

        Player player = players.get(i);
        txtName.setText(player.getName());
        txtDesc.setText(player.getDescription());
        txtNationality.setText(player.getNationality());
        imgPlayer.setImageResource(player.getImage());
        return view;
    }
}
