/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicing.test2;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ronescape
 */
public class Serial {

    public static void main(String[] args) {
        String serial_ib = "9QG9CA69\n"
                + "0QGA1AXJ\n"
                + "9QGA26LX\n"
                + "9QGADGJC\n"
                + "9QGAAEGT\n"
                + "9QG8NT6T\n"
                + "9QG8NT75\n"
                + "9QG83W35\n"
                + "9QG8RWXL\n"
                + "5QG15K82\n"
                + "9QGA4T89\n"
                + "9QG942Y3\n"
                + "5QG2S9KY\n"
                + "9QGA80F2\n"
                + "9QG9QSVY\n"
                + "9QGA91J5\n"
                + "9QGA5W7Y\n"
                + "9QGA7M5A\n"
                + "9QG9KA0A\n"
                + "9QGA60KV\n"
                + "9QGA03XM\n"
                + "9QGA1FY6\n"
                + "5QG2KQ75\n"
                + "5QG2M6KC\n"
                + "5QG2P65S\n"
                + "5QG2CJF3\n"
                + "5QG2E8E6\n"
                + "9QGABER4\n"
                + "5QG2P5MQ\n"
                + "9QG9PXK7\n"
                + "5QG2YB0Q\n"
                + "9QGA1W3N\n"
                + "9QGA3BV0\n"
                + "9QGA2PGM\n"
                + "9QGA2N7S\n"
                + "9QG95RKN\n"
                + "5QG2ZAAR\n"
                + "9QG9QZ47\n"
                + "5QG2P3J0\n"
                + "9QGA6DAT\n"
                + "\n"
                + "9QG9A9NF\n"
                + "9QGA5WKR\n"
                + "9QGA1W9E\n"
                + "5QG2T1NF\n"
                + "9QGA33LA\n"
                + "9QGA3E7Y\n"
                + "9QG9F2V9\n"
                + "9QGA4TWA\n"
                + "9QG8Y8KA\n"
                + "5QG2NW16\n"
                + "5QG2CPWC\n"
                + "9QG99W8Z\n"
                + "9QG8Y15Q\n"
                + "9QGA0691\n"
                + "9QGA7NHG\n"
                + "9QGADG0E\n"
                + "9QG9ZLHE\n"
                + "9QG9VK96\n"
                + "9QGA3ENW\n"
                + "9QG9PXEQ\n"
                + "9QGA7509\n"
                + "9QG93GBH\n"
                + "9QGA2QWM\n"
                + "9QG8DHPC\n"
                + "9QGA34EV\n"
                + "9QG91L1A\n"
                + "9QGAAEZK\n"
                + "9QG8PH01\n"
                + "9QG8Z2YF\n"
                + "5QG2PJG1\n"
                + "9QG9TYAH\n"
                + "9QGA4V4W\n"
                + "9QG9XY5H\n"
                + "5QG2G7E6\n"
                + "9QGA5BX3\n"
                + "9QG9TBQL\n"
                + "5QG2NB7J\n"
                + "5QG2KANH\n"
                + "9QG966BD\n"
                + "9QGA35KJ\n"
                + "9QGA4WA1\n"
                + "5QG2LAAJ\n"
                + "9QGA2NXN\n"
                + "5QG2VYHK\n"
                + "9QG9411Q\n"
                + "9QGA5VHS\n"
                + "9QG8VM5Q\n"
                + "9QG9THW1\n"
                + "9QGA8ZGH\n"
                + "9QGA8KXL\n"
                + "5QG2KQD9\n"
                + "5QG2VXEE\n"
                + "9QGADWV2\n"
                + "9QGADB47\n"
                + "9QG9X18B\n"
                + "9QG9K47C\n"
                + "9QGAE8ND\n"
                + "9QGACP03\n"
                + "9QG8Z34D\n"
                + "9QGA99LZ";

        String serial_si = "9QG9F1AQ\n"
                + "9QG8JDG5\n"
                + "9QG9PZ03\n"
                + "9QGA2ENN\n"
                + "9QGA2N9N\n"
                + "9QGA732C\n"
                + "9QGA5TNZ\n"
                + "5QG331HH\n"
                + "9QGAL025\n"
                + "9QGA9C0Q\n"
                + "5QG2GMGJ\n"
                + "9QGA1L6F\n"
                + "9QG986PZ\n"
                + "9QGA245S\n"
                + "9QG90TWT\n"
                + "9QGA99LZ\n"
                + "9QG9K47C";

        System.out.println(remove_duplicates(serial_ib, serial_si));
    }

    public static String remove_duplicates(String s1, String s2) {
        String[] s_ib = s1.split("\n");
        String[] s_si = s2.split("\n");
        List<String> new_list = new ArrayList();
//        System.out.println("s_ib: " + s_ib.length);
        for (String s : s_ib) {
            int ii = 0;

            for (String t : s_si) {
                if (s.equalsIgnoreCase(t)) {
                    ii = 1;
                    break;
                }
            }
            if (ii == 0) {
                if (s.isEmpty() || s.equals("") || s.equals("") || s.equals("\n")) {
                } else {
                    new_list.add(s);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (String s : new_list) {
            sb.append(s + ", ");

        }

        return sb.toString();
    }
}
