package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

public class ShoesAdapter extends BaseAdapter {
    Context myContext;
    int myLayout;
    List<Shoes> arrayShoes;


    public ShoesAdapter (Context context, int layout, List<Shoes> listShoes){
        myContext = context;
        myLayout = layout;
        arrayShoes = listShoes;

    }
    @Override
    public int getCount() {
        return arrayShoes.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = (LayoutInflater) myContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(myLayout,null);

        // ánh xạ và gán giá trị
        TextView txtName = (TextView) view.findViewById(R.id.textViewName);
        txtName.setText(arrayShoes.get(i).Name);
        TextView txtPrice = (TextView) view.findViewById(R.id.textViewPrice);
        txtPrice.setText(arrayShoes.get(i).Price + " VNĐ");
        ImageView img = (ImageView) view.findViewById(R.id.imageViewImage);
        img.setImageResource(arrayShoes.get(i).Image);

        return view;
    }
}
