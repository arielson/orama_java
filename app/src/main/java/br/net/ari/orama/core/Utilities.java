package br.net.ari.orama.core;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import br.net.ari.orama.interfaces.APIService;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class Utilities {
    public final static String ServiceUrl = "https://s3.amazonaws.com/orama-media/";

    private final static HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY);

    private static OkHttpClient okHttpClient() {
        return new OkHttpClient.Builder()
                .readTimeout(60, TimeUnit.SECONDS)
                .connectTimeout(60, TimeUnit.SECONDS)
                .addInterceptor(interceptor)
                .build();
    }

    private static APIService service;

    public static APIService Service() {
        if(service == null) {
            Gson gson = new GsonBuilder()
                    .setDateFormat("yyyy-MM-dd'T'HH:mm:ss")
                    .create();

            GsonConverterFactory gsonConverterFactory = GsonConverterFactory.create(gson);

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(ServiceUrl)
                    .client(okHttpClient())
                    .addConverterFactory(ScalarsConverterFactory.create())
                    .addConverterFactory(gsonConverterFactory)
                    .build();

            service = retrofit.create(APIService.class);
        }

        return service;
    }

    public static boolean IsNetworkAvailable(Activity activity) {
        ConnectivityManager connectivityManager = (ConnectivityManager) activity.getSystemService(Context.CONNECTIVITY_SERVICE);
        Network network;
        if (connectivityManager == null) {
            return false;
        } else {
            network = connectivityManager.getActiveNetwork();
            NetworkCapabilities networkCapabilities = connectivityManager.getNetworkCapabilities(network);
            if (networkCapabilities == null) {
                return false;
            }
            return networkCapabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) ||
                    networkCapabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR);
        }
    }
}
