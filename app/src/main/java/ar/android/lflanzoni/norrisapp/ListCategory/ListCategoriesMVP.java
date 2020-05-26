package ar.android.lflanzoni.norrisapp.ListCategory;

import java.util.List;

public interface ListCategoriesMVP {

    public interface Model{

        interface OnFinishListener{
            void onFinished(List<String> categories);
            void onFailure(Throwable t);
    }
        void getCategories(OnFinishListener onFinishListener);
    }

    public interface View{
        void setDataToRecyclerView(List<String> categories);
        void onResponseFailure(Throwable throwable);
    }

    public interface Presenter{
        void onDestroy();
        void requestDataFromServer();
        void navigateTo(String category);
    }
}
