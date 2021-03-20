package com.example.prepare;


import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.example.prepare.Ringing;
import com.example.prepare.Task;

public class TaskReceiver extends BroadcastReceiver
{
    private final String TAG = "TaskReceiver";

    @Override
    public void onReceive(Context context, Intent intent)
    {
        Log.d(TAG, "onReceive");

        Intent newIntent = new Intent(context, Ringing.class);
        com.example.prepare.Task task = new com.example.prepare.Task();
        task.fromIntent(intent);
        task.toIntent(newIntent);
        newIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_SINGLE_TOP);

        context.startActivity(newIntent);
    }
}
