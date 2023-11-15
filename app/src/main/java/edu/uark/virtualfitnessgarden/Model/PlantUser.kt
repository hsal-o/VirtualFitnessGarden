package edu.uark.virtualfitnessgarden.Model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "plantUserinfo_table")
class PlantUser (
    @PrimaryKey(autoGenerate = true) val plant_id: Int,
    @PrimaryKey(autoGenerate = false) var user_id: Int,
    @PrimaryKey(autoGenerate = true) var id: Int,
    @ColumnInfo(name = "status") var status: Int, // status of plant, 0: bad, 1: okay, 2: good
    @ColumnInfo(name = "currentStage") val currentStage: Int // current growth stage of plant from 0 - 2


)