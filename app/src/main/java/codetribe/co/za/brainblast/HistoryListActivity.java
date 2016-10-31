package codetribe.co.za.brainblast;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import codetribe.co.za.brainblast.Adapter.GeoAdapter;
import codetribe.co.za.brainblast.Class.Question;

public class HistoryListActivity extends AppCompatActivity {

    private RecyclerView rvHistory;
    private GeoAdapter adapter;
    private List<Question> questions;
    private String[] historyQuestions;
    private String[] historyAnswers;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history_list);

        historyQuestions = getResources().getStringArray(R.array.historyQuestion);
        historyAnswers = getResources().getStringArray(R.array.historyAnswers);

        questions = new ArrayList<Question>();

        questions.add(
                new Question( 2,historyQuestions[0],historyAnswers[0],getResources().getString(R.string.true_false_text),getResources().getString(R.string.package_text) + R.drawable.southafrica,getResources().getString(R.string.history_text)));
        questions.add(new Question(1,historyQuestions[1],historyAnswers[1],getResources().getString(R.string.fill_blank_text),getResources().getString(R.string.package_text) + R.drawable.king,getResources().getString(R.string.history_text)));

        questions.add(new Question(1,historyQuestions[2],historyAnswers[2],getResources().getString(R.string.fill_blank_text),getResources().getString(R.string.package_text) + R.drawable.nelson,getResources().getString(R.string.history_text)));

        questions.add(new Question(1,historyQuestions[3],historyAnswers[3],getResources().getString(R.string.fill_blank_text),getResources().getString(R.string.package_text) + R.drawable.henry,getResources().getString(R.string.history_text)));

        questions.add(new Question(2,historyQuestions[4],historyAnswers[0],getResources().getString(R.string.true_false_text),getResources().getString(R.string.package_text) + R.drawable.africa,getResources().getString(R.string.history_text)));


        long seed = System.nanoTime();
        Collections.shuffle(questions, new Random(seed));

        String image =getResources().getString(R.string.package_text) + R.drawable.historypic;
        adapter = new GeoAdapter(HistoryListActivity.this,questions,image);


        rvHistory = (RecyclerView) findViewById(R.id.rvHistory);
        rvHistory.setLayoutManager(new LinearLayoutManager(this));
        rvHistory.setAdapter(adapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_history, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();


        if(id == R.id.action_cs)
        {

            Intent intent = new Intent(HistoryListActivity.this,CSListActivity.class);
            startActivity(intent);
            finish();
        }else if(id == R.id.action_geo)
        {
            Intent intent = new Intent(HistoryListActivity.this,GeographyListActivity.class);
            startActivity(intent);
            finish();
        }


        return super.onOptionsItemSelected(item);
    }
}

