package ar.com.wolox.android.example.network;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static ar.com.wolox.android.example.BaseConfiguration.TRAINING_CONFIGURATION_URL;

public class RetrofitInstance {

    private static Retrofit retrofit = null;
    private static final String BASE_URL = TRAINING_CONFIGURATION_URL;

    public static Retrofit getRetrofitInstance() {
        //https://stackoverflow.com/questions/32514410/logging-with-retrofit-2
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();

        if (retrofit == null) {
            retrofit = new retrofit2.Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}