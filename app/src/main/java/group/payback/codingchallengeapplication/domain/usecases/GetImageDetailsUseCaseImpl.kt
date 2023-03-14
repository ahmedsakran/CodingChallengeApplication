package group.payback.codingchallengeapplication.domain.usecases

import group.payback.codingchallengeapplication.domain.repositories.ImageDetailsRepository
import javax.inject.Inject

class GetImageDetailsUseCaseImpl @Inject constructor(
    private val repository: ImageDetailsRepository,
) : GetImageDetailsUseCase {
    override operator fun invoke(imageID: Int) = repository.getImageDetails(imageID)
}