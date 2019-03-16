package com.certuit.agroapp.ui.notification;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.certuit.agroapp.R;
import com.certuit.agroapp.data.model.Notification;
import com.certuit.agroapp.data.model.NotificationType;

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
public class NotificationFragment extends Fragment {


    @BindView(R.id.recyclerView)
    protected RecyclerView recyclerView;

    private NotificationClickListener listener;

    public NotificationFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_notification, container, false);
        ButterKnife.bind(this, view);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView.setHasFixedSize(true);
        recyclerView.setNestedScrollingEnabled(false);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        NotificationAdapter adapter = new NotificationAdapter(getDummyNotifications(), getContext());

        adapter.setListener(new NotificationAdapter.NotificationClickListener() {
            @Override
            public void onNotificationClick(Notification notification) {
                listener.onNotificationClick(notification);
            }
        });

        recyclerView.setAdapter(adapter);
    }

    public void setListener(NotificationClickListener listener) {
        this.listener = listener;
    }

    private List<Notification> getDummyNotifications() {
        List<Notification> notifications = new ArrayList<>();

        Notification notification = new Notification();
        notification.setContent("Hay tres compradores interesados en tu oferta");
        notification.setDate("15/02/2019");
        notification.setType(NotificationType.BUYER.getId());
        notification.setNotificationType(NotificationType.BUYER);
        notifications.add(notification);


        Notification notification1 = new Notification();
        notification1.setContent("Tu cultivo está listo para cosecharse");
        notification1.setDate("14/02/2019");
        notification1.setType(NotificationType.CROP_READY.getId());
        notification1.setNotificationType(NotificationType.CROP_READY);
        notifications.add(notification1);


        Notification notification2 = new Notification();
        notification2.setContent("¡Lograste una venta!");
        notification2.setDate("13/02/2019");
        notification2.setType(NotificationType.SALE_MADE.getId());
        notification2.setNotificationType(NotificationType.SALE_MADE);
        notifications.add(notification2);

        return notifications;
    }

    public interface NotificationClickListener {
        void onNotificationClick(Notification notification);
    }
}
