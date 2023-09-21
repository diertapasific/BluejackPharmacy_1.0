package com.example.mcs_assignment_lab;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    View view;
    private ArrayList<Medicine> medicineArrayList;
    private String[] medicineHeading;
    private int[] imageResourceID;
    private RecyclerView RecycleViewAdapter;
    private String[] manufacturer;
    private String[] price;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_home, container, false);
        return view;
    }



    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        dataInitialize();
        RecycleViewAdapter = view.findViewById(R.id.recycleViewHome);
        RecycleViewAdapter.setLayoutManager(new LinearLayoutManager(getContext()));
        RecycleViewAdapter.setHasFixedSize(true);
        RecycleViewAdapter recycleViewAdapter = new RecycleViewAdapter(getContext(),medicineArrayList);
        RecycleViewAdapter.setAdapter(recycleViewAdapter);
        recycleViewAdapter.notifyDataSetChanged();

    }


        private void dataInitialize() {

        medicineArrayList = new ArrayList<>();

        medicineHeading = new String[]{
                getString(R.string.head_1),
                getString(R.string.head_2),
                getString(R.string.head_3),
                getString(R.string.head_4),
                getString(R.string.head_5),
                getString(R.string.head_6),
                getString(R.string.head_7),
                getString(R.string.head_8),
                getString(R.string.head_9),
                getString(R.string.head_10)
        };

        manufacturer = new String[]{
                getString(R.string.manufacturer_1),
                getString(R.string.manufacturer_1),
                getString(R.string.manufacturer_2),
                getString(R.string.manufacturer_2),
                getString(R.string.manufacturer_3),
                getString(R.string.manufacturer_3),
                getString(R.string.manufacturer_4),
                getString(R.string.manufacturer_4),
                getString(R.string.manufacturer_6),
                getString(R.string.manufacturer_6)
            };

        price = new String[]{
                getString(R.string.price_1),
                getString(R.string.price_2),
                getString(R.string.price_3),
                getString(R.string.price_4),
                getString(R.string.price_5),
                getString(R.string.price_6),
                getString(R.string.price_7),
                getString(R.string.price_8),
                getString(R.string.price_9),
                getString(R.string.price_10)
            };

        imageResourceID = new int[]{
                R.drawable.a,
                R.drawable.a,
                R.drawable.b,
                R.drawable.b,
                R.drawable.c,
                R.drawable.d,
                R.drawable.e,
                R.drawable.f,
                R.drawable.g,
                R.drawable.g
        };

        for (int i = 0; i < medicineHeading.length; i++){

            Medicine medicine = new Medicine(medicineHeading[i], manufacturer[i],imageResourceID[i], price[i]);
            medicineArrayList.add(medicine);

        }

    }
}