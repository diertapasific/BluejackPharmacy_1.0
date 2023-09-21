package com.example.mcs_assignment_lab;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.imageview.ShapeableImageView;

import java.util.ArrayList;

public class RecycleViewAdapterTransaction extends RecyclerView.Adapter<RecycleViewAdapter.viewHolder>{

    Context context;
    ArrayList<Transaction> transactionArrayList;

    public RecycleViewAdapterTransaction(Context context, ArrayList<Transaction> transactionArrayList) {

        this.context = context;
        this.transactionArrayList = transactionArrayList;

    }

    @NonNull
    @Override
    public RecycleViewAdapter.viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_medicine, parent, false);
        return new RecycleViewAdapter.viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecycleViewAdapter.viewHolder holder, int position) {

        Transaction transaction = transactionArrayList.get(position);
        holder.textViewHeading.setText(transaction.medicineName);
        holder.manufacturer.setText(transaction.medicineQuantity);
        holder.price.setText(transaction.medicinePrice);

    }

    @Override
    public int getItemCount() {
        return transactionArrayList.size();
    }

    public static class viewHolder extends RecyclerView.ViewHolder{

        TextView textViewHeading;
        TextView price;
        TextView quantity;
        CardView cv;


        public viewHolder(@NonNull View itemView) {
            super(itemView);
            textViewHeading = itemView.findViewById(R.id.textViewHeading);
            price = itemView.findViewById(R.id.textViewPrice);
            quantity = itemView.findViewById(R.id.textViewQuantity);
            cv = itemView.findViewById(R.id.cvTransaction);
        }
    }

}
