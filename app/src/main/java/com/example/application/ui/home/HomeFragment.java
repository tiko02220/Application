package com.example.application.ui.home;

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
import com.example.application.databinding.FragmentHomeBinding;
import com.example.application.ui.admin_data.AdminData;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;
 private  Button submit;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentHomeBinding.inflate(inflater, container, false);
            View view = binding.getRoot();
submit = binding.submitButton;
submit.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Fragment registration= new Registration();
        FragmentManager fragmentManager = getParentFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.setReorderingAllowed(true);
        fragmentTransaction.replace(R.id.nav_host_fragment_content_main,registration);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();

    }
});
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}