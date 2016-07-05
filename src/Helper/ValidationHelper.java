package Helper;

/**
 * Created by ajanthan on 2016-07-04.
 */
public class ValidationHelper {
    public static boolean isValidSquare(int x, int y) {
        if (x >= 0 && x <= 7 && y >= 0 && y <= 7) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isValidInput(String colourCode, String pieceCode, int x, int y) {
        if (isValidPieceCode(pieceCode) && ValidationHelper.isValidSquare(x, y) && isValidColourCode(colourCode)) {
            return true;
        } else {
            return false;
        }
    }

    private static boolean isValidPieceCode(String p) {
        if (p.toUpperCase().equals("K") || p.toUpperCase().equals("Q") || p.toUpperCase().equals("R") ||
                p.toUpperCase().equals("B") || p.toUpperCase().equals("N") || p.toUpperCase().equals("P")) {
            return true;
        } else {
            return false;
        }
    }

    private static boolean isValidColourCode(String c) {
        if (c.toUpperCase().equals("W") || c.toUpperCase().equals("B")) {
            return true;
        } else {
            return false;
        }
    }

}
