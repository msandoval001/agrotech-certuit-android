package com.certuit.agroapp.ui.sale_made;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.certuit.agroapp.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class SaleMadeFragment extends Fragment {


    public SaleMadeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sale_made, container, false);
    }

}
