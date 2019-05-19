package com.example.notification2cancelupdate;

import android.app.PendingIntent;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {


    Button buttonTriggerNotification, buttonCancel, buttonUpdate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonTriggerNotification = findViewById(R.id.buttonTriggerNotification);
        buttonCancel = findViewById(R.id.buttonCancel);
        buttonUpdate = findViewById(R.id.buttonUpdate);

        buttonTriggerNotification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                ((MyApplication) getApplication()).triggerNotification(NotificationDetailsActivity.class,
                        getString(R.string.NEWS_CHANNEL_ID),
                        "Sample Notification",
                        "This is a sample notification app",
                        "This is a sample notification created by Codetutor for demonstration of how to trigger notifications in Android app ",
                        NotificationCompat.PRIORITY_HIGH,
                        true,
                        getResources().getInteger(R.integer.notificationId),
                        PendingIntent.FLAG_UPDATE_CURRENT);
            }
        });

        buttonCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MyApplication) getApplication()).cancelNotification(getResources().getInteger(R.integer.notificationId));
            }
        });

        buttonUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MyApplication) getApplication()).updateNotification(NotificationDetailsActivity.class,
                        "Updated Notification",
                        "This is updatedNotification",
                        getString(R.string.NEWS_CHANNEL_ID),
                        getResources().getInteger(R.integer.notificationId),
                        "This is a updated information for bigpicture String",
                        PendingIntent.FLAG_UPDATE_CURRENT);
            }
        });
    }
}
