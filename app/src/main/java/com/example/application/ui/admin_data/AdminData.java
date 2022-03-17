package com.example.application.ui.admin_data;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import com.example.application.databinding.FragmentAdminDataBinding;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;


public class AdminData extends Fragment {

    private FragmentAdminDataBinding binding;
    private TabLayout tabLayout;
    private ViewPager2 viewPager2;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentAdminDataBinding.inflate(inflater, container, false);
        View view = binding.getRoot();

        tabLayout = binding.tabView;
        viewPager2 = binding.viewPage;
        ViewAdapter adapter = new ViewAdapter(getParentFragmentManager(), getLifecycle());
        adapter.addFragment(new FacultyData());
        adapter.addFragment(new StudentData());
        viewPager2.setAdapter(adapter);

        new TabLayoutMediator(tabLayout, viewPager2, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                switch (position) {
                    case 0:
                        tab.setText("Faculties");
                        break;
                    case 1:
                        tab.setText("Students");
                        break;

                }
            }
        }).attach();
        return view;
    }
}