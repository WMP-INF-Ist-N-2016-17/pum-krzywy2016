package com.moniaczek.projekt;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;

public class Activity6 extends AppCompatActivity {

    private TextView text;
    private RatingBar rating;
    private Button btnSave6;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_6);
        rating = (RatingBar) findViewById(R.id.ratingBar);
        text = (TextView)findViewById(R.id.textView);


        btnSave6 = (Button)findViewById(R.id.btnSave6);



        rating.setOnRatingBarChangeListener(
                new RatingBar.OnRatingBarChangeListener() {
                    @Override
                    public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                        text.setText(String.valueOf(rating));
                    }
                }
        );


        btnSave6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = getSharedPreferences("myrate6", MODE_PRIVATE).edit();
                editor.putFloat("rating6", rating.getRating());
                editor.commit();
            }
        });




        SharedPreferences prefs = getSharedPreferences("myrate6", MODE_PRIVATE);
        if (prefs != null) {
            Float savedrate = prefs.getFloat("rating6", 0f);
            rating.setRating(savedrate);

        }

    }
}
