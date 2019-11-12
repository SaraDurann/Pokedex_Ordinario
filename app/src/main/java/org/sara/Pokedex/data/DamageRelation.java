package org.sara.Pokedex.data;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import org.sara.morelists.R;

public class DamageRelation extends AppCompatActivity {
    private String[] doubleDamageFrom;
    private String[] doubleDamageTo;
    private String[] halfDamageFrom;
    private String[] halfDamageTo;
    private String[] noDamageFrom;
    private String[] noDamageTo;

    public DamageRelation(String[] doubleDamageFrom, String[] doubleDamageTo, String[] halfDamageFrom, String[] halfDamageTo, String[] noDamageFrom, String[] noDamageTo) {
        this.doubleDamageFrom = doubleDamageFrom;
        this.doubleDamageTo = doubleDamageTo;
        this.halfDamageFrom = halfDamageFrom;
        this.halfDamageTo = halfDamageTo;
        this.noDamageFrom = noDamageFrom;
        this.noDamageTo = noDamageTo;
    }

    public String[] getDoubleDamageFrom() {
        return doubleDamageFrom;
    }

    public void setDoubleDamageFrom(String[] doubleDamageFrom) {
        this.doubleDamageFrom = doubleDamageFrom;
    }

    public String[] getDoubleDamageTo() {
        return doubleDamageTo;
    }

    public void setDoubleDamageTo(String[] doubleDamageTo) {
        this.doubleDamageTo = doubleDamageTo;
    }

    public String[] getHalfDamageFrom() {
        return halfDamageFrom;
    }

    public void setHalfDamageFrom(String[] halfDamageFrom) {
        this.halfDamageFrom = halfDamageFrom;
    }

    public String[] getHalfDamageTo() {
        return halfDamageTo;
    }

    public void setHalfDamageTo(String[] halfDamageTo) {
        this.halfDamageTo = halfDamageTo;
    }

    public String[] getNoDamageFrom() {
        return noDamageFrom;
    }

    public void setNoDamageFrom(String[] noDamageFrom) {
        this.noDamageFrom = noDamageFrom;
    }

    public String[] getNoDamageTo() {
        return noDamageTo;
    }

    public void setNoDamageTo(String[] noDamageTo) {
        this.noDamageTo = noDamageTo;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_damage_relation);
    }
}
