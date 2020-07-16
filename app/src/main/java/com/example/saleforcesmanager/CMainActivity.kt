package com.example.saleforcesmanager

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.saleforcesmanager.fragment.AMainFragment
import com.example.saleforcesmanager.fragment.CMainFragment
import kotlinx.android.synthetic.main.activity_main.*

class CMainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.beginTransaction().add(R.id.container,
            CMainFragment.newIntance(),"Cmain").commit()
    }
}
