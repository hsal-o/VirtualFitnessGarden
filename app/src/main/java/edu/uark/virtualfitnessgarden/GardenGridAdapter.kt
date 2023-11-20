package edu.uark.virtualfitnessgarden

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ProgressBar
import androidx.recyclerview.widget.RecyclerView
import edu.uark.virtualfitnessgarden.Model.PlantUser

class GardenGridAdapter(
    private val plantList: List<PlantUser>,
    private val context: Context,
    private val user_id: Int
) : RecyclerView.Adapter<GardenGridAdapter.ViewHolder>() {

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
        val plant = plantList[position]

        // Set image for imageviewPlant
        // holder.imageviewPlant.setImageResource(plant.image)

        // Set progress for progbarStatus
        holder.progbarStatus.progress = plant.status
    }

    override fun getItemCount(): Int {
        return plantList.size
    }
}
