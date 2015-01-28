/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author KenyStev
 */
public class FuncionesRecursivas {
    
    public static int sumatoriaDown(int x, int suma){
        if(x>=1)
            return sumatoriaDown(x-1, suma + x);
        return suma;
    }
    
    public static int sumatoriaUp(int x){
        if(x>1)
            return x + sumatoriaUp(x-1);
        return x;
    }
    
    public static int powUp(int b, int e){
        if(e>0)
            return b * powUp(b, e-1);
        return 1;
    }
    
    public static int powDown(int b, int e, int pow){
        if(e>0)
            return powDown(b, e-1, pow*b);
        return pow;
    }
    
    public static int factorialUp(int x){
        if(x>1)
            return x * factorialUp(x-1);
        return 1;
    }
    
    public static int factorialDown(int x, int fact){
        if(x>1)
            return factorialDown(x-1, x * fact);
        return fact;
    }
    
    public static String palindromeUp(String pal){
        if(pal.length()>0)
            return pal.charAt(pal.length()-1) + palindromeUp(pal.substring(0, pal.length()-1));
        return pal;
    }
    
    public static String palindromeDown(String pal, String pal2){
        if(pal.length()>1)
            return palindromeDown(pal.substring(0, pal.length()-1), pal2 + pal.charAt(pal.length()-1));
        return pal2;
    }
    
    public static void main(String[] args) {
//        System.out.println("PowUp: 2^4: "+ powUp(2,4));
//        System.out.println("PowDown: 2^4: "+ powDown(2,4,1));
        
        System.out.println("Factorial Up: "+ factorialUp(5));
        System.out.println("Factorial Down: " + factorialDown(5, 1));
        
//        System.out.println("Palindrome Up: "+ palindromeUp("Hola"));
//        System.out.println("Palindrome Down: "+ palindromeDown("Hola", ""));
    }
}
