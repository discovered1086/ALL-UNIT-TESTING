package mypractice.unittesting.junit;

/**
 * Created with IntelliJ IDEA.
 * User: co21321
 * Date: 8/11/16
 * Time: 12:37 PM
 * To change this template use File | Settings | File Templates.
 */
public class PlayingWithString {
    public static void main(String[] args) {
        System.out.println("The Fax Number is " + new PlayingWithString().returnFaxNumber("FAX (866) 411-5613"));
    }

    public String returnFaxNumber(String faxNumber) {
        String regularexpression = ("[^0-9]");
        String finalFaxNumber = null;
        if (faxNumber.indexOf("1-") > -1) {
            int i = faxNumber.indexOf("1-");
            if (i == 0) {
                faxNumber = faxNumber.substring(i + 1);
            }
        }
        finalFaxNumber = faxNumber.replaceAll(regularexpression, "").trim();
        return finalFaxNumber;
    }
}
