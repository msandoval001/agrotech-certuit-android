package com.certuit.agroapp.ui.productor_home.list.demand;


import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.certuit.agroapp.R;
import com.certuit.agroapp.data.model.Demand;
import com.certuit.agroapp.data.model.Product;
import com.certuit.agroapp.ui.productor_home.list.products.MyProductsAdapter;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class DemandFragment extends Fragment implements DemandsContract.View {

    @BindView(R.id.recyclerView)
    protected RecyclerView recyclerView;

    private DemandsPresenter presenter;


    public DemandFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_demand, container, false);

        presenter = new DemandsPresenter(this);

        ButterKnife.bind(this, view);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView.setNestedScrollingEnabled(false);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        presenter.getDemands();
    }


    @Override
    public void showDemands(List<Demand> demands) {
        DemandAdapter adapter = new DemandAdapter(demands);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public Context getAppContext() {
        return getContext();
    }
}
