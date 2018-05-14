package com.drondon.android9;

import android.content.Context;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

class RecyclerClickListener implements RecyclerView.OnItemTouchListener {

    private static final String TAG = "RecyclerTouchListener";

    private OnTouchActionListener mOnTouchActionListener;
    private GestureDetectorCompat mGestureDetector;

    public static interface OnTouchActionListener {
        public void onClick(View view, int position);
    }

    public RecyclerClickListener(Context context, final RecyclerView recyclerView,
                                 OnTouchActionListener onTouchActionListener) {

        mOnTouchActionListener = onTouchActionListener;
        mGestureDetector = new GestureDetectorCompat(context, new GestureDetector.SimpleOnGestureListener() {

            @Override
            public boolean onSingleTapConfirmed(MotionEvent e) {
                Log.d(TAG, "On Single Tap Confirmed");
                // Find the item view that was swiped based on the coordinates
                View child = recyclerView.findChildViewUnder(e.getX(), e.getY());
                int childPosition = recyclerView.getChildAdapterPosition(child);
                mOnTouchActionListener.onClick(child, childPosition);
                return false;
            }
        });
    }

    @Override
    public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
        mGestureDetector.onTouchEvent(e);
        return false;
    }

    @Override
    public void onTouchEvent(RecyclerView rv, MotionEvent e) {
    }

    @Override
    public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {
        // do nothing
    }

}
