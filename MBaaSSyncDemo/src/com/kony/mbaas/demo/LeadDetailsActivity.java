package com.kony.mbaas.demo;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

public class LeadDetailsActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_leads_details);
		Intent intent = getIntent();

		((TextView) findViewById(R.id.fname)).setText(
				intent.getStringExtra("fn"), TextView.BufferType.EDITABLE);
		((TextView) findViewById(R.id.lname)).setText(
				intent.getStringExtra("ln"), TextView.BufferType.EDITABLE);
		((TextView) findViewById(R.id.name)).setText(
				intent.getStringExtra("n"), TextView.BufferType.EDITABLE);
		((TextView) findViewById(R.id.email)).setText(
				intent.getStringExtra("email"), TextView.BufferType.EDITABLE);
		((TextView) findViewById(R.id.phone)).setText(
				intent.getStringExtra("phone"), TextView.BufferType.EDITABLE);
		((TextView) findViewById(R.id.title)).setText(
				intent.getStringExtra("title"), TextView.BufferType.EDITABLE);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.leads_details, menu);
		return true;
	}
	public void home(View v) {

		/*Intent intent = new Intent(this, MenuActivity.class);
		startActivity(intent);
        finish();*/
	}
}
