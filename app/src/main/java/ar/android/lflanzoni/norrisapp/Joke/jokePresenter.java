package ar.android.lflanzoni.norrisapp.Joke;

import ar.android.lflanzoni.norrisapp.Models.Jokes;

public class jokePresenter implements JokeMVP.Presenter, JokeMVP.Model.OnFinishListener {
    jokeView mView;
    jokeModel mModel;

    public jokePresenter(jokeView mJokeView){
        mView=mJokeView;
        mModel = new jokeModel();
    }


    @Override
    public void onDestroy() {
        mView=null;
    }

    @Override
    public void requestDataFromServer(String category) {
        if(category==null){
            mModel.getRandomJoke(this);
        }else{
            mModel.getCategoryJoke(this,category);
        }
    }

    @Override
    public void onFinished(Jokes randomJoke) {
        mView.setDataToTextView(randomJoke);
    }

    @Override
    public void onFailure(Throwable t) {
        mView.onResponseFailure(t);
    }
}
