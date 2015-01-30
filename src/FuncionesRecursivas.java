
import java.util.Scanner;

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
    
    public static int sumatoriaDown(int x){
        return sumatoriaDown(x, 0);
    }
    
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
    
    public static int powDown(int b, int e){
        return powDown(b, e, 1);
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
    
    public static int factorialDown(int x){
        return factorialDown(x, 1);
    }
    
    public static int factorialDown(int x, int fact){
        if(x>1)
            return factorialDown(x-1, x * fact);
        return fact;
    }
    
    public static String reversoUp(String pal){
        if(pal.length()>0)
            return pal.charAt(pal.length()-1) + reversoUp(pal.substring(0, pal.length()-1));
        return pal;
    }
    
    public static String reversoDown(String pal){
        return reversoDown(pal, "");
    }    
    public static String reversoDown(String pal, String pal2){
        if(pal.length()>1)
            return reversoDown(pal.substring(0, pal.length()-1), pal2 + pal.charAt(pal.length()-1));
        return pal2;
    }
    
    public static boolean prime(int x){
        return prime(x,2);
    }
    
    public static boolean prime(int x, int cont){
        if(x==1)
            return false;
        else if(cont < x){
            if(x%cont==0)
                return false;
            return prime(x, cont+1);
        }
        return true;
    }
    
    public static boolean palindrome(String pal){
        return palindrome(pal, 0, pal.length()-1);
    }
    
    public static boolean palindrome(String pal, int inicio, int fin){
        if(inicio<fin){
            if(pal.charAt(inicio) == pal.charAt(fin))
                return palindrome(pal, inicio+1, fin-1);
            return false;
        }
        return true;
    }
    
    public static void reveroInts(int x){
        if(x<10){
            System.out.println(x);
        }else{
            System.out.print(x%10);
            reveroInts(x/10);
        }
        
    }
    
    public static int maxComDiv(int n1, int n2){
        return maxComDiv(n1, n2, 2);
    }
    
    public static int maxComDiv(int n1, int n2, int div){
        if(n1>div && n2>div){
            if(n1%div==0 && n2%div==0){
                return div * maxComDiv(n1/div, n2/div, div);
            }else{
                return maxComDiv(n1, n2, div+1);
            }
        }
        return 1;
    }
    
    // 0 1 1 2 3 5 8 13 21 34 55 89 144
    // 0 1 2 3 4 5 6  7  8  9 10 11  12
    
    public static void fibonachi(int n1, int before, int after){
        if(before<n1){
            System.out.print(before+" ");
            fibonachi(n1, after, after+before);
        }
    }
    
    public static int fibonachi(int n){
        if(n>1){
            return fibonachi(n-1) + fibonachi(n-2);
        }
        return n;
    }
    
    public static int fibonachi(int n, int before, int after, int cont){
        if(cont<=n)
            return fibonachi(n, after, after+before, cont+1);
        return after;
    }
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        while(true){
            int n1,n2;
            String temp;
            
            System.out.println("\n\nSeleccione que operacion desea realizar.");
            System.out.printf("%s\n%s\n%s\n%s\n%s\n%s\n%s\n%s\n%s\n%s\n%s\n%s\n%s\n%s\n",
                    "1.  Factorial UP",
                    "2.  Factorial DOWN",
                    "3.  Pow UP",
                    "4.  Pow DOWN",
                    "5.  Sumatoria UP",
                    "6.  Sumatoria DOWN",
                    "7.  Voltear Palabras UP",
                    "8.  Voltear Palabras DOWN",
                    "9.  Voltear Nemeros",
                    "10. Es Primo",
                    "11. Es Palindrome",
                    "12. Maximo Comun Divisor",
                    "13. Fibonachi",
                    "14. Imprime el Fibonachi en la posicion",
                    "-1. Salir");
            System.out.print("Escoja du Opcion: ");
            switch(scan.nextInt()){
                case -1: System.exit(0);
                case 1: 
                    System.out.print("Ingrese un numero: ");
                    n1 = scan.nextInt();
                    System.out.println("Factorial de "+n1+": "+factorialUp(n1));
                    break;
                case 2: 
                    System.out.print("Ingrese un numero: ");
                    n1 = scan.nextInt();
                    System.out.println("Factorial de "+n1+": "+factorialDown(n1));
                    break;
                case 3: 
                    System.out.print("Ingrese la base: ");
                    n1 = scan.nextInt();
                    System.out.print("Ingrese el Exponente: ");
                    n2 = scan.nextInt();
                    System.out.println("Potencia: "+n1+"^"+n2+": "+powUp(n1, n2));
                    break;
                case 4: 
                    System.out.print("Ingrese la base: ");
                    n1 = scan.nextInt();
                    System.out.print("Ingrese el Exponente: ");
                    n2 = scan.nextInt();
                    System.out.println("Potencia: "+n1+"^"+n2+": "+powDown(n1, n2));
                    break;
                case 5: 
                    System.out.print("Ingrese un numero: ");
                    n1=scan.nextInt();
                    System.out.println("Sumatoria desde 1 a "+n1+": "+sumatoriaUp(n1));
                    break;
                case 6: 
                    System.out.print("Ingrese un numero: ");
                    n1=scan.nextInt();
                    System.out.println("Sumatoria desde 1 a "+n1+": "+sumatoriaDown(n1));
                    break;
                case 7: 
                    System.out.print("Ingrese una palabra: ");
                    temp = scan.next();
                    System.out.println("Palabra volteada: "+reversoUp(temp));
                    break;
                case 8: 
                    System.out.print("Ingrese una palabra: ");
                    temp = scan.next();
                    System.out.println("Palabra volteada: "+reversoDown(temp));
                    break;
                case 9: 
                    System.out.print("Ingrese un numero: ");
                    n1 = scan.nextInt();
                    if(n1<10)
                        System.out.println("Es de Un solo digito, no puede voltearse mas!");
                    else{
                        System.out.print("Numero volteado: ");
                        reveroInts(n1);
                    }
                    break;
                case 10: 
                    System.out.print("Ingrese un numero: ");
                    n1 = scan.nextInt();
                    if(prime(n1))
                        System.out.println(n1+" Es Primo!");
                    else
                        System.out.println(n1+" No es Primo!");
                    break;
                case 11: 
                    System.out.print("Ingrese una palabra: ");
                    temp = scan.next();
                    if(palindrome(temp))
                        System.out.println(temp+ " Es Palindrome!");
                    else
                        System.out.println(temp+ " No es Palindrome!");
                    break;
                case 12: 
                    System.out.print("Ingres dos numeros separados por espacio: ");
                    n1 = scan.nextInt(); n2 = scan.nextInt();
                    System.out.println("MCD de "+n1+" y "+n2+" es: "+maxComDiv(n1, n2));
                    break;
                case 13: //Imprime los fibonachis
                    System.out.print("Ingrese el Limite: ");
                    fibonachi(scan.nextInt(), 1, 1);
                    break;
                case 14: //Retorna el valor fibonachi
                    System.out.print("Ingrese la posicion del fibonachi: ");
                    n1 = scan.nextInt();
                    System.out.println("El Fibonachi de "+n1+" es: "+fibonachi(n1,0,1,2));
                    break;
            }
        }
    }
}
