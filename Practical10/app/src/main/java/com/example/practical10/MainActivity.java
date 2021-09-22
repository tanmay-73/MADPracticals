package com.example.practical10;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    ListView listView;
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            listView = findViewById(R.id.listViewHeroes);
            getHeroes();
        }

        private void getHeroes() {
            Call<List<Model>> call = RetrofitClient.getInstance().getMyApi().getHeroes();
            call.enqueue(new Callback<List<Model>>() {
                @Override
                public void onResponse(Call<List<Model>> call, Response<List<Model>> response) {
                    List<Model> heroList = response.body();
                    String[] heroes = new String[heroList.size()];
                    for (int i = 0; i < heroList.size(); i++) {
                        heroes[i] = heroList.get(i).getName();
                    }
                    listView.setAdapter(new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, heroes));
                }
                @Override
                public void onFailure(Call<List<Model>> call, Throwable t) {
                    Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });
        }
    }