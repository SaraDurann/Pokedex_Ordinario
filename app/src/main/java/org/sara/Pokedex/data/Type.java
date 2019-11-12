package org.sara.Pokedex.data;

import android.os.Bundle;

import org.sara.morelists.R;


public class Type extends androidx.appcompat.app.AppCompatActivity {
    private String name;
    private String damageRelations;
    private String id;

    public Type(String name, String pokemon, String url) {
        this.name = name;
        this.damageRelations = damageRelations;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDamageRelations() {
        return damageRelations;
    }

    public void setDamageRelations(String damageRelations) {
        this.damageRelations = damageRelations;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_type);
    }
}