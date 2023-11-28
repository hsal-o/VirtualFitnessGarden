package edu.uark.virtualfitnessgarden

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import edu.uark.virtualfitnessgarden.Model.PlantRepository
import edu.uark.virtualfitnessgarden.Model.PlantUser
import edu.uark.virtualfitnessgarden.Util.GridSpacingItemDecoration

class MainActivity : AppCompatActivity() {

    val user_id: Int = 0


    private val gardenGridAdapterViewModel: GardenGridAdapterViewModel by viewModels{
        GardenGridAdapterViewModelFactory((application as VirtualFitnessGardenApplication).plant_respository, (application as VirtualFitnessGardenApplication).plant_user_repository, user_id)
    }

    private val mainActivityViewModel: MainActivityViewModel by viewModels {
        MainActivityViewModelFactory((application as VirtualFitnessGardenApplication).plant_user_repository, user_id)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_prototype_main)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)

//        val plantList: MutableList<PlantUser> = mutableListOf()
//        plantList.add(PlantUser(0, 0, 0, 0, 0))
//        plantList.add(PlantUser(0, 0, 0, 1, 0))
//        plantList.add(PlantUser(0, 0, 0, 0, 0))
//
//        plantList.add(PlantUser(0, 0, 0, 2, 0))
//        plantList.add(PlantUser(0, 0, 0, 2, 0))
//        plantList.add(PlantUser(0, 0, 0, 1, 0))
//
//        plantList.add(PlantUser(0, 0, 0, 1, 0))
//        plantList.add(PlantUser(0, 0, 0, 1, 0))
//        plantList.add(PlantUser(0, 0, 0, 0, 0))

        //val adapter = GardenGridAdapter(plantList, this, gardenGridAdapterViewModel, user_id)
        val adapter = GardenGridAdapter(this, gardenGridAdapterViewModel, user_id)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = GridLayoutManager(this, 3)
        recyclerView.addItemDecoration(GridSpacingItemDecoration(3, 32, false))

        mainActivityViewModel.allUserPlants.observe(this) { userPlants ->
            // Update the cached copy of the user's plants in the adapter.
            userPlants.let{
                adapter.submitList(it)
            }

        }

    }



}