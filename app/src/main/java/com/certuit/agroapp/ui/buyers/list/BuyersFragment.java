package com.certuit.agroapp.ui.buyers.list;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.certuit.agroapp.R;
import com.certuit.agroapp.data.model.User;

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
public class BuyersFragment extends Fragment {


    @BindView(R.id.recyclerView)
    protected RecyclerView recyclerView;

    private BuyersClickListener listener;

    public BuyersFragment() {
        // Required empty public constructor
    }

    public void setListener(BuyersClickListener listener) {
        this.listener = listener;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_buyers, container, false);
        ButterKnife.bind(this, view);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView.setHasFixedSize(true);
        recyclerView.setNestedScrollingEnabled(false);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        BuyerAdapter adapter = new BuyerAdapter(getDummyUsers());
        adapter.setListener(new BuyerAdapter.BuyerClickListener() {
            @Override
            public void onBuyerClick(User user) {
                listener.onBuyerClick(user);
            }
        });
        recyclerView.setAdapter(adapter);
    }

    private List<User> getDummyUsers() {
        List<User> users = new ArrayList<>();

        User user1 = new User("Moises Sandoval");
        User user2 = new User("Jorge Aguirre");
        User user3 = new User("Ernesto Guevara");
        User user4 = new User("Ivan Martinez");
        User user5 = new User("Marco Butrón");

        users.add(user1);
        users.add(user2);
        users.add(user3);
        users.add(user4);
        users.add(user5);

        return users;
    }

    public interface BuyersClickListener {
        void onBuyerClick(User user);
    }
}
