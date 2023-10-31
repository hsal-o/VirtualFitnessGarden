package edu.uark.virtualfitnessgarden.Model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "plantinfo_table")
class Plant (
    @PrimaryKey(autoGenerate = true) val id: Int?,

    )