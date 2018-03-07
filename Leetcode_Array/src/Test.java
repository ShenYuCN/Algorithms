import com.sun.tools.doclets.internal.toolkit.util.DocFinder;
import sun.print.SunMinMaxPage;

import javax.lang.model.util.ElementScanner6;
import javax.print.DocFlavor;
import java.awt.*;
import java.util.Map;

/**
 * Created by happiness on 2018/2/14.
 */
public class Test {

    public static void main(String args[]) {

        int i = 60;
        if (i > 80) {
            System.out.println("A");

        } else if (i > 60) {
            System.out.println("B");

        } else if (i > 40) {
            System.out.println("C");

        } else if (i > 20) {
            System.out.println("D");

        } else if (i > 60) {
            System.out.println("E");

        }
    }
}