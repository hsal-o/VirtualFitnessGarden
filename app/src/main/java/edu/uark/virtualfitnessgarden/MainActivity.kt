package edu.uark.virtualfitnessgarden

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels

class MainActivity : AppCompatActivity() {

    val user_id: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_prototype_main)
    }

    private val gardenGridAdapterViewModel: GardenGridAdapterViewModel by viewModels {
        GardenGridViewModelFactory((application as VirtualFitnessGardenApplication).plant_user_repository, user_id)
    }
}