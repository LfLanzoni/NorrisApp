package ar.android.lflanzoni.norrisapp.joke

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import ar.android.lflanzoni.norrisapp.repository.JokesRepository
import ar.android.lflanzoni.norrisapp.Resource
import kotlinx.coroutines.Dispatchers
import org.koin.standalone.KoinComponent
import java.lang.Exception

class JokeViewModel(private val jokesRepository: JokesRepository) : ViewModel(), KoinComponent {

    fun getJokes(selected: String) = liveData(Dispatchers.IO){
        emit(Resource.Loading())
        try{
            emit(Resource.Success(jokesRepository.getJoke(selected)))
        }catch (e: Exception){
            emit(Resource.Failure(e))
        }

    }

    fun getRandomJoke() = liveData(Dispatchers.IO){
        emit(Resource.Loading())
        try{
            emit(Resource.Success(jokesRepository.getRandomJoke()))
        }catch (e: Exception){
            emit(Resource.Failure(e))
        }

    }
}