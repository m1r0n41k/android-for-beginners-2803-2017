package com.drondon.android16;


import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.text.Editable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import java.util.Arrays;


/**
 * A simple {@link Fragment} subclass.
 */
public class EditFragment extends Fragment {

    private EditText sumEditText, user1EditText, user2EditText;

    private DataViewModel viewModel;

    private int sum = 0;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        viewModel = ViewModelProviders.of((FragmentActivity) context).get(DataViewModel.class);
    }

    public EditFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_edit, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        sumEditText = view.findViewById(R.id.sumEditText);
        user1EditText = view.findViewById(R.id.user1EditText);
        user2EditText = view.findViewById(R.id.user2EditText);

        sumEditText.setText("100");
        user1EditText.setText("0");

        sumEditText.addTextChangedListener(new TextWatcherAdapter() {
            @Override
            public void afterTextChanged(Editable s) {
                if (TextUtils.isDigitsOnly(s)) {
                    sum = Integer.valueOf(s.toString());
                }
            }
        });

        user1EditText.addTextChangedListener(new TextWatcherAdapter() {
            @Override
            public void afterTextChanged(Editable s) {
                if (!TextUtils.isEmpty(s) && TextUtils.isDigitsOnly(s)) {
                    int value = Integer.parseInt(s.toString());

                    Data data = new Data(sum, Arrays.asList(value, sum - value));
                    viewModel.set(data);
                }
            }
        });

        viewModel.getLiveData().observe(this, new Observer<Data>() {
            @Override
            public void onChanged(@Nullable Data data) {
                Integer part = data.getParts().get(1);
                user2EditText.setText(String.valueOf(part));
            }
        });

    }
}
