package com.drondon.android15;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

public class FirstFragment extends Fragment {

    public FirstFragment() {

    }

    public static final String EXTRA_KEY_MESSAGE = "extra.key.messga";

    private String message;

    public static FirstFragment newInstance(String message) {

        Bundle args = new Bundle();

        args.putString(EXTRA_KEY_MESSAGE, message);

        FirstFragment fragment = new FirstFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        @Nullable Bundle arguments = getArguments();
        if (arguments != null) {
            message = arguments.getString(EXTRA_KEY_MESSAGE);
        }

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_first, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        FragmentActivity activity = getActivity();
        if (activity != null) {
            Toast.makeText(activity.getBaseContext(), message, Toast.LENGTH_SHORT).show();
        }
    }
}
