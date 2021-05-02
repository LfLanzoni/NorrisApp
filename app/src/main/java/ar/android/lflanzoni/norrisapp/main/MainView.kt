package ar.android.lflanzoni.norrisapp.main

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ar.android.lflanzoni.norrisapp.R
import ar.android.lflanzoni.norrisapp.databinding.MainviewBinding
import ar.android.lflanzoni.norrisapp.joke.JokeView
import ar.android.lflanzoni.norrisapp.listCategory.ListCategoryView

class MainView: AppCompatActivity() {
    private lateinit var binding: MainviewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = MainviewBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.iVNameApp.setImageResource(R.drawable.ic_norrisicono)

        binding.btnCategory.setOnClickListener{
            val i = Intent(this, ListCategoryView::class.java)
            startActivity(i)
        }

        binding.btnRandom.setOnClickListener {
            val intent = Intent(this, JokeView::class.java)
            startActivity(intent)
        }
    }
}