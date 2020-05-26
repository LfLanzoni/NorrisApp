package ar.android.lflanzoni.norrisapp.Network;

import java.util.List;
import ar.android.lflanzoni.norrisapp.Models.Jokes;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {

    //RANDOM JOKE
    @GET("random")
    Call<Jokes> getRandomJokes();

    // LIST CATEGORIES
    @GET("categories")
    Call<List<String>> getCategories();

    // JOKE FROM SELECTED CATEGORY
    @GET("random")
    Call<Jokes> getSelectJoke(@Query("category")String select);

}
