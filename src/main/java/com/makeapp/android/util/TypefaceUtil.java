/**
 *  Copyright(c) Shanghai QianZhi Network Info Technologies Inc. All right reserved.
 */
package com.makeapp.android.util;

import android.graphics.Typeface;
import android.content.Context;

/**
 * @author <a href="mailto:shigang@shqianzhi.com">shigang</a>
 * @version $Date:11-10-25 ����3:57 $
 *          $Id$
 */
public class TypefaceUtil
{
    /**
     *  ��ȡ����
     * @param context
     * @param fontPath  �����ļ����Ŀ¼  �� assets Ϊ��Ŀ¼
     * @return
     */
    public static Typeface getTypeface(Context context,String fontPath)
    {
        return Typeface.createFromAsset(context.getAssets(), fontPath);
    }
}
