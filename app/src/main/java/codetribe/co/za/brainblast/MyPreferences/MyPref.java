package codetribe.co.za.brainblast.MyPreferences;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

/**
 * Created by ProJava on 10/7/2016.
 */

public class MyPref  {

    private SharedPreferences  pref;
    private SharedPreferences.Editor editor;
    private String KEY_PREF = "myPref";
    private int score = 0;
    private String KEY_SCORE="score", KEY_GEO="geo",KEY_CS="cs",KEY_HISTORY="history",KEY_GEO_TRY ="try_geo",KEY_CS_TRY="cs_try",KEY_HISTORY_TRY="try_history";
    private int scoreHistory=0, scoreGeo=0,scoreCS=0;
    private int scoreTryHistory=0, scoreTryGeo=0, scoreTryCS=0;
    private static final String TAG ="context";










    public void saveGeo(Context context,int score,int trys)
    {



        scoreGeo =getGeo(context);
        scoreGeo += score;
        scoreGeo+=score;
        scoreTryGeo = getGeoTry(context);
        scoreTryGeo+=trys;
        pref = context.getSharedPreferences(KEY_PREF, Context.MODE_PRIVATE);
        editor = pref.edit();
        editor.putInt(KEY_GEO, scoreGeo);
        editor.putInt(KEY_GEO_TRY,scoreTryGeo);
        editor.apply();

        Log.v(TAG,"done");
    }

    public void saveHistory(Context context,int score,int trys)
    {
        scoreTryCS = getHistoryTry(context);
        scoreTryCS+=trys;
        scoreHistory = getHistory(context);
        scoreHistory+=score;
        pref = context.getSharedPreferences(KEY_PREF, Context.MODE_PRIVATE);
        editor = pref.edit();
        editor.putInt(KEY_HISTORY, scoreHistory);
        editor.putInt(KEY_HISTORY_TRY,scoreTryHistory);
        editor.apply();


        Log.v(TAG,"done");
    }


    public void saveCS(Context context,int score,int trys)
    {

        scoreCS = getCS(context);
        scoreCS+=score;
        scoreTryCS = getCSTry(context);
        scoreTryCS+=trys;
        pref = context.getSharedPreferences(KEY_PREF,  Context.MODE_PRIVATE);
        editor = pref.edit();
        editor.putInt(KEY_CS, scoreCS);
        editor.putInt(KEY_CS_TRY,scoreTryCS);
        editor.apply();

        Log.v(TAG,"done");
    }


    public int getGeo(Context context)
    {


        pref = context.getSharedPreferences(KEY_PREF,Context.MODE_PRIVATE);
        Log.v(TAG,""+pref.getInt(KEY_GEO,0));
        return  pref.getInt(KEY_GEO,0);
    }


    public int getHistory(Context context)
    {
        pref = context.getSharedPreferences(KEY_PREF, Context.MODE_PRIVATE);
        Log.v(TAG,""+pref.getInt(KEY_HISTORY,0));
        return  pref.getInt(KEY_HISTORY,0);
    }


    public int getCS(Context context)
    {
        pref = context.getSharedPreferences(KEY_PREF, Context.MODE_PRIVATE);
        Log.v(TAG,""+pref.getInt(KEY_CS,0));
        return  pref.getInt(KEY_CS,0);
    }

    public int getGeoTry(Context context)
    {
        pref = context.getSharedPreferences(KEY_PREF, Context.MODE_PRIVATE);
        Log.v(TAG,""+pref.getInt(KEY_GEO_TRY,0));
        return  pref.getInt(KEY_GEO_TRY,0);
    }

    public int getHistoryTry(Context context)
    {
        pref = context.getSharedPreferences(KEY_PREF, Context.MODE_PRIVATE);
        Log.v(TAG,""+pref.getInt(KEY_HISTORY_TRY,0));
        return  pref.getInt(KEY_HISTORY_TRY,0);
    }

    public int getCSTry(Context context)
    {
        pref = context.getSharedPreferences(KEY_PREF,  Context.MODE_PRIVATE);
        Log.v(TAG,""+pref.getInt(KEY_CS_TRY,0));
        return  pref.getInt(KEY_CS_TRY,0);
    }



    public int history(Context context)
    {

      int score = getHistory(context);

        return  score;

    }


    public int cs(Context context)
    {

        int score = getCS(context);

        return  score;

    }


    public int geo(Context context)
    {

        int score = getGeo(context);

        return  score;

    }




}
