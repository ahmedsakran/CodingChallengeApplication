package group.payback.codingchallengeapplication.data.local.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import group.payback.codingchallengeapplication.data.local.base.BaseDao
import group.payback.codingchallengeapplication.data.local.entities.Hit


@Dao
interface HitDao : BaseDao<Hit> {

    @Query("SELECT * FROM Hit WHERE id = :imageID LIMIT 1")
    fun getImageDetailsByID(imageID: Int): Hit

    @Query("SELECT * FROM Hit ")
    fun getAllHits(): List<Hit>

    @Query("SELECT * FROM Hit where wordQuery LIKE '%' || :word || '%'")
    fun getHitsByKeyword(word: String): List<Hit>


}