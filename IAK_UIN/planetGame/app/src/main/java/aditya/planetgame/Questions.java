package aditya.planetgame;


public class Questions {
    public String mQuestions[] = {
            "which is the first planet iin the Solar System?",
            "which is the second planet iin the Solar System?",
            "which is the third planet iin the Solar System?",
            "which is the fourth planet iin the Solar System?",
            "which is the fifth planet iin the Solar System?",
            "which is the sixth planet iin the Solar System?",
            "which is the seventh planet iin the Solar System?",
            "which is the eight planet iin the Solar System?",
            "which is the ninth planet iin the Solar System?",
    };
    private String mChoices[][] = {
            {"Mercury","Venus","Mars","Saturn"},
            {"Jupiter","Venus","Earth","Neptune"},
            {"Earth","Jupiter","Pluto","Venus"},
            {"Jupiter","Saturn","Mars","Earth"},
            {"Jupiter","Pluto","Mercury","Earth"},
            {"Uranus","Venus","Mars","Saturn"},
            {"Saturn","Pluto","Uranus","Earth"},
            {"Venus","Neptune","Pluto","Mars"},
            {"Mercury","Venus","Mars","Pluto"}

    };
    private String mCorrectAnswer[] = {"Mercury","Venus","Earth","Mars","Jupiter","Saturn","Uranus","Neptune","Pluto"};

    public String getQuestion (int a){
        String question = mQuestions[a];
        return question;
    }
    public String getQuestion (int a){
        String choice = mQuestions[a][0];
        return choice;
    }
    public String getQuestion (int a){
        String choice = mQuestions[a][1];
        return choice;
    }
    public String getQuestion (int a){
        String choice = mQuestions[a][2];
        return choice;
    }
    public String getQuestion (int a){
        String choice = mQuestions[a][3];
        return choice;
    }
    public String getCorrectAnswer(int a){
        String answer = mCorrectAnswer[a];
        return answer;
    }
}
