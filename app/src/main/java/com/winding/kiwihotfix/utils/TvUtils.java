package com.winding.kiwihotfix.utils;

import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;

/**
 * Created by 刘少帅 on 2017/11/3
 */

public class TvUtils {

    /**
     * 富文本设置字体大小
     *
     * @param srcString
     * @param tartgetString
     * @param txtSize
     * @return
     */
     public static SpannableString setTextPartTextSize(String srcString, String tartgetString, int txtSize) {
        int position = srcString.indexOf(tartgetString);
        SpannableString mSp = new SpannableString(srcString);
        if (position >= 0) {
            mSp.setSpan(new AbsoluteSizeSpan(txtSize, false), position, position + tartgetString.length(),
                    Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        }
        return mSp;
    }

    /**富文本设置字体颜色和大小
     * @param srcString
     * @param tartgetString
     * @param targetColor
     * @param txtSizeDp
     * @return
     */
     public static SpannableString setTextPartTextSize(String srcString, String tartgetString, int targetColor, int txtSizeDp) {
        int position = srcString.indexOf(tartgetString);
        SpannableString mSp = new SpannableString(srcString);
        if (position >= 0) {
            mSp.setSpan(new AbsoluteSizeSpan(txtSizeDp, true), position, position + tartgetString.length(),
                    Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            mSp.setSpan(new ForegroundColorSpan(targetColor), position, position + tartgetString.length(),
                    Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        }
        return mSp;
    }

    /**富文本设置部分文字颜色
     * @param srcString
     * @param tartgetString
     * @param targetColor
     * @return
     */
    public static SpannableString setTextPartColor(String srcString,String tartgetString,int targetColor){
        int position = srcString.indexOf(tartgetString);
        SpannableString mSp = new SpannableString(srcString);
        if (position >= 0) {
            mSp.setSpan(new ForegroundColorSpan(targetColor), position, position + tartgetString.length(),
                    Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        }
        return mSp;
    }

    /**富文本设置部分文字背景色
     * @param srcString
     * @param tartgetString
     * @param targetColor
     * @return
     */
    public static SpannableString setTextPartBg(String srcString,String tartgetString,int targetColor){
        int position = srcString.indexOf(tartgetString);
        SpannableString mSp = new SpannableString(srcString);
        if (position >= 0) {
            mSp.setSpan(new BackgroundColorSpan(targetColor), position, position + tartgetString.length(),
                    Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        }
        return mSp;
    }

}
