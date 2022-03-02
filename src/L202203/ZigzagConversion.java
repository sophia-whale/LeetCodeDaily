package L202203;

public class ZigzagConversion {
    public static void main(String[] args) {
        System.out.println(convert("Apalindromeisaword,phrase,number,orothersequenceofunitsthatcanbereadthesamewayineitherdirection,withgeneralallowancesforadjustmentstopunctuationandworddividers."
                , 2));
    }

    public static String convert(String s, int numRows) {
        char[] chars = s.toCharArray();
        int length = chars.length;
        if (numRows == 1 || numRows >= length) return s;
        int zNum = 2 * numRows - 2;
        char[][] char2D = new char[numRows][((length / zNum) + 1) * numRows];//
        for (int i = 0; i < length; i++) {
            int remain = i % zNum;
            int column = (i/zNum) * numRows;
            if (remain < numRows) {
                char2D[remain][column] = chars[i];
            } else {
                // numRows - (remain - numRows + 1) - 1
                char2D[2 * numRows - remain - 2][column + remain - numRows + 1] = chars[i];
            }
            /* else {(remain < 2 * numRows - 2)
                char2D[remain - 2 * numRows + 2][column + numRows - 1] = chars[i];
            }*/
        }

        StringBuffer stringBuffer = new StringBuffer();

        for (int i = 0; i < numRows; i++) {
            for (int j = 0 ;j < char2D[i].length; j++) {
                /*if (char2D[i][j] - 'A' >=0 && char2D[i][j] - 'A' <= 26) stringBuffer.append(char2D[i][j]);
                if (char2D[i][j] - 'a' >=0 && char2D[i][j] - 'z' <= 26) stringBuffer.append(char2D[i][j]);
                if (char2D[i][j] == '.' || char2D[i][j] == ',') stringBuffer.append(char2D[i][j]);*/
                if (char2D[i][j] != 0) stringBuffer.append(char2D[i][j]);
            }
        }

        return stringBuffer.toString();
    }
}
