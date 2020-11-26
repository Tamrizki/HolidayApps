package tam.pa.holiday.model.response


import com.google.gson.annotations.SerializedName
import tam.pa.holiday.model.profile.DataProfile

data class ProfileResponse(
    @SerializedName("data")
    val data: DataProfile?,
    @SerializedName("message")
    val message: String?,
    @SerializedName("status_code")
    val statusCode: Int?
)