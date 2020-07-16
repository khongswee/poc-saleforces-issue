package com.example.saleforcesmanager.fragment

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.saleforcesmanager.AMainActivity.Companion.C_PAGE
import com.example.saleforcesmanager.BMainActivity
import com.example.saleforcesmanager.R
import com.scb.scbone.common.customview.FullScreenProgressDialog
import kotlinx.android.synthetic.main.fragment_main.*

class BMainFragment : Fragment() {

    private lateinit var fullScreenProgressDialog: FullScreenProgressDialog


    companion object {
        fun newIntance(): BMainFragment {
            val fragment = BMainFragment()
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
        context?.let {
            fullScreenProgressDialog = FullScreenProgressDialog(it)
        }

        fullScreenProgressDialog.show()

        object : CountDownTimer(5000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                tvPage.text =
                    getString(R.string.page_b) + " remaining: " + millisUntilFinished / 1000
            }

            override fun onFinish() {
                fullScreenProgressDialog.dismiss()
                activity?.finish()
                activity?.setResult(Activity.RESULT_OK)
            }
        }.start()
    }
}