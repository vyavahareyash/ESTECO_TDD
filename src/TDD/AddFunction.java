package TDD;

import java.text.DecimalFormat;

public class AddFunction {
	public static String add(String number) {
		DecimalFormat decimalFormat = new DecimalFormat("#.##");
		if(number.isEmpty()) {
			return "0";			
		}
		else if(number.contains(",")) {
			String[] numbers = number.split(",");
			return String.valueOf(decimalFormat.format(getFloat(numbers[0])+getFloat(numbers[1])));
			
		}
		else {
			return number;
		}
	}
	
	public static Float getFloat(String num) throws NumberFormatException{
		return Float.parseFloat(num);
	}
}
