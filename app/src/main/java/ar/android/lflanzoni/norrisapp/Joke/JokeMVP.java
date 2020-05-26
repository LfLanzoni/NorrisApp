package ar.android.lflanzoni.norrisapp.Joke;
import ar.android.lflanzoni.norrisapp.Models.Jokes;

public interface JokeMVP {

    public interface Model{

        interface OnFinishListener{
            void onFinished(Jokes randomJoke);

            void onFailure(Throwable t);

        }

        void getRandomJoke(OnFinishListener onFinishListener);
        void getCategoryJoke(OnFinishListener onFinishListener,String category);
    }

    public interface Presenter{

        void onDestroy();

        void requestDataFromServer(String category);
    }

    public interface View{

        void setDataToTextView(Jokes randomJoke);

        void onResponseFailure(Throwable throwable);
    }



}
