package com.moniaczek.projekt;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;

public class Activity5 extends AppCompatActivity {

    private TextView text;
    private RatingBar rating;
    private Button btnSave5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_5);
        rating = (RatingBar) findViewById(R.id.ratingBar);
        text = (TextView)findViewById(R.id.textView);


        btnSave5 = (Button)findViewById(R.id.btnSave5);



        rating.setOnRatingBarChangeListener(
                new RatingBar.OnRatingBarChangeListener() {
                    @Override
                    public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                        text.setText(String.valueOf(rating));
                    }
                }
        );


        btnSave5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = getSharedPreferences("myrate5", MODE_PRIVATE).edit();
                editor.putFloat("rating5", rating.getRating());
                editor.commit();
            }
        });




        SharedPreferences prefs = getSharedPreferences("myrate5", MODE_PRIVATE);
        if (prefs != null) {
            Float savedrate = prefs.getFloat("rating5", 0f);
            rating.setRating(savedrate);

        }

    }
}
