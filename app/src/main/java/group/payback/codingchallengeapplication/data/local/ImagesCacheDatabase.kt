package group.payback.codingchallengeapplication.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import group.payback.codingchallengeapplication.data.local.dao.HitDao
import group.payback.codingchallengeapplication.data.local.entities.Hit

@Database(
    entities = [
        Hit::class
],
    version = 1,
    exportSchema = true
)
abstract class ImagesCacheDatabase : RoomDatabase() {
    abstract fun hitDao(): HitDao
}