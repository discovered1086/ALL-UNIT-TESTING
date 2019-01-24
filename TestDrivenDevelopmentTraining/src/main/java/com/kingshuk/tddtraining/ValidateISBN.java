package com.kingshuk.tddtraining;

public class ValidateISBN {

	public boolean checkIsbn(String isbn) {

		
		if(isbn.length()!=10){
			return false;
		}
		
		char [] isbnArray = isbn.toCharArray();
				
		int multiplier = 10;
		
		int sumTotal = 0;
		
		for (int i = 0; i < isbnArray.length; i++) {
			int digit = Character.getNumericValue(isbnArray[i]);
			
			sumTotal += digit*multiplier;
			
			multiplier--;
		}
		
		return sumTotal%11==0;
	}

}
