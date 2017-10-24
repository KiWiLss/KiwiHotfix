package com.winding.kiwihotfix.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.trycatch.mysnackbar.Prompt;
import com.trycatch.mysnackbar.TSnackbar;
import com.winding.kiwihotfix.R;
import com.winding.kiwihotfix.utils.SnackbarUtil;
import com.winding.kiwihotfix.utils.ToastUtil;

/**
 * Created by 刘少帅 on 2017/10/24
 */

public class SnackbarActivity extends AppCompatActivity implements View.OnClickListener{

    private FloatingActionButton mFab;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //设置状态栏透明
//        if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT && android.os.Build.VERSION.SDK_INT<=Build.VERSION_CODES.LOLLIPOP) {
//            Window window = getWindow();
//            window.setFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS, WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
//        }

        setContentView(R.layout.activity_snackbar);

        initView();

        final ViewGroup viewGroup = (ViewGroup) findViewById(android.R.id.content).getRootView();//注意getRootView()最为重要，直接关系到TSnackBar的位置
        //snackBar.setPromptThemBackground(Prompt.SUCCESS).setText("登录成功").setDuration(TSnackbar.LENGTH_LONG).show();
        //snackBar.setPromptThemBackground(Prompt.ERROR).setText("登录失败").setDuration(TSnackbar.LENGTH_LONG).show();
        TSnackbar.make(viewGroup, "网络已连接", TSnackbar.LENGTH_LONG, TSnackbar.APPEAR_FROM_TOP_TO_DOWN)
         .setPromptThemBackground(Prompt.SUCCESS).show();
//        TSnackbar.make(viewGroup, "网络未连接", TSnackbar.LENGTH_LONG, TSnackbar.APPEAR_FROM_TOP_TO_DOWN)
// .setPromptThemBackground(Prompt.WARNING).show();
//        TSnackbar snackBar = TSnackbar.make(viewGroup, "正在加载中...", TSnackbar.LENGTH_INDEFINITE, TSnackbar.APPEAR_FROM_TOP_TO_DOWN);
//        snackBar.setAction("取消", new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//            }
//        });
//        snackBar.setPromptThemBackground(Prompt.SUCCESS);
//        snackBar.addIconProgressLoading(0,true,false);
//        snackBar.show();



    }

    private void initView() {
        mFab = (FloatingActionButton) findViewById(R.id.fab_snackbar_float);
        mFab.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.fab_snackbar_float:
                Snackbar.make(mFab,"hahahahhahah", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    /**简单显示
     * @param view
     */
    public void simpleListener(View view) {
        Snackbar.make(mFab,"hahahahhahah", Toast.LENGTH_SHORT).show();
    }

    /**
     * 简单显示加点击事件
     * @param view
     */
    public void simpleAndListener(View view) {
        Snackbar snackbar = Snackbar.make(mFab, "点击", Toast.LENGTH_SHORT)
                .setAction("sure", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                    }
                }).setActionTextColor(ContextCompat.getColor(this, R.color.scan_corner_color));//改变button的字体颜色
            setSnackbarColor(snackbar,ContextCompat.getColor(this, R.color.tab_checked),
                    ContextCompat.getColor(this, R.color.tab_unchecked));
              snackbar.show();
    }

    public static void setSnackbarColor(Snackbar snackbar, int messageColor, int backgroundColor) {
        View view = snackbar.getView();//获取Snackbar的view
        if(view!=null){
            view.setBackgroundColor(backgroundColor);//修改view的背景色
            ((TextView) view.findViewById(R.id.snackbar_text)).setTextColor(messageColor);//获取Snackbar的message控件，修改字体颜色
        }
    }

    /**添加图片布局
     * @param view
     */
    public void addIconListener(View view) {
        Snackbar snackbar = SnackbarUtil.ShortSnackbar(mFab, "hello kitty", SnackbarUtil.Info);

        SnackbarUtil.SnackbarAddView(snackbar,this);
        snackbar.show();

//        Snackbar snackbar = Snackbar.make(mFab, "添加图片", Toast.LENGTH_SHORT);
//        SnackbarAddView(snackbar,R.layout.snackbar_icon,1);
//        snackbar.show();
    }

    public  void SnackbarAddView(Snackbar snackbar,int layoutId,int index) {
        View snackbarview = snackbar.getView();//获取snackbar的View(其实就是SnackbarLayout)

        Snackbar.SnackbarLayout snackbarLayout=(Snackbar.SnackbarLayout)snackbarview;//将获取的View转换成SnackbarLayout

        View add_view = LayoutInflater.from(snackbarview.getContext()).inflate(layoutId,null);//加载布局文件新建View

        LinearLayout.LayoutParams p = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT
                ,LinearLayout.LayoutParams.WRAP_CONTENT);//设置新建布局参数

        p.gravity= Gravity.CENTER_VERTICAL;//设置新建布局在Snackbar内垂直居中显示

        snackbarLayout.addView(add_view,index,p);//将新建布局添加进snackbarLayout相应位置
    }


    public void toolListener(View view) {
        SnackbarUtil.ShortSnackbar(mFab,"hello kitty",SnackbarUtil.Info).show();
    }


    public void toolComplexListener(View view) {
        Snackbar snackbar= SnackbarUtil.ShortSnackbar(mFab,"妹子删了你发出的消息",SnackbarUtil.Warning).setActionTextColor(Color.RED).setAction("再次发送", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SnackbarUtil.LongSnackbar(mFab,"妹子已将你拉黑",SnackbarUtil.Alert).setActionTextColor(Color.WHITE).show();
            }
        });

        SnackbarUtil.SnackbarAddView(snackbar,R.layout.snackbar_icon,0);

        snackbar.show();
    }



    public void setPositionListener(View view) {
//        SnackbarUtils.Custom(mFab,"10s+左右drawable+背景色+圆角带边框+指定View下方",1000*10)
//                .leftAndRightDrawable(R.mipmap.arrow_down,R.mipmap.coupons_food)
//                .backColor(0XFF668899)
//                .radius(16,1,Color.BLUE)
//                .bellow(mFab,10,16,16)
//                .show();

        ToastUtil toastUtil=new ToastUtil();
        toastUtil.Short(this,"自定义message字体、背景色").setToastColor(Color.WHITE, getResources().getColor(R.color.colorAccent)).show();


    }
}


