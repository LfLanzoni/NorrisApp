package ar.android.lflanzoni.norrisapp.joke

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import ar.android.lflanzoni.norrisapp.R
import ar.android.lflanzoni.norrisapp.Resource
import ar.android.lflanzoni.norrisapp.databinding.JokeViewBinding
import org.koin.android.viewmodel.ext.android.viewModel

class JokeView : AppCompatActivity() {

    private lateinit var binding: JokeViewBinding
    private val jokeViewModel: JokeViewModel  by viewModel()
    private lateinit var category: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = JokeViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.imgJoke.setImageResource(R.drawable.ic_norrisicono)

        if (intent.getStringExtra("category") != null) {
            category = intent.getStringExtra("category")
            jokeViewModel.getJokes(category).observe(this,{result ->
                when(result){
                    is Resource.Loading-> {
                        binding.imgJoke.visibility = View.GONE
                        binding.progressBarJoke.visibility = View.VISIBLE
                    }
                    is Resource.Success-> {
                        binding.progressBarJoke.visibility = View.GONE
                        binding.imgJoke.visibility = View.VISIBLE
                        binding.textViewJoke.text = result.data.value
                    }
                    is Resource.Failure->{
                        binding.imgJoke.visibility = View.GONE
                        binding.progressBarJoke.visibility = View.VISIBLE
                        showAlertDialog()
                    }
                }
            })
        }else{
            jokeViewModel.getRandomJoke().observe(this,{result ->
                when(result){
                    is Resource.Loading-> {
                        binding.imgJoke.visibility = View.GONE
                        binding.progressBarJoke.visibility = View.VISIBLE
                    }
                    is Resource.Success-> {
                        binding.progressBarJoke.visibility = View.GONE
                        binding.imgJoke.visibility = View.VISIBLE
                        binding.textViewJoke.text = result.data.value
                    }
                    is Resource.Failure->{
                        binding.imgJoke.visibility = View.GONE
                        binding.progressBarJoke.visibility = View.VISIBLE
                       showAlertDialog()
                    }
                }
            })
        }
    }

    private fun showAlertDialog(){
        val builder: AlertDialog.Builder = let {
            AlertDialog.Builder(it, R.style.MyDialogTheme)
        }
        builder.setMessage(R.string.dialog_message)
                .setTitle(R.string.dialog_title)
                .setPositiveButton(R.string.ok) { _, _ ->
                    finish()
                }
        val dialog: AlertDialog = builder.create()
        dialog.show()
    }

}