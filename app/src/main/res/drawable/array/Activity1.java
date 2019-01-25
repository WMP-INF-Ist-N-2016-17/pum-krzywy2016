package com.example.moniaczek.array;


import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;

public class Activity1 extends AppCompatActivity {
    private TextView text;
    private RatingBar rating;
    private Button btnSave;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_1);
        rating = (RatingBar) findViewById(R.id.ratingBar);
        text = (TextView)findViewById(R.id.textView);


        btnSave = (Button)findViewById(R.id.btnSave);



        rating.setOnRatingBarChangeListener(
                new RatingBar.OnRatingBarChangeListener() {
                    @Override
                    public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                        text.setText(String.valueOf(rating));
                    }
                }
        );


        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = getSharedPreferences("myrate", MODE_PRIVATE).edit();
                editor.putFloat("rating", rating.getRating());
                editor.commit();
            }
        });




        SharedPreferences prefs = getSharedPreferences("myrate", MODE_PRIVATE);
        if (prefs != null) {
            Float savedrate = prefs.getFloat("rating", 0f);
            rating.setRating(savedrate);

        }

    }




}




