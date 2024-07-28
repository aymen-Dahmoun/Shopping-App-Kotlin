package com.example.shi

import android.os.Bundle
import android.view.MenuItem
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {


    private lateinit var bottomnavigationBar : BottomNavigationView
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var toggle : ActionBarDrawerToggle




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        drawerLayout = findViewById(R.id.main)
        toggle = ActionBarDrawerToggle(this,drawerLayout,R.string.Open,R.string.Close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)







        val homeFrag : Fragment = homeFrag()
        val other_view_modeFrag = otherViewMode()
        val profileFrag = profile()

        currentFragment(homeFrag)
        bottomnavigationBar = findViewById(R.id.bottom_navBar)
        bottomnavigationBar.selectedItemId = R.id.Home
        bottomnavigationBar.setOnNavigationItemSelectedListener {

            when(it.itemId){
                R.id.Home -> currentFragment(homeFrag)
                R.id.profile -> currentFragment(profileFrag)
                R.id.icon_view -> currentFragment(other_view_modeFrag)

            }
            true
        }



    }


    private fun currentFragment(fragment: Fragment) =
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragment_container_view, fragment)
            commit()

        }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (toggle.onOptionsItemSelected(item)) {
            return true
        }
        return super.onOptionsItemSelected(item)

    }

}
