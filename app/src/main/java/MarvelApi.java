import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MarvelApi {

    String Base_url ="";
//    get "results array of object using marvel api
    @GET("results")
    Call<List<Preview>>getData();
}

