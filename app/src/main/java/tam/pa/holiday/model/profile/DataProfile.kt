package tam.pa.holiday.model.profile

import com.google.gson.annotations.SerializedName


data class DataProfile(
    @SerializedName("avatar")
    val avatar: String?,
    @SerializedName("email")
    val email: String?,
    @SerializedName("fullname")
    val fullname: String?,
    @SerializedName("id")
    val id: Int?,
    @SerializedName("phone")
    val phone: String?,
    @SerializedName("username")
    val username: String?
)