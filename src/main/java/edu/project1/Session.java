package edu.project1;

import java.util.ArrayList;

class Session implements Dictionary{
    private final static int MAX_ATTEMPTS = 8;
    private final ArrayList<Character> answerArray = randomWord();
    private ArrayList<Character> userAnswers = new ArrayList<>();
    private int currentAttempts = 0;
    private boolean hasSessionEnded = false;
    private int statusCode = 0;
    private boolean answeredAll = false;
    private String userMessage;
    public Session guess(char guess){
        statusCode = 0;
        if (userAnswers.contains(guess)){
            statusCode = -1;
            return this;
        }
        userAnswers.add(guess);
        currentAttempts++;
        return this;
    }

    public void PrintState(){

    }
    public boolean isSessionEnded(){
        return this.hasSessionEnded;
    }
    public boolean isAttemptsEnd(){
        return this.currentAttempts == MAX_ATTEMPTS;
    }
    public int getStatusCode(){
        return this.statusCode;
    }
}
