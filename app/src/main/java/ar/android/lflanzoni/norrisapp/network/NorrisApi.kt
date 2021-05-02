package ar.android.lflanzoni.norrisapp.network

import ar.android.lflanzoni.norrisapp.models.Jokes
import retrofit2.http.GET
import retrofit2.http.Query

interface NorrisApi {
    //RANDOM JOKE
    @GET("random")
    suspend fun getRandomJokes(): Jokes

    // LIST CATEGORIES
    @GET("categories")
    suspend fun getCategories(): List<String>

    // JOKE FROM SELECTED CATEGORY
    @GET("random")
    suspend fun getSelectJoke(@Query("category") select: String): Jokes
}