package guessProblems;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Named
@SessionScoped
public class QuizBean implements Serializable {

    private enum QuizState {
        BEGIN,
        AGAIN,
        FAIL,
        FINISH
    }

    @Inject
    private ProblemsHolder problemsHolder;
    private List<Problem> problems;
    private int tries;
    private int score;
    private String currentResponse;
    private String currentSubmitResult;
    private Problem currentProblem;
    private QuizState currentState;

    private boolean displayAnswer;
    private boolean displayQuestion;
    private boolean displayInput;
    private boolean displayReset;
    private boolean displaySubmit;
    private boolean displaySubmitResult;
    private boolean displayScore;

    @PostConstruct
    public void init() {
        problems = new ArrayList<Problem>(problemsHolder.getProblems());
        reset();
    }

    public void processResponse() {
        if (currentProblem.getAnswer().equalsIgnoreCase(currentResponse.trim())) {
            score++;
            if (problems.indexOf(currentProblem) == problems.size() - 1) {
                currentSubmitResult = "You're right, this is the end of the quiz";
                currentState = QuizState.FINISH;
                applyStateVisibility();
            } else {
                currentState = QuizState.BEGIN;
                currentProblem = problems.get(problems.indexOf(currentProblem) + 1);
                currentResponse = "";
                tries = 0;
                currentSubmitResult = "You're right ! test change";
                applyStateVisibility();
            }
            return;
        }
        if (tries > 0) {
            currentState = QuizState.FAIL;
            currentSubmitResult = "This is wrong again";
            applyStateVisibility();
            return;
        }
        tries++;
        currentState = QuizState.AGAIN;
        currentSubmitResult = "This is wrong, try again";
        applyStateVisibility();
        return;
    }

    public void reset() {
        Collections.shuffle(problems);
        tries = 0;
        score = 0;
        currentProblem = problems.get(0);
        currentSubmitResult = "";
        currentResponse = "";
        currentState = QuizState.BEGIN;
        applyStateVisibility();
    }

    private void applyStateVisibility() {
        if (currentState == null) {
            return;
        }
        switch (currentState) {
            case BEGIN:
                displayAnswer = false;
                displayQuestion = true;
                displayInput = true;
                displayReset = false;
                displaySubmit = true;
                displaySubmitResult = true;
                displayScore = false;
                break;
            case FAIL:
                displayAnswer = true;
                displayQuestion = true;
                displayInput = false;
                displayReset = true;
                displaySubmit = false;
                displaySubmitResult = true;
                displayScore = true;
                break;
            case AGAIN:
                displayAnswer = false;
                displayQuestion = true;
                displayInput = true;
                displayReset = false;
                displaySubmit = true;
                displaySubmitResult = true;
                displayScore = false;
                break;
            case FINISH:
                displayAnswer = false;
                displayQuestion = false;
                displayInput = false;
                displayReset = true;
                displaySubmit = false;
                displaySubmitResult = true;
                displayScore = true;
                break;
        }
        System.out.println(toString());
    }

    public List<Problem> getProblems() {
        return problems;
    }

    public void setProblems(List<Problem> problems) {
        this.problems = problems;
    }

    public int getTries() {
        return tries;
    }

    public void setTries(int tries) {
        this.tries = tries;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Problem getCurrentProblem() {
        return currentProblem;
    }

    public void setCurrentProblem(Problem currentProblem) {
        this.currentProblem = currentProblem;
    }

    public boolean isDisplayAnswer() {
        return displayAnswer;
    }

    public void setDisplayAnswer(boolean displayAnswer) {
        this.displayAnswer = displayAnswer;
    }

    public boolean isDisplayQuestion() {
        return displayQuestion;
    }

    public void setDisplayQuestion(boolean displayQuestion) {
        this.displayQuestion = displayQuestion;
    }

    public boolean isDisplayReset() {
        return displayReset;
    }

    public void setDisplayReset(boolean displayReset) {
        this.displayReset = displayReset;
    }

    public boolean isDisplaySubmit() {
        return displaySubmit;
    }

    public void setDisplaySubmit(boolean displaySubmit) {
        this.displaySubmit = displaySubmit;
    }

    public String getCurrentResponse() {
        return currentResponse;
    }

    public void setCurrentResponse(String currentResponse) {
        this.currentResponse = currentResponse;
    }

    public boolean isDisplayInput() {
        return displayInput;
    }

    public void setDisplayInput(boolean displayInput) {
        this.displayInput = displayInput;
    }

    public String getCurrentSubmitResult() {
        return currentSubmitResult;
    }

    public void setCurrentSubmitResult(String currentSubmitResult) {
        this.currentSubmitResult = currentSubmitResult;
    }

    public boolean isDisplaySubmitResult() {
        return displaySubmitResult;
    }

    public void setDisplaySubmitResult(boolean displaySubmitResult) {
        this.displaySubmitResult = displaySubmitResult;
    }

    public boolean isDisplayScore() {
        return displayScore;
    }

    public void setDisplayScore(boolean displayScore) {
        this.displayScore = displayScore;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("QuizBean");
        sb.append("{tries=").append(tries);
        sb.append(", score=").append(score);
        sb.append(", currentResponse='").append(currentResponse).append('\'');
        sb.append(", currentSubmitResult='").append(currentSubmitResult).append('\'');
        sb.append(", currentProblem=").append(currentProblem);
        sb.append(", currentState=").append(currentState);
        sb.append(", displayAnswer=").append(displayAnswer);
        sb.append(", displayQuestion=").append(displayQuestion);
        sb.append(", displayInput=").append(displayInput);
        sb.append(", displayReset=").append(displayReset);
        sb.append(", displaySubmit=").append(displaySubmit);
        sb.append(", displaySubmitResult=").append(displaySubmitResult);
        sb.append(", displayScore=").append(displayScore);
        sb.append('}');
        return sb.toString();
    }
}
