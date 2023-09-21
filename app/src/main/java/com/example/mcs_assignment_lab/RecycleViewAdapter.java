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

public class RecycleViewAdapter extends RecyclerView.Adapter<RecycleViewAdapter.viewHolder>{

    Context context;
    ArrayList<Medicine> medicineArrayList;

    public RecycleViewAdapter(Context context, ArrayList<Medicine> medicineArrayList) {

        this.context = context;
        this.medicineArrayList = medicineArrayList;

    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.list_medicine, parent, false);
        return new viewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {

        Medicine medicine = medicineArrayList.get(position);
        holder.textViewHeading.setText(medicine.heading);
        holder.manufacturer.setText(medicine.manufacturer);
        holder.price.setText(medicine.price);
        holder.titleImage.setImageResource(medicine.titleImage);

        holder.cv.setOnClickListener(view -> {
            Intent intent = new Intent(context, MedicineDetailPage.class);
            context.startActivity(intent);
        });

    }

    @Override
    public int getItemCount() {
        return medicineArrayList.size();
    }

    public static class viewHolder extends RecyclerView.ViewHolder{

        ShapeableImageView titleImage;
        TextView textViewHeading;
        TextView price;

        TextView manufacturer;
        CardView cv;


        public viewHolder(@NonNull View itemView) {
            super(itemView);
            titleImage = itemView.findViewById(R.id.title_image);
            textViewHeading = itemView.findViewById(R.id.textViewHeading);
            manufacturer = itemView.findViewById(R.id.textViewManufacturer);
            price = itemView.findViewById(R.id.textViewPrice);
            cv = itemView.findViewById(R.id.cvMedicine);
        }
    }

}
