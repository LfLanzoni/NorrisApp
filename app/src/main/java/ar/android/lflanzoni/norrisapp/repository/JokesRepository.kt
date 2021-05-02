package ar.android.lflanzoni.norrisapp.repository

import ar.android.lflanzoni.norrisapp.network.NorrisApi

class JokesRepository(private val norrisApi: NorrisApi) {

    suspend fun getCategories()= norrisApi.getCategories()
    suspend fun getJoke(category: String) = norrisApi.getSelectJoke(category)
    suspend fun getRandomJoke() = norrisApi.getRandomJokes()
}




