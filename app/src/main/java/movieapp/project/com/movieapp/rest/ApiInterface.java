package movieapp.project.com.movieapp.rest;

import movieapp.project.com.movieapp.model.movieResponce;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by hemant on 23/10/18.
 */

public interface ApiInterface {

    @GET("movie/upcoming")
    Call<movieResponce> getTopRatedMovies(@Query("api_key") String apikey);

    @GET("movie/{id}")
    Call<movieResponce> getMovieDetails(@Path("id")int id,@Query("api_key")String apikey);
}
