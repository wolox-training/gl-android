package ar.com.wolox.android.example.ui.home

import android.content.Intent
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ar.com.wolox.android.R
import ar.com.wolox.wolmo.core.fragment.WolmoFragment
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_home_recycler_item.*

class HomeFragment : WolmoFragment<HomePresenter>(), HomeView {

    // val vHomeListItems: ArrayList<HomeItem>
    val vHomeListItems = arrayListOf<HomeItem>()
    private var vRecyclerViewList: RecyclerView? = null
    private var vAdapter: HomeAdapter? = null
    private var vLayoutManager: RecyclerView.LayoutManager? = null

    override fun layout(): Int {
        return R.layout.fragment_home
    }

    override fun init() {
        createHomeListItems()
        buildRecyclerView()
    }

    fun createHomeListItems() {
        vHomeListItems.add(HomeItem(R.drawable.ic_like_off, "Titulo1", "Texto1", "Tiempo1", R.drawable.ic_like_off))
        vHomeListItems.add(HomeItem(R.drawable.ic_like_on, "Titulo2", "Texto2", "Tiempo2", R.drawable.ic_like_on))
        vHomeListItems.add(HomeItem(R.drawable.ic_like_off, "Titulo3", "Texto3", "Tiempo3", R.drawable.ic_like_off))
        vHomeListItems.add(HomeItem(R.drawable.ic_like_on, "Titulo4", "Texto4", "Tiempo4", R.drawable.ic_like_on))
        vHomeListItems.add(HomeItem(R.drawable.ic_like_off, "Titulo5", "Texto5", "Tiempo5", R.drawable.ic_like_off))
        vHomeListItems.add(HomeItem(R.drawable.ic_like_on, "Titulo6", "Texto6", "Tiempo6", R.drawable.ic_like_on))
        vHomeListItems.add(HomeItem(R.drawable.ic_like_off, "Titulo7", "Texto7", "Tiempo7", R.drawable.ic_like_off))
        vHomeListItems.add(HomeItem(R.drawable.ic_like_on, "Titulo8", "Texto8", "Tiempo8", R.drawable.ic_like_on))
        vHomeListItems.add(HomeItem(R.drawable.ic_like_off, "Titulo9", "Texto9", "Tiempo9", R.drawable.ic_like_off))
        vHomeListItems.add(HomeItem(R.drawable.ic_like_on, "Titulo10", "Texto10", "Tiempo10", R.drawable.ic_like_on))
        vHomeListItems.add(HomeItem(R.drawable.ic_like_off, "Titulo11", "Texto11", "Tiempo11", R.drawable.ic_like_off))
        vHomeListItems.add(HomeItem(R.drawable.ic_like_on, "Titulo12", "Texto12", "Tiempo12", R.drawable.ic_like_on))
        vHomeListItems.add(HomeItem(R.drawable.ic_like_off, "Titulo13", "Texto13", "Tiempo13", R.drawable.ic_like_off))
        vHomeListItems.add(HomeItem(R.drawable.ic_like_on, "Titulo14", "Texto14", "Tiempo14", R.drawable.ic_like_on))
        vHomeListItems.add(HomeItem(R.drawable.ic_like_off, "Titulo15", "Texto15", "Tiempo15", R.drawable.ic_like_off))
        vHomeListItems.add(HomeItem(R.drawable.ic_like_on, "Titulo16", "Texto16", "Tiempo16", R.drawable.ic_like_on))
    }

    fun buildRecyclerView() {
        vRecyclerViewList = vHomeRecyclerView
        vRecyclerViewList!!.setHasFixedSize(true)
        vLayoutManager = LinearLayoutManager(requireContext())

        vAdapter = vHomeListItems?.let {
            HomeAdapter(it, object : ClickListener {
            override fun onClick(view: View, position: Int) {
                Toast.makeText(requireContext(), vHomeListItems[position].getTitleResource(), Toast.LENGTH_SHORT).show()
            }
        })
        }
        vRecyclerViewList?.layoutManager = vLayoutManager
        vRecyclerViewList?.adapter = vAdapter
    }

    override fun setListeners() {
        vItemImage
        vTitleView
        vTextInformation
        vTextTime
        vEmotionImage
    }

    override fun onBackPressed(): Boolean {
        val intent = Intent(Intent.ACTION_MAIN)
        intent.addCategory(Intent.CATEGORY_HOME)
        startActivity(intent)
        return true
    }
}
