package codetribe.co.za.brainblast.Adapter;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import codetribe.co.za.brainblast.Class.AnswerQuestion;
import codetribe.co.za.brainblast.Class.Score;
import codetribe.co.za.brainblast.R;

/**
 * Created by ProJava on 10/13/2016.
 */

public class ScoreAdapter extends RecyclerView.Adapter<ScoreAdapter.ViewHolder> {


    private List<Score> answers;
    private Context context;


    public ScoreAdapter(Context context)
    {

       this.context = context;
    }
    public ScoreAdapter(Context context,List<Score> answerQuestions)
    {

        this.context = context;
        this.answers = answerQuestions;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

      View view=  LayoutInflater.from(parent.getContext()).inflate(R.layout.answer_view,null);
        ViewHolder vh = new ViewHolder(view);
        return  vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

            Score score= answers.get(position);



        if(score.getSection().equals(context.getResources().getString(R.string.geo_text)))
        {
            Picasso.with(context).load(Uri.parse(context.getResources().getString(R.string.package_text)+ R.drawable.geography)).into(holder.ivImage);
        }else if(score.getSection().equals(context.getResources().getString(R.string.history_text)))
        {
            Picasso.with(context).load(Uri.parse(context.getResources().getString(R.string.package_text)+ R.drawable.historypic)).into(holder.ivImage);
        }else if(score.getSection().equals(context.getResources().getString(R.string.cs_text)))
        {
            Picasso.with(context).load(Uri.parse(context.getResources().getString(R.string.package_text)+ R.drawable.computer)).into(holder.ivImage);
        }

        holder.tvQuestion.setText(score.getScore() +"/"+score.getTryouts());


    }

    @Override
    public int getItemCount() {
        return answers.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tvQuestion;
        private ImageView ivImage;

        public ViewHolder(View view) {
            super(view);


            tvQuestion = (TextView) view.findViewById(R.id.tvQuestion);
            ivImage = (ImageView) view.findViewById(R.id.ivImage);
        }
    }
}
