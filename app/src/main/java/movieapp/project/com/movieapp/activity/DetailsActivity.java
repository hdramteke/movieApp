package movieapp.project.com.movieapp.activity;

import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import movieapp.project.com.movieapp.R;
import movieapp.project.com.movieapp.adapter.detailsAdapter;
import movieapp.project.com.movieapp.model.movie;

public class DetailsActivity extends AppCompatActivity {

    ViewPager viewPager;
    LinearLayout sliderDots;
    private int dotCounts;
    private ImageView []dots;
    Float value;

    TextView textTitle,textDescription;
    RatingBar ratingBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);

        viewPager = findViewById(R.id.viewPager);

        Intent intent = getIntent();

        movie Movie = intent.getParcelableExtra("Movie");

        textTitle = findViewById(R.id.textTitle);
        textDescription = findViewById(R.id.textDescription);
        ratingBar = findViewById(R.id.ratingBar);

        textTitle.setText("Title - "+Movie.getTitle());
        textDescription.setText("Overview - "+Movie.getOverview());

        value = Movie.getPopularity().floatValue();
        value = ((value*50)/200)/5;

        ratingBar.setRating(value);
        ratingBar.setEnabled(false);
        Log.e("Popularity",""+value);

        detailsAdapter detailsAdapter = new detailsAdapter(this,Movie.getPosterPath());
        viewPager.setAdapter(detailsAdapter);

        sliderDots = findViewById(R.id.sliderDots);
        dotCounts = detailsAdapter.getCount();
        dots = new ImageView[dotCounts];

        for(int i=0;i<dotCounts;i++){
            dots[i] = new ImageView(this);
            dots[i].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(),R.drawable.non_active_dot));

            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,LinearLayout.LayoutParams.WRAP_CONTENT);

            params.setMargins(8,0,8,0);

            sliderDots.addView(dots[i],params);

        }
        dots[0].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(),R.drawable.active_dot));

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

                for(int i=0;i<dotCounts;i++){
                    dots[i].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(),R.drawable.non_active_dot));
                }
                dots[position].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(),R.drawable.active_dot));
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });





    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()== android.R.id.home){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
