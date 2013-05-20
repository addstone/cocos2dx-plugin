package com.makeapp.android.util;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;

/**
 * Created by IntelliJ IDEA.
 * User: yuanyou
 * Date: 11-5-17
 * Time: ����3:18
 */
public class ShortcutUtil
{
    /**
     * Ϊ���򴴽������ݷ�ʽ.
     * <p/>
     * ��AndroidManifest.xml �ļ������� ������ɾ����ݷ�ʽʱ����Ȩ��
     * <uses-permission android:name="com.android.launcher.permission.INSTALL_SHORTCUT" />
     *
     * @param activity
     * @param name
     * @param packageName
     * @param className
     */
    private void addShortcut(Activity activity, String name, String packageName, String className, int iconResId)
    {
        Intent shortcut = new Intent("com.android.launcher.action.INSTALL_SHORTCUT");

        //��ݷ�ʽ������
        shortcut.putExtra(Intent.EXTRA_SHORTCUT_NAME, name);
        shortcut.putExtra("duplicate", false); //�������ظ�����

        //ָ����ǰ��ActivityΪ��ݷ�ʽ�����Ķ���: �� com.everest.video.VideoPlayer
        //ע��: ComponentName�ĵڶ�������������ϵ��(.)�������ݷ�ʽ�޷�������Ӧ����
        ComponentName comp = new ComponentName(packageName, "." + className);
        shortcut.putExtra(Intent.EXTRA_SHORTCUT_INTENT, new Intent(Intent.ACTION_MAIN).setComponent(comp));

        //��ݷ�ʽ��ͼ��
        Intent.ShortcutIconResource iconRes = Intent.ShortcutIconResource.fromContext(activity,iconResId);
        shortcut.putExtra(Intent.EXTRA_SHORTCUT_ICON_RESOURCE, iconRes);

        activity.sendBroadcast(shortcut);
    }

    /**
     * ɾ������Ŀ�ݷ�ʽ.
     * ��AndroidManifest.xml �ļ������� ������ɾ����ݷ�ʽʱ����Ȩ��
     * <uses-permission android:name="com.android.launcher.permission.UNINSTALL_SHORTCUT" />
     *
     * @param activity
     * @param name
     * @param packageName
     * @param className
     */
    @Deprecated
    private void removeShortcut(Activity activity, String name, String packageName, String className)
    {
        Intent shortcut = new Intent("com.android.launcher.action.UNINSTALL_SHORTCUT");

        //��ݷ�ʽ������
        shortcut.putExtra(Intent.EXTRA_SHORTCUT_NAME, name);

        //ָ����ǰ��ActivityΪ��ݷ�ʽ�����Ķ���: �� com.everest.video.VideoPlayer
        //ע��: ComponentName�ĵڶ�����������������������������+�������������޷�ɾ����ݷ�ʽ
        String appClass = packageName + "." + className;
        ComponentName comp = new ComponentName(packageName, appClass);
        shortcut.putExtra(Intent.EXTRA_SHORTCUT_INTENT, new Intent(Intent.ACTION_MAIN).setComponent(comp));

        activity.sendBroadcast(shortcut);
    }


    /**
     * Ϊ���򴴽������ݷ�ʽ
     *
     * <uses-permission android:name="com.android.launcher.permission.INSTALL_SHORTCUT" />
     * @param activity
     * @param shortcutName ��ݷ�ʽ����
     * @param shortcutIcon ��ݷ�ʽͼ��
     * @param isRepeat     �Ƿ����ظ�����
     */
    @Deprecated
    public static void addShortcut(Activity activity, String shortcutName, int shortcutIcon, boolean isRepeat)
    {
        Intent shortcut = new Intent("com.android.launcher.action.INSTALL_SHORTCUT");

        //��ݷ�ʽ������
        shortcut.putExtra(Intent.EXTRA_SHORTCUT_NAME, shortcutName);
        shortcut.putExtra("duplicate", isRepeat); //�������ظ�����

        //ָ����ǰ��ActivityΪ��ݷ�ʽ�����Ķ���: �� com.everest.video.VideoPlayer
        //ע��: ComponentName�ĵڶ�������������ϵ��(.)�������ݷ�ʽ�޷�������Ӧ����
        ComponentName comp = new ComponentName(activity.getPackageName(), "." + activity.getLocalClassName());
        shortcut.putExtra(Intent.EXTRA_SHORTCUT_INTENT, new Intent(Intent.ACTION_MAIN).setComponent(comp));

        //��ݷ�ʽ��ͼ��
        Intent.ShortcutIconResource iconRes = Intent.ShortcutIconResource.fromContext(activity, shortcutIcon);
        shortcut.putExtra(Intent.EXTRA_SHORTCUT_ICON_RESOURCE, iconRes);

        activity.sendBroadcast(shortcut);
    }

    /**
     * ɾ����ݷ�ʽ
     *
     * <uses-permission android:name="com.android.launcher.permission.UNINSTALL_SHORTCUT" />
     * @param activity
     * @param shortcutName ��ݷ�ʽ����
     */
    public static void remShortcut(Activity activity, String shortcutName)
    {
        Intent shortcut = new Intent("com.android.launcher.action.UNINSTALL_SHORTCUT");

        //��ݷ�ʽ������
        shortcut.putExtra(Intent.EXTRA_SHORTCUT_NAME, shortcutName);

        //ָ����ǰ��ActivityΪ��ݷ�ʽ�����Ķ���: �� com.everest.video.VideoPlayer
        //ע��: ComponentName�ĵڶ�����������������������������+�������������޷�ɾ����ݷ�ʽ
        String appClass = activity.getPackageName() + "." + activity.getLocalClassName();
        ComponentName comp = new ComponentName(activity.getPackageName(), appClass);
        shortcut.putExtra(Intent.EXTRA_SHORTCUT_INTENT, new Intent(Intent.ACTION_MAIN).setComponent(comp));

        activity.sendBroadcast(shortcut);
    }
}
