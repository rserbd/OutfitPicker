package com.example.outfitpicker;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class OutfitDBHelper extends SQLiteOpenHelper {

    private Context context;
    private static final String DATABASE_NAME = "OutfitPicker.db";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NAME = "my_outfits";
    private static final String COLUMN_ID = "_id";
    private static final String COLUMN_TITLE = "outfit_title";
    private static final String COLUMN_NR_PIECES = "outfit_nr_pieces";

    public OutfitDBHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query =
                "CREATE TABLE " + TABLE_NAME +
                        " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        COLUMN_TITLE + " TEXT, " +
                        COLUMN_NR_PIECES + " INTEGER);";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
}
