package org.sara.Pokedex.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import org.sara.morelists.R;
import org.sara.Pokedex.data.PokemonShort;
import java.util.List;
public class PokemonAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    List<PokemonShort> items;
    PokemonItemListener listener;
    public PokemonAdapter(List<PokemonShort> items, PokemonItemListener listener) {
        this.items = items;
        this.listener = listener;
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType
    ) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.pokemon_cell, parent, false);
        return new PokemonViewHolder(view, listener);
    }
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof PokemonViewHolder) {
            ((PokemonViewHolder) holder).decorateWith(items.get(position));
        }
    }
    @Override
    public int getItemCount() {
        return items.size();
    }
}