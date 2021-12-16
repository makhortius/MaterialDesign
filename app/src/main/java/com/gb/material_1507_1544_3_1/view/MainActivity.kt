package com.gb.material_1507_1544_3_1.view

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.*
import androidx.appcompat.app.AppCompatDelegate
import com.gb.material_1507_1544_3_1.view.chips.SettingsFragment
import com.gb.material_1507_1544_3_1.view.picture.PictureOfTheDayFragment
import com.gb.material_1507_1555_3_1.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        //AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
       //AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        // если во время исполнения то не забываем выполнить recreate()
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            /*supportFragmentManager.beginTransaction()
                .replace(R.id.container, PictureOfTheDayFragment.newInstance()).commit()*/

            supportFragmentManager.beginTransaction()
                .replace(R.id.container, SettingsFragment.newInstance()).commit()
        }
        //recreate()
    }

    private fun isConnecton(): Boolean {
        return true
    }

}