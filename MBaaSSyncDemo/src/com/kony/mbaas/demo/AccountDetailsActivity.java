package com.kony.mbaas.demo;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

public class AccountDetailsActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_account_details);
		
		Intent intent = getIntent();

		((TextView) findViewById(R.id.name)).setText(
				intent.getStringExtra("name"), TextView.BufferType.EDITABLE);
		((TextView) findViewById(R.id.phone)).setText(
				intent.getStringExtra("phone"), TextView.BufferType.EDITABLE);
		
		((TextView) findViewById(R.id.baddress)).setText(
				intent.getStringExtra("baddress"), TextView.BufferType.EDITABLE);
	
		((TextView) findViewById(R.id.bcity)).setText(
				( intent.getStringExtra("bcity")+" "+intent.getStringExtra("bstate")), TextView.BufferType.EDITABLE);
		
		((TextView) findViewById(R.id.industry)).setText(
				intent.getStringExtra("industry"), TextView.BufferType.EDITABLE);
		((TextView) findViewById(R.id.type)).setText(
				intent.getStringExtra("type"), TextView.BufferType.EDITABLE);
		
		
		((TextView) findViewById(R.id.website)).setText(
				intent.getStringExtra("website"), TextView.BufferType.EDITABLE);
		

		if(intent.getStringExtra("email").length() >0){
			((TextView) findViewById(R.id.email)).setText(
					intent.getStringExtra("email"), TextView.BufferType.EDITABLE);
		}
	}

	public void home(View v) {

		/*Intent intent = new Intent(this, MenuActivity.class);
		startActivity(intent);
         finish();*/
	}

	/*public void back(View v) {

		Intent intent = new Intent(this, ContactActivity2.class);
		startActivity(intent);

	}
	*/
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.account_details, menu);
		return true;
	}

}
