package ar.android.lflanzoni.norrisapp.ListCategory;

import android.util.Log;
import java.util.List;
import ar.android.lflanzoni.norrisapp.Network.ApiInterface;
import ar.android.lflanzoni.norrisapp.Network.NorrisClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import static android.content.ContentValues.TAG;

public class ListCategoriesModel implements ListCategoriesMVP.Model {

    @Override
    public void getCategories(final OnFinishListener onFinishedListener) {
        ApiInterface apiService =
                NorrisClient.getClient().create(ApiInterface.class);
        Call<List<String>> call = apiService.getCategories();
        call.enqueue(new Callback<List<String>>() {
            @Override
            public void onResponse(Call<List<String>> call, Response<List<String>> response) {
                if(response.isSuccessful()) {
                    List<String> categories = response.body();
                    onFinishedListener.onFinished(categories);
                }else{
                    Log.d("ERROR",String.valueOf(response.code()));
                }
            }

            @Override
            public void onFailure(Call<List<String>> call, Throwable t) {
                Log.e(TAG, t.toString());
                onFinishedListener.onFailure(t);
            }

        });
    }
}
