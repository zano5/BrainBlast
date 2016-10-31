package codetribe.co.za.brainblast;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import codetribe.co.za.brainblast.Class.Constants;
import codetribe.co.za.brainblast.Class.Question;
import codetribe.co.za.brainblast.Class.Score;
import codetribe.co.za.brainblast.Database.ScoreDatabase;
import codetribe.co.za.brainblast.MyPreferences.MyPref;

public class FillBlackActivity extends AppCompatActivity {

    private TextView tvQuestion;
    private EditText etAnswer;
    private Button btnsubmit;
    private ImageView ivImage;
    private Question question;
    private int count;
    private ScoreDatabase db;

    private AlphaAnimation buttonClick = new AlphaAnimation(1F, 0.8F);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Intent intent = getIntent();
        question = (Question) intent.getSerializableExtra(Constants.GEO);

        db = new ScoreDatabase(this);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fill_black);

        tvQuestion = (TextView) findViewById(R.id.tvQuestion);
        etAnswer = (EditText) findViewById(R.id.etAnswer);
        btnsubmit = (Button) findViewById(R.id.btnSubmit);
        ivImage = (ImageView) findViewById(R.id.ivImage);


        initialise();
        // Uri path = Uri.parse("android.resource://your.package.name/" + R.drawable.sample_1);
    }

    public void initialise() {
        tvQuestion.setText(question.getQuestion());

        if (!question.getUrl().equals("")) {
            Picasso.with(FillBlackActivity.this).load(Uri.parse(question.getUrl())).into(ivImage);
        }


    }


    public void onSubmit(View view) {

        view.startAnimation(buttonClick);
        if (!etAnswer.getText().toString().equals("")) {


            String answer = etAnswer.getText().toString();

            if (answer.toLowerCase().equals(question.getAnswer().toLowerCase())) {

                Toast.makeText(FillBlackActivity.this, getResources().getString(R.string.correct_text), Toast.LENGTH_SHORT).show();

                count = 1;


                if (question.getSection().equals(getResources().getString(R.string.geo_text))) {

                    Score score = new Score(1, 1, 1, getResources().getString(R.string.geo_text));
                    db.updateScore(score);
                } else if (question.getSection().equals(getResources().getString(R.string.history_text))) {

                    Score score = new Score(2, 1, 1, getResources().getString(R.string.history_text));
                    db.updateScore(score);
                } else if (question.getSection().equals(getResources().getString(R.string.cs_text))) {
                    Score score = new Score(3, 1, 1, getResources().getString(R.string.cs_text));
                    db.updateScore(score);
                }


                finish();

            } else {

                if (question.getSection().equals(getResources().getString(R.string.geo_text))) {

                    Score score = new Score(1, 0, 1, getResources().getString(R.string.geo_text));
                    db.updateScore(score);
                } else if (question.getSection().equals(getResources().getString(R.string.history_text))) {

                    Score score = new Score(2, 0, 1, getResources().getString(R.string.history_text));
                    db.updateScore(score);
                } else if (question.getSection().equals(R.string.cs_text)) {

                    Score score = new Score(3, 0, 1, getResources().getString(R.string.cs_text));
                    db.updateScore(score);
                }
            }
            Toast.makeText(FillBlackActivity.this, getResources().getString(R.string.wrong_text), Toast.LENGTH_SHORT).show();

            finish();
        } else

        {


            Toast.makeText(FillBlackActivity.this, getResources().getString(R.string.answer_request_text), Toast.LENGTH_SHORT).show();


        }
    }

}

