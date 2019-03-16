package com.certuit.agroapp.ui.add_product;


import android.app.DatePickerDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;

import com.certuit.agroapp.R;
import com.certuit.agroapp.data.model.Crop;
import com.google.android.material.textfield.TextInputEditText;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatSpinner;
import androidx.fragment.app.Fragment;
import butterknife.BindArray;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class AddProductFragment extends Fragment implements AddProductContract.View {

    @BindArray(R.array.quantity_type)
    protected String[] quantityTypes;

    @BindView(R.id.quantityType)
    protected AppCompatSpinner quantityTypesSpinner;
    @BindView(R.id.productType)
    protected AppCompatSpinner productTypesSpinner;
    @BindView(R.id.sowingDate)
    protected TextInputEditText sowingDate;
    @BindView(R.id.harvestDate)
    protected TextInputEditText harvestDate;
    @BindView(R.id.quantity)
    protected TextInputEditText quantity;
    @BindView(R.id.status)
    protected TextInputEditText status;
    @BindView(R.id.description)
    protected TextInputEditText description;
    @BindView(R.id.price)
    protected TextInputEditText price;

    private AddProductPresenter presenter;
    private List<Crop> crops;
    private Calendar calendarSowing;
    private Calendar calendarHarvest;


    public AddProductFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_add_product, container, false);
        ButterKnife.bind(this, view);
        presenter = new AddProductPresenter(this);

        calendarSowing = Calendar.getInstance();
        calendarHarvest = Calendar.getInstance();

        sowingDate.setOnClickListener(v -> {
            DatePickerDialog datePickerDialog = new DatePickerDialog(getAppContext(), (view1, year, month, dayOfMonth) -> {
                calendarSowing.set(Calendar.YEAR, year);
                calendarSowing.set(Calendar.MONTH, month);
                calendarSowing.set(Calendar.DAY_OF_MONTH, dayOfMonth);

                String format = "dd/MM/yyyy";
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format, Locale.ROOT);
                sowingDate.setText(simpleDateFormat.format(calendarSowing.getTime()));
            }, calendarSowing.get(Calendar.YEAR),
                    calendarSowing.get(Calendar.MONTH), calendarSowing.get(Calendar.DAY_OF_MONTH));
            datePickerDialog.show();
        });

        harvestDate.setOnClickListener(v -> {
            DatePickerDialog datePickerDialog = new DatePickerDialog(getAppContext(), (view12, year, month, dayOfMonth) -> {
                calendarHarvest.set(Calendar.YEAR, year);
                calendarHarvest.set(Calendar.MONTH, month);
                calendarHarvest.set(Calendar.DAY_OF_MONTH, dayOfMonth);

                String format = "dd/MM/yyyy";
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format, Locale.ROOT);
                harvestDate.setText(simpleDateFormat.format(calendarHarvest.getTime()));
            }, calendarHarvest.get(Calendar.YEAR),
                    calendarHarvest.get(Calendar.MONTH), calendarHarvest.get(Calendar.DAY_OF_MONTH));
            datePickerDialog.show();
        });

        initQuantitySpinner();

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        presenter.getCrops();
    }

    private void initQuantitySpinner() {
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_dropdown_item,
                quantityTypes);
        quantityTypesSpinner.setAdapter(adapter);
    }

    @OnClick(R.id.addButton)
    public void addAction() {
        presenter.createProduct(crops.get(productTypesSpinner.getSelectedItemPosition()).getId(),
                Integer.parseInt(quantity.toString().trim()), sowingDate.toString().trim(), harvestDate.toString().trim(),
                status.toString().trim(), quantityTypesSpinner.getSelectedItemPosition(),
                description.toString().trim(), Float.parseFloat(price.toString().trim()));
    }

//    @OnClick(R.id.textInputLayout1)
//    public void sowingDatePicker() {
//
//        DatePickerDialog datePickerDialog = new DatePickerDialog(getAppContext(), (view, year, month, dayOfMonth) -> {
//            calendarSowing.set(Calendar.YEAR, year);
//            calendarSowing.set(Calendar.MONTH, month);
//            calendarSowing.set(Calendar.DAY_OF_MONTH, dayOfMonth);
//
//            String format = "dd/MM/yyyy";
//            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format, Locale.ROOT);
//            sowingDate.setText(simpleDateFormat.format(calendarSowing.getTime()));
//        }, calendarSowing.get(Calendar.YEAR),
//                calendarSowing.get(Calendar.MONTH), calendarSowing.get(Calendar.DAY_OF_MONTH));
//        datePickerDialog.show();
//    }
//
//    @OnClick(R.id.textInputLayout2)
//    public void harvestdatePicker() {
//        DatePickerDialog datePickerDialog = new DatePickerDialog(getAppContext(), (view, year, month, dayOfMonth) -> {
//            calendarHarvest.set(Calendar.YEAR, year);
//            calendarHarvest.set(Calendar.MONTH, month);
//            calendarHarvest.set(Calendar.DAY_OF_MONTH, dayOfMonth);
//
//            String format = "dd/MM/yyyy";
//            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format, Locale.ROOT);
//            harvestDate.setText(simpleDateFormat.format(calendarHarvest.getTime()));
//        }, calendarHarvest.get(Calendar.YEAR),
//                calendarHarvest.get(Calendar.MONTH), calendarHarvest.get(Calendar.DAY_OF_MONTH));
//        datePickerDialog.show();
//    }

    @Override
    public void showCrops(List<Crop> crops) {
        this.crops = crops;
        List<String> cropsNames = new ArrayList<>();
        for (Crop crop : crops) {
            cropsNames.add(crop.getName());
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_dropdown_item,
                cropsNames);
        productTypesSpinner.setAdapter(adapter);
    }

    @Override
    public void onCreateProduct() {
        quantity.setText("");
        sowingDate.setText("");
        harvestDate.setText("");
        status.setText("");
        description.setText("");
    }

    @Override
    public Context getAppContext() {
        return getContext();
    }
}
