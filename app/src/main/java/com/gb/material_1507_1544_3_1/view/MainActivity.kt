package com.gb.material_1507_1544_3_1.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.gb.material_1507_1544_3_1.view.picture.PictureOfTheDayFragment
import com.gb.material_1507_1555_3_1.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        // TODO FULL SCREEN
        if (isConnecton()) {
            setTheme(R.style.ThemeConnected)
        }else{
            setTheme(R.style.ThemeDisConnected)
        }
        // если во время исполнения то не забываем выполнить recreate()
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, PictureOfTheDayFragment.newInstance()).commit()
        }
        //recreate()
    }

    private fun isConnecton(): Boolean {
        return true
    }

}