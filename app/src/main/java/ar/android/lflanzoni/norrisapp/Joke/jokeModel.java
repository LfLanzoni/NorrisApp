package ar.android.lflanzoni.norrisapp.Joke;

import android.util.Log;
import ar.android.lflanzoni.norrisapp.Models.Jokes;
import ar.android.lflanzoni.norrisapp.Network.ApiInterface;
import ar.android.lflanzoni.norrisapp.Network.NorrisClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import static android.content.ContentValues.TAG;

public class jokeModel implements JokeMVP.Model {

    @Override
    public void getRandomJoke(final OnFinishListener onFinishedListener) {
        ApiInterface apiService =
                NorrisClient.getClient().create(ApiInterface.class);
        Call<Jokes> call = apiService.getRandomJokes();

        call.enqueue(new Callback<Jokes>() {
            @Override
            public void onResponse(Call<Jokes> call, Response<Jokes> response) {
                if(response.isSuccessful()) {
                    Jokes jokeRandom = response.body();
                    onFinishedListener.onFinished(jokeRandom);
                }else{
                    Log.d("ERROR",String.valueOf(response.code()));
                }
            }

            @Override
            public void onFailure(Call<Jokes> call, Throwable t) {
                // Log error here since request failed
                Log.e(TAG, t.toString());
                onFinishedListener.onFailure(t);
            }
        });
    }

    @Override
    public void getCategoryJoke(final OnFinishListener onFinishedListener, String category) {
        ApiInterface apiService =
                NorrisClient.getClient().create(ApiInterface.class);
        Call<Jokes> call = apiService.getSelectJoke(category);

        call.enqueue(new Callback<Jokes>() {
            @Override
            public void onResponse(Call<Jokes> call, Response<Jokes> response) {
                if(response.isSuccessful()) {
                    Jokes jokeRandom = response.body();
                    onFinishedListener.onFinished(jokeRandom);
                }else{
                    Log.d("ERROR",String.valueOf(response.code()));
                }
            }

            @Override
            public void onFailure(Call<Jokes> call, Throwable t) {
                // Log error here since request failed
                Log.e(TAG, t.toString());
                onFinishedListener.onFailure(t);
            }
        });
    }


}
