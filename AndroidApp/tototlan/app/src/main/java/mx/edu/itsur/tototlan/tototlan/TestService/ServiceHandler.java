package mx.edu.itsur.tototlan.tototlan.TestService;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import mx.edu.itsur.tototlan.tototlan.Factories.TestFactory;
import mx.edu.itsur.tototlan.tototlan.modelo.Test;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServiceHandler {

    private static TestService service;

    static {
        // Register type adapters
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(ServiceQuestion.class, new QuestionDeserializer());
        gsonBuilder.registerTypeAdapter(ServiceQuestion.class, new QuestionSerializer());
        gsonBuilder.setPrettyPrinting();
        // build gson
        Gson gson = gsonBuilder.create();
        // Create a retrofit builder.
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.0.7:3000")
                // use gson defined here for custom conversion.
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        // Build the service object from the defined interface.
        service = retrofit.create(TestService.class);
    }

    /**
     * Obtains a list of Test Objects from the service.
     * If decoratedQuestions is set to true, the Question objects in the Test will be decorated
     * with the appropriate question decorator according to the type of the Question Object,
     * determined with the type property of the Question Object.
     * If decoratedQuestions is set to false, the question won't be decorated.
     * @param decoratedQuestions
     * @return
     */
    public static List<Test> getAllTests(Boolean decoratedQuestions) {
        List<Test> tests = new ArrayList<>();
        // Obtain tests from service
        List<ServiceTest> sTests = new ArrayList<>();
        Call<List<ServiceTest>> call = service.getAllTests();
        try {
            Response<List<ServiceTest>> response = call.execute();
            sTests = response.body();
        } catch(IOException ex){
            System.out.println("Error reading from service.");
        } finally {
            call.cancel();
        }
        // Create tests and decorate Questions if requested to do so.
        tests = TestFactory.createTests(sTests, decoratedQuestions);
        return tests;
    }

    /**
     * Obtains a Test Object from the service.
     * If decoratedQuestions is set to true, the Question objects in the Test will be decorated
     * with the appropriate question decorator according to the type of the Question Object,
     * determined with the type property of the Question Object.
     * If decoratedQuestions is set to false, the question won't be decorated.
     * @param decoratedQuestions
     * @return
     */
    public static Test getTestById(int id, Boolean decoratedQuestions) throws Exception{
        Test test = new Test();
        // Obtain test.
        Call<ServiceTest> call = service.getTest(id);
        ServiceTest sTest = null; // ServiceTest
        try {
            sTest = call.execute().body();
        } catch (Exception e) {
            throw new Exception("Error reading from service.");
        }
        // Create Test from ServiceTest and decorate if requested.
        test = TestFactory.createTest(sTest, decoratedQuestions);
        return test;
    }

}
