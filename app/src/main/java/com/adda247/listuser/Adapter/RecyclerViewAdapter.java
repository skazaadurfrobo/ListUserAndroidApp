package com.adda247.listuser.Adapter;

import android.content.Context;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.adda247.listuser.Model.model;
import com.adda247.listuser.R;

import java.util.List;


public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    private Context mContext ;
    private List<model> mData ;


    public RecyclerViewAdapter(Context mContext, List<model> mData) {
        this.mContext = mContext;
        this.mData = mData;

    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view ;
        LayoutInflater inflater = LayoutInflater.from(mContext);
        view = inflater.inflate(R.layout.list_row,parent,false) ;
        final MyViewHolder viewHolder = new MyViewHolder(view) ;

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {

        holder.Name.setText(mData.get(position).getName());
        holder.Email.setText(mData.get(position).getEmail());
        holder.Gender.setText(mData.get(position).getGender());
        holder.Status.setText(mData.get(position).getStatus());

    }



    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

      TextView Name,Email,Gender,Status;


        public MyViewHolder(View itemView) {
            super(itemView);
            Name = itemView.findViewById(R.id.name);
            Email = itemView.findViewById(R.id.email);
            Gender = itemView.findViewById(R.id.gender);
            Status = itemView.findViewById(R.id.status);


        }
    }

}
