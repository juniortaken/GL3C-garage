package com.bgstuffs.pabapp;

import android.app.Fragment;
import android.content.Intent;

import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Home extends Fragment {

    // declaration of the views
    private Button bt_location;

    //a list to store all the products
    List<serviceCenteres> serviceCenteresList;

    //the recyclerview
    RecyclerView recyclerView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        // connecting our activity with layout using inflater
        View view = inflater.inflate(R.layout.activity_home,container,false);

        //getting the recyclerView from xml
        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getActivity()));

        //initializing the productList
        serviceCenteresList = new ArrayList<>();



        String url = "http://192.168.137.1:8080/GL3C_SHOP/webresources/controllerpersonnel/listepersonnel";
        HttpHandler service = new HttpHandler();
        String jsonperson = service.serviceCall(url);

        System.out.println("erreur 2 : "+service);

        if(jsonperson!=null){
            try {
                JSONArray vehicules = new JSONArray(jsonperson);
                for(int i=0; i<vehicules.length(); i++){
                    JSONObject p = vehicules.getJSONObject(i);
                    int idV = p.getInt("idpersonnel");
                    String nomV = p.getString("nom");
                    String typeV = p.getString("login");

                    System.out.println("erreur : "+nom);

                    serviceCenteresList.add(new serviceCenteres());


                }
            } catch (JSONException e) {

            }
        }else{

        }
        return null;
    }


    // creating recylerView adapter
        shopAdapter adapter = new shopAdapter(this.getActivity(),serviceCenteresList);

        // setting adapter to recyclerView
        recyclerView.setAdapter(adapter);

        // initialization of views in fragment
        bt_location = view.findViewById(R.id.btLocation);

        bt_location.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // A fragment can get the activity via the getActivity() function.
                Intent intent = new Intent(getActivity(),myLocation.class);
                startActivity(intent);
            }
        });

        return view;

    }
}
