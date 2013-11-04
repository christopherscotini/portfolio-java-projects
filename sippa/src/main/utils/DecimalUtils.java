package utils;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

import exception.FormatException;


public final class DecimalUtils {

	public static final String DEFAULT_PATTERN = "#,##0.00";

	private DecimalUtils() {
		super();
	}

	public static String format(BigDecimal value) {
		if (value != null) {
			DecimalFormat formatter = getFormatter();
			formatter.applyPattern(DEFAULT_PATTERN);
			return formatter.format(value);
		}
		return "";
	}

	public static BigDecimal convert(String value) {
		if (value != null && !"".equals(value.trim())) {
			DecimalFormat formatter = getFormatter();
			formatter.applyPattern(DEFAULT_PATTERN);
			try {
				return (BigDecimal) formatter.parse(value);
			} catch (ParseException e) {
				throw new FormatException("Erro convertendo valor decimal.", e);
			}
		}
		return BigDecimal.ZERO;
	}

	private static DecimalFormat getFormatter() {
		DecimalFormat df = (DecimalFormat) NumberFormat.getInstance(new Locale ("pt", "BR"));
		df.setParseBigDecimal(true);
		return df;
	}
}
