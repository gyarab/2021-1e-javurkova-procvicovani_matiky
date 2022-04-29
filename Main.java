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

            if(operace<1 || operace>6){
                System.out.println("Tato operace není v nabídce, zadejte znova.");
                System.out.println();
            }
            else{
                cyklus=true;
            }
        }while(cyklus==false);

        System.out.println();
        Random rand = new Random();
        int pocetPrikladu=0;
        int prvniCislo;
        int druheCislo;

        for(int uspesnost=0;uspesnost<10;) {
            prvniCislo = (int) Math.floor(Math.random() * (nejvetsiCislo - nejmensiCislo + 1) + nejmensiCislo);
            druheCislo = (int) Math.floor(Math.random() * (nejvetsiCislo - nejmensiCislo + 1) + nejmensiCislo);

            int uzivateluvVysledek;
            int spravnyVysledek;

            if (operace == 1) {
                if (druheCislo < 0) {
                    System.out.print(prvniCislo + " + (" + druheCislo + ") = ");
                }
                else{
                    System.out.print(prvniCislo +" + "+ druheCislo + " = ");
                }
                uzivateluvVysledek=sc.nextInt();
                spravnyVysledek=prvniCislo+druheCislo;
                pocetPrikladu++;

                if(spravnyVysledek==uzivateluvVysledek){
                    System.out.println("Správně!!");
                    uspesnost++;
                }
                else{
                    System.out.println("Špatně, správný výsledek je "+spravnyVysledek);
                }
            }

            if(operace == 2){
                if (druheCislo < 0) {
                    System.out.print(prvniCislo + " - (" + druheCislo + ") = ");
                }
                else{
                    System.out.print(prvniCislo +" - "+ druheCislo + " = ");
                }
                uzivateluvVysledek=sc.nextInt();
                spravnyVysledek=prvniCislo-druheCislo;
                pocetPrikladu++;

                if(spravnyVysledek==uzivateluvVysledek){
                    System.out.println("Správně!!");
                    uspesnost++;
                }
                else{
                    System.out.println("Špatně, správný výsledek je "+spravnyVysledek);
                }
            }

            if(operace == 3){
                if(prvniCislo<0 && druheCislo<0){
                    System.out.print("(" + prvniCislo + ") x (" + druheCislo + ") = ");
                }
                else if(prvniCislo<0){
                    System.out.print("(" + prvniCislo + ") x " + druheCislo + " = ");
                }
                else if (druheCislo < 0) {
                    System.out.print(prvniCislo + " x (" + druheCislo + ") = ");
                }
                else{
                    System.out.print(prvniCislo +" x "+ druheCislo + " = ");
                }
                uzivateluvVysledek=sc.nextInt();
                spravnyVysledek=prvniCislo*druheCislo;
                pocetPrikladu++;

                if(spravnyVysledek==uzivateluvVysledek){
                    System.out.println("Správně!!");
                    uspesnost++;
                }
                else{
                    System.out.println("Špatně, správný výsledek je "+spravnyVysledek);
                }
            }

            if(operace == 4){
                if(prvniCislo!=0 && druheCislo!=0){
                    int zbytekPoDeleni = prvniCislo % druheCislo;
                    if(zbytekPoDeleni==0){
                        if(prvniCislo<0 && druheCislo<0){
                            System.out.print("(" + prvniCislo + ") : (" + druheCislo + ") = ");
                        }
                        else if(prvniCislo<0){
                            System.out.print("(" + prvniCislo + ") : " + druheCislo + " = ");
                        }
                        else if (druheCislo < 0) {
                            System.out.print(prvniCislo + " : (" + druheCislo + ") = ");
                        }
                        else{
                            System.out.print(prvniCislo +" : "+ druheCislo + " = ");
                        }
                        uzivateluvVysledek=sc.nextInt();
                        spravnyVysledek=prvniCislo/druheCislo;
                        pocetPrikladu++;

                        if(spravnyVysledek==uzivateluvVysledek){
                            System.out.println("Správně!!");
                            uspesnost++;
                        }
                        else{
                            System.out.println("Špatně, správný výsledek je "+spravnyVysledek);
                        }
                    }
                }
            }

            if(operace == 5){
                if(prvniCislo<0){
                    System.out.print("Druhá mocnina čísla ("+prvniCislo+"): ");
                }
                else{
                    System.out.print("Druhá mocnina čísla "+prvniCislo+": ");
                }
                uzivateluvVysledek=sc.nextInt();
                spravnyVysledek=prvniCislo*prvniCislo;
                pocetPrikladu++;

                if(spravnyVysledek==uzivateluvVysledek){
                    System.out.println("Správně!!");
                    uspesnost++;
                }
                else{
                    System.out.println("Špatně, správný výsledek je "+spravnyVysledek);
                }
            }

            if(operace == 6){
                int nahodnaOperace = (int) Math.floor(Math.random() * 5 + 1);

                if (nahodnaOperace == 1) {
                    if (druheCislo < 0) {
                        System.out.print(prvniCislo + " + (" + druheCislo + ") = ");
                    }
                    else{
                        System.out.print(prvniCislo +" + "+ druheCislo + " = ");
                    }
                    uzivateluvVysledek=sc.nextInt();
                    spravnyVysledek=prvniCislo+druheCislo;
                    pocetPrikladu++;

                    if(spravnyVysledek==uzivateluvVysledek){
                        System.out.println("Správně!!");
                        uspesnost++;
                    }
                    else{
                        System.out.println("Špatně, správný výsledek je "+spravnyVysledek);
                    }
                }

                if(nahodnaOperace == 2){
                    if (druheCislo < 0) {
                        System.out.print(prvniCislo + " - (" + druheCislo + ") = ");
                    }
                    else{
                        System.out.print(prvniCislo +" - "+ druheCislo + " = ");
                    }
                    uzivateluvVysledek=sc.nextInt();
                    spravnyVysledek=prvniCislo-druheCislo;
                    pocetPrikladu++;

                    if(spravnyVysledek==uzivateluvVysledek){
                        System.out.println("Správně!!");
                        uspesnost++;
                    }
                    else{
                        System.out.println("Špatně, správný výsledek je "+spravnyVysledek);
                    }
                }

                if(nahodnaOperace == 3){
                    if(prvniCislo<0 && druheCislo<0){
                        System.out.print("(" + prvniCislo + ") x (" + druheCislo + ") = ");
                    }
                    else if(prvniCislo<0){
                        System.out.print("(" + prvniCislo + ") x " + druheCislo + " = ");
                    }
                    else if (druheCislo < 0) {
                        System.out.print(prvniCislo + " x (" + druheCislo + ") = ");
                    }
                    else{
                        System.out.print(prvniCislo +" x "+ druheCislo + " = ");
                    }
                    uzivateluvVysledek=sc.nextInt();
                    spravnyVysledek=prvniCislo*druheCislo;
                    pocetPrikladu++;

                    if(spravnyVysledek==uzivateluvVysledek){
                        System.out.println("Správně!!");
                        uspesnost++;
                    }
                    else{
                        System.out.println("Špatně, správný výsledek je "+spravnyVysledek);
                    }
                }

                if(nahodnaOperace == 4){
                    if(prvniCislo!=0 && druheCislo!=0){
                        int zbytekPoDeleni = prvniCislo % druheCislo;
                        if(zbytekPoDeleni==0){
                            if(prvniCislo<0 && druheCislo<0){
                                System.out.print("(" + prvniCislo + ") : (" + druheCislo + ") = ");
                            }
                            else if(prvniCislo<0){
                                System.out.print("(" + prvniCislo + ") : " + druheCislo + " = ");
                            }
                            else if (druheCislo < 0) {
                                System.out.print(prvniCislo + " : (" + druheCislo + ") = ");
                            }
                            else{
                                System.out.print(prvniCislo +" : "+ druheCislo + " = ");
                            }
                            uzivateluvVysledek=sc.nextInt();
                            spravnyVysledek=prvniCislo/druheCislo;
                            pocetPrikladu++;

                            if(spravnyVysledek==uzivateluvVysledek){
                                System.out.println("Správně!!");
                                uspesnost++;
                            }
                            else{
                                System.out.println("Špatně, správný výsledek je "+spravnyVysledek);
                            }
                        }
                    }
                }

                if(nahodnaOperace == 5){
                    if(prvniCislo<0){
                        System.out.print("Druhá mocnina čísla ("+prvniCislo+"): ");
                    }
                    else{
                        System.out.print("Druhá mocnina čísla "+prvniCislo+": ");
                    }
                    uzivateluvVysledek=sc.nextInt();
                    spravnyVysledek=prvniCislo*prvniCislo;
                    pocetPrikladu++;

                    if(spravnyVysledek==uzivateluvVysledek){
                        System.out.println("Správně!!");
                        uspesnost++;
                    }
                    else{
                        System.out.println("Špatně, správný výsledek je "+spravnyVysledek);
                    }
                }

            }
        }

        int procentniUspesnost = 1000/pocetPrikladu;
        if(procentniUspesnost==100){
            System.out.println("Gratuluji!! Dosáhl jste stoprocentní úspěšnosti:)");
        }
        else if(procentniUspesnost>=50){
            System.out.println("Nebylo to perfektní, ale dobrá práce:)");
        }
        else{
            System.out.println("To se moc nepovedlo, zkuste znova:(");
        }
        System.out.println("Vaše procentní úspěšnost je "+procentniUspesnost+"%, počet zadaných příkladů byl "+pocetPrikladu);
    }
}