package tam.pa.holiday.fragment.gallery

import androidx.fragment.app.FragmentActivity
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers
import tam.pa.holiday.helper.LoadingHelper
import tam.pa.holiday.model.response.GalleryResponse
import tam.pa.holiday.network.ApiClient

class GalleryPresenter(val iViewGallery: IViewGallery, context: FragmentActivity?) {
    val loadingHelper = LoadingHelper(context)
    fun onGetDataGallery(){
        loadingHelper.onStart()
        val apiClient = ApiClient
        val disposable = CompositeDisposable()
        disposable.add(
                apiClient.getData().getGallery()
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribeWith(object : DisposableObserver<GalleryResponse>(){
                            override fun onNext(t: GalleryResponse) {
                                iViewGallery.onGetData(t.data)
                            }
                            override fun onError(e: Throwable) {
                                iViewGallery.onFailur(e.message.toString())
                                loadingHelper.onStop()
                            }
                            override fun onComplete() {
                                loadingHelper.onStop()
                            }
                        })
        )
    }
}