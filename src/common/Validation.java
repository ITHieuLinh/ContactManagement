package common;

public class Validation {

    private final String VALID_PHONE = "[(]?[0-9]{3}[)]?[-. ]?[0-9]{3}[-. ]?[0-9]{4}"
            + "|[0-9]{3}[-][0-9]{3}[-][0-9]{4}[ a-z0-9]+";

    //check input phone
    public boolean checkInputPhone(String phone) {
        if (phone.matches(VALID_PHONE)) {
            return true;
        }
        System.err.println("Please input Phone flow\n"
                + "• 1234567890\n"
                + "• 123-456-7890 \n"
                + "• 123-456-7890 x1234\n"
                + "• 123-456-7890 ext1234\n"
                + "• (123)-456-7890\n"
                + "• 123.456.7890\n"
                + "• 123 456 7890");
        return false;
    }
}
