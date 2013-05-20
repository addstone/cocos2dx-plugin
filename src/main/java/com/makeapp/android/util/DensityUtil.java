/**
 *  Copyright(c) Shanghai QianZhi Network Info Technologies Inc. All right reserved.
 */
package com.makeapp.android.util;

import android.content.Context;

/**
 * @author <a href="mailto:shigang@shqianzhi.com">shigang</a>
 * @version $Date:11-12-28 ����4:32 $
 *          $Id$
 */

/**
 * android ��λת��������
 */
public class DensityUtil
{
    /**
     * �����ֻ��ķֱ��ʴ� dp �ĵ�λ ת��Ϊ px(����)
     */
    public static int dip2px(Context context, float dpValue)
    {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    /**
     * �����ֻ��ķֱ��ʴ� px(����) �ĵ�λ ת��Ϊ dp
     */
    public static int px2dip(Context context, float pxValue)
    {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }

    /**
     * �����ֻ��ֱ��ʴ� sp �ĵ�λת��Ϊ px
     *
     * @param context
     * @param spValue
     * @return
     */
    public static int sp2px(Context context, float spValue)
    {
        final float fontScale = context.getResources().getDisplayMetrics().scaledDensity;
        return (int) (spValue * fontScale + 0.5f);
    }

    /**
     * �����ֻ��ֱ��ʴ� px �ĵ�λת��Ϊ sp
     *
     * @param context
     * @param pxValue
     * @return
     */
    public static int ps2sp(Context context, float pxValue)
    {
        final float fontScale = context.getResources().getDisplayMetrics().scaledDensity;
        return (int) (pxValue / fontScale + 0.5f);
    }
}





