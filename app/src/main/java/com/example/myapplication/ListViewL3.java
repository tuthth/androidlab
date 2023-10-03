package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class ListViewL3 extends AppCompatActivity implements View.OnClickListener {
    ListView lvSubjects;
    TextView txtSubject;
    ArrayList<String> subjectList;
    Button btnSearch;
    Button btnUpdate;
    Button btnDelete;
    ArrayAdapter<String> adapter;
    EditText txtSearch;
    String[] subjectArray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_l3);
        lvSubjects = (ListView) findViewById(R.id.lvSubjects);
        txtSubject = (TextView) findViewById(R.id.txtSubject);
        txtSearch = (EditText) findViewById(R.id.txtSearch);
        subjectArray = getResources().getStringArray(R.array.subjects);
        subjectList = new ArrayList<>(Arrays.asList(subjectArray));
        btnSearch = (Button)findViewById(R.id.btnSearch);
        btnDelete = (Button)findViewById(R.id.btnDelete);
        btnUpdate = (Button)findViewById(R.id.btnUpdate);

        adapter = new ArrayAdapter<String>(this, R.layout.mylist, subjectList);
        lvSubjects.setAdapter(adapter);

        btnSearch.setOnClickListener(this);
        btnUpdate.setOnClickListener(this);
        txtSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                ListViewL3.this.adapter.getFilter().filter(charSequence);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }
    @Override
    public void onClick(View v){
        if(v.getId() == R.id.btnSearch){
            String searchText = txtSearch.getText().toString();
            int pos = -1;

            for(int i = 0; i < adapter.getCount(); i++){
                if(adapter.getItem(i).equalsIgnoreCase(searchText)){
                    pos = i;
                    break;
                }
            }
            if(pos != -1){
                String foundItem = adapter.getItem(pos);
                Toast.makeText(this, "Item found!!!" , Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(this, "Item not found!!!", Toast.LENGTH_SHORT).show();
            }
        }
        if(v.getId() == R.id.btnUpdate){
            String updateText = txtSearch.getText().toString();
            boolean itemHasExisted = false;
            for(String item: subjectList){
                if(item.equalsIgnoreCase(updateText)){
                    itemHasExisted = true;
                    break;
                }
            }
            if(itemHasExisted){
                Toast.makeText(this, "Item existed!!!", Toast.LENGTH_SHORT).show();
            }else{
                subjectList.add(updateText);
                Toast.makeText(this, "Add item to list success", Toast.LENGTH_SHORT).show();
                adapter.notifyDataSetChanged();
                lvSubjects.setAdapter(adapter);
            }
        }
    }
}