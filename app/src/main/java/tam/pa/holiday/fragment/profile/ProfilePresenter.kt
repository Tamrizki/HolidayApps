package tam.pa.holiday.fragment.profile

import androidx.fragment.app.FragmentActivity
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers
import tam.pa.holiday.helper.LoadingHelper
import tam.pa.holiday.model.response.ProfileResponse
import tam.pa.holiday.network.ApiClient

class ProfilePresenter(val iViewProfile: IViewProfile, context: FragmentActivity?){
    val loadingHelper = LoadingHelper(context)

    fun onGetProfile(){
        loadingHelper.onStart()
        val apiClient = ApiClient
        val disposable = CompositeDisposable()
        disposable.add(
            apiClient.getData().getProfile()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableObserver<ProfileResponse>(){
                    override fun onNext(t: ProfileResponse) {
                        iViewProfile.onGetData(t.data)
                    }

                    override fun onError(e: Throwable) {
                        iViewProfile.onFailur(e.message.toString())
                        loadingHelper.onStop()
                    }

                    override fun onComplete() {
                        loadingHelper.onStop()
                    }
                })
        )
    }
}