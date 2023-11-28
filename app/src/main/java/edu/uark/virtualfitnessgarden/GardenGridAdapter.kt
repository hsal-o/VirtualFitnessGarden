package edu.uark.virtualfitnessgarden

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ProgressBar
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import edu.uark.virtualfitnessgarden.Model.PlantUser
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class GardenGridAdapter(
    private val context: Context,
    private val gardenGridAdapterViewModel: GardenGridAdapterViewModel,
    private val user_id: Int

) : ListAdapter<PlantUser, GardenGridAdapter.ViewHolder>(PlantUserComparator()) {
//) : RecyclerView.Adapter<GardenGridAdapter.ViewHolder>() {

    // ViewHolder class
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        // Initialize views for the ViewHolder
        val progbarStatus: ProgressBar = itemView.findViewById(R.id.progbar_status)
        val imageviewPlant: ImageView = itemView.findViewById(R.id.imageview_plant)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // Inflate the item layout and create the ViewHolder
        val view = LayoutInflater.from(context).inflate(R.layout.plant_card_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // Bind data to the ViewHolder components
        //val plant = plantList[position]
        val plant = getItem(position)

        CoroutineScope(Dispatchers.Main).launch {
            Log.d("DEBUG", "<<<<<<<<<<<< plant.currentStage: " + plant.currentStage)

            val imageId = when (plant.currentStage){
                1 -> gardenGridAdapterViewModel.getPlantImageStage1(plant.plant_id)
                2 -> gardenGridAdapterViewModel.getPlantImageStage2(plant.plant_id)
                3 -> gardenGridAdapterViewModel.getPlantImageStage3(plant.plant_id)
                else -> R.drawable.img_plant_default_1
            }

            holder.imageviewPlant.setImageResource(imageId)
        }

        // Set progress for progbarStatus
        holder.progbarStatus.progress = plant.status
    }

//    override fun getItemCount(): Int {
//        return plantList.size
//    }

    class PlantUserComparator : DiffUtil.ItemCallback<PlantUser>() {
        override fun areItemsTheSame(oldItem: PlantUser, newItem: PlantUser): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: PlantUser, newItem: PlantUser): Boolean {
            return oldItem.id == newItem.id
        }
    }
}
