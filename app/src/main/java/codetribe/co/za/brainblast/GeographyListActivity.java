package codetribe.co.za.brainblast;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import codetribe.co.za.brainblast.Adapter.GeoAdapter;
import codetribe.co.za.brainblast.Class.Question;

public class GeographyListActivity extends AppCompatActivity {

    private RecyclerView rvGeo;
    private ArrayList<Question> questions;
    private GeoAdapter adapter;
    private String[] geoQuestions;
    private String[] geoAnswers;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_geography);

        geoQuestions = getResources().getStringArray(R.array.geoQuestions);
        geoAnswers =  getResources().getStringArray(R.array.geoAnswers);

        questions = new ArrayList<Question>();

       /* questions.add(
                new Question( 2,"The intersecting lines drawn on maps on globes are called  geographic grids","true","TF",Uri.parse("android.resource://codetribe.co.za.brainblast/" + R.drawable.meridian)));
        questions.add(new Question(1,"The great Victoria Desert is located in_____","Australia","FB",Uri.parse("android.resource://codetribe.co.za.brainblast/" + R.drawable.desert)));

        questions.add(new Question(1,"The smallest continent in the world is______ ","Australia","FB",Uri.parse("android.resource://codetribe.co.za.brainblast/" + R.drawable.austrailia)));

        questions.add(new Question(1,"Temperature increases rapidly after_______","ionosphere","FB",Uri.parse("android.resource://codetribe.co.za.brainblast/" + R.drawable.ionic)));

        questions.add(new Question(2,"The largest glaciers are piedmont glaciers","true","TF",Uri.parse("android.resource://codetribe.co.za.brainblast/" + R.drawable.piedmont)));*/

        questions.add(
                new Question( 2,geoQuestions[0],geoAnswers[0],getResources().getString(R.string.true_false_text),getResources().getString(R.string.package_text) + R.drawable.meridian,getResources().getString(R.string.geo_text)));
        questions.add(new Question(1,geoQuestions[1],geoAnswers[1],getResources().getString(R.string.fill_blank_text),getResources().getString(R.string.package_text) + R.drawable.desert,getResources().getString(R.string.geo_text)));

        questions.add(new Question(1,geoQuestions[2],geoAnswers[1],getResources().getString(R.string.fill_blank_text),getResources().getString(R.string.package_text) + R.drawable.austrailia,getResources().getString(R.string.geo_text)));

        questions.add(new Question(1,geoQuestions[3],geoAnswers[2],getResources().getString(R.string.fill_blank_text),getResources().getString(R.string.package_text) + R.drawable.ionic,getResources().getString(R.string.geo_text)));

        questions.add(new Question(2,geoQuestions[4],geoAnswers[0],getResources().getString(R.string.true_false_text),getResources().getString(R.string.package_text) + R.drawable.piedmont,getResources().getString(R.string.geo_text)));

        String image =getResources().getString(R.string.package_text) + R.drawable.geography;

        long seed = System.nanoTime();
        Collections.shuffle(questions, new Random(seed));


        adapter = new GeoAdapter(GeographyListActivity.this,questions,image);
        rvGeo = (RecyclerView) findViewById(R.id.rvGeo);
        rvGeo.setLayoutManager(new LinearLayoutManager(this));

        rvGeo.setAdapter(adapter);













    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        adapter.notifyDataSetChanged();

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_geo, menu);
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

                Intent intent = new Intent(GeographyListActivity.this,CSListActivity.class);
                startActivity(intent);
                finish();
            }else if(id == R.id.action_history)
            {
                Intent intent = new Intent(GeographyListActivity.this,HistoryListActivity.class);
                startActivity(intent);
                finish();
            }


        return super.onOptionsItemSelected(item);
    }
}
