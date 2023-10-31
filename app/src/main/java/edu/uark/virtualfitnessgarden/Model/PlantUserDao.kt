package edu.uark.virtualfitnessgarden.Model

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface PlantUserDao {
    //Get a single user with a given id
    @Query("SELECT * FROM plantUserinfo_table WHERE id=:id" )
    fun getPlantUser(id:Int): Flow<PlantUser>

    @Query("SELECT * FROM plantUserinfo_table WHERE id=:id" )
    fun getPlantUserNotLive(id:Int): PlantUser

    //Insert a single User
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(plantUser: PlantUser)

    // Delete all users
    @Query("DELETE FROM plantUserinfo_table")
    suspend fun deleteAll()

    @Delete
    suspend fun delete(plantUser: PlantUser)

    @Update
    suspend fun update(plantUser: PlantUser):Int
}