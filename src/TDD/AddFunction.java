package TDD;

import java.text.DecimalFormat;
import java.util.Collections;
import java.util.List;
import ch.lambdaj.function.convert.Converter;
import static ch.lambdaj.Lambda.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.ArrayList;

public class AddFunction {
	static DecimalFormat decimalFormat = new DecimalFormat("#.##");
	public static String add(String number) {
		String[] numbers = tokenize(number);			
		List<Float> nums = convert(numbers, getFloat());
		checkNegatives(nums);
		return String.valueOf(decimalFormat.format(sum(nums).floatValue()));
		
	}
	
	public static void checkNegatives(List <Float> nums) {
		List<String> negatives = new ArrayList<>();
        for (float num : nums) {
            if (num < 0) {
                negatives.add(decimalFormat.format(num));
            }
        }
        if(negatives.size()>0) {
        	throw new RuntimeException("Negative not allowed : "+join(negatives));
        }
	}
	
	public static String[] tokenize(String number) {
		if(number.isEmpty()) {
			return new String[0];
		}else if(number.startsWith("//")) {
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
