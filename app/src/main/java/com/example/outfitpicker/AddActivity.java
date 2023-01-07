package com.example.outfitpicker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddActivity extends AppCompatActivity {

    EditText title_input, pieces_input;
    Button add_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        title_input = findViewById(R.id.title_input);
        pieces_input = findViewById(R.id.pieces_input);
        add_button = findViewById(R.id.add_button);
        add_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                OutfitDBHelper myDB = new OutfitDBHelper(AddActivity.this);
                myDB.addOutfit(title_input.getText().toString().trim(), Integer.valueOf(pieces_input.getText().toString().trim()));
            }
        });
    }
}