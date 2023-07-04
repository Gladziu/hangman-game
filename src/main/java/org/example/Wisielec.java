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
        char[] guessedLetters, guessedLettersHelper;
        guessedLetters = new char[wordLength];
        Arrays.fill(guessedLetters, '_');
        guessedLettersHelper = new char[wordLength];

        List<String> usedLetters = new ArrayList<>();

        while(hasLives){

            System.out.print("Word to guess: ");
            System.out.println(guessedLetters);

            System.out.print("> ");

            // Wczytanie litery od uzytkownika
            char letter = scanner.next().charAt(0);

            // Sprawdzenie czy literka jest w slowie
            for (int i = 0; i < wordLength; i++){
                if (word.charAt(i) == letter){
                    guessedLetters[i]=letter;
                }
            }

            // Metoda zwraca aktualna ilosc zyc
            lives = checkCorrectLetter(lives, guessedLetters, guessedLettersHelper);

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
            usedLetters.add(String.valueOf(letter));
            int lastIndex = usedLetters.size() - 1;
            for (char eachLeter : guessedLetters){
                if (eachLeter == letter){
                    usedLetters.remove(lastIndex);
                    break;
                }
            }

            // Print uzytych literek
            if(!usedLetters.isEmpty()){
                System.out.print("Used leters: ");
                for(String usedLeter : usedLetters) {
                    System.out.print(usedLeter.toUpperCase() + " ");
                }
                System.out.println();
            }

            hasLives = checkWin(guessedLetters);

            guessedLettersHelper = guessedLetters.clone();
        }
            System.out.println("\nYes, it is: " + word + " You won!");
    }

    private int checkCorrectLetter(int lives, char[] guessedLetters, char[] guessedLettersHelper) {
        for (int i = 0; i < guessedLetters.length; i++){
            if (guessedLettersHelper[i] != guessedLetters[i]){
                return lives;
            }
        }
        lives--;

        return lives;
    }

    private boolean checkWin(char[] guessedLetters){
        for (char guessedLetter : guessedLetters) {
            if ('_' == guessedLetter) {
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
