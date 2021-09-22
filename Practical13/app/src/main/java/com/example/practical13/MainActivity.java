package com.example.practical13;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.annotation.SuppressLint;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public static final String NOTIFICATION_CHANNEL_ID = "10001" ;
    private final static String default_notification_channel_id = "default" ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText et1 = findViewById(R.id.et1);
        EditText et2 = findViewById(R.id.et2);
        Button btn = findViewById(R.id.btn);
        btn.setOnClickListener(view -> {
         if (et2.getText().toString().isEmpty() || et1.getText().toString().isEmpty()) {
                Toast t = Toast.makeText(getApplicationContext(), "Please Enter Values", Toast.LENGTH_SHORT);
                t.show();
            }
            else
            {
            NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(MainActivity.this,
                    default_notification_channel_id)
                    .setSmallIcon(R.drawable.ic_baseline_notifications)
                    .setContentTitle(et2.getText())
                    .setContentText(et1.getText());
            NotificationManager mNotificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                int importance = NotificationManager.IMPORTANCE_HIGH;
                NotificationChannel notificationChannel = new
                        NotificationChannel(NOTIFICATION_CHANNEL_ID, "NOTIFICATION_CHANNEL_NAME", importance);
                mBuilder.setChannelId(NOTIFICATION_CHANNEL_ID);
                assert mNotificationManager != null;
                mNotificationManager.createNotificationChannel(notificationChannel);
            }
            assert mNotificationManager != null;
            mNotificationManager.notify((int) System.currentTimeMillis(), mBuilder.build());
            }
        });
    }
}