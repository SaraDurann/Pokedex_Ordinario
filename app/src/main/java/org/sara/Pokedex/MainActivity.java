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

import static org.sara.Pokedex.utils.NetworkUtils.createUrl;
import static org.sara.Pokedex.utils.NetworkUtils.makeHttpRequest;

public class MainActivity extends AppCompatActivity implements PokemonItemListener {


    private String LOG_TAG;

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


    private class JsonAsyncTask extends AsyncTask<Void, Void, List<PokemonShort>> {
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected List<PokemonShort> doInBackground(Void... voids) {
            URL url = createUrl("https://pokeapi.co/api/v2/pokemon?limit=107&offset=386");
            // Hacemos la petición. Ésta puede tirar una exepción.
            String jsonResponse = "";
            try {
                jsonResponse = makeHttpRequest(url);
                listapokemon(jsonResponse);
            } catch (IOException e) {
                Log.e(LOG_TAG, "Problem making the HTTP request.", e);
            }
            return null;
        }

        @Override
        protected void onPostExecute(List<PokemonShort> pokemonShortList) {
            super.onPostExecute(pokemonShortList);
            if (pokemonShortList != null) {
                updatePokemonList(pokemonShortList);
            }
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