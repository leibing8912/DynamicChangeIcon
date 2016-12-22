package cn.jianke.dynamicchangeicon.module.activity;

import android.content.ComponentName;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import cn.jianke.dynamicchangeicon.R;
import cn.jianke.dynamicchangeicon.common.DynamicChangeIcon;

/**
 * @className: MainActivity
 * @classDescription: 测试动态更改app图标
 * @author: leibing
 * @createTime: 2016/12/22
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    // 默认组件名
    private ComponentName defaultComponentName;
    // 健客医生组件名
    private ComponentName doctorComponentName;
    // 网上药店组件名
    private ComponentName jkmallComponentName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // init ComponentName
        defaultComponentName = getComponentName();
        doctorComponentName = DynamicChangeIcon.getInstance().getComponentName(getBaseContext(),
                "cn.jianke.dynamicchangeicon.doctor");
        jkmallComponentName = DynamicChangeIcon.getInstance().getComponentName(getBaseContext(),
                "cn.jianke.dynamicchangeicon.jkmall");
        // onClick
        findViewById(R.id.btn_default).setOnClickListener(this);
        findViewById(R.id.btn_doctor).setOnClickListener(this);
        findViewById(R.id.btn_jkmall).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_doctor:
                // 健客医生
                changeDoctorIcon();
                break;
            case R.id.btn_jkmall:
                // 网上药店
                changeJkmallIcon();
                break;
            case R.id.btn_default:
                // 默认
                changeDefaultIcon();
                break;
            default:
                break;
        }
    }

    /**
     * 更改为健客医生app图标
     * @author leibing
     * @createTime 2016/12/22
     * @lastModify 2016/12/22
     * @param
     * @return
     */
    private void changeDoctorIcon(){
        DynamicChangeIcon.getInstance().disableComponent(defaultComponentName);
        DynamicChangeIcon.getInstance().disableComponent(jkmallComponentName);
        DynamicChangeIcon.getInstance().enableComponent(doctorComponentName);
    }

    /**
     * 更改为网上药店app图标
     * @author leibing
     * @createTime 2016/12/22
     * @lastModify 2016/12/22
     * @param
     * @return
     */
    private void changeJkmallIcon(){
        DynamicChangeIcon.getInstance().disableComponent(defaultComponentName);
        DynamicChangeIcon.getInstance().enableComponent(jkmallComponentName);
        DynamicChangeIcon.getInstance().disableComponent(doctorComponentName);
    }

    /**
     * 更改为默认app图标
     * @author leibing
     * @createTime 2016/12/22
     * @lastModify 2016/12/22
     * @param
     * @return
     */
    private void changeDefaultIcon(){
        DynamicChangeIcon.getInstance().enableComponent(defaultComponentName);
        DynamicChangeIcon.getInstance().disableComponent(jkmallComponentName);
        DynamicChangeIcon.getInstance().disableComponent(doctorComponentName);
    }
}
