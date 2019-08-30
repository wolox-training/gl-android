package ar.com.wolox.android.example.ui.home

class HomeItem(
    private val mImageResource: Int,
    private val mTitleResource: String,
    private val mTextInformationResource: String,
    private val mTimeResource: String,
    private val mEmotionImage: Int
) {

    fun getImageResource(): Int {
        return mImageResource
    }

    fun getTitleResource(): String {
        return mTitleResource
    }

    fun getTextInformationResource(): String {
        return mTextInformationResource
    }

    fun getTimeResource(): String {
        return mTimeResource
    }

    fun getEmotionImage(): Int {
        return mEmotionImage
    }
}