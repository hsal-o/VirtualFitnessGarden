package edu.uark.virtualfitnessgarden

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.ProgressBar
import edu.uark.virtualfitnessgarden.Model.PlantUser
import androidx.activity.viewModels

class GardenGridAdapter ( private val plantList: List<PlantUser>, private val context: Context, private val user_id: Int) : BaseAdapter() {

    private val gardenGridAdapterViewModel: GardenGridAdapterViewModel by viewModels{
        GardenGridAdapterViewModelFactory((application as VirtualFitnessGardenApplication).plant_user_repository, user_id)
    }

    private var layoutInflater: LayoutInflater? = null
    private lateinit var progbar_status: ProgressBar
    private lateinit var imageview_plant: ImageView
    override fun getCount(): Int {
        return plantList.size
    }

    override fun getItem(position: Int): Any? {
        return null
    }

    override fun getItemId(p0: Int): Long {
        return 0
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var convertView = convertView

        // Check if layoutinflater is null to initialize it
        if (layoutInflater == null) {
            layoutInflater =
                context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        }
        // Check if convertview is null to initialize it
        if (convertView == null) {
            // Pass layoutfile to inflate with
            convertView = layoutInflater!!.inflate(R.layout.plant_card_item, null)
        }

        // Initialize views
        progbar_status = convertView!!.findViewById(R.id.progbar_status)
        imageview_plant = convertView!!.findViewById(R.id.imageview_plant)

        // Set image for imageview_plant
        imageview_plant.setImageResource(plantList.get(position).image)

        // Set progress for progbar_status
        progbar_status.setProgress(plantList.get(position).status)

        return convertView
    }


}