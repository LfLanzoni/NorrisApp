package ar.android.lflanzoni.norrisapp.Joke;

import android.content.Intent;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import ar.android.lflanzoni.norrisapp.Models.Jokes;
import ar.android.lflanzoni.norrisapp.R;

public class jokeView extends AppCompatActivity implements JokeMVP.View {

    JokeMVP.Presenter mPresenter;
    TextView tvJoke;
    ImageView ivJoke;
    String category;
    Boolean flagRestore;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.joke_view);
        mPresenter = new jokePresenter(this);
        tvJoke=  new TextView(this);
        tvJoke= findViewById(R.id.textViewJoke);
        ivJoke = new ImageView(this);
        ivJoke = findViewById(R.id.imgJoke);
        ivJoke.setImageResource(R.drawable.ic_norrisicono);
        if(savedInstanceState!=null){
            this.onRestoreInstanceState(savedInstanceState);
        }else {
            Intent i = this.getIntent();
            if (i.getStringExtra("category") != null) {
                category = i.getStringExtra("category");
            }

            mPresenter.requestDataFromServer(category);
        }
    }

    @Override
    public void setDataToTextView(Jokes randomJoke) {
        tvJoke.setText(String.valueOf(randomJoke.getValue()));
    }

    @Override
    public void onResponseFailure(Throwable throwable) {
        Toast.makeText(this,throwable.getMessage(),Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putCharSequence("joke",tvJoke.getText());

    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        tvJoke.setText(savedInstanceState.getCharSequence("joke"));

    }

    @Override
    protected void onResume() {
        super.onResume();
    }
}
