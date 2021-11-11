package com.leetcode;

public class StringXor {

    public void test() {




    }

    /*public static void main(String args[]){
        System.out.println("请输入一个英文字符串或解密字符串:");
        String password = "wwwwwwww";
        char[] array = password.toCharArray(); //获取字符数组
        for(int i=0;i<array.length;i++) //遍历字符数组
        {
            array[i]=(char)(array[i]^'4'); //对每个数组元素进行异或运算
        }
        System.out.println("加密或解密结果如下:");
        System.out.println(new String(array));
    }*/

    public static void main(String args[]){
        /*System.out.println("请输入一个英文字符串或解密字符串:");
        char password = '%';
        *//*char[] array = password.toCharArray(); //获取字符数组
        for(int i=0;i<array.length;i++) //遍历字符数组
        {
            array[i]=(char)(array[i]^'4'); //对每个数组元素进行异或运算
        }*//*
        char x = (char) (password ^ '!');
        System.out.println("加密或解密结果如下:");
        System.out.println(x);

        char y = (char) (x ^ '!');
        System.out.println("adadadad:");
        System.out.println(y);*/

        System.out.println("请输入一个英文字符串或解密字符串:");
        String password = "dfsfsfsf";
        String  aass = "aaaa";
        /*char[] array = password.toCharArray(); //获取字符数组
        for(int i=0;i<array.length;i++) //遍历字符数组
        {
            array[i]=(char)(array[i]^'4'); //对每个数组元素进行异或运算
        }*/
        System.out.println("加密或解密结果如下:");
        String s = aaaaa(password, aass);
        System.out.println(s);

        System.out.println("adadadad:");
        String y = aaaaa(s, aass);
        System.out.println(y);

    }

    public static String aaaaa(String h,String key) {
        int l1 = h.length();
        int l2 = key.length();
        String r = "";
        for (int i = 0; i < l1; i = i + l2) {
            int j = i + l2;
            if (j >= h.length())
                j = h.length();
            r += xor(h.substring(i, j), key);
        }
//        String s = Base64.encodeToString(r.getBytes(), Base64.DEFAULT);
        String s = new String(r);
        return s;
    }

    public static String xor(String s1, String s2) {
        /*byte b1[] = s1.getBytes();
        byte b2[] = s2.getBytes();
        byte lb[], sb[];
        lb = b1.length >= b2.length ? b1 : b2;
        sb = b1.length >= b2.length ? b2 : b1;
        byte rb[] = new byte[sb.length];
        int i = 0;
        for (; i < sb.length; i++) {
            rb[i] = (byte) (sb[i] ^ lb[i]);
        }
        return new String(rb);*/
//        byte b1[] = s1.getBytes();
//        byte b2[] = s2.getBytes();
        String lb, sb;
        lb = s1.length() >= s2.length() ? s1 : s2;
        sb = s1.length() >= s2.length() ? s2 : s1;
        char rb[] = new char[sb.length()];
        int i = 0;
        for (; i < sb.length(); i++) {
            char a = sb.charAt(i);
            char b = lb.charAt(i);
            int m = a^b;
            char n = (char) m;
            String kk = Integer.toHexString(n);
            String kk1 = Integer.toBinaryString(12);
            String kk2 = Integer.toHexString(12);
            String kk3 = Integer.toOctalString(12);
            String kk4 = Integer.toString(12);

            rb[i] = (char) ((int)sb.charAt(i) ^ (int)lb.charAt(i));
        }
        return new String(rb);
    }
}
