package com.magis.app.quizzes.questions.generator;

import java.util.Collections;
import java.util.Random;
import java.util.ArrayList;

public class OperatorQuestions {
    Random rand;

    private String[] incrementalEquations = {"++", "--", "+=", "-=", "*=", "/="};

    private String[] manipulativeStrings = {"Dog", "Cat", "Apple", "Pineapple", "Squid", "Bean",
            "Squirrel", "Chicken", "Zoo", "Dark", "Cute", "Ape", "Burger", "Pittsburgh", "Pennsylvania",
            "Valentine", "Programming", "Computer"};

    private String[] answers;
    private char[] characters = {'+','-','*','/','%'};
    private String correctAnswer;
    private String question = "";

    public OperatorQuestions(){
        rand = new Random();
    }

    public void getIntegerDivisionQuestion(){
        question = "";
        int firstInt, secondInt = 100;
        double firstDouble;

        ArrayList<String> shuffler = new ArrayList<>();

        question+="int value1 = "+secondInt+";\n";

        int firstData = rand.nextInt(2);
        if(firstData>0){
            firstInt = rand.nextInt(100)+1;
            question += "int value2 = " + firstInt+";\n";
            correctAnswer = ""+(secondInt/firstInt);
            shuffler.add(correctAnswer);
            shuffler.add(""+(secondInt/(double)firstInt));
        }
        else{
            firstDouble = rand.nextDouble()*100;
            question += "double value2 = " + firstDouble+";\n";
            correctAnswer = ""+(secondInt/firstDouble);
            shuffler.add(correctAnswer);
            shuffler.add(""+(secondInt/(int)firstDouble));
        }

        for(int i=2; i<5; i++){
            shuffler.add(""+(rand.nextInt(50)));
        }
        Collections.shuffle(shuffler);

        answers = shuffler.toArray(answers);

        question+="quotient = value1 / value2; \n\nWhat is the value of \"quotient\"?";
    }

    public void getIncrementalQuestion(){
        question = "";
        int number;
        int extraNumber;
        number = rand.nextInt(11);
        ArrayList<String> shuffler = new ArrayList<>();

        question += "int value = " + number;

        int incrementSelector = rand.nextInt(incrementalEquations.length);

        switch(incrementSelector){
            case 0:
                question += "\nvalue++;";
                correctAnswer = ""+(number++);
                shuffler.add(correctAnswer);
                break;
            case 1:
                question += "\nvalue--;";
                correctAnswer = ""+(number--);
                shuffler.add(correctAnswer);
                break;
            case 2:
                extraNumber = rand.nextInt(11);
                question += "\nvalue += " + extraNumber+";";
                number += extraNumber;
                correctAnswer = ""+(number);
                shuffler.add(correctAnswer);
                break;
            case 3:
                extraNumber = rand.nextInt(11);
                question += "\nvalue -= " + extraNumber+";";
                number -= extraNumber;
                correctAnswer = ""+(number);
                shuffler.add(correctAnswer);
                break;
            case 4:
                extraNumber = rand.nextInt(11);
                question += "\nvalue *= " + extraNumber+";";
                number *= extraNumber;
                correctAnswer = ""+(number);
                shuffler.add(correctAnswer);
                break;
            case 5:
                extraNumber = rand.nextInt(11);
                question += "\nvalue /= " + extraNumber+";";
                number /= extraNumber;
                correctAnswer = ""+(number);
                shuffler.add(correctAnswer);
                break;
        }

        shuffler.add(""+(number+=25));
        shuffler.add(""+(number*=11));
        shuffler.add(""+(number-=14));
        Collections.shuffle(shuffler);
        shuffler.add("Unknown");

        answers = shuffler.toArray(answers);

        question+="\n\nWhat is the value of \"value\" after this incremental equation?";
    }

    public void getModularQuestion(){
        question = "";
        int divisor = rand.nextInt(11);
        int divider = rand.nextInt(11);
        ArrayList<String> shuffler = new ArrayList<>();

        question += ""+divisor+" % "+divider+"\n\nWhat is the result of this operation?";
        correctAnswer = ""+(divisor%divider);
        shuffler.add(correctAnswer);
        shuffler.add((""+(divisor+divider)));
        shuffler.add((""+(divisor*divider)));
        shuffler.add((""+(divisor++)));
        Collections.shuffle(shuffler);
        shuffler.add("Unknown");
        answers = shuffler.toArray(answers);
    }

    public String[] getAnswers() { return answers; }

    public String getQuestion(){
        return question;
    }

    public String getCorrectAnswer(){
        return correctAnswer;
    }
}