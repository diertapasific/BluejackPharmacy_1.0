package com.example.mcs_assignment_lab;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class TransactionFragment extends Fragment {

    View view;
    private ArrayList<Transaction> transactionArrayList;
    private String[] transactionHeading;
    private int[] imageResourceID;
    private RecyclerView RecycleViewAdapterTransaction;
    private String[] manufacturer;
    private String[] price;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_transaction, container, false);
        return view;
    }

    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        dataInitialize();
        RecycleViewAdapterTransaction = view.findViewById(R.id.recycleViewTransaction);
        RecycleViewAdapterTransaction.setLayoutManager(new LinearLayoutManager(getContext()));
        RecycleViewAdapterTransaction.setHasFixedSize(true);
        RecycleViewAdapterTransaction recycleViewAdapterTransaction = new RecycleViewAdapterTransaction(getContext(),transactionArrayList);
        RecycleViewAdapterTransaction.setAdapter(recycleViewAdapterTransaction);
        recycleViewAdapterTransaction.notifyDataSetChanged();

    }

    private void dataInitialize() {

        transactionArrayList = new ArrayList<>();
        transactionArrayList = dataBaseTransaction.getInstance().getMyList();


    }

}