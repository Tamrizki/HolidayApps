package tam.pa.holiday.fragment.gallery

import tam.pa.holiday.model.gallery.DataGallery

interface IViewGallery {
    fun onGetData(listData: List<DataGallery>?)
    fun onFailur(msg: String)
}