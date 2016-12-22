package cn.jianke.dynamicchangeicon.module;

import android.app.Application;

/**
 * @className: BaseApplication
 * @classDescription: 应用基础实例
 * @author: leibing
 * @createTime: 2016/12/22
 */
public class BaseApplication extends Application{
    // sington
    private static BaseApplication instance;

    @Override
    public void onCreate() {
        super.onCreate();
        // init sington
        instance = this;
    }

    /**
     * get sington
     * @author leibing
     * @createTime 2016/12/22
     * @lastModify 2016/12/22
     * @param
     * @return
     */
    public static BaseApplication getInstance(){
        if (instance == null){
            synchronized (BaseApplication.class){
                if (instance == null){
                    instance = new BaseApplication();
                }
            }
        }

        return instance;
    }
}
