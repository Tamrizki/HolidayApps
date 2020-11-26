package tam.pa.holiday.network

import io.reactivex.Observable
import retrofit2.http.GET
import tam.pa.holiday.model.response.GalleryResponse
import tam.pa.holiday.model.response.ListResponse
import tam.pa.holiday.model.response.ProfileResponse

interface ApiService {
    @GET("place.json")
    fun getListPlace(): Observable<ListResponse>

    @GET("user.json")
    fun getProfile(): Observable<ProfileResponse>

    @GET("gallery.json")
    fun getGallery(): Observable<GalleryResponse>
}