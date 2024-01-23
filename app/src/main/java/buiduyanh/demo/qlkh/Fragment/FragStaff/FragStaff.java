package buiduyanh.demo.qlkh.Fragment.FragStaff;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import buiduyanh.demo.qlkh.DAO.StaffDAO;
import buiduyanh.demo.qlkh.model.Staff;

import java.util.ArrayList;

import buiduyanh.demo.qlkh.MainActivity;

public class FragStaff extends Fragment {
    FragStaffBinding binding;
    ArrayList<Staff> list;
    StaffDAO dao;

    public FragStaff() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragStaffBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        dao = new StaffDAO();
        list = dao.getAll();

        if (!list.isEmpty()) {
            MainActivity.loadFrag(new FragStaffList());
        }

        MainActivity.loadFrag(new FragStaffList());

        binding.btnAddnv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.loadFrag(new FragStaffAdd());
            }
        });
    }

}