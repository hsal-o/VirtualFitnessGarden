package edu.uark.virtualfitnessgarden

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.asLiveData
import edu.uark.virtualfitnessgarden.Model.PlantRepository
import edu.uark.virtualfitnessgarden.Model.PlantUser
import edu.uark.virtualfitnessgarden.Model.PlantUserRepository
import kotlinx.coroutines.withContext

class GardenGridAdapterViewModel(private val plantRepository: PlantRepository, private val plantUserRepository: PlantUserRepository, private val user_id: Int) : ViewModel() {

    val allUserPlants: LiveData<List<PlantUser>> = plantUserRepository.getAllPlantUsers(user_id).asLiveData()

    suspend fun getPlantImageStage1(plant_id: Int): Int {
        return plantRepository.getPlantImageStage1(plant_id)
    }

    suspend fun getPlantImageStage2(plant_id: Int): Int {
        return plantRepository.getPlantImageStage2(plant_id)
    }

    suspend fun getPlantImageStage3(plant_id: Int): Int {
        return plantRepository.getPlantImageStage3(plant_id)
    }

}

class GardenGridAdapterViewModelFactory(private val plantRepository: PlantRepository, private val plantUserRepository: PlantUserRepository, private val user_id:Int) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(GardenGridAdapterViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return GardenGridAdapterViewModel(plantRepository, plantUserRepository, user_id) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}