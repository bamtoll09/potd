package jo.sangmyung.kr.put_on_this_dress.activity

import android.app.SearchManager
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v4.view.MenuItemCompat
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.SearchView
import android.support.v7.widget.Toolbar
import android.transition.TransitionManager
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ListView
import jo.sangmyung.kr.put_on_this_dress.R
import jo.sangmyung.kr.put_on_this_dress.adapter.ShopItemAdapter
import jo.sangmyung.kr.put_on_this_dress.item.ShopItem
import jo.sangmyung.kr.put_on_this_dress.retrofit.APIInterface
import jo.sangmyung.kr.put_on_this_dress.retrofit.APIUtils
import jo.sangmyung.kr.put_on_this_dress.retrofit.ShopResource
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

class ConsumerActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private lateinit var imageTodayStyle: ImageView
    private lateinit var shopListView: ListView
    private lateinit var shopItemAdapter: ShopItemAdapter

    private lateinit var service: APIInterface

    internal fun ResourceToItem(shopResources: List<ShopResource>?): List<ShopItem> {
        val shopItems = ArrayList<ShopItem>()

        for (i in shopResources!!.indices) {
            val images = shopResources[i].images.toTypedArray<String>()

            val dateFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")

            try {
                shopItems.add(ShopItem(
                        shopResources[i].id,
                        shopResources[i].name,
                        shopResources[i].explanation,
                        images,
                        shopResources[i].likes,
                        shopResources[i].style,
                        shopResources[i].lat,
                        shopResources[i].log,
                        dateFormat.parse(shopResources[i].date)
                ))
            } catch (e: ParseException) {
                e.printStackTrace()
            }

        }
        return shopItems
    }

    private fun LoadShops() {
        service.shops.enqueue(object : Callback<List<ShopResource>> {
            override fun onResponse(call: Call<List<ShopResource>>, response: Response<List<ShopResource>>) {
                if (response.isSuccessful) {
                    val shopItems = ResourceToItem(response.body())
                    shopItemAdapter = ShopItemAdapter(applicationContext, R.layout.item_store, shopItems)
                    shopListView.adapter = shopItemAdapter
                    Log.d("TAG", shopItemAdapter.count.toString() + "")

                    Log.d("ConsumerActivity", "posts loaded from API")
                } else {
                    val statusCode = response.code()
                    Log.d("ConsumerActivity", statusCode.toString() + ": occured error")
                }
            }

            override fun onFailure(call: Call<List<ShopResource>>, t: Throwable) {
                Log.d("ConsumerActivity", "error loading from API")
            }
        })
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        service = APIUtils.getAPIService()

        val toolbar = findViewById<View>(R.id.toolbar) as Toolbar
        setSupportActionBar(toolbar)

        val drawer = findViewById<View>(R.id.drawer_layout) as DrawerLayout
        val toggle = ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawer.addDrawerListener(toggle)
        toggle.syncState()

        val navigationView = findViewById<View>(R.id.nav_view) as NavigationView
        navigationView.setNavigationItemSelectedListener(this)

        View.inflate(applicationContext, R.layout.layout_consumer, findViewById(R.id.layout_main))

        imageTodayStyle = findViewById<View>(R.id.img_today_style) as ImageView
        shopListView = findViewById<View>(R.id.list_shop) as ListView

        LoadShops()

        val intent = intent
        if (Intent.ACTION_SEARCH == intent.action) {
            val query = intent.getStringExtra(SearchManager.QUERY)
            Log.d("TAGTAHG", "onCreate: $query")
        }
    }

    override fun onBackPressed() {
        val drawer = findViewById<View>(R.id.drawer_layout) as DrawerLayout
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)

        val searchManager = getSystemService(Context.SEARCH_SERVICE) as SearchManager
        val searchView = menu.findItem(R.id.action_search).actionView as SearchView

        searchView.setSearchableInfo(searchManager.getSearchableInfo(componentName))
        searchView.setIconifiedByDefault(true)

        searchView.queryHint ="Search"
        searchView.setOnQueryTextListener(object: SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query:String):Boolean {
                Log.d("searching", "submit: " + query)
                return true
            }

            override fun onQueryTextChange(newText:String):Boolean {
                Log.d("searching", newText)
                return true
            }
        })

        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        val id = item.itemId


        when (id) {
            R.id.action_search -> {
                TransitionManager.beginDelayedTransition(this.findViewById<View>(R.id.toolbar) as ViewGroup)
                MenuItemCompat.expandActionView(item)
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        val id = item.itemId

        when (id) {
            R.id.nav_camera -> false
            R.id.nav_gallery -> false
            R.id.nav_gallery -> false
            R.id.nav_slideshow -> false
            R.id.nav_manage -> false
            R.id.nav_share -> false
            R.id.nav_send -> false
        }

        val drawer = findViewById<View>(R.id.drawer_layout) as DrawerLayout
        drawer.closeDrawer(GravityCompat.START)
        return true
    }
}