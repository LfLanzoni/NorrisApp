package ar.android.lflanzoni.norrisapp.ListCategory;
import android.content.Intent;

import java.util.List;

import ar.android.lflanzoni.norrisapp.Joke.jokeView;

public class ListCategoriesPresenter implements  ListCategoriesMVP.Presenter, ListCategoriesMVP.Model.OnFinishListener {
    ListCategoriesView mView;
    ListCategoriesModel mModel;

    public ListCategoriesPresenter(ListCategoriesView listCategoriesView) {
        mView= listCategoriesView;
        mModel = new ListCategoriesModel();
    }

    @Override
    public void onDestroy() {
        mView=null;
    }

    @Override
    public void requestDataFromServer() {
        mModel.getCategories(this);
    }

    @Override
    public void navigateTo(String category) {
        Intent i = new Intent(mView, jokeView.class);
        i.putExtra("category",category);
        mView.startActivity(i);
    }

    @Override
    public void onFinished(List<String> categories) {
        mView.setDataToRecyclerView(categories);
    }

    @Override
    public void onFailure(Throwable t) {
        mView.onResponseFailure(t);
    }
}
