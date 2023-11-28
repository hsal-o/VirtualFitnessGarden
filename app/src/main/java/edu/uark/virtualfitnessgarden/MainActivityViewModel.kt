package edu.uark.virtualfitnessgarden

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.asLiveData
import edu.uark.virtualfitnessgarden.Model.PlantUser
import edu.uark.virtualfitnessgarden.Model.PlantUserRepository

class MainActivityViewModel(private val repository: PlantUserRepository, private val user_id: Int) : ViewModel() {
    val allUserPlants: LiveData<List<PlantUser>> = repository.getAllPlantUsers(user_id).asLiveData()
}

class MainActivityViewModelFactory(private val repository: PlantUserRepository, private val user_id: Int) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainActivityViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return MainActivityViewModel(repository, user_id) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}