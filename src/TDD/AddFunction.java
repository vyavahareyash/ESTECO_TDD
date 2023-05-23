package TDD;

import java.text.DecimalFormat;
import java.util.List;
import ch.lambdaj.function.convert.Converter;
import static ch.lambdaj.Lambda.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AddFunction {
	public static String add(String number) {
		DecimalFormat decimalFormat = new DecimalFormat("#.##");
		if(number.isEmpty()) {
			return "0";			
		}
		else{
			String[] numbers = tokenize(number);			
			List<Float> nums = convert(numbers, getFloat());
			return String.valueOf(decimalFormat.format(sum(nums).floatValue()));
		}
	}
	
	public static String[] tokenize(String number) {
		if(number.startsWith("//")) {
			return splitWithCustomDelimiter(number);
		}else {
			return splitByNewlineComma(number);			
		}
	}
	
	public static String[] splitByNewlineComma(String number) {
		String[] tokens=number.split(",|\n");
		return tokens;
	}
	
	public static String[] splitWithCustomDelimiter(String number) {
		Matcher m =Pattern.compile("//(.*)\n(.*)").matcher(number);
		m.matches();
		String delimiter=m.group(1);
		String numbers=m.group(2);
		return numbers.split(Pattern.quote(delimiter));
	}
	
	public static Converter<String, Float> getFloat(){
		return new Converter<String, Float>(){ 
			public Float convert(String n) {
				return getFloat(n);
			}
		};
	}	
		
	public static Float getFloat(String num) throws NumberFormatException{
		return Float.parseFloat(num);
	}
}
