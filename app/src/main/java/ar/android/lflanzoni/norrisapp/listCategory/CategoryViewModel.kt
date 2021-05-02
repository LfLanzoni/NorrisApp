package ar.android.lflanzoni.norrisapp.listCategory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import ar.android.lflanzoni.norrisapp.repository.JokesRepository
import ar.android.lflanzoni.norrisapp.Resource
import kotlinx.coroutines.Dispatchers
import org.koin.standalone.KoinComponent

class CategoryViewModel(private val jokesRepository: JokesRepository) : ViewModel(), KoinComponent {

    fun getCategories() = liveData(Dispatchers.IO){
        emit(Resource.Loading())
        try{
            emit(Resource.Success(jokesRepository.getCategories()))
        }catch (e: Exception){
            emit(Resource.Failure(e))
        }
    }
}