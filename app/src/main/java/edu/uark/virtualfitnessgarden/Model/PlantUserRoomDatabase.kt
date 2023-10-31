package edu.uark.virtualfitnessgarden.Model

import android.content.Context
import android.util.Log
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Database(entities = arrayOf(PlantUser::class), version = 1, exportSchema = false)
abstract class PlantUserRoomDatabase : RoomDatabase() {

    abstract fun plantUserDao(): PlantUserDao

    private class TaskDatabaseCallback(
        private val scope: CoroutineScope
    ) : RoomDatabase.Callback() {

        override fun onCreate(db: SupportSQLiteDatabase) {
            super.onCreate(db)
            Log.d("Database", "Here1")

            INSTANCE?.let { database ->
                scope.launch {
                    val plantUserDao = database.plantUserDao()

                    // Delete all content here.
                    plantUserDao.deleteAll()

                    var plantUser = PlantUser(0, 0, 0)
                    plantUserDao.insert(plantUser)
                }
            }
        }
    }

    companion object {
        @Volatile
        private var INSTANCE: PlantUserRoomDatabase? = null

        fun getDatabase(
            context: Context,
            scope: CoroutineScope
        ): PlantUserRoomDatabase {
            // if the INSTANCE is not null, then return it,
            // if it is, then create the database
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    PlantUserRoomDatabase::class.java,
                    "plantUserinfo_table"
                )
                    .addCallback(TaskDatabaseCallback(scope))
                    .build()
                INSTANCE = instance
                // return instance
                instance
            }
        }
    }
}
