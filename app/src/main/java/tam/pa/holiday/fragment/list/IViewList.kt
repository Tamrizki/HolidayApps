package tam.pa.holiday.fragment.list

import tam.pa.holiday.model.list.Data

interface IViewList {
    fun getData(data: Data)
    fun onFail(msg: String)
}