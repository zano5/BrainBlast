package codetribe.co.za.brainblast;

import android.content.Intent;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

import codetribe.co.za.brainblast.Adapter.ScoreAdapter;
import codetribe.co.za.brainblast.Class.AnswerQuestion;
import codetribe.co.za.brainblast.Class.Score;
import codetribe.co.za.brainblast.Database.ScoreDatabase;
import codetribe.co.za.brainblast.MyPreferences.MyPref;

public class MainActivity extends AppCompatActivity {

    private Button btnGeography,btnHistory,btnCS;
    private RecyclerView rvScore;
    private ScoreAdapter scoreAdapter;
    private MyPref pref;
    private ArrayList<AnswerQuestion> answerQuestions;
    private ScoreDatabase db;
    private ArrayList<Score> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnGeography = (Button) findViewById(R.id.btnGeography);
        btnHistory = (Button) findViewById(R.id.btnHistory);
        btnCS = (Button) findViewById(R.id.btnCS);


        db = new ScoreDatabase(this);
        list =(ArrayList<Score>) db.getScores();


        if(list.size() == 0)
        {
            db.createScore("geography");
            db.createScore("history");
            db.createScore("CS");



            list = (ArrayList<Score>) db.getScores();

            Log.i("Database Size",String.valueOf(list.size()));
        }






        rvScore = (RecyclerView) findViewById(R.id.rvScore);
        rvScore.setLayoutManager(new LinearLayoutManager(this));
     /* answerQuestions.add(new AnswerQuestion(getResources().getString(R.string.history_text),pref.history(MainActivity.this),pref.getHistoryTry(MainActivity.this)));
        answerQuestions.add(new AnswerQuestion(getResources().getString(R.string.geo_text),pref.geo(MainActivity.this),pref.getGeoTry(MainActivity.this)));
        answerQuestions.add(new AnswerQuestion(getResources().getString(R.string.cs_text),pref.cs(MainActivity.this),pref.getCSTry(MainActivity.this)));*/
        scoreAdapter = new ScoreAdapter(MainActivity.this,list);

        rvScore.setAdapter(scoreAdapter);
    }


    public void initialize()
    {




    }


    public void onGeography(View view)
    {
        Intent intent = new Intent(MainActivity.this,GeographyListActivity.class);
        startActivity(intent);

    }


    public void onHistory(View view)
    {
        Intent intent = new Intent(MainActivity.this,HistoryListActivity.class);
        startActivity(intent);
    }

    public void onCS(View view)
    {
        Intent intent = new Intent(MainActivity.this,CSListActivity.class);
        startActivity(intent);
    }
}
