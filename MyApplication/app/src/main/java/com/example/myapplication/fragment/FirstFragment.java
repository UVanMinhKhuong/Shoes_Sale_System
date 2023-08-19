package com.example.myapplication.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.myapplication.R;
import com.example.myapplication.adapter.ProductAdapter;
import com.example.myapplication.model.ProductModel;
import com.example.myapplication.service.ProductService;

import java.util.ArrayList;

public class FirstFragment extends Fragment {

    ListView lvShoes;
    ArrayList<ProductModel> productList  = new ArrayList<ProductModel>();

    ProductService productService;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.home_fragment, container, false);

        productService = new ProductService(getActivity());
        productList.addAll(productService.findAll());
        lvShoes = (ListView) view.findViewById(R.id.lvShoes);
        ProductAdapter anAdapter = new ProductAdapter(
                getActivity(),
                R.layout.product_custom,
                productList
        );

        lvShoes.setAdapter(anAdapter);
        anAdapter.notifyDataSetChanged();
        return view;
    }


}
