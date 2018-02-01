package com.a14mob.a21game.a21game


import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import com.a14mob.a21game.a21game.fragments.GameFragment
import com.a14mob.a21game.a21game.fragments.SobreFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_jogar -> {

                this.changeFragment(GameFragment());
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_sobre -> {

                this.changeFragment(SobreFragment());

                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_sair -> {

                this@MainActivity.finish();

                return@OnNavigationItemSelectedListener true
            }
        }
        false

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        this.changeFragment(GameFragment());
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
    }


    /**
     * altera o fragment
     */
    fun changeFragment ( fragment: Fragment){
        supportFragmentManager.beginTransaction()
                    .replace(R.id.frame, fragment)
                    .commit()
    }
}
