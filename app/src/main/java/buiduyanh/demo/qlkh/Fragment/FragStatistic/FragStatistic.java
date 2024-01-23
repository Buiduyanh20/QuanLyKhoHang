package buiduyanh.demo.qlkh.Fragment.FragStatistic;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class FragStatistic extends Fragment {
    FragStatisticBinding binding;
    StatisticPager adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragStatisticBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        adapter = new StatisticPager(this);
        binding.vpSt.setAdapter(adapter);


        new TabLayoutMediator(binding.tablSt, binding.vpSt, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                switch (position) {
                    case 0:
                        tab.setText("Thống kê số lượng");
                        break;
                    case 1:
                        tab.setText("Thống kê lượng tiền");
                        break;
                }
            }
        }).attach();
    }
}
