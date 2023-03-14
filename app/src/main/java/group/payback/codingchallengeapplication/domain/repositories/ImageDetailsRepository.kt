package group.payback.codingchallengeapplication.domain.repositories

import group.payback.codingchallengeapplication.domain.models.Hit
import group.payback.codingchallengeapplication.util.Resource
import kotlinx.coroutines.flow.Flow

interface ImageDetailsRepository {
    fun getImageDetails(imageID: Int): Flow<Resource<Hit>>
}