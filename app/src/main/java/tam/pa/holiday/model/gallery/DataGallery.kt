package tam.pa.holiday.model.gallery


import com.google.gson.annotations.SerializedName

data class DataGallery(
    @SerializedName("caption")
    val caption: String?,
    @SerializedName("image")
    val image: String?,
    @SerializedName("thumbnail")
    val thumbnail: String?
)