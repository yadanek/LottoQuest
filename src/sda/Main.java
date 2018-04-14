package sda;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
       /* LOTTO
        1.Program losuje 6 cyfr bez powtórzeń z pośród 49, tak jak to ma miejsce w prawdziwym lotto.
        Wylosowane liczby przechowywane są tablicy.
        2.Program wczytuje liczby podane przez użytkownika, zapmiętuje je w tablicy
        3.Następuje wyświetlenie posortowanych zestawów liczb wylosowanych w lotto i podanych przez użytkownika.
        4.Na ekranie wyswietlony jest komuniat którego stopnia jest wygrana
        np: 6 liczb trafionych to pierszy stopie
        5 liczb trafionych to drugi stopien*/

        //wylosowanie liczb
        int[] tabLotto = new int[6];
        int count = 0;
        int num;
        Random r = new Random();
        while (count < tabLotto.length) {
            num = r.nextInt(49) + 1;
            boolean repeat = false;
            do {
                for (int i = 0; i < tabLotto.length; i++) {
                    if (num == tabLotto[i]) {
                        repeat = true;
                        break;
                    } else if (i == count) {
                        tabLotto[count] = num;
                        count++;
                        repeat = true;
                        break;
                    }
                }
            } while (!repeat);

        }
        //stworzenie tablicy uzytkownika
        int[] tabUzytkownika = new int[6];
        Scanner input = new Scanner(System.in);
        for (int i = 0; i < tabUzytkownika.length; i++) {
            System.out.println("Wpisz " + (i + 1) + " liczbę z zakresu 1-49: ");
            tabUzytkownika[i] = input.nextInt();

            //sprawdzenie, czy liczba niepowtórzona

            boolean liczbaPowtorzona = true;
            while (liczbaPowtorzona == true) {
                liczbaPowtorzona = false;
                for (int j = 0; j < i; j++) {
                    if (tabUzytkownika[i] == tabUzytkownika[j]) {
                        liczbaPowtorzona = true;
                    }
                }
                if (liczbaPowtorzona == true) {
                    System.out.println("Tę liczbę już wytypowałeś, proszę podaj jeszcze raz " + (i + 1) + ". liczbę:");
                    tabUzytkownika[i] = new Scanner(System.in).nextInt();
                }
                }
            }
            //posortowanie tablicy LOTTO
            int temp;
            int zmiana = 1;
            while (zmiana > 0) {
                zmiana = 0;
                for (int i = 0; i < tabLotto.length - 1; i++) {
                    if (tabLotto[i] > tabLotto[i + 1]) {
                        temp = tabLotto[i + 1];
                        tabLotto[i + 1] = tabLotto[i];
                        tabLotto[i] = temp;
                        zmiana++;
                    }
                }
            }
            //posortowanie tablicy użytkownika

            while (zmiana > 0) {
                zmiana = 0;
                for (int i = 0; i < tabUzytkownika.length - 1; i++) {
                    if (tabUzytkownika[i] > tabUzytkownika[i + 1]) {
                        temp = tabUzytkownika[i + 1];
                        tabUzytkownika[i + 1] = tabUzytkownika[i];
                        tabUzytkownika[i] = temp;
                        zmiana++;
                    }
                }
            }

            //wyświetlenie obu tablic
            System.out.println("Twoje liczby to: ");
            for (int i = 0; i < tabUzytkownika.length; i++) {
                System.out.print(tabUzytkownika[i] + ", ");
            }
            System.out.println("\nWylosowane liczby to: ");
            for (int i = 0; i < tabLotto.length; i++) {
                System.out.print(tabLotto[i] + ", ");
            }
            ///// dla każdej zmiennej uzytkownika sprawdź wszystkie zmienne Lotto. jesli, któraś sie powtórzyła, to ją policz.
            /////sprawdź, ile liczb się powtórzyło
            int trafiona = 0;
           // boolean traf = false;
            for (int i = 0; i < tabUzytkownika.length; i++){
                for (int j = 0; j < tabLotto.length; j++){
                    if (tabUzytkownika[i] == tabLotto[j]){
                        trafiona = trafiona +1;
                    }
                }
            }

            System.out.println("\nliczba trafień: " + trafiona);
            if (trafiona == 6){
                System.out.println("Gratuluje nagrody 1-go stopnia!");}
            if  (trafiona == 5){
                System.out.println("Gratuluje nagrody 2-go stopnia!");}
            if  (trafiona == 4){
                System.out.println("Gratuluje nagrody 3-go stopnia!");}
            if  (trafiona == 3){
                System.out.println("Gratuluje nagrody 4-go stopnia!");}
            if  (trafiona == 2){
                System.out.println("Gratuluje nagrody 5-go stopnia!");}
            if  (trafiona == 1){
                System.out.println("Gratuluje nagrody 6-go stopnia!");}
            if  (trafiona == 0){
                System.out.println("Jestes przegrywem, ale nie martw się, miałeś marne szanse ;-p");}


        }

    }

