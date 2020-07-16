package com.example.saleforcesmanager.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.saleforcesmanager.R
import kotlinx.android.synthetic.main.fragment_main.*

class CMainFragment : Fragment() {

    companion object {
        fun newIntance(): CMainFragment {
            val fragment = CMainFragment()
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
        tvPage.text = getString(R.string.page_c)

    }
}