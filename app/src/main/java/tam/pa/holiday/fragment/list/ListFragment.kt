package tam.pa.holiday.fragment.list

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.recyclerview.widget.LinearLayoutManager
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
                tvTitle1.text = data.title
                tvContent1.text = data.content
                rvList1!!.setHasFixedSize(true)
                rvList1.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
                if (data.type?.toLowerCase().equals("multiple")){
                    data.media?.let { listImg.addAll(it) }
                    rvList1.adapter = getAdapter(listImg, data)
                    rvList1.animation = AnimationUtils.loadAnimation(activity, R.anim.arrow)
                }else{
                    rvList1.adapter = getSingleAdapter(data)
                }
            }
            else if (data.id == 2){
                tvTitle2.text = data.title
                tvContent2.text = data.content
                rvList2!!.setHasFixedSize(true)
                rvList2.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
                if (data.type?.toLowerCase().equals("multiple")){
                    data.media?.let { listImg.addAll(it) }
                    rvList2.adapter = getAdapter(listImg, data)
                    rvList2.animation = AnimationUtils.loadAnimation(activity, R.anim.arrow)
                }else{
                    rvList2.adapter = getSingleAdapter(data)
                }
            }
            else if (data.id == 3){
                tvTitle3.text = data.title
                tvContent3.text = data.content
                rvList3!!.setHasFixedSize(true)
                rvList3.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
                if (data.type?.toLowerCase().equals("multiple")){
                    data.media?.let { listImg.addAll(it) }
                    rvList3.adapter = getAdapter(listImg, data)
                    rvList3.animation = AnimationUtils.loadAnimation(activity, R.anim.arrow)
                }else{
                    rvList3.adapter = getSingleAdapter(data)
                }
            }
            else if (data.id == 4){
                tvTitle4.text = data.title
                tvContent4.text = data.content
                rvList4!!.setHasFixedSize(true)
                rvList4.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
                if (data.type?.toLowerCase().equals("multiple")){
                    data.media?.let { listImg.addAll(it) }
                    rvList4.adapter = getAdapter(listImg, data)
                    rvList4.animation = AnimationUtils.loadAnimation(activity, R.anim.arrow)
                }else{
                    rvList4.adapter = getSingleAdapter(data)
                }
            }
            else if (data.id == 5){
                tvTitle5.text = data.title
                tvContent5.text = data.content
                rvList5!!.setHasFixedSize(true)
                rvList5.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
                if (data.type?.toLowerCase().equals("multiple")){
                    data.media?.let { listImg.addAll(it) }
                    rvList5.adapter = getAdapter(listImg, data)
                    rvList5.animation = AnimationUtils.loadAnimation(activity, R.anim.arrow)
                }else{
                    rvList5.adapter = getSingleAdapter(data)
                }
            }
        }
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
        Log.d("ERORRPRESENTER", msg)
    }
}