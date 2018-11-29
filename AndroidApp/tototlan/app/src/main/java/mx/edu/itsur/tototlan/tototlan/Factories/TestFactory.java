package mx.edu.itsur.tototlan.tototlan.Factories;

import java.sql.Time;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import mx.edu.itsur.tototlan.tototlan.TestService.ServiceTest;
import mx.edu.itsur.tototlan.tototlan.modelo.Question;
import mx.edu.itsur.tototlan.tototlan.modelo.Test;

public class TestFactory {

    /**
     * Creates a Test object from a ServiceTest object.
     * If decoratedQuestions is set to true, the Question objects in the Test will be decorated
     * with the appropriate question decorator according to the type of the Question Object,
     * determined with the type property of the Question Object.
     * If decoratedQuestions is set to false, the question won't be decorated.
     * @param serviceTest
     * @return
     */
    public static Test createTest(ServiceTest serviceTest, Boolean decoratedQuestions){
        Test test = new Test();
        // Fill the properties of the Test object
        test.setDesciption(serviceTest.getDesc());
        test.setEndDate(serviceTest.getEnd());
        test.setGroupCode(serviceTest.getGroupId());
        test.setIdTest(serviceTest.getId());
        test.setStartDate(serviceTest.getStart());
        test.setTeacherName(serviceTest.getTeacherName());
        test.setTotalTime(new Time(0)); // TODO: Change type
        // Fill questions
        List<Question> questions = null;
        if(decoratedQuestions) {
            questions = QuestionFactory.createDecoratedQuestions(serviceTest.getQuestions());
        } else {
            questions = QuestionFactory.createQuestions(serviceTest.getQuestions());
        }
        // Insert questions.
        test.setQuestions(new HashSet<>(questions));
        return test;
    }

    /**
     * Creates a list of Test objects from a list of ServiceTest objects.
     * If decoratedQuestions is set to true, the Question objects in the Test will be decorated
     * with the appropriate question decorator according to the type of the Question Object,
     * determined with the type property of the Question Object.
     * If decoratedQuestions is set to false, the question won't be decorated.
     * @param serviceTests
     * @param decoratedQuestions
     * @return
     */
    public static List<Test> createTests(List<ServiceTest> serviceTests, Boolean decoratedQuestions){
        List<Test> tests = new ArrayList<>();
        // Fill the list.
        for(ServiceTest sTest : serviceTests){
            tests.add(createTest(sTest, decoratedQuestions));
        }
        return tests;
    }
}
