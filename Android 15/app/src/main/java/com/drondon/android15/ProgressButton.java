package com.drondon.android15;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ProgressBar;

public class ProgressButton extends FrameLayout {

    private ProgressBar progressBar;
    private Button button;

    public ProgressButton(@NonNull Context context) {
        super(context);
        init(context);
    }

    public ProgressButton(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public ProgressButton(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    public ProgressButton(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context);
    }

    private void init(Context context) {
        View.inflate(context, R.layout.view_progress_button, this);
        progressBar = findViewById(R.id.progressBar);
        button = findViewById(R.id.button1);
    }

    void showProgress(){
        progressBar.setVisibility(VISIBLE);
    }

    void hideProgress(){
        progressBar.setVisibility(GONE);
    }

    @Override
    public void setOnClickListener(@Nullable OnClickListener l) {
        button.setOnClickListener(l);
    }
}
