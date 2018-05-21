package com.drondon.android16;


import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class ViewFragment extends Fragment {


    public ViewFragment() {
        // Required empty public constructor
    }

    private DataViewModel viewModel;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        viewModel = ViewModelProviders.of((FragmentActivity) context).get(DataViewModel.class);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_view, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        final TextView textView = view.findViewById(R.id.textView);

        textView.setText("No data!");

        viewModel.getLiveData().observe(this, new Observer<Data>() {
            @Override
            public void onChanged(@Nullable Data data) {
                StringBuilder buffer = new StringBuilder().append("Sum: ").append(data.getSum()).append('\n');
                for (Integer integer : data.getParts()) {
                    buffer.append("User : " + integer).append('\n');
                }
                textView.setText(buffer.toString());
            }
        });
    }
}
