package ar.android.lflanzoni.norrisapp.listCategory

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import ar.android.lflanzoni.norrisapp.adapters.RvAdapter
import ar.android.lflanzoni.norrisapp.Resource
import ar.android.lflanzoni.norrisapp.databinding.ListCategoryViewBinding
import ar.android.lflanzoni.norrisapp.joke.JokeView
import org.koin.android.viewmodel.ext.android.viewModel
import kotlin.collections.ArrayList

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
                    adapter = RvAdapter( ArrayList(result.data),this)
                    binding.rvCategories.adapter = adapter
                }
                is Resource.Failure -> {
                    binding.progressBarCategory.visibility = View.VISIBLE
                    Toast.makeText(this,result.exception.message, Toast.LENGTH_SHORT).show()
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