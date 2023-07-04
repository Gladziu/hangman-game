package org.example;

import java.util.*;


public class Wisielec {

    public void play(){

        int lives = 8;
        boolean hasLives = true;

        Scanner scanner = new Scanner(System.in);

        WisielecVisual wisielecVisual = new WisielecVisual();

        ReadWords readWords = new ReadWords();
        String word = readWords.wordToGuess();

        int wordLength = word.length();
        char[] guessedLeters, guessedLetersHelper;
        guessedLeters = new char[wordLength];
        Arrays.fill(guessedLeters, '_');
        guessedLetersHelper = new char[wordLength];

        List<String> usedLeters = new ArrayList<>();

        while(hasLives){

            System.out.print("Word to guess: ");
            System.out.println(guessedLeters);

            System.out.print("> ");

            // Wczytanie litery od uzytkownika
            char leter = scanner.next().charAt(0);

            // Sprawdzenie czy literka jest w slowie
            for (int i = 0; i < wordLength; i++){
                if (word.charAt(i) == leter){
                    guessedLeters[i]=leter;
                }
            }

            // Metoda zwraca aktualna ilosc zyc
            lives = checkCorrectLetter(lives, guessedLeters, guessedLetersHelper);

            // Koniec gry jezeli skoncza sie zycia
            if (lives <= 0){
                System.out.println("\nYou lost, it was: " + word);
                System.out.println(wisielecVisual.getWisielecVisual(lives));
                return;
            }

            // Rysowanie wisielca
            String wisielecDrawing = wisielecVisual.getWisielecVisual(lives);
            System.out.println(wisielecDrawing);

            // Uzupelnienie listy uzytych literek
            usedLeters.add(String.valueOf(leter));
            int lastIndex = usedLeters.size() - 1;
            for (char eachLeter : guessedLeters){
                if (eachLeter == leter){
                    usedLeters.remove(lastIndex);
                    break;
                }
            }

            // Print uzytych literek
            if(!usedLeters.isEmpty()){
                System.out.print("Used leters: ");
                for(String usedLeter : usedLeters) {
                    System.out.print(usedLeter.toUpperCase() + " ");
                }
                System.out.println();
            }

            hasLives = checkWin(guessedLeters);

            guessedLetersHelper = guessedLeters.clone();
        }

            System.out.println("\nYes, it is: " + word + " You won!");

    }

    private int checkCorrectLetter(int lives, char[] guessedLeters, char[] guessedLetersHelper) {
        for (int i = 0; i < guessedLeters.length; i++){
            if (guessedLetersHelper[i] != guessedLeters[i]){
                return lives;
            }
        }
        lives--;

        return lives;
    }

    private boolean checkWin(char[] guessedLeters){
        for (char guessedLeter : guessedLeters) {
            if ('_' == guessedLeter) {
                return true;
            }
        }

        return false;
    }

    public void startGame() {
        boolean keepPlaying = true;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Hangman game! You have 9 lifes. Good luck :D");

        do {
            play();

            String check;
            do {
                System.out.print("\nPlay again? y/n ");
                check = scanner.next();
            } while (!Objects.equals(check, "n") && !Objects.equals(check, "y"));

            if (Objects.equals(check, "n")) {
                keepPlaying = false;
            }
        }while (keepPlaying);

        System.out.println("Thanks for playing.");

    }
}
