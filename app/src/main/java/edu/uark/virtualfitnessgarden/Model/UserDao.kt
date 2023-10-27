package edu.uark.virtualfitnessgarden.Model

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao {
    //Get a single user with a given id
    @Query("SELECT * FROM userinfo_table WHERE id=:id" )
    fun getUser(id:Int): Flow<User>

    @Query("SELECT * FROM userinfo_table WHERE id=:id" )
    fun getUserNotLive(id:Int): User

    //Insert a single User
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(user: User)

    // Delete all users
    @Query("DELETE FROM userinfo_table")
    suspend fun deleteAll()

    @Delete
    suspend fun delete(user: User)

    //Update a single task
    @Update
    suspend fun update(user: User):Int
}