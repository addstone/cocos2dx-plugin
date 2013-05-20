/**
 *  Copyright(c) Shanghai QianZhi Network Info Technologies Inc. All right reserved.
 */
package com.makeapp.android.util;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.os.Bundle;

/**
 * @author <a href="mailto:shigang@shqianzhi.com">shigang</a>
 * @version $Date:11-4-18 ����1:56 $
 *          $Id$
 */
public class ActivityUtil
{

    /**
     * ����activity
     *
     * @param packageContext
     * @param pakname
     * @param clazzName
     */
    public static void startActivity(Context packageContext, String pakname, String clazzName)
    {
        Intent intent = new Intent();
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.setPackage(pakname);
        intent.setClassName(pakname, clazzName);
        packageContext.startActivity(intent);
    }

    public static void startActivity(Context packageContext, Class<?> cls)
    {
        Intent it = new Intent();
        it.setClass(packageContext, cls);
        packageContext.startActivity(it);
    }

    public static void startActivity(Context packageContext, Class<?> cls,int flag)
    {
        Intent it = new Intent();
        it.setClass(packageContext, cls);
        it.setFlags(flag);
        packageContext.startActivity(it);
    }

    public static void startActivityForResult(Activity packageContext, Class<?> cls, int reqCode)
    {
        Intent it = new Intent();
        it.setClass(packageContext, cls);
        packageContext.startActivityForResult(it, reqCode);
    }

    /**
     * ����activity
     *
     * @param packageContext
     * @param cls
     */
    public static void startActivity(Context packageContext, Class<?> cls, Bundle bundle)
    {
        Intent it = new Intent();
        it.setClass(packageContext, cls);
        it.putExtras(bundle);
        packageContext.startActivity(it);
    }

    /**
     * ����Ӧ��.
     *
     * @param context
     * @param packageName
     */
    public static void startPackage(Context context, String packageName)
    {
        PackageManager packageManager = context.getPackageManager();
        Intent intent = packageManager.getLaunchIntentForPackage(packageName);
        if (intent != null) {
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            try {
                context.startActivity(intent);
            }
            catch (Throwable e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * �ر�Ӧ��.
     * ��ҪȨ��
     * <uses-permission android:name="android.permission.RESTART_PACKAGES" />
     *
     * @param context
     * @param pkg
     */
    public static void restartPackage(Context context, String pkg)
    {
        ActivityManager activityMgr = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);

        activityMgr.restartPackage(pkg);
    }

    /**
     * ��������.
     *
     * @param context
     */
    public static void gotoHome(Context context)
    {
        Intent startMain = new Intent(Intent.ACTION_MAIN);
        startMain.addCategory(Intent.CATEGORY_HOME);
        startMain.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(startMain);
    }

    /**
     * �˳�Ӧ�ó���.
     *
     * @param context
     */
    public static void exitPackage(Context context)
    {
        int currentVersion = android.os.Build.VERSION.SDK_INT;
        if (currentVersion > android.os.Build.VERSION_CODES.ECLAIR_MR1) {
            gotoHome(context);
            System.exit(0);
        }
        else {// android2.1
            ActivityManager am = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
            am.restartPackage(context.getPackageName());
        }
    }

    public static void systemExit(Context context)
    {
        Intent startMain = new Intent(Intent.ACTION_MAIN);
        startMain.addCategory(Intent.CATEGORY_HOME);
        startMain.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(startMain);
        System.exit(0);
    }

    /**
     * ���ݰ������� Context
     *
     * @param context
     * @param packageName
     *
     * @return �µ�Context
     */
    public static Context createPackageContext(Context context, String packageName)
    {
        try {
            return context.createPackageContext(packageName, Context.CONTEXT_IGNORE_SECURITY);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * ��ȡĳ��Ӧ�ð�����Դ.
     *
     * @param context
     * @param packageName
     */
    public static Resources getPackageResources(Context context, String packageName)
    {
        Context context1 = createPackageContext(context, packageName);
        if (context1 != null) {
            return context1.getResources();
        }
        return null;
    }


}
