package com.uniguajira.proyectofinalv2.views;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.uniguajira.proyectofinalv2.R;
import com.uniguajira.proyectofinalv2.repositories.retrofit.responses.RevistasResponse;
import com.uniguajira.proyectofinalv2.repositories.room.entities.Revistas;
import com.uniguajira.proyectofinalv2.views.adapters.RevistasAdapter;
import com.uniguajira.proyectofinalv2.views.callback.RevistasClickCallback;
import com.uniguajira.proyectofinalv2.views.utils.ToastUtils;
import com.uniguajira.proyectofinalv2.viewsmodels.RevistasViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RevistasViewModel vmRevistas;
    ProgressBar pgRevistas;
    RecyclerView rvRevistas;
    RevistasAdapter aRevistas;
    SwipeRefreshLayout swipeRefreshLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        vmRevistas = ViewModelProviders.of(this).get(RevistasViewModel.class);
        rvRevistas = findViewById(R.id.mRecyclerView);
        rvRevistas.setLayoutManager(new LinearLayoutManager(this));
        pgRevistas = findViewById(R.id.progress);
        pgRevistas.setVisibility(View.VISIBLE);
        //vmRevistas.insertDummyRevistas();

        swipeRefreshLayout = findViewById(R.id.swipeRefreshLayout);
        init();

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                init();
                swipeRefreshLayout.setRefreshing(false);
            }
        });
    }

    private void init() {
        aRevistas = new RevistasAdapter(revistasClickCallback);
        rvRevistas.setAdapter(aRevistas);

        //from room
        //vmRevistas.getRevistasRoomListObservable().observe(this, new Observer<List<Revistas>>() {
        //from ws
        vmRevistas.getRevistasListObservable().observe(this, new Observer<List<Revistas>>() {
            @Override
            public void onChanged(List<Revistas> revistas) {
                //Toast.makeText(getBaseContext(),"Datos: " + revistas,Toast.LENGTH_LONG).show();
                pgRevistas.setVisibility(View.INVISIBLE);
                if (revistas != null) {
                    aRevistas.setRevistasList(revistas);
                }
            }
        });
    }

    private final RevistasClickCallback revistasClickCallback = new RevistasClickCallback() {
        @Override
        public void onClick(Revistas revistas) {
            ToastUtils.shortToast("Revista: " + revistas.numero);
            save();
        }

        @Override
        public void onDelete(Revistas revistas) {
            delete(revistas.id);//vmRevistas.deleteRevistasListObservable(revistas.id);
            //init();
        }

        @Override
        public void onUpdate(Revistas revistas) {
            ToastUtils.shortToast("Update: " + revistas.id);
            //int revistaId = Integer.parseInt(revistas.id);
            //getrevista(revistaId);
        }
    };

    public void delete(int revistaId){
        vmRevistas.deleteRevistasListObservable(revistaId).observe(this, new Observer<RevistasResponse>() {
            @Override
            public void onChanged(RevistasResponse response) {
                ToastUtils.shortToast(response.getMessage());
                init();
            }
        });
    }

    public void save(){
        vmRevistas.setRevistasListObservable("Revista 5","IUYTYGA",123,"2021").observe(this, new Observer<RevistasResponse>() {
            @Override
            public void onChanged(RevistasResponse response) {
                ToastUtils.shortToast(response.getMessage());
                init();
            }
        });
    }

    public void roomsave(){
        vmRevistas.setRevistasRoom("Revista 5","IUYTYGA",123,"2021");
        init();
    }



    public void getrevista(int revistaId){
        vmRevistas.getRevistaListObservable(revistaId).observe(this, new Observer<Revistas>() {
            @Override
            public void onChanged(Revistas response) {
                ToastUtils.shortToast(response.getMessage());
            }
        });
    }
}