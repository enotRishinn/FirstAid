package com.practice.firstaid.db;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class MyScore {
    private final DBHelper dbHelper;

    public MyScore(DBHelper dbHelper) {
        this.dbHelper = dbHelper;
    }

    private Integer getScore() {
        String sql = "SELECT * FROM myNotes WHERE id = " + 0 + ";";
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        try (Cursor cursor = db.rawQuery(sql, null)) {
            if (cursor.moveToFirst()) {
                int index = cursor.getColumnIndex("my_score");

                return cursor.getInt(index);
            }
        }

        return null;
    }

    public void updateScore (Integer score) {
        ContentValues cv = new ContentValues();
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        String[] forID = new String[] {Integer.toString(0)};

        Integer new_score = score + getScore();
        cv.put("my_score", new_score);
        db.update("score", cv, "id = ?", forID);
    }


}
