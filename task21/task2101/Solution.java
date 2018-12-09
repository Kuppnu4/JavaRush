
package com.javarush.task.task21.task2101;

/* 
Определяем адрес сети
*/
public class Solution {
    public static void main(String[] args) {
        byte[] ip = new byte[]{(byte) 192, (byte) 168, 1, 2};
        byte[] mask = new byte[]{(byte) 255, (byte) 255, (byte) 254, 0};
        byte[] netAddress = getNetAddress(ip, mask);
        print(ip);          //11000000 10101000 00000001 00000010
        print(mask);        //11111111 11111111 11111110 00000000
        print(netAddress);  //11000000 10101000 00000000 00000000
    }

    public static byte[] getNetAddress(byte[] ip, byte[] mask) {
        byte[] netAdress = new byte[4];

        StringBuilder sb;
        for (int i = 0; i < ip.length; i++){
            sb = new StringBuilder();
            int a = ip[i]; int b = mask[i];
            a = a < 0 ? a + 256 : a;
            b = b < 0 ? b + 256 : b;
            for(int j = 0; j < 8; j++){
                int iP = a % 2; int mAsk = b % 2;
                byte aDres = (byte) (iP & mAsk);
                sb.append(aDres);
                a = a /2; b = b / 2;
            }
            int c = Integer.parseInt(sb.reverse().toString(), 2);
            netAdress[i] = (byte) c;
        }

        return netAdress;
    }



    public static void print(byte[] bytes) {
        System.out.println();
        for (int i = 0; i < bytes.length; i++){
            StringBuilder sb = new StringBuilder();
            int a = bytes[i];
            a = a < 0 ? a + 256 : a;
            for (int j = 0; j < 8; j++){
                int bYte = a % 2;
                sb.append(bYte);
                a = a / 2;
            }
            System.out.print(sb.reverse().toString() + " ");
        }


    }
}
