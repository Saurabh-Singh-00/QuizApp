package com.example.srbhs.quizapp;

public class QuestionBank {

    public String question[] = {
            "Radius of Earth ?", // Earth
            "Never found on Mercury ?", // Mercury
            "Venus is ______ ?", // Venus
            "Gravity of Jupiter ?", // Jupiter
            "Mars is the ___ planet ?", // Mars
            "ghdfgh", // Skip this Question
            "Neptune's diameter is ?", // Neptune
            "Discovery Date of Pluto ?", // Pluto
            "Sun exists since, " // Sun
    };

    public String options[][] = {
            {"6,371 KM", "60,371 KM", "637 KM"},
            {"Oxygen", "Potassium", "Carbon monoxide"},
            {"Smallest", "Hottest", "Farthest"},
            {"2.53", "2.68", "3.2"},
            {"Second", "Third", "Fourth"},
            {"fdgh", "fdgh", "rey"},
            {"24,000 KM", "49,500 KM", "32,600 KM"},
            {"18 Feb 1930", "22 Feb 1932", "18 Feb 1933"},
            {"4.5 Bln years", "3.5 Bln years", "2.5 Bln years"}
    };

    public String checkBoxQuestion[] = {
            "Planet/s between Jupiter & Neptune", // CheckBox
            "Planet/s between Earth & Jupiter" // CheckBox
    };

    public String checkBoxOptions[][] = {
            {"Saturn", "Uranus", "Pluto"},
            {"Mars", "Neptune", "Venus"}
    };

    public String checkBoxAnswer[][] = {
            {"Saturn", "Uranus", "-"},
            {"Mars", "-", "-"}
    };

    public String answers[] = {
            "6,371 KM",
            "Carbon monoxide",
            "Hottest",
            "2.53",
            "Fourth",
            "sdf",
            "49,500 KM",
            "18 Feb 1930",
            "4.5 Bln years"
    };

    public int image[] = {
            R.drawable.earth,
            R.drawable.mercury,
            R.drawable.venus,
            R.drawable.jupiter,
            R.drawable.mars,
            R.drawable.mars,
            R.drawable.neptune,
            R.drawable.pluto,
            R.drawable.sun
    };

    public int checkBoxImage[] = {
            R.drawable.saturn,
            R.drawable.uranus
    };

    public String getQuestion(int questionNumber){
        return question[questionNumber];
    }

    public String getOptionOne(int questionNumber){
        return options[questionNumber][0];
    }

    public String getOptionTwo(int questionNumber){
        return options[questionNumber][1];
    }

    public String getOptionThree(int questionNumber){
        return options[questionNumber][2];
    }

    public String getAnswer(int questionNumber){
        return answers[questionNumber];
    }

    public String getCheckBoxQuestion(int questionNumber) {
        return checkBoxQuestion[questionNumber];
    }

    public String getCheckBoxOptionOne(int questionNumber) {
        return checkBoxOptions[questionNumber][0];
    }

    public String getCheckBoxOptionTwo(int questionNumber) {
        return checkBoxOptions[questionNumber][1];
    }

    public String getCheckBoxOptionThree(int questionNumber) {
        return checkBoxOptions[questionNumber][2];
    }

    public String[] getCheckBoxAnswer(int questionNumber) {
        return checkBoxAnswer[questionNumber];
    }

    public int getImage(int questionNumber){
        return image[questionNumber];
    }

    public int getCheckBoxImage(int questionNumber){
        return checkBoxImage[questionNumber];
    }

}
