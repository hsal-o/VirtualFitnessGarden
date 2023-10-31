package edu.uark.virtualfitnessgarden.Model

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface PlantDao {
    //Get a single user with a given id
    @Query("SELECT * FROM plantinfo_table WHERE id=:id" )
    fun getPlant(id:Int): Flow<Plant>

    @Query("SELECT * FROM plantinfo_table WHERE id=:id" )
    fun getPlantNotLive(id:Int): Plant

    //Insert a single User
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(plant: Plant)

    // Delete all users
    @Query("DELETE FROM plantinfo_table")
    suspend fun deleteAll()

    @Delete
    suspend fun delete(plant: Plant)

    //Update a single task
    @Update
    suspend fun update(plant: Plant):Int
}