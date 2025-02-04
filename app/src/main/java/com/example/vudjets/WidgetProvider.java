package com.example.vudjets;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraManager;
import android.os.Build;
import android.util.Log;
import android.widget.RemoteViews;

public class WidgetProvider extends AppWidgetProvider {

    private static boolean isFlashOn = false;
    private static final String TOGGLE_FLASHLIGHT = "com.example.vudjets.TOGGLE_FLASHLIGHT";

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        for (int appWidgetId : appWidgetIds) {
            updateAppWidget(context, appWidgetManager, appWidgetId);
        }
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        super.onReceive(context, intent);

        if (TOGGLE_FLASHLIGHT.equals(intent.getAction())) {
            toggleFlashlight(context);
            updateAllWidgets(context); // Update widgets after toggling
        }
    }

    static void updateAppWidget(Context context, AppWidgetManager appWidgetManager, int appWidgetId) {
        RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.widget_view);
        Intent intent = new Intent(context, WidgetProvider.class); //Use WidgetProvider for onReceive
        intent.setAction(TOGGLE_FLASHLIGHT); // Use the action directly
        PendingIntent pendingIntent = PendingIntent.getBroadcast(context, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT | PendingIntent.FLAG_IMMUTABLE); //Flag immutable is mandatory
        views.setOnClickPendingIntent(R.id.widget_flashlight_button, pendingIntent);

        // Update the button text based on the flashlight state.
        views.setTextViewText(R.id.widget_flashlight_button, isFlashOn ? "Turn Off" : "Turn On");
        appWidgetManager.updateAppWidget(appWidgetId, views);
    }

    private void toggleFlashlight(Context context) {
        CameraManager cameraManager = (CameraManager) context.getSystemService(Context.CAMERA_SERVICE);
        try {
            String cameraId = cameraManager.getCameraIdList()[0];
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                try {
                    cameraManager.setTorchMode(cameraId, !isFlashOn);
                    isFlashOn = !isFlashOn;
                } catch (CameraAccessException e) {
                    Log.e("WidgetProvider", "Error accessing camera: " + e.getMessage());
                }
            } else {
                Log.w("WidgetProvider", "Torch Mode control requires API level 23+");
            }
        } catch (CameraAccessException e) {
            Log.e("WidgetProvider", "Error accessing camera: " + e.getMessage());
        }
    }

    private void updateAllWidgets(Context context) {
        AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(context);
        int[] appWidgetIds = appWidgetManager.getAppWidgetIds(new ComponentName(context, WidgetProvider.class));

        for (int appWidgetId : appWidgetIds) {
            updateAppWidget(context, appWidgetManager, appWidgetId);
        }
    }
}