package com.feliperoriz.itemdecorationexample

import android.graphics.Canvas
import android.graphics.Rect
import android.graphics.drawable.Drawable
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.View

class ExampleDecoration(private val drawable: Drawable): RecyclerView.ItemDecoration() {

    override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
        super.getItemOffsets(outRect, view, parent, state)

        // TODO figure out better way of getting item offset with drawable
        outRect.left = drawable.intrinsicWidth + 50
    }

    override fun onDrawOver(canvas: Canvas, parent: RecyclerView, state: RecyclerView.State) {
        val count = parent.childCount
        for (index in 0 until count) {
            val child = parent.getChildAt(index)
            val params = child.layoutParams as RecyclerView.LayoutParams

            val drawableLeft = parent.left + params.marginStart
            val drawableRight = drawable.intrinsicWidth + params.marginStart

            val drawableTop = child.top
            val drawableBottom = child.top + drawable.intrinsicHeight

            drawable.setBounds(drawableLeft, drawableTop, drawableRight, drawableBottom)
            drawable.draw(canvas)
        }
    }
}