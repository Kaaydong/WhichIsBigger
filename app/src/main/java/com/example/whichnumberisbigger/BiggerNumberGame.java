package com.example.whichnumberisbigger;

public class BiggerNumberGame {
    private int number1;
    private int number2;
    private int score;
    private int lowerLimit;
    private int upperLimit;

    public BiggerNumberGame(int lowerLimit, int upperLimit) {
        this.lowerLimit = lowerLimit;
        this.upperLimit = upperLimit;
    }

    public void generateRandomNumbers()
            // generate a number between upper and lower limits inclusive
            // store that in number1
            // generate a different number and store in number2
    {
        number1 = lowerLimit + (int) (Math.random() * (upperLimit - lowerLimit + 1));
        number2 = lowerLimit + (int) (Math.random() * (upperLimit - lowerLimit + 1));
    while (number1 == number2) {
        number2 = lowerLimit + (int) (Math.random() * (upperLimit - lowerLimit + 1));
    }
    }

    public String checkAnswer(int answer)
            //determine if answer is right
            //update score accordingly
            //return a relevant message
    {
        int bigNumber = Math.max(number1,number2);
        if (answer == bigNumber)
        {
            score++;
            return "YOU'RE CORRECT!";
        }
        return "YOU'RE WRONG!!!!";

    }


    public int getNumber1() {
        return number1;
    }

    public void setNumber1(int number1) {
        this.number1 = number1;
    }

    public int getNumber2() {
        return number2;
    }

    public void setNumber2(int number2) {
        this.number2 = number2;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getLowerLimit() {
        return lowerLimit;
    }

    public void setLowerLimit(int lowerLimit) {
        this.lowerLimit = lowerLimit;
    }

    public int getUpperLimit() {
        return upperLimit;
    }

    public void setUpperLimit(int upperLimit) {
        this.upperLimit = upperLimit;
    }
}
