package com.drondon.android15;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatEditText;
import android.text.TextUtils;
import android.util.AttributeSet;

public class RequiredEditText extends AppCompatEditText {

    private boolean required;

    public RequiredEditText(Context context) {
        super(context);
        init(context, null);
    }

    public RequiredEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public RequiredEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    private void init(Context context, @Nullable AttributeSet attrs) {
        if (attrs != null) {
            TypedArray typedArray = null;
            try {
                typedArray = context.obtainStyledAttributes(attrs, R.styleable.RequiredEditText, 0, 0);
                required = typedArray.getBoolean(R.styleable.RequiredEditText_required, false);
            } finally {
                if (typedArray != null)
                    typedArray.recycle();

            }
        }
    }

    public boolean isRequired() {
        return required;
    }

    public boolean validate() {

        if (!required) {
            return true;
        }

        if (TextUtils.isEmpty(getText())) {
            setError("Это поле обязательно!");
            return false;
        } else {
            setError(null);
            return true;
        }

    }
}
