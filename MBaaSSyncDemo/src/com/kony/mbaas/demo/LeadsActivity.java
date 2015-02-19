package com.kony.mbaas.demo;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.ListActivity;
import android.content.Intent;
/*import com.konylabs.androidsdk.MbaasException;
import com.konylabs.androidsdk.MbaasIntegrationService;
import com.konylabs.androidsdk.MbaasObjectCallback;
*/
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.kony.sdk.services.integration.IntegrationService;
import com.konylabs.android.commons.AppUtils;


public class LeadsActivity  extends ListActivity {
	String auth_token = null;
	JSONObject leadsListObj = null;
	IntegrationService mbaasint = null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	       createLeads();
		
	}

	public void home(View v) {

		Intent intent = new Intent(this, MenuActivity.class);
		startActivity(intent);
		finish();
	}
	
	private void createLeads(){
		Log.d("Leads", "createContacts");
		View header = (View) getLayoutInflater().inflate(
				R.layout.activity_leads, null);
		
		ListView lv = getListView();
		lv.addHeaderView(header);
		leadsListObj = AppUtils.getSFLeadsList();
		Log.d("Leads", "createContacts=" +leadsListObj.toString());
		
		JSONArray contactsList = null;
		try {
			Log.d("Leads", "Contacts at Check");
			
			contactsList = leadsListObj.getJSONArray("Lead");
		} catch (JSONException e) {
			Log.d("Contact", "No Contacts" + leadsListObj.toString());
			return;

		}
		int numRecords = contactsList.length();;
		List<ContactObj> list = new ArrayList<ContactObj>();
	
		
		for (int i = 0; i < numRecords; i++)
			try {
				
				ContactObj contact = new ContactObj();
				contact.setLine1(((JSONObject) contactsList.get(i)).getString("FirstName")+" "+((JSONObject) contactsList.get(i)).optString("LastName"));
				contact.setImg("lead");
				if(!((JSONObject) contactsList.get(i)).isNull("Title")){
				contact.setLine2(((JSONObject) contactsList.get(i)).getString("Title"));
				}
			    list.add(contact);
			
			} catch (JSONException e) {
				Log.d("Leads", "No Leads Exception=" +e);
				return;
			}
		Log.d("Leads", "List Adapter");
		MyCustomAdapter adapter = new MyCustomAdapter(LeadsActivity.this,(ArrayList<ContactObj>)list);
		setListAdapter(adapter);

		lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View view,
					final int position, long id) {
				Intent intent = new Intent(LeadsActivity.this,
						LeadDetailsActivity.class);
				
				try {
					/*intent.putExtra("n", ((JSONObject) leadsListObj
							.getJSONArray("Lead").get(position - 1))
							.getString("Name"));*/
					intent.putExtra("fn", ((JSONObject) leadsListObj
							.getJSONArray("Lead").get(position - 1))
							.getString("FirstName"));
					intent.putExtra("ln", ((JSONObject) leadsListObj
							.getJSONArray("Lead").get(position - 1))
							.getString("LastName"));
					intent.putExtra("email", ((JSONObject) leadsListObj
							.getJSONArray("Lead").get(position - 1))
							.getString("Email"));
					intent.putExtra("phone", ((JSONObject) leadsListObj
							.getJSONArray("Lead").get(position - 1))
							.getString("Phone"));
					intent.putExtra("title", ((JSONObject) leadsListObj
							.getJSONArray("Lead").get(position - 1))
							.getString("Title"));
				} catch (JSONException e) {
					e.printStackTrace();
					return;
				}
				startActivity(intent);
			}

		});
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.contact, menu);
		return true;
	}

}
