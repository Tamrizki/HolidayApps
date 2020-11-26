package tam.pa.holiday.fragment.profile

import tam.pa.holiday.model.profile.DataProfile

interface IViewProfile {
    fun onGetData(data: DataProfile?)
    fun onFailur(msg: String)
}