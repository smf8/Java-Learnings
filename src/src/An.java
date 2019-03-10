import java.util.ArrayList;
import java.util.Scanner;

public class An {


    public static void main(String[] args) {
//        ArrayList<String> str=new ArrayList<String>();
        Scanner scan = new Scanner(System.in);
//        str.add(scan.next());
//        System.out.println(str.get(0));
        String str = scan.next();
        str = str.replace("-", "#-");
        String[] res = str.split("[+#]");
        ArrayList<String> sign = new ArrayList<>();
        ArrayList<String> pow = new ArrayList<>();
        int s = 0;
        if (res[0].equals("")) s++;
//        for (int i = 0; i < res.length; i++)
//            System.out.println(res[i]);
//        System.out.println("res.l=" + res.length);
        boolean flag = true;
        for (int i = s; i < res.length; i++) {
            if (res[i].contains("x^")) {
                for (int j = 0; j < res[i].length(); j++) {
                    if (res[i].charAt(j) == 'x') {
                        if (res[i].charAt(0) == 'x')
                            sign.add("1");
                        else if (res[i].charAt(0) == '-' && res[i].charAt(1) == 'x') {
                            sign.add("-1");
                        } else
                            sign.add(res[i].substring(0, j));
//                            System.out.println("*&&");
                        int t=res[i].length();
                        pow.add(res[i].substring(j + 2, t));
//                            flag=false;
                    }
//                    System.out.println(sign.get(i));
//                    if(!flag) break;
                }
            } else if (res[i].contains("x")) {
                for (int j = 0; j < res[i].length(); j++) {
                    if (res[i].charAt(j) == 'x') {
                        if (res[i].charAt(0) == 'x') {
                            sign.add("1");
//                            System.out.println("*&");
                        } else if (res[i].charAt(0) == '-' && res[i].charAt(1) == 'x') {
                            sign.add("-1");
//                            System.out.println("*****");
                        } else
                            sign.add(res[i].substring(0, j));
//                            System.out.println("***");
                        pow.add("1");

                    }
                }
            }
            if (!res[i].contains("x^") && !res[i].contains("x")) {
//                        if (res[i].charAt(0) == '-') {
//                            int t=res[i].length();
                sign.add(res[i]);
//                    System.out.println("**");
//                    System.out.println("res{i}=" + res[i]);
                pow.add("0");
//                        }
//                        else {
//                            sign.add(res[i]);
//                            System.out.println("*");
//                            pow.add("0");
//                        }
            }
        }
        ArrayList<Double> sign1 = new ArrayList<>();
        ArrayList<Integer> pow1 = new ArrayList<>();

        for (int i = 0; i < sign.size(); i++) {
            sign1.add(Double.parseDouble(sign.get(i)));
            pow1.add(Integer.parseInt(pow.get(i)));
//            pow1.set(i, pow1.get(i) + 1);
//            sign1.set(i, sign1.get(i) / pow1.get(i));
        }
//        for (int i = 0; i < res.length-s; i++) {
//            System.out.println(sign1.get(i));
//            System.out.println(pow1.get(i));
//        }
//        System.out.println("res:" + sign.size());
//        int t = pow1.size() - 1;
//        boolean flag1 = true;
//        while (flag) {
////            flag = false;
//            for (int i = 0; i < pow1.size()-1; i++) {
////                System.out.println("alkfj:" + pow1.size());
////                flag=false;
//                if (pow1.get(i) < pow1.get(i + 1)) {
//                    int temp = pow1.get(i);
//                    pow1.set(i, pow1.get(i + 1));
//                    pow1.set(i + 1, temp);
//                    double tempf = sign1.get(i);
//                    sign1.set(i, sign1.get(i + 1));
//                    sign1.set(i + 1, tempf);
//                    flag1 = true;
////                    System.out.println(sign1.get(i));
//                }
//            }
//
//        }
        //lpkmfadffajkflag=true;
        //ewfkqwdf,adq
////        for(int i=0;i<)
//        afklkaflak

        for (int j = 0; j < sign1.size() - 1; j++) {
            for (int i = 0; i < sign1.size() - j - 1; i++) {
                if (pow1.get(i) < pow1.get(i + 1)) {
                    int temp = pow1.get(i);
                    pow1.set(i, pow1.get(i + 1));
                    pow1.set(i + 1, temp);
                    double tempf = sign1.get(i);
                    sign1.set(i, sign1.get(i + 1));
                    sign1.set(i + 1, tempf);
//                    flag1 = true;
////                    System.out.println(sign1.get(i));
//                }
                    //hkgbgvsf.
                }
                else if (pow1.get(i) == pow1.get(i + 1)) {
//                    System.out.println("miad");
//                    System.out.println("jam=" + sign1.get(i) + "+" + sign1.get(i + 1) + "=" + (sign1.get(i) + sign1.get(i + 1)));
                    sign1.set(i, sign1.get(i) + sign1.get(i + 1));
                    pow1.remove(i + 1);
                    sign1.remove(i + 1);
                    i--;
                    flag = true;
                }
            }
        }
        for(int i=0;i<pow1.size();i++){
            pow1.set(i, pow1.get(i) + 1);
            sign1.set(i, sign1.get(i) / pow1.get(i));
        }
//        while (flag) {
//            flag = false;
//            for (int i = 0; i < pow1.size()-1; i++) {
//                if (pow1.get(i) == pow1.get(i + 1)) {
////                    System.out.println("miad");
////                    System.out.println("jam=" + sign1.get(i) + "+" + sign1.get(i + 1) + "=" + (sign1.get(i) + sign1.get(i + 1)));
//                    sign1.set(i, sign1.get(i) + sign1.get(i + 1));
//                    pow1.remove(i + 1);
//                    sign1.remove(i + 1);
//                    i--;
//                    flag = true;
//                }
//            }
//        }
//        for (int i = 0; i < pow1.size(); i++) {
//            System.out.println(pow1.get(i));
//            sign1.set(i, double.valueOf(String.format("%.2f", sign1.get(i))));
//            System.out.println(sign1.get(i));
//        }
//        for(int i=0;i<pow1.size();i++){
//            system.print
//        }
//        for(int i=0;i<sign1.size();i++){
//             if(sign1.get(i)<0){
//                 sign1.set(i,Math.abs(sign1.get(i)));
//             }
//        }
        for(int i=0;i<sign1.size();i++){
            if(sign1.get(i)==0){
                sign1.remove(i);
                pow1.remove(i);
                i--;
            }
        }
        //kfanjf al;a
        for (int i = 0; i < pow1.size(); i++) {
            if((int)(sign1.get(i) * 100) != 0){
//            if (sign1.get(i) != 0) {
                double signs = sign1.get(i);
                if (signs == (int) signs) {
//                for (int j = 0; j < pow1.size(); j++) {
//                sign1.set(i,Integer.parseInt(signs));
                    if (signs >= 0 && i != 0) {
                        System.out.print("+");
                    }
                    if (pow1.get(i) != 1  && (signs != 1 && signs!=-1))
                        System.out.printf("%.0fx^%d", signs, pow1.get(i));
                    else if (signs != 1 && signs!=-1 && pow1.get(i) == 1) {
                        System.out.printf("%.0fx", signs);
                    } else if (signs == 1  && pow1.get(i) == 1)
                        System.out.print("x");
                    else if(signs==-1 && pow1.get(i)==1){
                        System.out.print("-x");
                    }
                    else if(pow1.get(i)!=1 && signs==1){
                        System.out.print("x^" + pow1.get(i));
                    }
                    else if(pow1.get(i)!=1 && signs==-1)
                        System.out.print("-x^" + pow1.get(i));

//                }
                }
                else if (signs * 10 == (int)(signs * 10)) {
//                for (int j = 0; j < pow1.size(); j++) {
                    if (signs >= 0 && i != 0) {
                        System.out.print("+");
                    }
                    if (pow1.get(i) != 1 && signs != 1)
                        System.out.printf("%.1fx^%d", signs, pow1.get(i));
                    else if (signs != 1 && pow1.get(i) == 1) {
                        System.out.printf("%.1fx", signs);
                    } else if (signs == 1 && pow1.get(i) == 1)
                        System.out.print("x");
                    else {
                        System.out.print("x^" + pow1.get(i));
                    }
//                }
                }

//            else if()
                else {

//                for (int j = 0; j < pow1.size(); j++) {
                    if (signs >= 0 && i !=0 ) {
                        System.out.print("+");
                    }
                    if (pow1.get(i) != 1 && signs != 1) {
                        double zarib = Math.abs(signs);
//                        System.out.println(zarib);
                        if (signs > 0){
                            System.out.printf("%.2fx^%d", (int)(zarib * 100) / (double)100, pow1.get(i));
                        }else{
                            System.out.printf("-%.2fx^%d", (int)(zarib * 100) / (double)100, pow1.get(i));
                        }
                    }else if (signs != 1 && pow1.get(i) == 1) {
                        System.out.printf("%.2fx", (int)(signs*100) / (double) 100);
                    } else if (signs == 1 && pow1.get(i) == 1)
                        System.out.print("x");
                    else {
                        System.out.print("x^" + pow1.get(i));
                    }
                }
            }
//        }
        }
    }
}
//}