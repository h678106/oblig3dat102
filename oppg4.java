package oblig3;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;

public class oppg4 {
	public static void main(String[] args) {
        int antElement = 100000;
        int[] tallTabell = new int[antElement];
        HashSet<Integer> hashSet = new HashSet<>();

        // Generer unike tall og legg dem til i både HashSet og tabellen
        int tall = new Random().nextInt(1000000);
        for (int i = 0; i < antElement; i++) {
            tall = (tall + 45713) % 1000000;
            tallTabell[i] = tall;
            hashSet.add(tall);
        }

        // Sorter tabellen for å kunne utføre binærsøk
        Arrays.sort(tallTabell);

        // Søk etter tilfeldige tall og mål tiden for HashSet
        long startTime = System.nanoTime();
        int antallFunnetHashSet = 0;
        for (int i = 0; i < 10000; i++) {
            int tilfeldigTall = new Random().nextInt(1000000);
            if (hashSet.contains(tilfeldigTall)) {
                antallFunnetHashSet++;
            }
        }
        long endTime = System.nanoTime();
        long tidHashSet = endTime - startTime;

        // Søk etter tilfeldige tall og mål tiden for binærsøk i tabellen
        startTime = System.nanoTime();
        int antallFunnetTabell = 0;
        for (int i = 0; i < 10000; i++) {
            int tilfeldigTall = new Random().nextInt(1000000);
            if (Arrays.binarySearch(tallTabell, tilfeldigTall) >= 0) {
                antallFunnetTabell++;
            }
        }
        endTime = System.nanoTime();
        long tidTabell = endTime - startTime;

        // Skriv ut resultatene og diskusjonen
        System.out.println("Antall funnet i HashSet: " + antallFunnetHashSet);
        System.out.println("Antall funnet i tabell: " + antallFunnetTabell);
        System.out.println("Tid brukt i HashSet (nanosekunder): " + tidHashSet);
        System.out.println("Tid brukt i tabell (nanosekunder): " + tidTabell);
    }

}
