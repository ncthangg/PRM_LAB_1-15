package com.example.pushnotification;

import static com.example.pushnotification.MyNotification.CHANNEL_ID;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

import java.util.Date;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab8);
        Button btnSendNotification = findViewById(R.id.btn_send_notification);
        btnSendNotification.setOnClickListener(v -> sendNotification(this));
    }
    public void sendNotification(Context context) {
        Bitmap bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.khunglongicon);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(context, CHANNEL_ID)
                .setSmallIcon(R.drawable.khunglongicon)
                .setLargeIcon(bitmap)
                .setContentTitle("Thông báo mới")
                .setContentText("Xin chào đã lâu không gặp!!!")
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setAutoCancel(true);

        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(context);
        notificationManager.notify(getNotificationId(), builder.build());
    }

    private int getNotificationId(){
        return (int)  new Date().getTime();
    }
}
