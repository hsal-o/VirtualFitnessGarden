package edu.uark.virtualfitnessgarden

import android.app.Application
import edu.uark.virtualfitnessgarden.Model.PlantRepository
import edu.uark.virtualfitnessgarden.Model.PlantRoomDatabase
import edu.uark.virtualfitnessgarden.Model.PlantUserRepository
import edu.uark.virtualfitnessgarden.Model.PlantUserRoomDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob

class VirtualFitnessGardenApplication : Application() {
    // Using by lazy so the database and the repository are only created when they're needed
    // rather than when the application starts
    val applicationScope = CoroutineScope(SupervisorJob())

    val plant_user_database by lazy { PlantUserRoomDatabase.getDatabase(this,applicationScope) }
    val plant_user_repository by lazy { PlantUserRepository(plant_user_database.plantUserDao()) }

    val plant_database by lazy { PlantRoomDatabase.getDatabase(this,applicationScope) }
    val plant_respository by lazy { PlantRepository(plant_database.plantDao())}
}