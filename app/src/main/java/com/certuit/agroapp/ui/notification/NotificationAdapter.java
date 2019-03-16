package com.certuit.agroapp.ui.notification;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.certuit.agroapp.R;
import com.certuit.agroapp.data.model.Notification;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

public class NotificationAdapter extends RecyclerView.Adapter<NotificationAdapter.NotificationViewHolder> {

    private List<Notification> notifications;
    private Context context;
    private NotificationClickListener listener;

    public NotificationAdapter(List<Notification> notifications, Context context) {
        this.notifications = notifications;
        this.context = context;
    }

    public void setListener(NotificationClickListener listener) {
        this.listener = listener;
    }

    @NonNull
    @Override
    public NotificationViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.notification_item, parent, false);
        return new NotificationViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NotificationViewHolder holder, int position) {
        holder.assignateData(notifications.get(position));
        holder.itemView.setOnClickListener(v -> listener.onNotificationClick(notifications.get(position)));
    }

    @Override
    public int getItemCount() {
        return notifications.size();
    }


    class NotificationViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.notificationImage)
        protected AppCompatImageView notificationImage;
        @BindView(R.id.notificationContent)
        protected AppCompatTextView content;
        @BindView(R.id.notificationDate)
        protected AppCompatTextView date;

        public NotificationViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        void assignateData(Notification notification) {
            content.setText(notification.getContent());
            date.setText(notification.getDate());

            switch (notification.getNotificationType()) {
                case BUYER:
                    notificationImage.setImageDrawable(context.getResources().getDrawable(R.drawable.ic_notificacion_buyers));
                    break;
                case SALE_MADE:
                    notificationImage.setImageDrawable(context.getResources().getDrawable(R.drawable.ic_mis_ventas));
                    break;
                case CROP_READY:
                    notificationImage.setImageDrawable(context.getResources().getDrawable(R.drawable.ic_notificacion_crop));
                    break;
                default:

            }
        }
    }

    public interface NotificationClickListener {
        void onNotificationClick(Notification notification);
    }
}
