package TDD;

import java.text.DecimalFormat;
import java.util.List;
import ch.lambdaj.function.convert.Converter;
import static ch.lambdaj.Lambda.*;

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
		String[] tokens=number.split(",");
		return tokens;
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
