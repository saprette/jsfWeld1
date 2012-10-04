package guessProblems;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@ManagedBean(eager = true)
@ApplicationScoped
public class ProblemsHolder implements Serializable {

    private static List<Problem> applicationProblems;

    @PostConstruct
    public void init() {
        applicationProblems = new ArrayList<Problem>();
        applicationProblems.add(new Problem("What trademarked slogan describes Java development? Write once, ...", "run anywhere"));
        applicationProblems.add(new Problem("What are the first 4 bytes of every class file (in hexadecimal)?", "CAFEBABE"));
        applicationProblems.add(new Problem("What does this statement print? System.out.println(1+\\\"2\\\");", "12"));
        applicationProblems.add(new Problem("Which Java keyword is used to define a subclass?", "extends"));
        applicationProblems.add(new Problem("What was the original name of the Java programming language?", "Oak"));
        applicationProblems.add(new Problem("Which java.util class describes a point in time?", "Date"));
    }

    public List<Problem> getProblems() {
        return applicationProblems;
    }

}
