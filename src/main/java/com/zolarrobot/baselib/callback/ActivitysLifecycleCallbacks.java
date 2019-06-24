package com.zolarrobot.baselib.callback;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

import java.util.Stack;

/**
 * Created by DuanYuntian on 2019/5/30.
 */

/** 统管所有activity */
public class ActivitysLifecycleCallbacks implements Application.ActivityLifecycleCallbacks {
    Stack<Activity> activityStack ;
    public ActivitysLifecycleCallbacks(Stack<Activity>  sActivityStack){
        activityStack = sActivityStack;
    }

    @Override
    public void onActivityCreated(Activity activity, Bundle bundle) {
        activityStack.add(activity);
    }

    @Override
    public void onActivityStarted(Activity activity) {
    }

    @Override
    public void onActivityResumed(Activity activity) {

    }

    @Override
    public void onActivityPaused(Activity activity) {
    }

    @Override
    public void onActivityStopped(Activity activity) {

    }

    @Override
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {

    }

    @Override
    public void onActivityDestroyed(Activity activity) {
        activityStack.remove(activity);
    }

    public Stack<Activity> returnActivityStack(){
        return activityStack;
    }
}