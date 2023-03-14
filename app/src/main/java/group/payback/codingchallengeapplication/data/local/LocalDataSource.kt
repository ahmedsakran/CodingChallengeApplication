package group.payback.codingchallengeapplication.data.local

import group.payback.codingchallengeapplication.data.local.dao.HitDao
import group.payback.codingchallengeapplication.data.local.entities.Hit
import javax.inject.Inject

class LocalDataSource @Inject constructor(
    private val hitDao: HitDao
) {
    suspend fun insertHitsToDAO(newObj: List<Hit>) {
        hitDao.insertList(newObj)
    }


    suspend fun getAllHits() {
        hitDao.getAllHits()
    }

    suspend fun getHitsByKeyword(word: String): List<Hit> {
        return hitDao.getHitsByKeyword(word)
    }




    fun getImageDetailsFromDAO(imageID: Int): Hit = hitDao.getImageDetailsByID(imageID)

}