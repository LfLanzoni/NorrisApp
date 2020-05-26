package ar.android.lflanzoni.norrisapp.ListCategory;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;
import ar.android.lflanzoni.norrisapp.Adapters.RvAdapter;
import ar.android.lflanzoni.norrisapp.R;

public class ListCategoriesView extends AppCompatActivity implements ListCategoriesMVP.View {
    RecyclerView rvCategories;
    ListCategoriesPresenter mPresenter;
    RvAdapter adapter;
    ArrayList<String> listCategories;
    RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_categories_view);
        rvCategories = findViewById(R.id.rvCategories);
        layoutManager = new LinearLayoutManager(this);
        rvCategories.setLayoutManager(layoutManager);
        mPresenter = new ListCategoriesPresenter(this);

        listCategories = new ArrayList<String>();
        adapter = new RvAdapter(this,listCategories);
        rvCategories.setAdapter(adapter);
        mPresenter.requestDataFromServer();

        adapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String selectCategory = listCategories.get(rvCategories.getChildAdapterPosition(view));
                if(selectCategory!=null){
                    mPresenter.navigateTo(selectCategory);
                }
            }
        });
    }

    @Override
    public void setDataToRecyclerView(List<String> categories) {
        listCategories.addAll(categories);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onResponseFailure(Throwable throwable) {
        Toast.makeText(this,throwable.getMessage(),Toast.LENGTH_SHORT).show();
    }
}
