package com.example.androidfragments

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.preference.PreferenceManager

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // add hotelFragment
        val frag = HotelFragment()
        supportFragmentManager.beginTransaction().replace(R.id.containerL,frag).commit()
    }

    override fun onResume() {
        super.onResume()
        val pref = PreferenceManager.getDefaultSharedPreferences(this)
        val name = pref.getString("signature", null)
        supportActionBar?.title = name
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menu?.add("Settings")
        menu?.add("Login")
        menu?.add("Exit")
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.title){
            "Settings"->{
                val frag = SettingsFragment()
                supportFragmentManager.beginTransaction().replace(R.id.containerL,frag).addToBackStack(null).commit()
            }
            "Login" ->{
                val i = Intent(this, LoginActivity::class.java)
                startActivity(i)
            }
            "Exit" -> finish()
        }

        return super.onOptionsItemSelected(item)
    }
}