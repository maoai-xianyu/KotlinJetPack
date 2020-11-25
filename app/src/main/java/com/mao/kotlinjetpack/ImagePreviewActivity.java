package com.mao.kotlinjetpack;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

public class ImagePreviewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_preview);

        Intent intent = getIntent();
        String url = intent.getStringExtra(Constant.EXTRA_PHOTO);
        if (!TextUtils.isEmpty(url)) {
            ImageView imageView = findViewById(R.id.imagePreview);
            Glide.with(this).load(url).into(imageView);
        }

        TextView viewById = findViewById(R.id.tv_reminder);

        toggleEllipsize(this,viewById,
        1,
                "服务商不管",
                "TOp",
                R.color.design_default_color_error,false);

    }


    public void toggleEllipsize(final Context context,
                                final TextView textView,
                                final int minLines,
                                final String originText,
                                final String endText,
                                final int endColorID,
                                final boolean isExpand) {
        if (TextUtils.isEmpty(originText)) {
            return;
        }
        textView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver
                .OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                if (isExpand) {
                    textView.setText(originText);
                } else {
                    int paddingLeft = textView.getPaddingLeft();
                    int paddingRight = textView.getPaddingRight();
                    TextPaint paint = textView.getPaint();
                    float moreText = textView.getTextSize() * endText.length();
                    float availableTextWidth = (textView.getWidth() - paddingLeft - paddingRight) *
                            minLines - moreText;
                    CharSequence ellipsizeStr = TextUtils.ellipsize(originText, paint,
                            availableTextWidth, TextUtils.TruncateAt.END);
                    if (ellipsizeStr.length() < originText.length()) {
                        CharSequence temp = ellipsizeStr + endText;
                        SpannableStringBuilder ssb = new SpannableStringBuilder(temp);
                        ssb.setSpan(new ForegroundColorSpan(context.getResources().getColor
                                        (endColorID)),
                                temp.length() - endText.length(), temp.length(), Spannable.SPAN_INCLUSIVE_EXCLUSIVE);
                        textView.setText(ssb);
                    } else {
                        textView.setText(originText);
                    }
                }
                textView.getViewTreeObserver().removeOnGlobalLayoutListener(this);

            }
        });
    }
}