package com.kingshuk.testing.practice.test;

public class StringTest {
	public StringTest() {
    }

    public static void main(String[] args) {
        String str = null;
        System.out.println("The returned string is " + new StringTest().checkEmptydata(str));
    }


    public String checkEmptydata(Object obj) {
        String writeValue = null;
        writeValue = (String) obj;
        writeValue=writeValue.trim();
            /*if (obj == null)
                writeValue = "";
            else
                writeValue = (String) obj;*/
            if(writeValue.length() == 0) {
                throw new IllegalArgumentException();
            }

         /*  if (obj == null)
                writeValue = "";
            else
                writeValue = obj.toString();  */

        return writeValue;
    }
}
