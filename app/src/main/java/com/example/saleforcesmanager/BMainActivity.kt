package com.example.saleforcesmanager

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.saleforcesmanager.fragment.BMainFragment

class BMainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.beginTransaction().add(R.id.container, BMainFragment.newIntance(),"Bmain").commit()
    }
}
