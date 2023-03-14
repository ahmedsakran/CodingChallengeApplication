package group.payback.codingchallengeapplication.domain.usecases

import group.payback.codingchallengeapplication.domain.models.Hit
import group.payback.codingchallengeapplication.util.Resource
import kotlinx.coroutines.flow.Flow

interface GetImagesUseCase {
    operator fun invoke(word: String): Flow<Resource<List<Hit>>>
}