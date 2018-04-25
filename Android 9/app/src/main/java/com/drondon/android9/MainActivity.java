package com.drondon.android9;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ListView listView = findViewById(R.id.listView);

        final List<Character> alphabet = getAlphabet();

        /*ArrayAdapter*/
        ListAdapter adapter = new ArrayAdapter<>(this,
                R.layout.item_single_selected,
                alphabet);

        listView.setAdapter(adapter);
        listView.setChoiceMode(AbsListView.CHOICE_MODE_SINGLE);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //view.setBackgroundColor(ContextCompat.getColor(view.getContext(), R.color.colorAccent));
                Toast.makeText(view.getContext(),
                        "Letter: " + alphabet.get(position),
                        Toast.LENGTH_SHORT
                ).show();
            }
        });

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int checkedPosition = listView.getCheckedItemPosition();
                openDetailScreen(alphabet.get(checkedPosition));
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
