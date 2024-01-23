package buiduyanh.demo.qlkh.Fragment.FragProd;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import buiduyanh.demo.qlkh.DAO.ProductDAO;
import buiduyanh.demo.qlkh.MainActivity;
import buiduyanh.demo.qlkh.model.Product;

import java.util.List;

public class FragProd extends Fragment {
    FragProdBinding binding;
    ProductDAO dao;
    List<Product> listsp;

    public FragProd() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragProdBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        dao = new ProductDAO();
        listsp = dao.getAll_Prod();
        if (!listsp.isEmpty()) {
            MainActivity.loadFrag(new FragProdList());
        }

        binding.btnAddPD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.loadFrag(new FragProdAdd());
            }
        });
    }
}