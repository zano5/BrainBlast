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

public class CSListActivity extends AppCompatActivity {
    private RecyclerView rvCs;
    private List<Question> questions;
    private GeoAdapter adapter;
    private String[] csQuestions;
    private String[] csAnswers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cslist);

        csQuestions = getResources().getStringArray(R.array.csQuestion);
        csAnswers = getResources().getStringArray(R.array.csAnswer);
        questions = new ArrayList<Question>();
        questions.add(
                new Question( 2,csQuestions[0],csAnswers[0],getResources().getString(R.string.true_false_text),getResources().getString(R.string.package_text) + R.drawable.programmer,getResources().getString(R.string.cs_text)));
        questions.add(new Question(1,csQuestions[1],csAnswers[1],getResources().getString(R.string.fill_blank_text),getResources().getString(R.string.package_text) + R.drawable.bill,getResources().getString(R.string.cs_text)));

        questions.add(new Question(1,csQuestions[2],csAnswers[2],getResources().getString(R.string.fill_blank_text),getResources().getString(R.string.package_text) + R.drawable.java,getResources().getString(R.string.cs_text)));

        questions.add(new Question(1,csQuestions[3],csAnswers[3],getResources().getString(R.string.fill_blank_text),getResources().getString(R.string.package_text) + R.drawable.android,getResources().getString(R.string.cs_text)));

        questions.add(new Question(2,csQuestions[4],csAnswers[4],getResources().getString(R.string.true_false_text),getResources().getString(R.string.package_text) + R.drawable.facebook,getResources().getString(R.string.cs_text)));

        String image = getResources().getString(R.string.package_text) + R.drawable.computer;

        ;
        long seed = System.nanoTime();
        Collections.shuffle(questions, new Random(seed));

        rvCs = (RecyclerView) findViewById(R.id.rvCs);
        rvCs.setLayoutManager(new LinearLayoutManager(this));
        adapter = new GeoAdapter(CSListActivity.this,questions,image);
        rvCs.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_cs, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();


        if(id == R.id.action_geo)
        {

            Intent intent = new Intent(CSListActivity.this,GeographyListActivity.class);
            startActivity(intent);
            finish();
        }else if(id == R.id.action_history)
        {
            Intent intent = new Intent(CSListActivity.this,HistoryListActivity.class);
            startActivity(intent);
            finish();
        }


        return super.onOptionsItemSelected(item);
    }
}
