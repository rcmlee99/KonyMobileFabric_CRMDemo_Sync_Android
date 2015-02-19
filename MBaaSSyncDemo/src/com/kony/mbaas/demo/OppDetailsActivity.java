package com.kony.mbaas.demo;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class OppDetailsActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_opp_details);
		
		Intent intent = getIntent();

		((TextView) findViewById(R.id.name)).setText(
				intent.getStringExtra("name"), TextView.BufferType.EDITABLE);
		((TextView) findViewById(R.id.type)).setText(
				intent.getStringExtra("type"), TextView.BufferType.EDITABLE);
		((TextView) findViewById(R.id.amount)).setText(
				intent.getStringExtra("amount"), TextView.BufferType.EDITABLE);
		((TextView) findViewById(R.id.source)).setText(
				intent.getStringExtra("source"), TextView.BufferType.EDITABLE);
		((TextView) findViewById(R.id.close)).setText(
				intent.getStringExtra("close"), TextView.BufferType.EDITABLE);
		((TextView) findViewById(R.id.revenue)).setText(
				intent.getStringExtra("revenue"), TextView.BufferType.EDITABLE);
		//Opportunity ICON
		ImageView imageView = (ImageView) findViewById(R.id.icon);
		String tmpperc = "p" + (int)Float.parseFloat(intent.getStringExtra("percent"));  	
    	int id = getResources().getIdentifier(tmpperc, "drawable","com.kony.mbaas.demo");
    	imageView.setImageResource(id);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.opp_details, menu);
		return true;
	}
	public void home(View v) {
		/*Intent intent = new Intent(this, MenuActivity.class);
		startActivity(intent);
		finish();
*/
	}
}
