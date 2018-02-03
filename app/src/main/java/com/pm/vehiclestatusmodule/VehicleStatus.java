package com.pm.vehiclestatusmodule;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import com.pm.vehiclestatusmodule.Adapter.AlertsAdapter;
import com.pm.vehiclestatusmodule.Model.Alerts;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by mahap on 03-02-18.
 */

public class VehicleStatus extends AppCompatActivity {
    private static RecyclerView recycler;
    private static AlertsAdapter mAdapter;
    private static ArrayList<String> alertsList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_alerts);
        recycler= (RecyclerView)findViewById(R.id.alertsRecycler);
        
        populateView();
    }
    private void populateView() {
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recycler.setLayoutManager(mLayoutManager);
        mAdapter = new AlertsAdapter( getDataSet(),getApplication());
        recycler.setAdapter(mAdapter);
    }
    private ArrayList<Alerts> getDataSet() {
        ArrayList<Alerts> results= new ArrayList<>();
        JSONArray jsonArray= null;
        try {
            jsonArray = new JSONArray(ResponseHolder.resp);
            for (int i=0;i<jsonArray.length();i++) {
                String lat,longi;
                JSONObject val = jsonArray.getJSONObject(i);

                try{
                   lat=String.valueOf(val.getDouble("Lati")).trim();
                }catch (Exception e){
                   lat="na";
                }

                try{
                    longi=String.valueOf(val.getDouble("Long")).trim();
                }catch (Exception e){
                    longi="na";
                }

                Alerts obj= new Alerts("Rj14Gh4789 Vehicle: "+val.getString("Vehicle"),"("+val.getString("Date")+")",val.getString("Location"),"Heading to GUDIVADA", "Idle Time: 0:27:30","Speed- 10 Kmph",lat,longi);
                results.add(i,obj);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        } catch(NullPointerException e){
            e.printStackTrace();
        }

        return results;
    }
}
