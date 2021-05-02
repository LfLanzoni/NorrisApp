package ar.android.lflanzoni.norrisapp

import ar.android.lflanzoni.norrisapp.network.NorrisApi
import ar.android.lflanzoni.norrisapp.repository.JokesRepository
import org.koin.android.viewmodel.ext.koin.viewModel
import ar.android.lflanzoni.norrisapp.joke.JokeViewModel
import ar.android.lflanzoni.norrisapp.listCategory.CategoryViewModel
import org.koin.dsl.module.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainModule {

    val mainModule = module {

        single { JokesRepository(get()) }

        single { createWebService() }

        viewModel { JokeViewModel(get()) }

        viewModel { CategoryViewModel(get()) }

    }

    fun createWebService(): NorrisApi {
        val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://api.chucknorris.io/jokes/")
                .build()

        return retrofit.create(NorrisApi::class.java)
    }
}