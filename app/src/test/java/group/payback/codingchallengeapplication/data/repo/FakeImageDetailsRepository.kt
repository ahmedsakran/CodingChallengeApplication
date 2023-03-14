package group.payback.codingchallengeapplication.data.repo

import group.payback.codingchallengeapplication.domain.models.Hit
import group.payback.codingchallengeapplication.domain.repositories.ImageDetailsRepository
import group.payback.codingchallengeapplication.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class FakeImageDetailsRepository: ImageDetailsRepository {

    //region prepare fake data and inject to table

    val hitToInsert : Hit = Hit(
        1,
        1,
        2,
        3,
        4,
        5,
        6,
        "path here1 Of Green Search",
        1,
        "url",
        1,
        "",
        1,
        "",
        "",
        "",
        "",
        1,
        2,
        3,
        "",
        1
    )

    //endregion

    override fun getImageDetails(imageID: Int): Flow<Resource<Hit>> {
        return flow { emit(Resource.Success(data = hitToInsert)) }
    }
}