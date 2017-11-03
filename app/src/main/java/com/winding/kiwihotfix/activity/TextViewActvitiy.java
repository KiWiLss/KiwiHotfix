package com.winding.kiwihotfix.activity;

import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.winding.kiwihotfix.BuildConfig;
import com.winding.kiwihotfix.R;

/**
 * Created by 刘少帅 on 2017/11/3
 */

public class TextViewActvitiy extends AppCompatActivity {
    TextView tvOne;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_textview);
        initView();
        spannableStringMethod();

//        String html = getString(R.string.from_html_text);
///*让链接可点击*/
//        tvOne.setMovementMethod(LinkMovementMethod.getInstance());
///*ResouroceImageGetter用来处理TextView中的图片*/
//        tvOne.setText(Html.fromHtml(html, new ResouroceImageGetter(), null));

        String str="稍后您将完成存管账户的开通, 同时也将开通自动授权功能, 了解自动投标授权功能";
        SpannableString sp = new SpannableString(str);
        sp.setSpan(new MyClick(),str.lastIndexOf(",")+1,str.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        tvOne.setText(sp);
        //设置可点击
        tvOne.setMovementMethod(LinkMovementMethod.getInstance());
        //tvOne.setHighlightColor(Color.TRANSPARENT); //设置点击后的颜色为透明

        //tvOne.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));//加粗,无效
        tvOne.getPaint().setFakeBoldText(true);//加粗
        //tvOne.getPaint().setFlags(Paint. UNDERLINE_TEXT_FLAG ); //下划线
        tvOne.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);//中划线
    }
    class MyClick extends ClickableSpan{

        @Override
        public void updateDrawState(TextPaint ds) {
            super.updateDrawState(ds);
            //设置超链接文本的颜色
            ds.setColor(ContextCompat.getColor(TextViewActvitiy.this,R.color.colorPrimary));
            //超链接形式的下划线，false 表示不显示下划线，true表示显示下划线
            ds.setUnderlineText(false);

        }

        @Override
        public void onClick(View view) {
            Toast.makeText(TextViewActvitiy.this, "点击了", Toast.LENGTH_SHORT).show();
        }
    }

    private class ResouroceImageGetter implements Html.ImageGetter {
        // Constructor takes a Context
        public Drawable getDrawable(String source) {
            int path = getResources().getIdentifier(source, "drawable", BuildConfig.APPLICATION_ID);
            Drawable drawable = getResources().getDrawable(path);
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
            return drawable;
        }
    }
    private void spannableStringMethod() {
        //方法一
        //tvOne.setText(Html.fromHtml("共<font color=yellow>"+ 5+ "</font>个软件，有<font color=yellow>"+9 + "</font>有更新"));
        //方法二
        String msg="随意输入进去,卡可能负";
        //SpannableString sp = new SpannableString("随意输入进去,卡可能负");


//    // 设置样式一
//        sp.setSpan(new ForegroundColorSpan(0xff009eff), 2, 4,
//                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
//    // 设置样式二
//        sp.setSpan(new ForegroundColorSpan(Color.RED), 6, 8,
//                Spannable.SPAN_EXCLUSIVE_INCLUSIVE);

        //SpannableString sp = TvUtils.setTextPartTextSize(msg, "可能", 30);
        //SpannableString sp = TvUtils.setTextPartTextSize(msg, "可能", Color.RED, 40);
        //SpannableString sp = TvUtils.setTextPartColor(msg, "可能", Color.RED);
//        SpannableString sp = TvUtils.setTextPartBg(msg, "可能", Color.YELLOW);
//        tvOne.setText(sp);

    }

    private void initView() {
         tvOne = (TextView) findViewById(R.id.tv_text_one);
    }
}
