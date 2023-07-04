package org.example;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class ReadWords {
    public String wordToGuess () {
        BufferedReader reader = null;
        String wordToGuess = null;
        try {
            // Podaj ścieżkę do pliku tekstowego
            String filePath = "src/main/resources/english-nouns.txt";

            // Tworzenie obiektu BufferedReader dla pliku
            reader = new BufferedReader(new FileReader(filePath));

            String line;
            int lineNumber = 1;
            List<String> words = new ArrayList<>();

            // Odczytuj kolejne linie z pliku, dopóki nie napotkasz końca pliku (null)
            while ((line = reader.readLine()) != null) {
                words.add(line);
                lineNumber++;
            }

            int randomNumber = ThreadLocalRandom.current().nextInt(0, lineNumber-1);
            wordToGuess = words.get(randomNumber);


        } catch (IOException e) {
            System.err.println("Błąd odczytu pliku: " + e.getMessage());
        } finally {
            // Sprawdź, czy obiekt BufferedReader nie jest pusty i zamknij go
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    System.err.println("Błąd podczas zamykania pliku: " + e.getMessage());
                }
            }
        }
        return wordToGuess;
    }
}
