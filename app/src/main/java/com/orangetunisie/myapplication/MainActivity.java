package com.orangetunisie.myapplication;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.orangetunisie.myapplication.retrofit.ApiInterface;
import com.orangetunisie.myapplication.retrofit.ApiResponse;
import com.orangetunisie.myapplication.retrofit.ApiService;
import com.orangetunisie.myapplication.retrofit.GamesAdapter;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recycler);
        ApiService.getRetrofit().create(ApiInterface.class)
                .getGames()
                .enqueue(new Callback<ApiResponse>() {
                    @Override
                    public void onResponse(Call<ApiResponse> call, Response<ApiResponse> response) {
                        if (response.body() != null) {
                            GamesAdapter adapter = new GamesAdapter(response.body().getData());
                            recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                            DividerItemDecoration itemDecoration =
                                    new DividerItemDecoration(MainActivity.this, DividerItemDecoration.VERTICAL);
                            recyclerView.addItemDecoration(itemDecoration);
                            recyclerView.setAdapter(adapter);
                        }
                    }

                    @Override
                    public void onFailure(Call<ApiResponse> call, Throwable t) {
                        Log.e("ERROR", "ERROR = ", t);
                    }
                });

        //code A
    }


}