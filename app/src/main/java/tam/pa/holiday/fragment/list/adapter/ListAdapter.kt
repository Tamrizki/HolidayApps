package tam.pa.holiday.fragment.list.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.custom_list.view.*
import tam.pa.holiday.R
import tam.pa.holiday.dialog.DialogDetail
import tam.pa.holiday.model.list.Content

class ListAdapter(val context: FragmentActivity, val list: List<String>, val data: Content): RecyclerView.Adapter<ListAdapter.vHolder>() {
    class vHolder(view: View): RecyclerView.ViewHolder(view) {
        fun bind(get: String) {
            Picasso.get()
                .load(get)
                .fit()
                .into(itemView.ivGambar)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): vHolder {
        return vHolder(LayoutInflater.from(parent.context).inflate(R.layout.custom_list, parent, false)
        )
    }

    override fun onBindViewHolder(holder: vHolder, position: Int) {
        holder.bind(list.get(position))
        holder.itemView.setOnClickListener {
            val dialog = DialogDetail(context, data, null)
            dialog.show()
            val window = dialog.window
            window?.setLayout(
                StaggeredGridLayoutManager.LayoutParams.MATCH_PARENT,
                StaggeredGridLayoutManager.LayoutParams.MATCH_PARENT)
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }
}