package com.akaiyukiusagi.scalegesturesample

import android.os.Bundle
import android.view.MotionEvent
import android.view.ScaleGestureDetector
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var mScaleDetector: ScaleGestureDetector

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initializeScaleDetector()
    }

    private fun initializeScaleDetector() {
        mScaleDetector = ScaleGestureDetector(this,
            object : ScaleGestureDetector.OnScaleGestureListener {
                // ピンチ中に断続的に呼ばれる
                override fun onScale(detector: ScaleGestureDetector): Boolean {
                    textX.text    = "X: ${detector.focusX}"
                    textY.text    = "Y: ${detector.focusY}"
                    textView.text = "current: ${detector.currentSpan}"
                    return true
                }

                // ピンチ開始時
                override fun onScaleBegin(detector: ScaleGestureDetector): Boolean {
                    return true
                }

                // ピンチ終了時
                override fun onScaleEnd(detector: ScaleGestureDetector) {
                }
            }
        )

    }

    override fun onTouchEvent(ev: MotionEvent): Boolean {
        mScaleDetector.onTouchEvent(ev)
        return true
    }

}

// 使い方： https://developer.android.com/training/gestures/scale?hl=ja#scale
// できることリスト：https://developer.android.com/reference/kotlin/android/view/ScaleGestureDetector
