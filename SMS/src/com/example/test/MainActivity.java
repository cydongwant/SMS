package com.example.test;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.drm.DrmStore.RightsStatus;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener {
	private static final String ACTION = "android.provider.Telephony.SMS_RECEIVED";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		findViewById(R.id.send_message).setOnClickListener(this);
		findViewById(R.id.call_phone).setOnClickListener(this);
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
//		registerReceiver(new BroadcastReceiver() {
//
//			@Override
//			public void onReceive(Context context, Intent intent) {
//				// TODO Auto-generated method stub
//				Log.d("cyd", intent.getAction());
//				finish();
//			}
//		}, new IntentFilter(ACTION));
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.call_phone:
			callPhone();
			break;
		case R.id.send_message:

			sendMessage();
			break;

		default:
			break;
		}
	}

	private void callPhone() {
		// TODO Auto-generated method stub
		Intent intent = new Intent();
		intent.setAction(Intent.ACTION_CALL);
		intent.setData(Uri.parse("tel:" + "15666666666"));
		startActivity(intent);
	}

	private void sendMessage() {
		// TODO Auto-generated method stub
		SmsManager smanager = SmsManager.getDefault();
		smanager.sendTextMessage("10086", null, "hello", null, null);
		// Intent it = new Intent();
		// it.setAction(Intent.ACTION_SENDTO);
		// it.setData(Uri.parse("smsto:10086"));
		// it.putExtra("sms_body", "000");
		// startActivity(it);
		// sendBroadcast(new Intent(ACTION));
	}
}
