package movieapp.project.com.movieapp.rest;


import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by hemant on 23/10/18.
 */

public class ApiClient {

  public static final String BASE_URL = "http://api.themoviedb.org/3/";

  private static Retrofit retrofit = null;


  public static Retrofit getCLient() {

    if (retrofit == null) {
      retrofit = new Retrofit.Builder().baseUrl(BASE_URL)
              .addConverterFactory(GsonConverterFactory.create())
              .build();

    }
    return retrofit;
  }

}