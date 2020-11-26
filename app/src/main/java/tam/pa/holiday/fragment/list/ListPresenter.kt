package tam.pa.holiday.fragment.list

import android.content.Context
import androidx.fragment.app.FragmentActivity
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers
import tam.pa.holiday.helper.LoadingHelper
import tam.pa.holiday.model.response.ListResponse
import tam.pa.holiday.network.ApiClient

class ListPresenter(val iView: IViewList, context: Context?){
    val loading = LoadingHelper(context)
    fun onGetListData(){
        loading.onStart()
        val apiClient = ApiClient
        val disposable = CompositeDisposable()
        disposable.add(
            apiClient.getData().getListPlace()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableObserver<ListResponse>() {
                    override fun onNext(t: ListResponse) {
                        iView.getData(t.data)
                    }

                    override fun onError(e: Throwable) {
                        iView.onFail(e.message.toString())
                        loading.onStop()
                    }

                    override fun onComplete() {
                        loading.onStop()
                    }
                })
        )
    }
}