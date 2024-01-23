package com.aniruddha.researchproject

import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.ScaleGestureDetector
import android.widget.HorizontalScrollView

class ZoomableScrollView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : HorizontalScrollView(context, attrs, defStyleAttr) {

    private var scaleGestureDetector: ScaleGestureDetector
    private var scaleFactorX = 1.0f
    private var scaleFactorY = 1.0f
    private var isScaling = false

    private val MIN_SCALE_FACTOR = 0.1f
    private val MAX_SCALE_FACTOR = 10.0f

    init {
        scaleGestureDetector = ScaleGestureDetector(context, ScaleListener())
    }

    override fun onTouchEvent(ev: MotionEvent): Boolean {
        // Handle touch events for zooming
        when (ev.actionMasked) {
            MotionEvent.ACTION_DOWN -> {
                isScaling = false
            }
            MotionEvent.ACTION_MOVE -> {
                isScaling = scaleGestureDetector.isInProgress
            }
            MotionEvent.ACTION_UP, MotionEvent.ACTION_CANCEL -> {
                isScaling = false
            }
        }

        // Let the ScaleGestureDetector inspect all events.
        scaleGestureDetector.onTouchEvent(ev)

        // If zooming is not in progress, pass the touch events to the RecyclerView
        if (!isScaling) {
            return super.onTouchEvent(ev)
        }

        return true
    }

    private inner class ScaleListener : ScaleGestureDetector.SimpleOnScaleGestureListener() {
        override fun onScale(detector: ScaleGestureDetector): Boolean {
            scaleFactorX *= detector.scaleFactor
            scaleFactorY *= detector.scaleFactor

            // Limit the scale factors to avoid extreme zoom levels
            scaleFactorX = scaleFactorX.coerceIn(MIN_SCALE_FACTOR, MAX_SCALE_FACTOR)
            scaleFactorY = scaleFactorY.coerceIn(MIN_SCALE_FACTOR, MAX_SCALE_FACTOR)

            // Perform zooming by scaling the view
            scaleX = scaleFactorX
            scaleY = scaleFactorY

            // If the zoom levels are too high, reset the view to its original state
            if (scaleFactorX == MAX_SCALE_FACTOR || scaleFactorY == MAX_SCALE_FACTOR ||
                scaleFactorX == MIN_SCALE_FACTOR || scaleFactorY == MIN_SCALE_FACTOR
            ) {
                resetZoom()
            }

            return true
        }
    }

    private fun resetZoom() {
        scaleFactorX = 1.0f
        scaleFactorY = 1.0f
        scaleX = scaleFactorX
        scaleY = scaleFactorY
    }
}
