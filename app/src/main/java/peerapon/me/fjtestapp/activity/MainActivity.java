package peerapon.me.fjtestapp.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;


import java.util.List;

import peerapon.me.fjtestapp.R;
import peerapon.me.fjtestapp.adapter.FungjaiListAdapter;
import peerapon.me.fjtestapp.api.service.ApiServiceGenerator;

import peerapon.me.fjtestapp.api.client.ResultClient;
import peerapon.me.fjtestapp.dto.ListResult;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        ResultClient client = ApiServiceGenerator.createService(ResultClient.class);


        Call<List<ListResult>> call =
                client.getListResults();


        call.enqueue(new Callback<List<ListResult>>() {
            @Override
            public void onResponse(Call<List<ListResult>> call, Response<List<ListResult>> response) {


                List<ListResult> listResults = response.body();
                recyclerView.setAdapter(new FungjaiListAdapter(listResults));
            }

            @Override
            public void onFailure(Call<List<ListResult>> call, Throwable t) {
            

            }
        });
    }
}
