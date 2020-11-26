package tam.pa.holiday.fragment.list

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import tam.pa.holiday.R
import tam.pa.holiday.fragment.list.adapter.SingleListAdapter
import tam.pa.holiday.model.list.Content
import tam.pa.holiday.model.list.Data
import kotlinx.android.synthetic.main.fragment_list.*
import tam.pa.holiday.fragment.list.adapter.ListAdapter

class ListFragment : Fragment(), IViewList {
    lateinit var iViewList: IViewList
    lateinit var listPresenter: ListPresenter
    lateinit var listContent: List<Content>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_list, container, false)
        iViewList = this
        listPresenter = ListPresenter(iViewList, activity)
        listPresenter.onGetListData()
        return view
    }

    override fun getData(data: Data) {
        listContent = data.content
        var listImg: MutableList<String> = ArrayList<String>()

        for (i in 0..listContent.size-1){
            Log.d("idx", i.toString())
            listImg.clear()
            var data: Content = listContent.get(i)

            if (data.id == 1){
                if (data.type?.toLowerCase().equals("multiple")){
                    setList(data, tvTitle1, tvContent1, rvList1)
                }else{
                    setSingleList(data, tvTitle1, tvContent1, rvList1)
                }
            }
            else if (data.id == 2){
                if (data.type?.toLowerCase().equals("multiple")){
                    setList(data, tvTitle2, tvContent2, rvList2)
                }else{
                    setSingleList(data, tvTitle2, tvContent2, rvList2)
                }
            }
            else if (data.id == 3){
                if (data.type?.toLowerCase().equals("multiple")){
                    setList(data, tvTitle3, tvContent3, rvList3)
                }else{
                    setSingleList(data, tvTitle3, tvContent3, rvList3)
                }
            }
            else if (data.id == 4){
                if (data.type?.toLowerCase().equals("multiple")){
                    setList(data, tvTitle4, tvContent4, rvList4)
                }else{
                    setSingleList(data, tvTitle4, tvContent4, rvList4)
                }
            }
            else if (data.id == 5){
                if (data.type?.toLowerCase().equals("multiple")){
                    setList(data, tvTitle5, tvContent5, rvList5)
                }else{
                    setSingleList(data, tvTitle5, tvContent5, rvList5)
                }
            }
        }
    }

    private fun setSingleList(
        data_: Content,
        tvTitle_: TextView?,
        tvContent_: TextView?,
        rvList_: RecyclerView?
    ) {
        tvTitle_!!.text = data_.title
        tvContent_!!.text = data_.content
        rvList_!!.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        rvList_!!.adapter = getSingleAdapter(data_)
    }

    private fun setList(
        data_: Content,
        tvTitle_: TextView?,
        tvContent_: TextView?,
        rvList_: RecyclerView?
    ) {
        var listImg_cp: MutableList<String> = ArrayList<String>()
        data_!!.media?.let { listImg_cp.addAll(it) }
        tvTitle_!!.text = data_.title
        tvContent_!!.text = data_.content
        rvList_?.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        rvList_!!.adapter = getAdapter(listImg_cp, data_)
        rvList_!!.animation = AnimationUtils.loadAnimation(activity, R.anim.arrow)
    }

    private fun getSingleAdapter(data: Content): SingleListAdapter {
        var listData: MutableList<Content> = ArrayList<Content>()
        listData.add(data)
        var adapter = activity?.let { SingleListAdapter(it, listData) }
        return adapter!!
    }

    private fun getAdapter(listImg: MutableList<String>, data: Content): ListAdapter {
        var adapter = activity?.let { ListAdapter(it, listImg, data) }
        return adapter!!
    }

    override fun onFail(msg: String) {
        Log.d("errorPresenter", msg)
    }
}