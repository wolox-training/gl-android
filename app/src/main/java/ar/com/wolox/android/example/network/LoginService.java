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

    /**
     * @GET("/users") Call<List < User>> getAllUsers();
     */

    @GET("users/{id}")
    Call<User> getUserByCredentials(
            @Query("email") String username,
            @Query("password") String password);
}

/**
 @GET("group/{id}/users") Call<List < User>> groupList(@Path("id") int groupId, @Query("sort") String sort);
 */

/**
 * @GET("/posts/{id}") fun getPostById(@Path("id") id: Int): Call<Post>
 * }
 **/