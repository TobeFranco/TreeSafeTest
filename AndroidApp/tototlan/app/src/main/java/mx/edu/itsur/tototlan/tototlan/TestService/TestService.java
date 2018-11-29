/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.itsur.tototlan.tototlan.TestService;

import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 *
 * @author tobefranco
 */
public interface TestService {
    @GET("tests")
    Call<List<ServiceTest>> getAllTests();
    
    @GET("tests/{id}")
    Call<ServiceTest> getTest(@Path("id") int id);
}
