package com.kony.mbaas.demo;

import com.kony.sdk.services.sync.codegen.Contact;
import com.konylabs.android.commons.AppUtils;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.TextureView;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

public class EditContactActivity extends Activity {
	Intent i;
	int pos;
	Contact c;
	EditText etFname,etLname,etMob,etEmail;
	TextView tvName,tvTitle;
	ImageButton imButtonSave;
	String fName,lName,mob,email;
	boolean isValid;
	Intent intent;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_edit_contact);
		etFname=(EditText)findViewById(R.id.editText_first_name);
		etLname=(EditText)findViewById(R.id.editText_last_name);
		etMob=(EditText)findViewById(R.id.editText_phone);
		etEmail=(EditText)findViewById(R.id.editText_email);
		tvName=(TextView)findViewById(R.id.textView_name);
		tvTitle=(TextView)findViewById(R.id.textView_title);
		imButtonSave=(ImageButton)findViewById(R.id.image_button_save);
		i=getIntent();
		pos=i.getIntExtra("position",0);
		c=AppUtils.getContactList().get(pos);
		setDetails();
		//intent=new Intent(EditContactActivity.this, ContactDetailsActivity.class);
		//intent.putExtra("position", pos);
		imButtonSave.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				isValid=true;
				validate();
				if(!isValid)
					return;
				c.setFirstName(fName);
				c.setLastName(lName);
				c.setPhone(mob);
				c.setEmail(email);
				//startActivity(intent);
				setDetails();
			}
		});
		
	}
	private void validate(){
		fName=etFname.getText().toString().trim();
		lName=etLname.getText().toString().trim();
		mob=etMob.getText().toString().trim();
		email=etEmail.getText().toString().trim();
		if(fName.matches("")){
			etFname.setError("first name required");
			isValid=false;
		}
		if(lName.matches("")){
			etLname.setError("last name required");
			isValid=false;
		}
		if(mob.matches("")){
			etMob.setError("phone no. required");
			isValid=false;
		}
		if(email.matches("")){
			etEmail.setError("email required");
			isValid=false;
		}
	}
	private void setDetails(){
		tvName.setText(c.getFirstName()+" "+c.getLastName());
		tvTitle.setText(c.getTitle());
		etFname.setText(c.getFirstName());
		etLname.setText(c.getLastName());
		etMob.setText(c.getPhone());
		etEmail.setText(c.getEmail());
	}
}