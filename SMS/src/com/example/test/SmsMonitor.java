package com.example.test;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.SmsMessage;
import android.util.Log;
import android.widget.Toast;

public class SmsMonitor extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		// TODO Auto-generated method stub
		Log.d("cyd", intent.getAction());
		if (intent != null && intent.getAction() != null) {
			Object[] pduArray = (Object[]) intent.getExtras().get("pdus");
			SmsMessage[] messages = new SmsMessage[pduArray.length];
			for (int i = 0; i < pduArray.length; i++) {
				messages[i] = SmsMessage.createFromPdu((byte[]) pduArray[i]);
			}
			StringBuilder sb = new StringBuilder();
			for (SmsMessage cur : messages) {
				sb.append("from£º");
				sb.append(cur.getDisplayOriginatingAddress());
				sb.append(" body£º");
				sb.append(cur.getDisplayMessageBody());
			}
			Toast.makeText(context, sb.toString(), Toast.LENGTH_LONG).show();
		}
	}

}
