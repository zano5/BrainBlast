package codetribe.co.za.brainblast.Adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

import codetribe.co.za.brainblast.Class.Constants;
import codetribe.co.za.brainblast.Class.Question;
import codetribe.co.za.brainblast.FillBlackActivity;
import codetribe.co.za.brainblast.R;
import codetribe.co.za.brainblast.TrueFalseActivity;

/**
 * Created by ProJava on 10/4/2016.
 */

public class GeoAdapter extends RecyclerView.Adapter<GeoAdapter.GeoViewHolder> {

    private Context context;
    private List<Question> questions;
    private String image;

    public GeoAdapter(Context context, List<Question> questions,String image)
    {
        this.context = context;
        this.questions =questions;
        this.image = image;

      ;
    }
    @Override
    public GeoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {


        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.question_view,null);

        GeoViewHolder gvh = new GeoViewHolder(view);
        return gvh;
    }

    @Override
    public void onBindViewHolder(final GeoViewHolder holder, final int position) {

        final Question question = questions.get(position);
        holder.ivImage.setImageURI(Uri.parse(image));

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                if(questions.get(position).getId() == 1)
                {

                    Intent intent = new Intent(context, FillBlackActivity.class);
                    intent.putExtra(Constants.GEO,question);
                    holder.cardView.setEnabled(false);
                    holder.ivImage.setEnabled(false);
                    holder.ivImage.setImageURI(null);
                    holder.cardView.setCardBackgroundColor(Color.GRAY);
                    context.startActivity(intent);


                }else if(questions.get(position).getId() == 2)
                {
                    Intent intent = new Intent(context, TrueFalseActivity.class);
                    intent.putExtra(Constants.GEO,question);
                    holder.cardView.setEnabled(false);
                    holder.ivImage.setEnabled(false);
                    holder.ivImage.setImageURI(null);
                    holder.cardView.setCardBackgroundColor(Color.GRAY);
                    context.startActivity(intent);


                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return questions.size();
    }

    public class GeoViewHolder extends RecyclerView.ViewHolder {


        CardView cardView;
        ImageView ivImage;
        public GeoViewHolder(View view) {
            super(view);

            cardView = (CardView) view.findViewById(R.id.cardview);
            ivImage = (ImageView) view.findViewById(R.id.ivImage);
        }
    }


    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }
}
