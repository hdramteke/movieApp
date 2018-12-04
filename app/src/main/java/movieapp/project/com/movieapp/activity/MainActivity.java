package movieapp.project.com.movieapp.activity;

import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.telecom.Call;
import android.util.Log;
import android.widget.Adapter;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import movieapp.project.com.movieapp.R;
import movieapp.project.com.movieapp.adapter.movieAdapter;
import movieapp.project.com.movieapp.model.movie;
import movieapp.project.com.movieapp.model.movieResponce;
import movieapp.project.com.movieapp.rest.ApiClient;
import movieapp.project.com.movieapp.rest.ApiInterface;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity  {


    public static final String TAG = MainActivity.class.getSimpleName();
    private final static String API_KEY = "b7cd3340a794e5a2f35e3abb820b497f";
    movieAdapter adapter;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Upcoming Movies");

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(this,1));

        if(API_KEY.isEmpty()){
            Toast.makeText(getApplicationContext(),"Please obtain your API KEY first from the moviedb.org",Toast.LENGTH_SHORT).show();
            return;
        }

        ApiInterface apiService = ApiClient.getCLient().create(ApiInterface.class);

        retrofit2.Call<movieResponce> call = apiService.getTopRatedMovies(API_KEY);

        call.enqueue(new Callback<movieResponce>() {
            @Override
            public void onResponse(retrofit2.Call<movieResponce> call, Response<movieResponce> response) {

                List<movie> movies = response.body().getResults();
                Log.e(TAG,"Number of movies received "+movies.size());
                recyclerView.setAdapter(new movieAdapter(movies,getApplicationContext()));

            }

            @Override
            public void onFailure(retrofit2.Call<movieResponce> call, Throwable t) {
                Log.e(TAG,t.toString());
            }




        });



    }


}
