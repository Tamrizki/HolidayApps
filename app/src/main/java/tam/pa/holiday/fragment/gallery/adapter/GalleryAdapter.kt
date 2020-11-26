package tam.pa.holiday.fragment.gallery.adapter

import android.app.ActionBar
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.squareup.picasso.Picasso
import tam.pa.holiday.model.gallery.DataGallery
import kotlinx.android.synthetic.main.custom_list.view.ivGambar
import tam.pa.holiday.R
import tam.pa.holiday.dialog.DialogDetail

class GalleryAdapter(val context: FragmentActivity, val listImg: List<DataGallery>?): RecyclerView.Adapter<GalleryAdapter.vHolder>() {
    class vHolder(view: View): RecyclerView.ViewHolder(view) {
        fun bind(get: DataGallery) {
            Picasso.get()
                    .load(get.thumbnail)
                    .fit()
                    .into(itemView.ivGambar)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): vHolder {
        return vHolder(LayoutInflater.from(parent.context).inflate(R.layout.custom_gallery, parent, false))
    }

    override fun onBindViewHolder(holder: vHolder, position: Int) {
        holder.bind(listImg!!.get(position))
        holder.itemView.setOnClickListener {
            val dialog = DialogDetail(context, null, listImg.get(position))
            dialog.show()
            val window = dialog.window
            window?.setLayout(StaggeredGridLayoutManager.LayoutParams.MATCH_PARENT,
                StaggeredGridLayoutManager.LayoutParams.MATCH_PARENT)

        }
    }

    override fun getItemCount(): Int {
        return listImg!!.size
    }
}