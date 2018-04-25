package com.drondon.android9;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Spinner listView = findViewById(R.id.listView);

        final List<Character> alphabet = getAlphabet();

        /*ArrayAdapter*/
        SpinnerAdapter adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1,
                alphabet);

        listView.setAdapter(adapter);

        listView.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(view.getContext(),
                        "Letter: " + alphabet.get(position),
                        Toast.LENGTH_SHORT
                ).show();
                openDetailScreen(alphabet.get(position));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

    public void openDetailScreen(char letter) {
        Toast.makeText(this, "Selected letter: " + letter, Toast.LENGTH_SHORT).show();
    }

    private List<Character> getAlphabet() {
        List<Character> list = new ArrayList<>();
        for (char i = 'A'; i <= 'Z'; i++) {
            list.add(i);
        }
        return list;
    }
}
