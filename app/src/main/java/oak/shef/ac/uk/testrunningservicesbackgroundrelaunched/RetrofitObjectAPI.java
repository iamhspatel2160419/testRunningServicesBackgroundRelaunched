package oak.shef.ac.uk.testrunningservicesbackgroundrelaunched;

import java.util.List;

import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Path;
import retrofit.http.Query;

/**
 * Created by navneet on 4/6/16.
 */
public interface RetrofitObjectAPI {

    /*
     * Retrofit get annotation with our URL
     * And our method that will return us details of student.
    */
    @GET("/api/users")
    Call<Example> getUserDetails(@Query("page") Integer sort);
}
