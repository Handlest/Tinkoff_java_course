package edu.project1;

import java.util.Scanner;

class ConsoleHangman {
    Scanner scanner = new Scanner(System.in);
    public void run() {
        Session session = new Session();
        while (true) {
            if (session.isSessionEnded()){
                System.out.println("Приятно было поиграть! Сессия закончена. Хорошего дня!");
                return;
            }
            if (session.isAttemptsEnd()){
                System.out.println("К сожалению, попытки закончились. Желаете начать новую сессию?" +
                    " Введите 'НАЧАТЬ', если готовы!");
                return;
            }
            if (session.getStatusCode() == -1){
                System.out.println("К сожалению, попытки закончились. Желаете начать новую сессию?" +
                    " Введите 'НАЧАТЬ', если готовы!");
            }
        }
    }

    private void tryGuess(Session session, String input) {

    }

    private void printState(GuessResult guess) {

    }
}
