package com.kony.mbaas.demo;



import com.kony.sdk.services.sync.codegen.Contact;
import com.konylabs.android.commons.AppUtils;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;

import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class ContactDetailsActivity extends Activity {
int pos;
ImageButton iMageButtonEdit;
Contact c;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_contact_details);
		iMageButtonEdit=(ImageButton)findViewById(R.id.image_button_edit);
		Intent intent = getIntent();
		pos=intent.getIntExtra("position",0);
		iMageButtonEdit.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i=new Intent(ContactDetailsActivity.this,EditContactActivity.class);
				i.putExtra("position", pos);
				startActivity(i);
			}
		});
		setDetails();
	}

	public void home(View v) {

		/*Intent intent = new Intent(this, MenuActivity.class);
		startActivity(intent);
		 finish();*/
	}

	/*public void back(View v) {

		Intent intent = new Intent(this, ContactActivity2.class);
		startActivity(intent);

	}*/

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.contact_details, menu);
		return true;
	}
	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		setDetails();
		//Toast.makeText(ContactDetailsActivity.this, "resume", 2000).show();
	}
	private void setDetails(){
		c=AppUtils.getContactList().get(pos);
	//	System.out.println(c.getName());
		((TextView) findViewById(R.id.fname)).setText(
				c.getFirstName(), TextView.BufferType.EDITABLE);
		((TextView) findViewById(R.id.lname)).setText(
				c.getLastName(), TextView.BufferType.EDITABLE);
		((TextView) findViewById(R.id.name)).setText(
				c.getFirstName()+" "+c.getLastName(), TextView.BufferType.EDITABLE);
		((TextView) findViewById(R.id.email)).setText(
				c.getEmail(), TextView.BufferType.EDITABLE);
		((TextView) findViewById(R.id.phone)).setText(
				c.getPhone(), TextView.BufferType.EDITABLE);
		((TextView) findViewById(R.id.title)).setText(
				c.getTitle(), TextView.BufferType.EDITABLE);
	}
}
