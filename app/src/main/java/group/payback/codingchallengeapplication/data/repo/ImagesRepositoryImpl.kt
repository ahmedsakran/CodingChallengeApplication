package group.payback.codingchallengeapplication.data.repo

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.asLiveData
import group.payback.codingchallengeapplication.data.local.LocalDataSource
import group.payback.codingchallengeapplication.data.local.toHitFromLocalToDomain
import group.payback.codingchallengeapplication.data.remote.RemoteDataSource
import group.payback.codingchallengeapplication.data.remote.dto.HitDTO
import group.payback.codingchallengeapplication.data.remote.toHitFromRemoteToDomain
import group.payback.codingchallengeapplication.data.remote.toHitFromRemoteToLocal
import group.payback.codingchallengeapplication.domain.models.Hit
import group.payback.codingchallengeapplication.domain.repositories.ImagesRepository
import group.payback.codingchallengeapplication.util.HasInternetConnection
import group.payback.codingchallengeapplication.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.flow
import retrofit2.Response
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ImagesRepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
) : ImagesRepository {

    @Inject
    lateinit var networkUtils: HasInternetConnection

    override fun getImages(word: String): Flow<Resource<List<Hit>>> = flow {
        if (networkUtils.isInternetAvailable()){
            try {
                val requestImagesFromAPI = getImagesFromAPI(word)
                insertHitsToDAO(word,requestImagesFromAPI)
                emit(Resource.Success(requestImagesFromAPI.map {it.toHitFromRemoteToDomain()}))
            }catch (e:Exception){
                emit(Resource.Success(getHitsByKeyword(word)))
            }

        }else{
            emit(Resource.Success(getHitsByKeyword(word)))
        }
    }

    private suspend fun getHitsByKeyword(word: String): List<Hit> {
        return localDataSource.getHitsByKeyword(word).map{
            it.toHitFromLocalToDomain()
        }
    }

    private suspend fun getImagesFromAPI(word: String): List<HitDTO> {
       return remoteDataSource.getImagesFromAPI(word).hits
    }

    private suspend fun insertHitsToDAO(word: String,hits:List<HitDTO>) {
        localDataSource.insertHitsToDAO(hits.map { it.toHitFromRemoteToLocal(word) })
    }

}