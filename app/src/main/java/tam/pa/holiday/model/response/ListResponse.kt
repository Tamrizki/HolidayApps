package tam.pa.holiday.model.response

import com.google.gson.annotations.SerializedName
import tam.pa.holiday.model.list.Data

data class ListResponse(
    @SerializedName("data") val data: Data,
    @SerializedName("message") val message: String,
    @SerializedName("status_code") val status_code: Int
)