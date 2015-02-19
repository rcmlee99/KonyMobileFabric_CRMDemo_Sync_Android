package com.kony.mbaas.demo;

import java.util.ArrayList;

import org.json.JSONObject;

import com.konylabs.android.commons.AppUtils;


import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MyCustomAdapter extends ArrayAdapter<ContactObj>{

	Context context;
	ContactObj [] contacts;
	JSONObject contactsListObj=null;
	public MyCustomAdapter(Context context, ArrayList<ContactObj> contacts) {
		super(context,R.layout.contactrow, contacts);
		this.context=context;
		contactsListObj = AppUtils.getSFContactsList();
	}
	
	@Override
	  public View getView(int position, View convertView, ViewGroup parent) {
		
	    LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	    View rowView = inflater.inflate(R.layout.contactrow, parent, false);
	    ContactObj contact = getItem(position);

	    TextView textView = (TextView) rowView.findViewById(R.id.line1);
	    textView.setText(contact.getLine1());
	    TextView textView2 = (TextView) rowView.findViewById(R.id.line2);
	    textView2.setText(contact.getLine2());
	    TextView textView3 = (TextView) rowView.findViewById(R.id.line3);
	    textView3.setText(contact.getLine3());
	    Log.d("Adapter","Line3="+contact.getLine3());
	    ImageView imageView = (ImageView) rowView.findViewById(R.id.icon);
	    if(contact.getImg().startsWith("contact")||contact.getImg().startsWith("lead"))
	    {
	    	imageView.setImageResource(R.drawable.contact);
	    }
	     
	    if(contact.getImg().startsWith("account"))
	    {
	    	imageView.setImageResource(R.drawable.account);
	    }
	    
	    if(contact.getImg().startsWith("opp"))
	    {
	    	Log.d("Adapter"," Opportunity");
	   
	    	String tmpperc = "p" + (int)Float.parseFloat(contact.getPercent());
	    	Log.d("Adapter"," Opportunity=" + tmpperc);
	    	int id = context.getResources().getIdentifier(tmpperc, "drawable","com.kony.mbaas.demo");
	    	Log.d("Adapter"," Opportunity="+id);
	    	imageView.setImageResource(id);
	    }
	     
	   
	    //   textView.setText((String)));
	    Log.d("Adapter","Iterating Rows");
	    return rowView;
	  }
	
}
