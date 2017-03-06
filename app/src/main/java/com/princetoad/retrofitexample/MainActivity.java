package com.princetoad.retrofitexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.princetoad.retrofitexample.Inteface.PlaylistAPI;
import com.princetoad.retrofitexample.Model.Playlist;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    //Root URL of our web service
    public static final String ROOT_URL = "https://trungtamjava.com/";
    private List<Playlist> playlists;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getAllPlayLists();
    }

    private void getAllPlayLists() {
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();
        //Creating a retrofit
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ROOT_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        //Creating an object of our api interface
        PlaylistAPI api = retrofit.create(PlaylistAPI.class);
        Call<List<Playlist>> repos = api.getAllPlaylists(1); // truyen page vao inteface . O day truyen 1
        repos.enqueue(new Callback<List<Playlist>>() {
            @Override
            public void onResponse(Call<List<Playlist>> call, Response<List<Playlist>> response) {
                if (response.isSuccessful()) {
                    playlists = response.body(); // lay danh sach trong json
                    Log.e("size", "" + playlists.get(1));

                    // Set adapter cho nay la ok
                } else {
                    Toast.makeText(MainActivity.this, "Lỗi gì đó", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<Playlist>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Lỗi gì đó", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
