package edu.uark.virtualfitnessgarden.Model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "userinfo_table")
class User (
    @PrimaryKey(autoGenerate = true) val id: Int?,
    @ColumnInfo(name = "userName") var userName: String
)