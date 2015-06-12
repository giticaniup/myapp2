package com.example.myapp2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.ab.activity.AbActivity;
import com.ab.view.slidingmenu.SlidingMenu;
import com.ab.view.titlebar.AbTitleBar;
import com.myapp2.advise.auditAdvise;
import com.myapp2.fragment.MainMenuFragment;

/**
 * Created by zhongcy on 2015/5/28.
 */
public class MainActivity extends AbActivity {

    private AbTitleBar abTitleBar;
    private SlidingMenu menu;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setAbContentView(R.layout.mainactivity);
        abTitleBar=this.getTitleBar();
        abTitleBar.setTitleText("GOODTIME");
        abTitleBar.setLogo(R.drawable.button_select);
        abTitleBar.setLogo2(R.drawable.button_more);
        abTitleBar.setLogoLine(R.drawable.line);
        abTitleBar.setTitleBarBackground(R.drawable.top_bg);
        abTitleBar.setTitleTextMargin(10, 0, 0, 0);
        initTitleRightLayout();

        //配置SlidingMenu
        menu=new SlidingMenu(this);
        menu.setMode(SlidingMenu.LEFT_RIGHT);
        menu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
        menu.setShadowWidthRes(R.dimen.shadow_width);
        menu.setShadowDrawable(R.drawable.shadow);
        menu.setBehindOffsetRes(R.dimen.slidingmenu_offset);
        menu.setFadeDegree(0.35f);
        menu.attachToActivity(this, SlidingMenu.SLIDING_CONTENT);

        //menu视图的Fragment添加
        MainMenuFragment mMainMenuFragment=new MainMenuFragment();
        menu.setMenu(R.layout.sliding_menu_menu);
        getFragmentManager()
                .beginTransaction()
                .replace(R.id.menu_frame, mMainMenuFragment).commit();

        //设置mAbTittleBar的点击监听事件
        abTitleBar.getLogoView().setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                if (menu.isMenuShowing()) {
                    menu.showContent();
                } else {
                    menu.showMenu();
                }
            }
        });

        abTitleBar.getLogoView2().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent adviseintent=new Intent(MainActivity.this,auditAdvise.class);
                startActivity(adviseintent);
            }
        });
//
    }
    private void initTitleRightLayout(){

    }
}
