package String;

/**
 * Created by happiness on 2018/10/30.
 */

public class S01_to_lower_case {
    public static void main(String args[]) {
        String str = "HeLLO";
        System.out.println(toLowerCase(str));

    }
    public static  String toLowerCase(String str) {
        char[] a = str.toCharArray();

        for (int i = 0; i < a.length; i++)
            if ('A' <= a[i] && a[i] <= 'Z')
                a[i] = (char) (a[i] - 'A' + 'a');
        return new String(a);

    }
}
