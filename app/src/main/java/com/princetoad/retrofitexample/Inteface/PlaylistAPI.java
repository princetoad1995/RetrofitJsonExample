package com.princetoad.retrofitexample.Inteface;

import com.princetoad.retrofitexample.Model.Playlist;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by PRINCE D. TOAD on 3/6/2017.
 */

public interface PlaylistAPI {

    // link json : https://trungtamjava.com/java-online/mobile/playlist/1
    // thi trong get la cai duoi sau va e truyen so trang (page) vao
    @GET("/java-online/mobile/playlist/get/{page}")
    Call<List<Playlist>> getAllPlaylists(@Path("page") int page);
}
