package tam.pa.holiday.dialog

import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.Window
import androidx.fragment.app.FragmentActivity
import com.squareup.picasso.Picasso
import com.synnapps.carouselview.ImageListener
import kotlinx.android.synthetic.main.custom_dialog_detail.*
import tam.pa.holiday.R
import tam.pa.holiday.model.gallery.DataGallery
import tam.pa.holiday.model.list.Content

class DialogDetail(val ctx: FragmentActivity, dataList: Content?, dataGallery: DataGallery?): Dialog(ctx) {
    var list: MutableList<String> = ArrayList<String>()
    var imageListener: ImageListener = ImageListener { position, imageView ->
        Picasso.get().load(list[position]).into(imageView)
    }
    init {
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        setContentView(R.layout.custom_dialog_detail)
        if (dataList!=null){
            tvTitle.text = dataList.title
            tvContent.text = dataList.content
            list.addAll(setListDetail(dataList))
        }else{
            tvTitle.text = dataGallery?.caption
            list.add(dataGallery?.image!!)
        }
        carouselImg.setImageListener(imageListener)
        carouselImg.pageCount = list.size
        btnClose.setOnClickListener { dismiss() }
    }

    private fun setListDetail(dataList: Content): MutableList<String> {
        var listTamp: MutableList<String> = ArrayList<String>()
        if (dataList.type.toString().equals("image")){
            listTamp.add(dataList.image!!)
        }else{
            listTamp.addAll(dataList.media!!)
        }
        return listTamp
    }



}