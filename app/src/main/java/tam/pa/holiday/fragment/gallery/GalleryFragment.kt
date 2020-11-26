package tam.pa.holiday.fragment.gallery

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.android.synthetic.main.fragment_gallery.*
import tam.pa.holiday.R
import tam.pa.holiday.fragment.gallery.adapter.GalleryAdapter
import tam.pa.holiday.model.gallery.DataGallery

class GalleryFragment : Fragment(), IViewGallery {
    lateinit var iViewGallery: IViewGallery
    lateinit var presenter: GalleryPresenter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_gallery, container, false)
        iViewGallery = this
        presenter = GalleryPresenter(iViewGallery, activity)
        presenter.onGetDataGallery()
        return view
    }

    override fun onGetData(listData: List<DataGallery>?) {
        rvList.setHasFixedSize(true)
        rvList.layoutManager = GridLayoutManager(activity, 3)
        rvList.adapter = activity?.let { GalleryAdapter(it, listData) }
    }

    override fun onFailur(msg: String) {
        Log.d("errorPresenter", msg)
    }
}