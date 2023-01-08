package com.example.outfitpicker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UpdateActivity extends AppCompatActivity {

    EditText title_input, pieces_input;
    Button update_button;

    String id, title, pieces;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        title_input = findViewById(R.id.title_input2);
        pieces_input = findViewById(R.id.pieces_input2);
        update_button = findViewById(R.id.update_button);

        getAndSetIntentData();

        update_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                OutfitDBHelper myDB = new OutfitDBHelper(UpdateActivity.this);
                title = title_input.getText().toString().trim();
                pieces = pieces_input.getText().toString().trim();
                myDB.updateData(id, title, pieces);
            }
        });
    }

    void getAndSetIntentData() {
        if(getIntent().hasExtra("id") && getIntent().hasExtra("title") && getIntent().hasExtra("pieces")){
            id = getIntent().getStringExtra("id");
            title = getIntent().getStringExtra("title");
            pieces = getIntent().getStringExtra("pieces");

            title_input.setText(title);
            pieces_input.setText(pieces);
        } else {
            Toast.makeText(this, "No data", Toast.LENGTH_SHORT).show();
        }
    }
}