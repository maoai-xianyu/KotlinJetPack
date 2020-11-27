package com.mao.kotlinjetpack.test_fun;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.TypedValue;

import androidx.annotation.Nullable;

public class AdjustTextView extends androidx.appcompat.widget.AppCompatTextView {
    private Paint mTextPaint;
    private float mTextSize;

    public AdjustTextView(Context context) {
        super(context);
    }

    public AdjustTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public AdjustTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    /**
     * Re size the font so the specified text fits in the text box assuming the
     * text box is the specified width.
     *
     * @param text
     * @param textViewWidth
     */
    private void refitText(String text, int textViewWidth) {
        if (text == null || textViewWidth <= 0)
            return;
        mTextPaint = new Paint();
        mTextPaint.set(this.getPaint());
        int availableTextViewWidth = getWidth() - getPaddingLeft() - getPaddingRight();
        float[] charsWidthArr = new float[text.length()];
        Rect boundsRect = new Rect();
        mTextPaint.getTextBounds(text, 0, text.length(), boundsRect);
        int textWidth = boundsRect.width();
        mTextSize = getTextSize();
        while (textWidth > availableTextViewWidth) {
            mTextSize -= 1;
            mTextPaint.setTextSize(mTextSize);
            textWidth = mTextPaint.getTextWidths(text, charsWidthArr);
        }
        this.setTextSize(TypedValue.COMPLEX_UNIT_PX, mTextSize);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        refitText(this.getText().toString(), this.getWidth());
    }
}