package com.company;
import java.util.Scanner;
import java.io.IOException;
import java.util.InputMismatchException;


public class Main {

    public static void main(String[] args) {

        //na první 2 řádky napíšu uvítání
        System.out.println("PROCVIČOVÁNÍ MATEMATIKY");
        System.out.println("Můžete si zadat typ operace, po vypočítání 10ti příkladu správně Vám oznámim procentní úspěšnost");

        System.out.println();

        //vytvořím si proměnné, které budu používat
        Scanner sc = new Scanner(System.in);
        Boolean cyklus=true;
        int nejmensiCislo;
        int nejvetsiCislo;

        //tento cyklus se ujistí, že uživatel nezadá čísla špatně
        do{
            System.out.print("Zadejte nejmenší celé číslo se kterým chcete pracovat: ");
            nejmensiCislo= sc.nextInt();

            System.out.print("Zadejte největší celé číslo se kterým chcete pracovat: ");
            nejvetsiCislo= sc.nextInt();

            if(nejmensiCislo>=nejvetsiCislo){
                System.out.println("Nejmenší číslo musí být menší než to největší, zadejte znova.");
            }
            //jestli je zadal špatně, cyklus se opakuje
            else{
                cyklus=false;
            }
            System.out.println();
        }while(cyklus);

        int operace;

        //cyklus se ujisti, že uživatel zvolí operaci, která existuje
        do{
            System.out.println("Dostupné operace se kterýma můžete pracovat:");
            System.out.println("sčítání 1");
            System.out.println("odečítaní 2");
            System.out.println("násobení 3");
            System.out.println("dělení 4");
            System.out.println("umocnění na druhou 5");
            System.out.println("mix všech operací 6");
            System.out.print("Vaše zvolená operace: ");
            operace= sc.nextInt();

            //pokud zadal něco co není v nabídce cyklus je false, a celý se opakuje
            if(operace<1 || operace>6){
                System.out.println("Tato operace není v nabídce, zadejte znova.");
                System.out.println();
            }
            else{
                cyklus=true;
            }
        }while(!cyklus);

        System.out.println();
        //vytvoříme proměnné
        int pocetPrikladu=0;
        int prvniCislo;
        int druheCislo;

        //tento for cyklus je ten, ve kterém se všechno počítání bude dít, dokud uživatel nebude mít 10 příkladů správně
        for(int uspesnost=0;uspesnost<10;) {
            //náhodně vygenerujeme čísla od nejmenšího po větší podle toho co uživatel zadal předtím
            prvniCislo = (int) Math.floor(Math.random() * (nejvetsiCislo - nejmensiCislo + 1) + nejmensiCislo);
            druheCislo = (int) Math.floor(Math.random() * (nejvetsiCislo - nejmensiCislo + 1) + nejmensiCislo);

            int uzivateluvVysledek;
            int spravnyVysledek;

            //jestli zvolí 1
            if (operace == 1) {
                //pokud je 2. číslo menší než jedna, bude v závorce
                if (druheCislo < 0) {
                    System.out.print(prvniCislo + " + (" + druheCislo + ") = ");
                }
                else{
                    System.out.print(prvniCislo +" + "+ druheCislo + " = ");
                }
                uzivateluvVysledek=sc.nextInt();
                spravnyVysledek=prvniCislo+druheCislo;
                //přictem 1 k počtu příkladů, abychom poté mohli počítat procetní úspěšnost
                pocetPrikladu++;

                //jestli je zadaný výsledek správný přičte se úspěšnost
                if(spravnyVysledek==uzivateluvVysledek){
                    System.out.println("Správně!!");
                    uspesnost++;
                }
                //jestli je špatně, nic se nepřičte, akorát se vypíše správný výsledek
                else{
                    System.out.println("Špatně, správný výsledek je "+spravnyVysledek);
                }
            }

            //jestli zvolí 2
            if(operace == 2){
                //to samé pravidlo se závorkama jako u sčítání
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

            //když zvolí 3
            if(operace == 3){
                //jestli je i první číslo menší než 0, tak se dá do závorky
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

            //když zvolí 4
            if(operace == 4){
                //u dělení je potřeba aby se ani jedno číslo nerovnalo 0 jinak to bude házet error
                if(prvniCislo!=0 && druheCislo!=0){
                    //ujistíme se, že o dělení vznikne celé číslo, jestli ne, čísla se generují znova
                    int zbytekPoDeleni = prvniCislo % druheCislo;
                    if(zbytekPoDeleni==0){
                        //závorky tu platí jako u násobení
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

            //když zvolí 5
            if(operace == 5){
                //na tuto operaci potřebujeme jen jedno z vygenerovaných čísel, jestli je záporné dáme ho do závorky
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

            //když zvolí 6
            if(operace == 6){
                //vytvoříme generátor operací, poté se budou genrovat náhodné operace
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

        //vypočítáme procentní úspěšnost a oznámíme ji
        int procentniUspesnost = 1000/pocetPrikladu;
        //jestli byly všechny příklady bez chyby
        if(procentniUspesnost==100){
            System.out.println("Gratuluji!! Dosáhl jste stoprocentní úspěšnosti:)");
        }
        //jestli víc jak půlka příkladů bylo správně
        else if(procentniUspesnost>=50){
            System.out.println("Nebylo to perfektní, ale dobrá práce:)");
        }
        //pokud míň jak půlka příkladu byla sorávně
        else{
            System.out.println("To se moc nepovedlo, zkuste znova:(");
        }
        //oznámíme procetní úspěšnost a počet příkladů
        System.out.println("Vaše procentní úspěšnost je "+procentniUspesnost+"%, počet zadaných příkladů byl "+pocetPrikladu);
    }
}