package codetribe.co.za.brainblast.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import codetribe.co.za.brainblast.Class.Score;

/**
 * Created by ProJava on 10/26/2016.
 */

public class ScoreDatabase extends  SQLiteOpenHelper
{
    private static String DATABASE_NAME = "scoredbase", KEY_ID = "_id", KEY_SCORE= "score",KEY_TRY="try",
    KEY_SECTION = "section", TABLE_NAME = "tblScore";
    private static int VERSIOn = 1;

    public ScoreDatabase(Context context) {
        super(context, DATABASE_NAME, null, VERSIOn);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String sql = " CREATE TABLE " + TABLE_NAME + " ( " + KEY_ID + " integer primary key  autoincrement, " + KEY_SCORE + " integer, " + KEY_TRY + " integer, " + KEY_SECTION + " text not null);";
        db.execSQL(sql);





    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {


        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);

    }






    public void createScore(String section)
    {

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();


        values.put(KEY_SCORE,0);
        values.put(KEY_TRY,0);
        values.put(KEY_SECTION,section);

        db.insert(TABLE_NAME,null,values);
        db.close();

    }


    public void updateScore(Score score)
    {


        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        Score score1 = getScore(score.getId());


        values.put(KEY_SCORE,score1.getScore() + score.getScore());
        values.put(KEY_TRY,score1.getTryouts() +score.getTryouts());
        values.put(KEY_SECTION,score.getSection());


        db.update(TABLE_NAME,values, KEY_ID + "=?",new String[]{String.valueOf(score.getId())});
        db.close();
    }


    public Score getScore(int id)
    {

        SQLiteDatabase db = getReadableDatabase();
        String sql = " SELECT _id,score,try,section FROM " + TABLE_NAME + " WHERE _id = "  + id;
        Score score =null;

        Cursor cursor = db.rawQuery(sql,null);

        if(cursor != null && cursor.moveToFirst())
        {

            if(cursor.moveToFirst())
            {

                score = new Score(cursor.getInt(0),cursor.getInt(1),cursor.getInt(2),cursor.getString(3));

            }


        }



        return  score;
    }




    public List<Score> getScores()
    {


        List<Score> list = new ArrayList<Score>();
        SQLiteDatabase db = this.getReadableDatabase();




        String sql ="SELECT _id,score,try,section FROM " + TABLE_NAME;
        Cursor cursor = db.rawQuery(sql,null);


        if(cursor != null && cursor .moveToFirst())
        {



            if(cursor.moveToFirst())
            {



                do{

                    list.add(new Score(cursor.getInt(0),cursor.getInt(1),cursor.getInt(2),cursor.getString(3)));
                }while (cursor.moveToNext());
            }


        }
        return  list;
    }


    public int getCount()
    {

        SQLiteDatabase db = this.getReadableDatabase();



        String sql = "SELECT  * FROM " + TABLE_NAME;

        Cursor cursor = db.rawQuery(sql,null);

        int count = cursor.getCount();


        db.close();
        cursor.close();

        return  count;
    }



}
