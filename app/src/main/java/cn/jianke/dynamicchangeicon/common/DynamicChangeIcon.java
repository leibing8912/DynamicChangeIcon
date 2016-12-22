package cn.jianke.dynamicchangeicon.common;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import cn.jianke.dynamicchangeicon.module.BaseApplication;

/**
 * @className: DynamicChangeIcon
 * @classDescription: 动态改变App默认图标
 * @author: leibing
 * @createTime: 2016/12/22
 */
public class DynamicChangeIcon {
    // 包管理器
    private PackageManager mPm;
    // sington
    private static DynamicChangeIcon intance;

    /**
     * Constructor
     * @author leibing
     * @createTime 2016/12/22
     * @lastModify 2016/12/22
     * @param
     * @return
     */
    private DynamicChangeIcon(){
        mPm = BaseApplication.getInstance().getApplicationContext().getPackageManager();
    }

    /**
     * get sington
     * @author leibing
     * @createTime 2016/12/22
     * @lastModify 2016/12/22
     * @param
     * @return
     */
    public static DynamicChangeIcon getInstance(){
        if (intance == null){
            synchronized (DynamicChangeIcon.class){
                if (intance == null)
                    intance = new DynamicChangeIcon();
            }
        }

        return intance;
    }

    /**
     * 设置组建可用
     * @author leibing
     * @createTime 2016/12/22
     * @lastModify 2016/12/22
     * @param componentName 组建名
     * @return
     */
    public void enableComponent(ComponentName componentName) {
        try {
            if (mPm != null) {
                mPm.setComponentEnabledSetting(componentName,
                        PackageManager.COMPONENT_ENABLED_STATE_ENABLED,
                        PackageManager.DONT_KILL_APP);
            }
        }catch (Exception ex){
        }
    }

    /**
     * 设置组件不可用
     * @author leibing
     * @createTime 2016/12/22
     * @lastModify 2016/12/22
     * @param componentName 组件名
     * @return
     */
    public void disableComponent(ComponentName componentName) {
        try {
            if (mPm != null) {
                mPm.setComponentEnabledSetting(componentName,
                        PackageManager.COMPONENT_ENABLED_STATE_DISABLED,
                        PackageManager.DONT_KILL_APP);
            }
        }catch (Exception ex){
        }
    }

    /**
     * 获取组件名
     * @author leibing
     * @createTime 2016/12/22
     * @lastModify 2016/12/22
     * @param context 上下文
     * @param name 名称
     * @return
     */
    public ComponentName getComponentName(Context context,String name){
        ComponentName mComponentName;
        try {
            mComponentName = new ComponentName(context, name);
        }catch (Exception ex){
            mComponentName = null;
        }
        return mComponentName;
    }
}
