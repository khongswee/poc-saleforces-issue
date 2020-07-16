package com.scb.scbone.common.customview

import android.animation.Animator
import android.animation.AnimatorSet
import android.animation.ArgbEvaluator
import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import android.annotation.SuppressLint
import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.view.animation.Animation
import android.view.animation.LinearInterpolator
import android.widget.ImageView
import android.widget.LinearLayout
import com.example.saleforcesmanager.R

class CustomViewProgressAnimationFull(context: Context, attrs: AttributeSet) :
    LinearLayout(context, attrs) {

    private var topPoint: ImageView
    private var leftPoint: ImageView
    private var rightPoint: ImageView
    private var bottomPoint: ImageView
    private var view: View
    private var animatorSet: AnimatorSet

    companion object {
        private const val DURATION_ANIMATION = 1000L
        private const val START_ANGLE = 0f
        private const val END_ANGLE = 90f
        private const val TRANSLATION_Y = "translationY"
        private const val TRANSLATION_VALUE = 10f
        private const val TRANSLATION_X = "translationX"
        private const val ROTATION = "rotation"
    }

    init {
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        view = inflater.inflate(R.layout.custom_view_progress_animation_full, this, true)
        topPoint = findViewById(R.id.progress_circle01)
        leftPoint = findViewById(R.id.progress_circle02)
        rightPoint = findViewById(R.id.progress_circle03)
        bottomPoint = findViewById(R.id.progress_circle04)

        animatorSet = AnimatorSet()
        playAnimation()
    }

    private fun playAnimation() {
        val pointTopColor = resources.getColor(R.color.point_top_purple)
        val pointLeftColor = resources.getColor(R.color.point_left_gray_75)
        val pointBottomColor = resources.getColor(R.color.point_bottom_gray_50)
        val pointRightColor = resources.getColor(R.color.point_right_gray_25)
        animatorSet.cancel()
        animatorSet = AnimatorSet().apply {
            val rotationAnimator = createRotationAnimator()
            val translateTopPointAnimator =
                createTranslationAnimator(topPoint, TRANSLATION_Y, TRANSLATION_VALUE)
            val translateLeftPointAnimator =
                createTranslationAnimator(leftPoint, TRANSLATION_X, TRANSLATION_VALUE)
            val translateRightPointAnimator =
                createTranslationAnimator(rightPoint, TRANSLATION_X, -TRANSLATION_VALUE)
            val translateBottomPointAnimator =
                createTranslationAnimator(bottomPoint, TRANSLATION_Y, -TRANSLATION_VALUE)
            val changeColorTopPointAnimaor =
                createColorAnimator(topPoint, pointTopColor, pointRightColor)
            val changeColorLeftPointAnimaor =
                createColorAnimator(leftPoint, pointLeftColor, pointTopColor)
            val changeColorRightPointAnimaor =
                createColorAnimator(rightPoint, pointRightColor, pointBottomColor)
            val changeColorBottomPointAnimaor =
                createColorAnimator(bottomPoint, pointBottomColor, pointLeftColor)
            playTogether(
                rotationAnimator,
                translateTopPointAnimator,
                translateLeftPointAnimator,
                translateRightPointAnimator,
                translateBottomPointAnimator,
                changeColorTopPointAnimaor,
                changeColorLeftPointAnimaor,
                changeColorRightPointAnimaor,
                changeColorBottomPointAnimaor
            )
            interpolator = LinearInterpolator()
        }
        animatorSet.start()
    }

    fun stopAnimation() {
        animatorSet.cancel()
    }

    @SuppressLint("WrongConstant")
    private fun createTranslationAnimator(
        imageView: ImageView?,
        translationType: String,
        translationValue: Float
    ): Animator? {
        return ObjectAnimator.ofFloat(imageView, translationType, -translationValue).apply {
            duration = DURATION_ANIMATION / 2
            repeatMode = Animation.REVERSE
            repeatCount = Animation.INFINITE
        }
    }

    @SuppressLint("WrongConstant")
    private fun createRotationAnimator(): Animator? {
        return ObjectAnimator.ofFloat(view, ROTATION, START_ANGLE, END_ANGLE).apply {
            duration = DURATION_ANIMATION
            repeatCount = Animation.INFINITE
            repeatMode = Animation.INFINITE
        }
    }

    @SuppressLint("WrongConstant")
    private fun createColorAnimator(target: ImageView, fromColor: Int, toColor: Int): Animator? {
        return ValueAnimator().apply {
            setIntValues(fromColor, toColor)
            setEvaluator(ArgbEvaluator())
            addUpdateListener {
                target.background.setTint(it.animatedValue as Int)
            }
            duration = DURATION_ANIMATION
            repeatCount = Animation.INFINITE
        }
    }
}

