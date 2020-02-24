package com.example.tugastpm3;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rvTeam;
    private ArrayList<modelHero> listHero = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvTeam = findViewById(R.id.rv_hero);
        rvTeam.setHasFixedSize(true);
        listHero.addAll(dataHero.getListData());

        showRecyclerList();
    }

    private void showRecyclerList() {
        rvTeam.setLayoutManager(new LinearLayoutManager(this));
        adapterHero aP = new adapterHero(this);
        aP.setmP(listHero);
        rvTeam.setAdapter(aP);
        aP.setDetail1(new adapterHero.Detail() {
            @Override
            public void detail(modelHero mP) {
                Toast.makeText(MainActivity.this, "Memilih "+mP.getHeroName(),Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, DetailHero.class);
                intent.putExtra(DetailHero.DATA,mP);
                startActivity(intent);
            }
        });
    }
}
