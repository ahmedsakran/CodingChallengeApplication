package group.payback.codingchallengeapplication.data.repo

import group.payback.codingchallengeapplication.R
import group.payback.codingchallengeapplication.data.local.LocalDataSource
import group.payback.codingchallengeapplication.data.local.toHitFromLocalToDomain
import group.payback.codingchallengeapplication.domain.models.Hit
import group.payback.codingchallengeapplication.domain.repositories.ImageDetailsRepository
import group.payback.codingchallengeapplication.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOException
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ImageDetailsRepositoryImpl @Inject constructor(
    private val localDataSource: LocalDataSource,
) : ImageDetailsRepository {

    override fun getImageDetails(imageID: Int): Flow<Resource<Hit>> = flow {
        emit(Resource.Loading())
        val getImageDetailsByIDFromDAO =
            localDataSource.getImageDetailsFromDAO(imageID).toHitFromLocalToDomain()
        try {
            emit(Resource.Success(data = getImageDetailsByIDFromDAO))
        } catch (e: IOException) {
            emit(
                Resource.Error(
                    message = R.string.msgError.toString(),
                    data = getImageDetailsByIDFromDAO
                )
            )
        }

    }

}