package com.example.myapplication.Lab8;


import static com.example.myapplication.Lab8.MyNotification.CHANNEL_ID;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import com.example.myapplication.R;

import java.util.Date;

public class MainActivity_Lab8 extends AppCompatActivity {

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
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.POST_NOTIFICATIONS) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        notificationManager.notify(getNotificationId(), builder.build());
    }

    private int getNotificationId(){
        return (int)  new Date().getTime();
    }
}
