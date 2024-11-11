package com.yuuki.local;

/**
 * @brief Convert year between the Western and Japanese calendars.
 * @author　Yuuki Tatsuya
 * @version　1.0
 * @history Created by Yuuki on October 27th, 2024.
 */
public class ConvertYear {

	/**
	 * @summary Constant values for each imperial era.
	 */
	public static final int SEIREKI = 1;
	public static final int MEIJI = 2;
	public static final int TAISHO = 3;
	public static final int SHOWA = 4;
	public static final int HEISEI = 5;
	public static final int REIWA = 6;
	
	/**
	 * @summary ERROR code.
	 */
	public static final int ERROR = -1;
	
	/**
	 * @summary Names of each imperial era.
	 */
	public static final String S_SEIREKI = "西暦";
	public static final String S_MEIJI = "明治";
	public static final String S_TAISHO = "大正";
	public static final String S_SHOWA = "昭和";
	public static final String S_HEISEI = "平成";
	public static final String S_REIWA = "令和";
	
	public static final String S_GANNEN = "元年";
	public static final String S_YEAR = "年";
	
	// 明治	1868 - 1912 ( - 45)
	public static final int MEIJI_1 = 1868;
	public static final int MEIJI_LAST = 45;
	// 大正	1912 - 1926 ( - 15)
	public static final int TAISHO_1 = 1912;
	public static final int TAISHO_LAST = 15;
	// 昭和	1926 - 1989 ( - 64)
	public static final int SHOWA_1 = 1926;
	public static final int SHOWA_LAST = 64;
	// 平成	1989 - 2019 ( - 31)
	public static final int HEISEI_1 = 1989;
	public static final int HEISEI_LAST = 31;
	// 令和	2019 - 2118（仮） ( - 100（仮）)
	public static final int REIWA_1 = 2019;
	public static final int REIWA_LAST = 100;

	public static final int NEXT_1 = 2119;

	/**
	 * @summary First year(GANNEN) of each imperial era.
	 */
	public static final String S_MEIJI_GANNEN = S_MEIJI + S_GANNEN;
	public static final String S_TAISHO_GANNEN = S_MEIJI + String.valueOf(MEIJI_LAST) + S_YEAR + "/" + S_TAISHO + S_GANNEN;
	public static final String S_SHOWA_GANNEN = S_TAISHO + String.valueOf(TAISHO_LAST) + S_YEAR + "/" + S_SHOWA + S_GANNEN;
	public static final String S_HEISEI_GANNEN = S_SHOWA + String.valueOf(SHOWA_LAST) + S_YEAR + "/" + S_HEISEI + S_GANNEN;
	public static final String S_REIWA_GANNEN = S_HEISEI + String.valueOf(HEISEI_LAST) + S_YEAR + "/" + S_REIWA + S_GANNEN;
	
	/**
	 * @summary Error messages.
	 */
	public static final String S_BEFORE_MEIJI = S_MEIJI + "以前";
	public static final String S_NEXT_X = "未来すぎて不明";
	public static final String S_CV_ERROR = "変換エラー";
	
	/**
	 * @brief Convert year between the Western and Japanese calendars.
	 * @param  year      number of the year.
	 * @param  selected  SEIREKI
	 *                   MEIJI
	 *                   TAISHO
	 *                   SHOWA
	 *                   HEISEI
	 *                   REIWA
	 * @return　Converted result string.
	 */
	public String convert(int year, int selected) {
		String str = "";
		if (selected == SEIREKI) {
			int tmp = 0;
			if (year < MEIJI_1) {
				str = S_BEFORE_MEIJI;
			// 明治	1868 - 1912 ( - 45)
			} else if (year == MEIJI_1) {
				str = S_MEIJI_GANNEN;
			} else if (year < TAISHO_1) {
				tmp = seirekiToWareki(year, MEIJI_1);
				str = S_MEIJI + String.valueOf(tmp) + S_YEAR;
			// 大正	1912 - 1926 ( - 15)
			} else if (year == TAISHO_1) {
				str = S_TAISHO_GANNEN;
			} else if (year < SHOWA_1) {
				tmp = seirekiToWareki(year, TAISHO_1);
				str = S_TAISHO + String.valueOf(tmp) + S_YEAR;
			// 昭和	1926 - 1989 ( - 64)
			} else if (year == SHOWA_1) {
				str = S_SHOWA_GANNEN;
			} else if (year < HEISEI_1) {
				tmp = seirekiToWareki(year, SHOWA_1);
				str = S_SHOWA + String.valueOf(tmp) + S_YEAR;
			// 平成	1989 - 2019 ( - 31)
			} else if (year == HEISEI_1) {
				str = S_HEISEI_GANNEN;
			} else if (year < REIWA_1) {
				tmp = seirekiToWareki(year,HEISEI_1);
				str = S_HEISEI + String.valueOf(tmp) + S_YEAR;
			// 令和	2019 -      ( - )
			} else if (year == REIWA_1) {
				str = S_REIWA_GANNEN;
			} else if (year < NEXT_1) {
				tmp = seirekiToWareki(year, REIWA_1);
				str = S_REIWA + String.valueOf(tmp) + S_YEAR;
			} else {
				str = S_NEXT_X;
			}			
		} else {
			int ret = 0;
			switch(selected) {
			case MEIJI:
				ret = warekiToSeireki(year, MEIJI_LAST, MEIJI_1);
				break;
			case TAISHO:
				ret = warekiToSeireki(year, TAISHO_LAST, TAISHO_1);
				break;
			case SHOWA:
				ret = warekiToSeireki(year, SHOWA_LAST, SHOWA_1);
				break;
			case HEISEI:
				ret = warekiToSeireki(year, HEISEI_LAST, HEISEI_1);
				break;
			case REIWA:
				ret = warekiToSeireki(year, REIWA_LAST, REIWA_1);
				break;
			default:
				ret = ERROR;
				break;
			}
			
			if (ret != ERROR) {
				str = S_SEIREKI + String.valueOf(ret) + S_YEAR;
			} else {
				str = S_CV_ERROR;
			}
		}
		return str;
	}
	
	/**
	 * @brief Convert Japanese calendar to Western one.
	 * @param  year      number of the year.
	 * @param  lastYear  the last western year of each imperial era.
	 * @param  firstYear the first western year of each imperial era.
	 * @return　converted western year.
	 *          ERROR if converting error occurred.
	 */
	private int warekiToSeireki(int year, int lastYear, int firstYear) {
		int ret = 0;
		if ((1 <= year) && (year <= lastYear)) {
			ret = year + firstYear - 1; 
		} else {
			ret = ERROR;
		}
		return ret;
	}
	
	/**
	 * @brief Convert Western calendar to Japanese one.
	 * @param  year      number of the year.
	 * @param  firstYear the first western year of each imperial era.
	 * @return　converted Japanese year.
	 */
	private int seirekiToWareki(int year, int firstYear) {
		return (year - firstYear + 1);
	}
}
