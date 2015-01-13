/*   
 * Copyright (c) 2012-2013 Qeemo Ltd. All Rights Reserved.      
 *
 */
package com.example.socket.im.tool;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Util {

    public static final boolean isEmpty(String s)
    {
        return ! isNotEmpty(s);
    }

    public static final boolean isNotEmpty(String s)
    {
        return (null != s && ! "".equals(s));
    }

    public static final String timeStr()
    {
        SimpleDateFormat sdf = new SimpleDateFormat("",Locale.SIMPLIFIED_CHINESE);
        
        
        sdf.applyPattern("yyyy 年MM月dd日_HH时mm分ss秒");

        return sdf.format(new Date());
    }

    public static final boolean notEquals(String s1, String s2)
    {
        if (null != s1 && null != s2 )
        {
            return ! s1.equals(s2);
        }
        return false;
    }

    public static final String trimString(String str, char trimChar)
    {
            char[] charArray = str.toCharArray();
            int len = charArray.length;
            int index = 0;
            for(int i = 0; i < len; i++)
            {
                if(charArray[i] != trimChar)
                {
                    charArray[index] = charArray[i];
                    index++;
                }
            }
            return String.valueOf(charArray, 0, index);
    }


}