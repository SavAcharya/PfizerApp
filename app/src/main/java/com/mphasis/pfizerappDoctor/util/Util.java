package com.mphasis.pfizerappDoctor.util;

import java.io.UnsupportedEncodingException;

/**
 * Created by Sourav.Bhattacharya on 1/17/2017.
 */

public class Util {

    private static final char[] HEX_CHARS = "0123456789abcdef".toCharArray();


    public static String stringToHex(String input) throws UnsupportedEncodingException
    {
        if (input == null) throw new NullPointerException();
        return asHex(input.getBytes());
    }

    public static String hexToString(String txtInHex)
    {
        byte [] txtInByte = new byte [txtInHex.length() / 2];
        int j = 0;
        for (int i = 0; i < txtInHex.length(); i += 2)
        {
            txtInByte[j++] = Byte.parseByte(txtInHex.substring(i, i + 2), 16);
        }
        return new String(txtInByte);
    }

    private static String asHex(byte[] buf)
    {
        char[] chars = new char[2 * buf.length];
        for (int i = 0; i < buf.length; ++i)
        {
            chars[2 * i] = HEX_CHARS[(buf[i] & 0xF0) >>> 4];
            chars[2 * i + 1] = HEX_CHARS[buf[i] & 0x0F];
        }
        return new String(chars);
    }

    public static String maskPrivateKeyNumber(String cardNumber, String mask) {

        // format the number
        int index = 0;
        StringBuilder maskedNumber = new StringBuilder(cardNumber);
        maskedNumber.replace(5,(cardNumber.length()-4),"XXXX........XXXXX");
        /*
        maskedNumber.replace(0,(cardNumber.length()-4),"X");
        for (int i = 0; i < cardNumber.length(); i++) {
            if (i>3&&i<(cardNumber.length()-4)){
                maskedNumber.setCharAt(i,'X');
            }
            char c = cardNumber.charAt(i);
            if (c == '#') {
                maskedNumber.append(cardNumber.charAt(index));
                index++;
            } else if (c == 'x') {
                maskedNumber.append(c);
                index++;
            } else {
                maskedNumber.append("x");
            }
        }
*/
        // return the masked number
        return maskedNumber.toString();
    }

}
