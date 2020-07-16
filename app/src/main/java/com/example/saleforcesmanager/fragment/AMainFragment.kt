package com.example.saleforcesmanager.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.saleforcesmanager.AMainActivity.Companion.C_PAGE
import com.example.saleforcesmanager.BMainActivity
import com.example.saleforcesmanager.R
import kotlinx.android.synthetic.main.fragment_main.*

class AMainFragment : Fragment() {

    companion object {
        fun newIntance(): AMainFragment {
            val fragment = AMainFragment()
            return fragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_main, container, false);
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        tvPage.text = getString(R.string.page_a)

        btnNext.setOnClickListener {
            activity?.startActivityForResult(Intent(activity, BMainActivity::class.java), C_PAGE)
        }
    }
}