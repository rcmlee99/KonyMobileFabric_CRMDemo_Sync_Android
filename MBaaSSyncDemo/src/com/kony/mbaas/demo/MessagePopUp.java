package com.kony.mbaas.demo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MessagePopUp extends Activity{
	
	Button b ;
	TextView tv;
	String msg="";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.msgpopup);
		Intent i = getIntent();
		b = (Button) findViewById(R.id.btnmsgok);
		tv = (TextView) findViewById(R.id.msgnew);
		
		
		msg	= i.getStringExtra("text");
		tv.setText(msg);
		
		b.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				finish();
			}
		});
	}

}
