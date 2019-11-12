package org.sara.Pokedex;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.sara.Pokedex.adapter.PokemonAdapter;
import org.sara.Pokedex.adapter.PokemonItemListener;
import org.sara.Pokedex.data.ListDataHelper;
import org.sara.Pokedex.data.PokemonShort;
import org.sara.morelists.R;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity implements PokemonItemListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        GridLayoutManager manager = new GridLayoutManager(recyclerView.getContext(), 3);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(new PokemonAdapter(ListDataHelper.provideElements(), this));
    }
    @Override
    public void onPokemonClicked(int position) {
        Toast.makeText(this, "Positionl: " + position, Toast.LENGTH_SHORT).show();
    }



    private class GetPokemonsAsyncTask extends AsyncTask<Void, Void, List<PokemonShort>> {
        String url= jsonArray.getJSONObject().getString("url");

        @Override
        protected List<PokemonShort> doInBackground(Void... voids) {
            AppDatabase db = AppDataBaseSingleton.getInstance(getApplicationContext()).appDatabase;
            return db.pokemonDao().getAll();
        }
        @Override
        protected void onPostExecute(List<PokemonShort> pokemonShortList) {
            super.onPostExecute(pokemonShortList);
            if (pokemonShortList != null) {
                updatePokemonList(pokemonShortList);
            }
        }
        @Override
        protected String doInBackground(String... urls) {

            // Creamos el objeto URL desde el string que recibimos.
            if (urls.length == 0) return "";
            URL url = createUrl(urls[0]);
            // Hacemos la petición. Ésta puede tirar una exepción.
            String jsonResponse = "";
            try {
                jsonResponse = makeHttpRequest(url);
            } catch (IOException e) {
                Log.e(LOG_TAG, "Problem making the HTTP request.", e);
            }
            return jsonResponse;
        }

        private List<PokemonShort> listapokemon(String jsonStr) {
            try {
                JSONObject jsonObj = new JSONObject(jsonStr);
                JSONArray jsonArray = jsonObj.getJSONArray("results");
                ArrayList<PokemonShort> pokemonShortList = new ArrayList<>();
                for (int i = 0; i < jsonArray.length(); i++) {
                    String url = jsonArray.getJSONObject(i).getString("url");
                    String name = jsonArray.getJSONObject(i).getString("name");
                    pokemonShortList.add(new PokemonShort(name, url));
                }
                return pokemonShortList;
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return null;
        }

    }



}