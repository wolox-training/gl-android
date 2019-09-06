package ar.com.wolox.android.example.model

import com.google.gson.annotations.SerializedName
import org.joda.time.DateTime
import org.ocpsoft.prettytime.PrettyTime

data class News(
    val id: Int,
    val userId: Int,
    @SerializedName("createdAt")
    val createdAt: String,
    val title: String,
    val picture: String,
    val text: String,
    val likes: List<Int>
) {
    val readableCreationTime get() = PrettyTime().format(DateTime(createdAt).toDate())!!
}
