package com.kingshuk.tddtraining;

public class ValidateISBN {

	public boolean checkIsbn(String isbn) {

		if(isbn.length()!=10){
			return false;
		}
		
		char [] isbnArray = isbn.toCharArray();
				
				int sumTotal = 0;
		
		for (int i = 0; i < isbnArray.length; i++) {
			//Just realized that we don't need to convert a character to an integer
			//By any additional steps. Have to revisit data types in java, soon
			sumTotal += isbnArray[i]*(isbnArray.length-i);
		}
		
		return sumTotal%11==0;
	}

}
