package com.example.moniaczek.array;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;

public class Activity3 extends AppCompatActivity {

    private TextView text;
    private RatingBar rating;
    private Button btnSave3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);
        rating = (RatingBar) findViewById(R.id.ratingBar);
        text = (TextView)findViewById(R.id.textView);


        btnSave3 = (Button)findViewById(R.id.btnSave3);



        rating.setOnRatingBarChangeListener(
                new RatingBar.OnRatingBarChangeListener() {
                    @Override
                    public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                        text.setText(String.valueOf(rating));
                    }
                }
        );


        btnSave3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = getSharedPreferences("myrate3", MODE_PRIVATE).edit();
                editor.putFloat("rating3", rating.getRating());
                editor.commit();
            }
        });




        SharedPreferences prefs = getSharedPreferences("myrate3", MODE_PRIVATE);
        if (prefs != null) {
            Float savedrate = prefs.getFloat("rating3", 0f);
            rating.setRating(savedrate);

        }

    }
}
