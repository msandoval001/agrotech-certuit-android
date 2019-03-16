package com.certuit.agroapp.ui.productor_home.landing;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.certuit.agroapp.R;
import com.certuit.agroapp.ui.productor_home.list.demand.DemandFragment;
import com.certuit.agroapp.ui.productor_home.list.products.MyProductsFragment;
import com.certuit.agroapp.util.TabsAdapter;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {


    @BindView(R.id.tabLayout)
    protected TabLayout tabLayout;
    @BindView(R.id.viewPager)
    protected ViewPager viewPager;

    private ProductorHomeListener listener;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        ButterKnife.bind(this, view);

        initViewPager();

        return view;
    }

    public void setListener(ProductorHomeListener listener) {
        this.listener = listener;
    }

    private void initViewPager() {
        MyProductsFragment activesFragment = new MyProductsFragment();
        activesFragment.setListener(new MyProductsFragment.DisplayAddFragmentListener() {
            @Override
            public void onClickAdd() {
                listener.showAddFragment();
            }
        });
        DemandFragment inactivesFragment = new DemandFragment();
        List<Fragment> fragments = new ArrayList<>();
        fragments.add(activesFragment);
        fragments.add(inactivesFragment);
        TabsAdapter adapter = new TabsAdapter(getChildFragmentManager(), fragments);
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setText("Mis Productos");
        tabLayout.getTabAt(1).setText("Demanda");
    }

    public interface ProductorHomeListener {
        void showAddFragment();
    }

}
