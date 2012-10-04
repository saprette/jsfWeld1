package com.tal.test;

import javax.enterprise.inject.Model;
import java.util.Random;

/**
 * User: sam
 * Date: 9/24/12
 * Time: 9:23 PM
 */
public
@Model
class GuessNumber {

    private int number = new Random().nextInt(4);

    private int guessedNumber;

    private String response;

    public GuessNumber() {
    }

    public int getGuessedNumber() {
        return guessedNumber;
    }

    public void setGuessedNumber(int guessedNumber) {
        this.guessedNumber = guessedNumber;
    }

    public String guessResult() {
        response = guessedNumber == number ? "Yes, you found it !" : "Bad luck, You're wrong !";
        return "/guessNumber/guessNumberResult";
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }
}
