/**
 * Copyright (C) 2017 Whyle-Laboratory  
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 **/
package android.whyle.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import java.text.DecimalFormat;
import java.util.Locale;

/**
 * @Modify Whyle
 * Support Chinese holiday
 */
public class WhyleUtils
{
    /**
	 *    2018 Chinese Holidays
	 *    These below numbers are the days of the holiday.
	 **/
    private static final int YEAR = 2018;
    private static final int[] JANH = {1}; // January
    private static final int[] FEBH = {15, 16, 17, 18, 19, 20, 21}; // February
    //private static final int[] MARH = {0}; // March
	private static final int[] APRH = {5, 6, 7, 29, 30}; // April
    private static final int[] MAYH = {1}; // May
    private static final int[] JUNH = {16, 17, 18}; // June
	//private static final int[] JULH = {0}; // July
	//private static final int[] AUGH = {0}; // August
    private static final int[] SEPH = {22, 23, 24}; // September
    private static final int[] OCTH = {1, 2, 3, 4, 5, 6, 7}; // October
	//private static final int[] NOVH = {0}; // November
	//private static final int[] DECH = {0}; // December


	/**
	 * @Method isSupportLanguage(Context)
	 * @Return boolean
	 *
	 * Use for checking current language and country.
	 **/
	public static boolean isSupportLanguage(Context mContext)
	{
        Locale locale = mContext.getResources().getConfiguration().locale;
		String language = locale.getLanguage();
        String country = locale.getCountry();
        return language.equals("zh") || country.equals("CN");
    }

	/**
	 * @Method isChineseHoliday(int,int,int)
	 * @Return boolean
	 *
	 * Use for checking All Day.
	 **/
    public static boolean isChineseHoliday(int years, int months, int days)
	{
		// Default value of holiday
        boolean IsHoliday = false;
		// Last year Dicember 31st
        if (years == YEAR - 1 && months == 12 && days == 31) 
			return true;
		// Isn't this year
		if (years != YEAR)
			return false;
		// Check one for one, if it's a holiday
		switch (months)
		{
			case 1:
				for (int day:JANH)
				{
					if (days == day) 
						IsHoliday = true;
				}
				break;
			case 2:
				for (int day:FEBH)
				{
					if (days == day) 
						IsHoliday = true;
				}
				break;
			case 3:
				break;
			case 4:
				for (int day:APRH)
				{
					if (days == day) 
						IsHoliday = true;
				}
				break;
			case 5:
				for (int day:MAYH)
				{
					if (days == day) 
						IsHoliday = true;
				}
				break;
			case 6:
				for (int day:JUNH)
				{
					if (days == day) 
						IsHoliday = true;
				}
				break;
			case 7:
				break;
			case 8:
				break;
			case 9:
				for (int day:SEPH)
				{
					if (days == day) 
						IsHoliday = true;
				}
				break;
			case 10:
				for (int day:OCTH)
				{
					if (days == day) 
						IsHoliday = true;
				}
				break;
			case 11:
				break;
			case 12:
				break;
		}
        return IsHoliday;
    }
}
