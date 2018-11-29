package mx.edu.itsur.tototlan.tototlan.Factories;

import android.os.AsyncTask;

import java.util.ArrayList;
import java.util.List;

import mx.edu.itsur.tototlan.tototlan.TestService.ServiceHandler;
import mx.edu.itsur.tototlan.tototlan.modelo.Test;

public class ServiceFactory {
    public static void getTestById(ServiceListener<Test, Integer> listener){
        new ServiceFactory.TestById().execute(listener);
    }

    public static void getAllTests(ServiceListener<List<Test>, Void> listener) {
        new ServiceFactory.AllTestsAsync().execute(listener);
    }

    public interface ServiceListener<T, D>{
        void responseEvent(T response);
        D params();
    }

    public static class TestById extends AsyncTask<ServiceListener<Test, Integer>, Void, Test> {
        private ServiceListener<Test, Integer> listener;
        @Override
        protected Test doInBackground(ServiceListener<Test, Integer>... params) {
            listener = params[0];
            Test test = null;
            try{
                test = ServiceHandler.getTestById(listener.params(), true);
            } catch (Exception ex) {
                // Do something.
            }
            return test;
        }

        @Override
        protected void onPostExecute(Test test) {
            listener.responseEvent(test);
        }
    }

    public static class AllTestsAsync extends AsyncTask<ServiceListener<List<Test>, Void>, Void, List<Test>>{
        private ServiceListener listener;
        @Override
        protected List<Test> doInBackground(ServiceListener<List<Test>, Void>... serviceListeners) {
            listener = serviceListeners[0];
            List<Test> tests = new ArrayList<>();
            try {
                tests = ServiceHandler.getAllTests(true);
            } catch (Exception e){
                // Nothing
            }
            return tests;
        }

        @Override
        protected void onPostExecute(List<Test> tests) {
            listener.responseEvent(tests);
        }
    }
}
