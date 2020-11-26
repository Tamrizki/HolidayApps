package tam.pa.holiday.model.response


import com.google.gson.annotations.SerializedName
import tam.pa.holiday.model.gallery.DataGallery

data class GalleryResponse(
        @SerializedName("data")
    val data: List<DataGallery>?,
        @SerializedName("message")
    val message: String?,
        @SerializedName("status_code")
    val statusCode: Int?
)