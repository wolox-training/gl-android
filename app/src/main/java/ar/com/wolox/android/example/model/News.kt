package ar.com.wolox.android.example.model

import com.google.gson.annotations.SerializedName
import org.joda.time.DateTime
import org.ocpsoft.prettytime.PrettyTime

data class News(
    @SerializedName("id") val id: Int,
    @SerializedName("userId") val userId: Int,
    @SerializedName("createdAt") val createdAt: String,
    @SerializedName("title") val title: String,
    @SerializedName("picture") val picture: String,
    @SerializedName("text") val text: String,
    @SerializedName("likes") val likes: List<Int>
) {
    val readableCreationTime get() = PrettyTime().format(DateTime(createdAt).toDate())!!

    val formatPicture get() = picture.replace("http://", "https://")
}
