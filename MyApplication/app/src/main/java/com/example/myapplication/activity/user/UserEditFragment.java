package com.example.myapplication.activity.user;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.myapplication.R;

public class UserEditFragment extends Fragment {
    EditText edtUsername, edtPassword, edtFirstName, edtLastName;

    Button btnAdd, btnEdit, btnDelete;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.user_admin_edit_activity, container, false);

        edtUsername = rootView.findViewById(R.id.edtUsername);
        edtPassword = rootView.findViewById(R.id.edtPassword);
        edtFirstName = rootView.findViewById(R.id.edtFirstName);
        edtLastName = rootView.findViewById(R.id.edtLastName);

        btnAdd = rootView.findViewById(R.id.btnAdd);
        btnEdit = rootView.findViewById(R.id.btnEdit);
        btnDelete = rootView.findViewById(R.id.btnDelete);


        return rootView;
    }
}
