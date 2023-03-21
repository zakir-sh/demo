package com.mybank.demo.util;

import java.math.BigDecimal;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

import com.mybank.demo.dto.DowJonesData;

public class DowJonesUtils {
	
	public static DowJonesData transform(String clientId, String[] val){
		DowJonesData data = new DowJonesData(
				clientId,
				NumberUtils.toInt(val[0]),
				val[1],
				formatDate(val[2]),
				bigDecimalNullCheck(val[3]),
				bigDecimalNullCheck(val[4]),
				bigDecimalNullCheck(val[5]),
				bigDecimalNullCheck(val[6]),
				NumberUtils.toInt(val[7]),
				bigDecimalNullCheck(val[8]),
				bigDecimalNullCheck(val[9]),
				NumberUtils.toInt(val[10]),
				bigDecimalNullCheck(val[11]),
				bigDecimalNullCheck(val[12]),
				bigDecimalNullCheck(val[13]),
				NumberUtils.toInt(val[14]),
				bigDecimalNullCheck(val[15])
				);
		return data;
	}
	
	public static String formatDate(String str){
		StringBuilder sb = new StringBuilder();
		String [] strArr = StringUtils.split(str, "/");
		if(strArr[0].length() == 1){
			sb.append("0");
		}
		sb.append(strArr[0]);
		sb.append("/");
		if(strArr[1].length() == 1){
			sb.append("0");
		}
		sb.append(strArr[1]);
		sb.append("/");
		sb.append(strArr[2]);
		return sb.toString();
	}
	
	public static BigDecimal bigDecimalNullCheck(String val){
		try{
			val = StringUtils.strip(val, "$");
			return NumberUtils.createBigDecimal(val);
		}
		catch(Exception e){
			return null;
		}
	}
	
}
