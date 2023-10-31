package edu.uark.virtualfitnessgarden.Model

import android.content.Context
import android.util.Log
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Database(entities = arrayOf(Plant::class), version = 1, exportSchema = false)
abstract class PlantRoomDatabase : RoomDatabase() {

    abstract fun plantDao(): PlantDao

    private class TaskDatabaseCallback(
        private val scope: CoroutineScope
    ) : RoomDatabase.Callback() {

        override fun onCreate(db: SupportSQLiteDatabase) {
            super.onCreate(db)
            Log.d("Database", "Here1")

            INSTANCE?.let { database ->
                scope.launch {
                    val plantDao = database.plantDao()

                    // Delete all content here.
                    plantDao.deleteAll()

                    var plant = Plant(null)
                    plantDao.insert(plant)
                }
            }
        }
    }

    companion object {
        @Volatile
        private var INSTANCE: PlantRoomDatabase? = null

        fun getDatabase(
            context: Context,
            scope: CoroutineScope
        ): PlantRoomDatabase {
            // if the INSTANCE is not null, then return it,
            // if it is, then create the database
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    PlantRoomDatabase::class.java,
                    "plantinfo_table"
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
