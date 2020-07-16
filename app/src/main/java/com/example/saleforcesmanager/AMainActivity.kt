package com.example.saleforcesmanager

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentTransaction
import com.example.saleforcesmanager.fragment.AMainFragment
import com.example.saleforcesmanager.fragment.CMainFragment

class AMainActivity : AppCompatActivity() {
    companion object {
        const val C_PAGE = 111
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.beginTransaction().add(R.id.container,AMainFragment.newIntance(),"Amain").commit()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == C_PAGE){
            val transaction: FragmentTransaction = supportFragmentManager.beginTransaction()
            val fragment = supportFragmentManager.findFragmentByTag("Amain")
            fragment?.let {
                transaction.hide(fragment)
                transaction.add(R.id.container,CMainFragment.newIntance(),"Cmain")
                transaction.commitAllowingStateLoss()
            }
        }
    }
}
