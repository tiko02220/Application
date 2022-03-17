package com.example.application.ui.admin_data;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ImageButton;

import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.application.R;
import com.example.application.ui.RecyclerAdapter;
import com.google.android.material.bottomsheet.BottomSheetDialog;


public class StudentData extends Fragment {


   private BottomSheetDialog dialog;
   private View view, view1;
   private ImageButton settings;

    AutoCompleteTextView autoCompleteTextView;
    ArrayAdapter adapter1;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_student_data, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.recycler);
        SearchView searchView = view.findViewById(R.id.search);
        searchView.onActionViewExpanded();
        settings = view.findViewById(R.id.settings);
        dialog = new BottomSheetDialog(getContext());
        view1 = inflater.inflate(R.layout.search_by, container, false);
        dialog.setContentView(view1);
        autoCompleteTextView = dialog.findViewById(R.id.autoCompleteSearchBy);
        adapter1 = new ArrayAdapter(getContext(),
                androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,
                getResources().getStringArray(R.array.search_by));
        autoCompleteTextView.setAdapter(adapter1);
        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.show();

            }
        });


        RecyclerAdapter adapter = new RecyclerAdapter();
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        return view;
    }
}