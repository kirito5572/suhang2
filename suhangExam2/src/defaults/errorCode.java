package defaults;

public class errorCode {
    private static int errorCode;

    public static String errorCode(int error) {
        errorCode = error;
        return errorCodeFind();
    }
    public static String errorCodeFind() {
        String errorText;
        switch (errorCode) {
            case 001: errorText = "This error need to report. I'm sorry"; break;
            case 501: errorText = "Only type number, don't type language"; break;
            default: errorText = null; break;
        }
        return Integer.toString(errorCode) + "    " + errorText;
    }
}
