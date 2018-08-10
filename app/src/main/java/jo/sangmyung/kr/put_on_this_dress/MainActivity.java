package jo.sangmyung.kr.put_on_this_dress;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.transition.TransitionManager;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    ImageView imageTodayStyle;
    ListView shopListView;
    ShopItemAdapter shopItemAdapter;

    APIInterface service;

    List<ShopItem> ResourceToItem(List<ShopResource> shopResources) {
        List<ShopItem> shopItems = new ArrayList<>();

        for (int i=0; i<shopResources.size(); ++i) {
            String[] images = new String[shopResources.get(i).getImages().size()];
            shopResources.get(i).getImages().toArray(images);

            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");

            try {
                shopItems.add(new ShopItem(
                        shopResources.get(i).getId(),
                        shopResources.get(i).getName(),
                        shopResources.get(i).getExplanation(),
                        images,
                        shopResources.get(i).getLikes(),
                        shopResources.get(i).getStyle(),
                        shopResources.get(i).getLat(),
                        shopResources.get(i).getLog(),
                        dateFormat.parse(shopResources.get(i).getDate())
                ));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return shopItems;
    }

    void LoadShops() {
        service.getShops().enqueue(new Callback<List<ShopResource>> () {
            @Override
            public void onResponse(Call<List<ShopResource>> call, Response<List<ShopResource>> response) {
                if (response.isSuccessful()) {
                    List<ShopItem> shopItems = ResourceToItem(response.body());
                    shopItemAdapter = new ShopItemAdapter(getApplicationContext(), R.layout.item_store, shopItems);
                    shopListView.setAdapter(shopItemAdapter);
                    Log.d("TAG", shopItemAdapter.getCount() + "");

                    Log.d("MainActivity", "posts loaded from API");
                } else {
                    int statusCode = response.code();
                    Log.d("MainActivity", statusCode + ": occured error");
                }
            }

            @Override
            public void onFailure(Call<List<ShopResource>> call, Throwable t) {
                Log.d("MainActivity", "error loading from API");
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        service = APIUtils.getAPIService();

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        imageTodayStyle = (ImageView) findViewById(R.id.img_today_style);
        shopListView = (ListView) findViewById(R.id.list_shop);

        LoadShops();

        Intent intent = getIntent();
        if (Intent.ACTION_SEARCH.equals(intent.getAction())) {
            String query = intent.getStringExtra(SearchManager.QUERY);
            Log.d("TAGTAHG", "onCreate: " + query);
        }
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);

        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        SearchView searchView = (SearchView) menu.findItem(R.id.action_search).getActionView();

        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
        searchView.setIconifiedByDefault(false);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        switch (id) {
            case R.id.action_search:
                TransitionManager.beginDelayedTransition((ViewGroup) this.findViewById(R.id.toolbar));
                MenuItemCompat.expandActionView(item);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
