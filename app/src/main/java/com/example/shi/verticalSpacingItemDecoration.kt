package com.example.shi

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class verticalSpacingItemDEcoration (private val spacing: Int) : RecyclerView.ItemDecoration() {

    override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
        super.getItemOffsets(outRect, view, parent, state)
        // Add spacing to the bottom of each item
        outRect.bottom = spacing
    }
}

