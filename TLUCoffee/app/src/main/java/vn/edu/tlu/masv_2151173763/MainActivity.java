package vn.edu.tlu.masv_2151173763;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Menu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import com.google.android.material.navigation.NavigationView;

import com.google.android.material.snackbar.Snackbar;


import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import vn.edu.tlu.masv_2151173763.databinding.ActivityMainBinding;
import vn.edu.tlu.masv_2151173763.ui.coffee.Coffee;
import vn.edu.tlu.masv_2151173763.ui.coffee.CoffeeAdapter;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    private ActivityMainBinding binding;
    private CoffeeAdapter coffeeAdapter;
    private List<Coffee> coffeeList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.appBarMain.toolbar);
        binding.appBarMain.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null)
                        .setAnchorView(R.id.fab).show();
            }
        });
        DrawerLayout drawer = binding.drawerLayout;
        NavigationView navigationView = binding.navView;
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_coffee, R.id.nav_fruitjuice, R.id.nav_tea, R.id.nav_cake, R.id.nav_sweetcake, R.id.nav_setting, R.id.nav_logout)
                .setOpenableLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        List<Coffee> coffeeList = new ArrayList<>();
        coffeeList.add(new Coffee("Americano", "49,000"));
        coffeeList.add(new Coffee("Cappuccino", "49,000"));
        coffeeList.add(new Coffee("Coffee", "49,000"));

        CoffeeAdapter adapter = new CoffeeAdapter(coffeeList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new CoffeeAdapter(coffeeList));


    }



        private void refreshCoffeeList() {
        coffeeList.clear();
            coffeeList.add(new Coffee("Americano", "49,000"));
            coffeeList.add(new Coffee("Cappuccino", "49,000"));
            coffeeList.add(new Coffee("Coffee", "49,000"));
        coffeeAdapter.notifyDataSetChanged();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }
}