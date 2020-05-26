package ar.android.lflanzoni.norrisapp.Main;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import ar.android.lflanzoni.norrisapp.Joke.jokeView;
import ar.android.lflanzoni.norrisapp.ListCategory.ListCategoriesView;
import ar.android.lflanzoni.norrisapp.R;

public class MainView extends AppCompatActivity implements View.OnClickListener {
    Button buttonRandom;
    Button buttonCategory;
    ImageView ivApp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainview);
        buttonRandom = (Button) findViewById(R.id.btnRandom);
        buttonRandom.setOnClickListener((View.OnClickListener) this);
        buttonCategory =(Button) findViewById(R.id.btnCategory);
        buttonCategory.setOnClickListener((View.OnClickListener) this);
        ivApp = findViewById(R.id.iVNameApp);
        ivApp.setImageResource(R.drawable.ic_norrisicono);
    }

    @Override
    public void onClick (View v){
        switch (v.getId()){
            case R.id.btnRandom:
                Intent intent = new Intent(this, jokeView.class);
                startActivity(intent);
                break;
            case R.id.btnCategory:
                Intent i = new Intent(this, ListCategoriesView.class);
                startActivity(i);
                break;
        }
    }

}
