package org.sara.Pokedex.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import org.sara.morelists.R;
import org.sara.Pokedex.data.PokemonShort;
public class PokemonViewHolder extends RecyclerView.ViewHolder {
    private ImageView pokemonImage;
    private TextView pokemonName;
    private PokemonItemListener listener;
    public PokemonViewHolder(@NonNull View itemView, PokemonItemListener listener) {
        super(itemView);
        pokemonImage = itemView.findViewById(R.id.pokemonImage);
        pokemonName = itemView.findViewById(R.id.pokemonName);
        this.listener = listener;
    }
    public void decorateWith(PokemonShort model) {
        pokemonName.setText(model.getName());
        Glide.with(itemView.getContext())
                .load(model.getUrl())
                .centerInside()
                .into(pokemonImage);
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onPokemonClicked(getAdapterPosition());
            }
        });
    }
}