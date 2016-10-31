package codetribe.co.za.brainblast;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import codetribe.co.za.brainblast.Class.Constants;
import codetribe.co.za.brainblast.Class.Question;
import codetribe.co.za.brainblast.Class.Score;
import codetribe.co.za.brainblast.Database.ScoreDatabase;
import codetribe.co.za.brainblast.MyPreferences.MyPref;

public class TrueFalseActivity extends AppCompatActivity {
    private Button btnSubmit;
    private TextView tvQuestion;
    private MyPref pref;
    private ImageView ivTF;
    private RadioGroup radioGroup;
    private String valid="";
    private AlphaAnimation buttonClick = new AlphaAnimation(1F, 0.8F);
    private int count=0;
    private ScoreDatabase db;



    private Question question;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        db = new ScoreDatabase(this);
        Intent intent = getIntent();
        question = (Question) intent.getSerializableExtra(Constants.GEO);
        super.onCreate(savedInstanceState);
        pref = new MyPref();
        setContentView(R.layout.activity_true_false);
        btnSubmit = (Button) findViewById(R.id.btnSubmit);
        tvQuestion = (TextView) findViewById(R.id.tvQuestion);
        ivTF = (ImageView) findViewById(R.id.ivTF);
        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);

        initialise();



    }




    public void initialise()
    {

        tvQuestion.setText(question.getQuestion());

        if(!question.getUrl().equals(""))
        {
            Picasso.with(TrueFalseActivity.this).load(Uri.parse(question.getUrl())).into(ivTF);
        }


    }

    public void onSubmit(View view)
    {

        view.startAnimation(buttonClick);


        if(valid.equals(""))
        {


            Toast.makeText(TrueFalseActivity.this, getResources().getString(R.string.radiobutton_request_text), Toast.LENGTH_SHORT).show();

        }else if(valid.toLowerCase().equals(question.getAnswer().toLowerCase()))
        {

            Toast.makeText(TrueFalseActivity.this,getResources().getString(R.string.correct_text),Toast.LENGTH_SHORT).show();


            count = 1;
            if(question.getSection().equals(getResources().getString(R.string.geo_text)))
            {

                Score score = new Score(1, 1, 1, getResources().getString(R.string.geo_text));
                db.updateScore(score);
            }else if(question.getSection().equals(getResources().getString(R.string.history_text)))
            {

                Score score = new Score(2, 1, 1, getResources().getString(R.string.history_text));
                db.updateScore(score);
            }else if(question.getSection().equals(R.string.cs_text))
            {
                Score score = new Score(3, 1, 1, getResources().getString(R.string.cs_text));
                db.updateScore(score);
            }
            finish();

        }else
        {
            Toast.makeText(TrueFalseActivity.this,getResources().getString(R.string.wrong_text),Toast.LENGTH_SHORT).show();
            if(question.getSection().equals(getResources().getString(R.string.geo_text)))
            {
                Score score = new Score(1, 0, 1, getResources().getString(R.string.geo_text));
                db.updateScore(score);
            }else if(question.getSection().equals(getResources().getString(R.string.history_text)))
            {
                Score score = new Score(2, 0, 1, getResources().getString(R.string.history_text));
                db.updateScore(score);
            }else if(question.getSection().equals(R.string.cs_text))
            {
                Score score = new Score(3, 0, 1, getResources().getString(R.string.cs_text));
                db.updateScore(score);
            }
            finish();
        }




    }

    public void onCheck(View view)
    {
        int id = view.getId();

        if(id == R.id.rbTrue)
        {

            valid = getResources().getString(R.string.true_text);



        }else if(id == R.id.rbFalse)
        {

            valid = getResources().getString(R.string.false_text);

        }

    }
}
