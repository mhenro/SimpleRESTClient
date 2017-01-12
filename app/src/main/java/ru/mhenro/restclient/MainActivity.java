package ru.mhenro.restclient;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private MhenroService service;
    private Button btnLoadData;
    private TextView tvData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnLoadData = (Button)findViewById(R.id.btnLoadData);
        tvData = (TextView)findViewById(R.id.tvData);

        service = createRetrofitService();

        if (service == null) {
            return;
        }

        btnLoadData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Call<JsonOb> call = service.getJsonOb();
                call.enqueue(new Callback<JsonOb>() {
                    @Override
                    public void onResponse(Call<JsonOb> call, Response<JsonOb> response) {
                        tvData.setText(response.body().toString());
                    }

                    @Override
                    public void onFailure(Call<JsonOb> call, Throwable t) {
                        tvData.setText("Fail while getting results from server! " + t.getMessage());
                    }
                });
            }
        });
    }

    private MhenroService createRetrofitService() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://10.0.2.2:8080/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(MhenroService.class);
    }
}
