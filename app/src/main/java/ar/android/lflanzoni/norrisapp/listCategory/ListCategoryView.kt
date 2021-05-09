package ar.android.lflanzoni.norrisapp.listCategory

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import ar.android.lflanzoni.norrisapp.R
import ar.android.lflanzoni.norrisapp.Resource
import ar.android.lflanzoni.norrisapp.adapters.RvAdapter
import ar.android.lflanzoni.norrisapp.databinding.ListCategoryViewBinding
import ar.android.lflanzoni.norrisapp.joke.JokeView
import org.koin.android.viewmodel.ext.android.viewModel

class ListCategoryView: AppCompatActivity(),RvAdapter.OnCategoryClickListener{

    private lateinit var  binding: ListCategoryViewBinding
    private val categoryViewModel: CategoryViewModel by viewModel()
    private lateinit var adapter: RvAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ListCategoryViewBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.rvCategories.layoutManager=LinearLayoutManager(this)

        categoryViewModel.getCategories().observe(this, { result ->
            when (result) {
                is Resource.Loading -> {
                    binding.progressBarCategory.visibility = View.VISIBLE
                }
                is Resource.Success -> {
                    binding.progressBarCategory.visibility = View.GONE
                    adapter = RvAdapter(ArrayList(result.data), this)
                    binding.rvCategories.adapter = adapter
                }
                is Resource.Failure -> {
                    binding.progressBarCategory.visibility = View.VISIBLE
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

        })
    }

    override fun onCategoryClick(category: String) {
        val i = Intent(this, JokeView::class.java)
        i.putExtra("category", category)
        startActivity(i)
    }
}