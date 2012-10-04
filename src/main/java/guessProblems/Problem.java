package guessProblems;

import java.io.Serializable;

public class Problem implements Serializable {

    private String problem;
    private String answer;

    public Problem() {
    }

    public Problem(String problem, String answer) {
        this.problem = problem;
        this.answer = answer;
    }

    public String getProblem() {
        return problem;
    }

    public void setProblem(String problem) {
        this.problem = problem;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Problem problem1 = (Problem) o;

        if (answer != null ? !answer.equals(problem1.answer) : problem1.answer != null) return false;
        if (problem != null ? !problem.equals(problem1.problem) : problem1.problem != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = problem != null ? problem.hashCode() : 0;
        result = 31 * result + (answer != null ? answer.hashCode() : 0);
        return result;
    }
}
