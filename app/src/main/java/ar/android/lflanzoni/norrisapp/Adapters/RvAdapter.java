package ar.android.lflanzoni.norrisapp.Adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.ArrayList;
import ar.android.lflanzoni.norrisapp.ListCategory.ListCategoriesView;
import ar.android.lflanzoni.norrisapp.R;

public class RvAdapter extends RecyclerView.Adapter<RvAdapter.rvViewHolder> implements View.OnClickListener {
    private ArrayList<String> categories;
    private ListCategoriesView listCategoriesView;
    private View.OnClickListener listener;

    @Override
    public void onClick(View view) {
        if(listener !=null){
            listener.onClick(view);
        }
    }

    public static class rvViewHolder extends RecyclerView.ViewHolder {

        public TextView tvCategory;

        public rvViewHolder(View v) {
            super(v);
            tvCategory = v.findViewById(R.id.tvCategory);
        }
    }

    public RvAdapter(ListCategoriesView listCtgView,ArrayList<String> Dataset) {
        categories = Dataset;
        listCategoriesView=listCtgView;
    }

    @NonNull
    @Override
    public RvAdapter.rvViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View v =  LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_category, parent, false);
        v.setOnClickListener(this);
        rvViewHolder vh = new rvViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull RvAdapter.rvViewHolder rvViewHolder, int i) {
        rvViewHolder.tvCategory.setText(categories.get(i));
    }

    @Override
    public int getItemCount() {
        return categories.size();
    }

    public void setOnClickListener(View.OnClickListener mListener){
        this.listener=mListener;
    }

    public void updateCBU() {
        String cbu = "es mi cbu papá";
    }
}
