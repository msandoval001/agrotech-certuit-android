package com.certuit.agroapp.ui.buyers.detail;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.certuit.agroapp.R;
import com.certuit.agroapp.data.model.User;
import com.certuit.agroapp.ui.buyers.detail.comments.CommentsAdapter;
import com.certuit.agroapp.ui.buyers.detail.directory.DirectoryAdapter;
import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class BuyerDetailFragment extends Fragment {

    @BindView(R.id.buyerName)
    protected AppCompatTextView buyerName;
    @BindView(R.id.buyerLocation)
    protected AppCompatTextView buyerLocation;
    @BindView(R.id.buyerRequest)
    protected AppCompatTextView buyerRequest;
    @BindView(R.id.buyerPhone)
    protected AppCompatTextView buyerPhone;
    @BindView(R.id.recyclerViewDirectory)
    protected RecyclerView recyclerViewDirectory;
    @BindView(R.id.recyclerViewComments)
    protected RecyclerView recyclerViewComments;
    @BindView(R.id.comment)
    protected TextInputEditText comment;


    private User user;

    public BuyerDetailFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_buyer_detail, container, false);
        ButterKnife.bind(this, view);

        user = getArguments().getParcelable("user");

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        buyerName.setText(user.getName());
        buyerLocation.setText("Mexicali");
        buyerRequest.setText("20 Cajas de Nopal");
        buyerPhone.setText(user.getEmail());

        initDirectoryRecycler();

        initCommentsRecycler();
    }

    private void initDirectoryRecycler() {
        recyclerViewDirectory.setHasFixedSize(true);
        recyclerViewDirectory.setNestedScrollingEnabled(false);
        recyclerViewDirectory.setLayoutManager(new LinearLayoutManager(getContext()));

        DirectoryAdapter adapter = new DirectoryAdapter(getDummyUsers(), getDummyPhones(), getContext());
        recyclerViewDirectory.setAdapter(adapter);
    }

    private void initCommentsRecycler() {
        recyclerViewComments.setHasFixedSize(true);
        recyclerViewComments.setNestedScrollingEnabled(false);
        recyclerViewComments.setLayoutManager(new LinearLayoutManager(getContext()));

        CommentsAdapter adapter = new CommentsAdapter(getCommentsDummy(), getDatesDummy());
        recyclerViewComments.setAdapter(adapter);
    }

    private List<User> getDummyUsers() {
        List<User> users = new ArrayList<>();

        User user;

        user = new User("Jesus Ernesto Guevara");
        users.add(user);

        user = new User("Jorge Antonio Aguirre");
        users.add(user);

        user = new User("Moises Sandoval");
        users.add(user);

        return users;
    }

    // 6861953052
    private List<String> getDummyPhones() {
        List<String> phones = new ArrayList<>();

        phones.add("6861953052");
        phones.add("6864085959");
        phones.add("6861880718");

        return phones;
    }

    private List<String> getCommentsDummy() {
        List<String> comments = new ArrayList<>();

        comments.add("Yo quiero las 20 cajas de nopales, para cuando me lo puedes entregar?");
        comments.add("Para el 24 de marzo, tenemos un trato?");

        return comments;
    }

    private List<String> getDatesDummy() {
        List<String> dates = new ArrayList<>();

        dates.add("14/03/2019");
        dates.add("15/03/2019");

        return dates;
    }
}
