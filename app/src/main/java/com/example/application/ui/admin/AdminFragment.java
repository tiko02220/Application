package com.example.application.ui.admin;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.application.R;
import com.example.application.databinding.FragmentAdminBinding;
import com.example.application.ui.admin_data.AdminData;

public class AdminFragment extends Fragment {
    Button submit;

//new vers
    private FragmentAdminBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {


        binding = FragmentAdminBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        submit = binding.logInButton;

        submit.setOnClickListener(v -> {
            Fragment AdminData = new AdminData();
            FragmentManager fragmentManager = getParentFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.setReorderingAllowed(true);
            fragmentTransaction.replace(R.id.nav_host_fragment_content_main, AdminData);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();

        });
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
