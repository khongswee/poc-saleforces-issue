package com.scb.scbone.common.customview

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.ViewGroup.LayoutParams.MATCH_PARENT
import android.view.Window
import android.view.WindowManager.LayoutParams.FLAG_DIM_BEHIND
import android.widget.TextView
import com.example.saleforcesmanager.R

/**
 * FullScreenProgressDialog
 */
class FullScreenProgressDialog(context: Context) : Dialog(context) {

    private var animationView: CustomViewProgressAnimationFull? = null
    private var title: TextView? = null
    private var description: TextView? = null

    init {
        setup()
    }

    private fun setup() {
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.custom_progress_fullscreen)
        animationView = findViewById(R.id.animation_view)
        description = findViewById(R.id.description_text_view)
        title = findViewById(R.id.title_text_view)

        val window = window

        if (window != null) {
            window.setLayout(MATCH_PARENT, MATCH_PARENT)
            window.clearFlags(FLAG_DIM_BEHIND)
            window.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        }

        setCancelable(false)
        setCanceledOnTouchOutside(false)
    }

    override fun dismiss() {
        super.dismiss()
        if (animationView != null) {
            animationView!!.stopAnimation()
        }
    }

    fun withTitle(title: String): FullScreenProgressDialog {
        this.title!!.text = title
        return this
    }

    fun withDescription(description: String): FullScreenProgressDialog {
        this.description!!.text = description
        return this
    }
}
