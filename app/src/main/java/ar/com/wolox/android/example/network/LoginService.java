package ar.com.wolox.android.example.network;

import java.util.List;

import ar.com.wolox.android.example.model.User;
import retrofit2.Call;

import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * User class for the REST TRAINING API
 */

public interface LoginService {

    @GET("users/")
    Call<List<User>> getUserLogin(
            @Query("email") String email);
}