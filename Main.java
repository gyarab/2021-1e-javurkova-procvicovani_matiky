package com.company;
import java.util.Scanner;
import java.util.Random;
import java.io.IOException;
import java.util.InputMismatchException;


public class Main {

    public static void main(String[] args) {

        System.out.println("PROCVIČOVÁNÍ MATEMATIKY");
        System.out.println("Můžete si zadat typ operace, po vypočítání 10ti příkladu správně Vám oznámim procentní úspěšnost");

        System.out.println();

        Scanner sc = new Scanner(System.in);
        Boolean cyklus=true;
        int nejmensiCislo;
        int nejvetsiCislo;

        do{
            System.out.print("Zadejte nejmenší celé číslo se kterým chcete pracovat: ");
            nejmensiCislo= sc.nextInt();

            System.out.print("Zadejte největší celé číslo se kterým chcete pracovat: ");
            nejvetsiCislo= sc.nextInt();

            if(nejmensiCislo>=nejvetsiCislo){
                System.out.println("Nejmenší číslo musí být menší než to největší, zadejte znova.");
            }
            else{
                cyklus=false;
            }
            System.out.println();
        }while(cyklus);

        int operace;

        do{
            System.out.println("Dostupné operace se kterýma můžete pracovat:");
            System.out.println("sčítání 1");
            System.out.println("odečítaní 2");
            System.out.println("násobení 3");
            System.out.println("dělení 4");
            System.out.println("umocnění na druhou");
            System.out.println("mix všech operací 6");
            System.out.print("Vaše zvolená operace: ");
            operace= sc.nextInt();

            if(operace<1 | operace>6){
                System.out.println("Tato operace není v nabídce, zadejte znova.");
                System.out.println();
            }
            else{
                cyklus=true;
            }
        }while(cyklus==false);

        System.out.println();
        Random rand = new Random();
        int pocetPrikladu;

        for(int uspesnost=0;uspesnost<10;){
            int prvniCislo=rand.nextInt(nejvetsiCislo+1);
            do{
                if(prvniCislo<nejmensiCislo){
                    prvniCislo=rand.nextInt(nejvetsiCislo+1);
                }
                else{
                    cyklus=true;
                }
            }while(cyklus==false);

            int druheCislo=rand.nextInt(nejvetsiCislo+1);
            do{
                if(druheCislo<nejmensiCislo){
                    druheCislo=rand.nextInt(nejvetsiCislo+1);
                }
                else{
                    cyklus=false;
                }
            }while(cyklus);

            int uzivateluvVysledek;
            int spravnyVysledek;

            /*if(operace==1){
                if(druheCislo<0){
                    System.out.print(prvniCislo+" + ("+druheCislo+") =");
                }

            }*/
            System.out.println(prvniCislo);
            System.out.println(druheCislo);


        }



    }
}
