package com.pm.vehiclestatusmodule.Adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.media.Image;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.pm.vehiclestatusmodule.Model.Alerts;
import com.pm.vehiclestatusmodule.R;
import com.pm.vehiclestatusmodule.TrackActivity;

import java.util.ArrayList;
import java.util.Random;


/**
 * Created by mahapa on 03/02/18.
 */

public class AlertsAdapter extends RecyclerView.Adapter<AlertsAdapter.MyViewHolder> {

    private ArrayList<Alerts> alerts;
    private Context mContext;

    public AlertsAdapter(ArrayList<Alerts> a, Context c){
        this.alerts=a;
        this.mContext=c;
    }
    @Override
    public AlertsAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_new_child, parent, false);

        return new AlertsAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final AlertsAdapter.MyViewHolder holder, final int position) {
        holder.regd_no.setText(alerts.get(position).getRegd_no());
        holder.timestamp.setText(alerts.get(position).getTimestamp());
        holder.detail.setText(alerts.get(position).getDetail());
        holder.location.setText(alerts.get(position).getLocation());
        holder.idle_time.setText(alerts.get(position).getIdle_time());
        holder.speed.setText(alerts.get(position).getSpeed());

        holder.linetwo.setVisibility(View.GONE);
        holder.lineone.setVisibility(View.GONE);
        holder.location.setVisibility(View.GONE);
        holder.map.setVisibility(View.GONE);

        /*Random random = new Random();

        int color = Color.argb(255, random.nextInt(256), random.nextInt(256), random.nextInt(256));
        holder.cardView.setCardBackgroundColor(color);
*/
        holder.map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    Intent intent=new Intent(mContext, TrackActivity.class);
                    intent.putExtra("lat",alerts.get(position).getLat());
                    intent.putExtra("long",alerts.get(position).getLongi());
                    if (alerts.get(position).getLongi().equalsIgnoreCase("na")){
                        Toast.makeText(mContext, "No Location found", Toast.LENGTH_SHORT).show();
                    }else{
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        mContext.startActivity(intent);
                    }
                }catch(NullPointerException e){
                    e.printStackTrace();
                }
            }
        });
        holder.more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (holder.map.getVisibility()==View.INVISIBLE ||holder.map.getVisibility()==View.GONE){
                    holder.linetwo.setVisibility(View.VISIBLE);
                    holder.lineone.setVisibility(View.VISIBLE);
                    holder.location.setVisibility(View.VISIBLE);
                    holder.map.setVisibility(View.VISIBLE);
                    holder.more.setImageResource(R.drawable.ic_expand_less);
                }else if(holder.map.getVisibility()==View.VISIBLE){
                    holder.linetwo.setVisibility(View.GONE);
                    holder.lineone.setVisibility(View.GONE);
                    holder.location.setVisibility(View.GONE);
                    holder.map.setVisibility(View.GONE);
                    holder.more.setImageResource(R.drawable.ic_expand_more);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return alerts.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView regd_no, timestamp, detail, location,idle_time,speed;
        CardView cardMain;
        LinearLayout map, lineone,linetwo;
        ImageView more;
        public MyViewHolder(View itemView) {
            super(itemView);
            regd_no= (TextView)itemView.findViewById(R.id.regd_no);
            timestamp=(TextView)itemView.findViewById(R.id.timestamp);
            detail=(TextView)itemView.findViewById(R.id.detail);
            location= (TextView)itemView.findViewById(R.id.location);
            idle_time=(TextView)itemView.findViewById(R.id.idle_time);
            speed=(TextView)itemView.findViewById(R.id.speed);
            //cardView=(CardView)itemView.findViewById(R.id.cardbg);
            //cardMain=(CardView)itemView.findViewById(R.id.card_main);
            map=(LinearLayout)itemView.findViewById(R.id.map);
            more=(ImageView)itemView.findViewById(R.id.more);
            lineone=(LinearLayout)itemView.findViewById(R.id.lineone);
            linetwo=(LinearLayout)itemView.findViewById(R.id.linetwo);


        }
    }
}
