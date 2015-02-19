package com.kony.mbaas.demo;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.kony.sdk.services.integration.IntegrationService;
import com.konylabs.android.commons.AppUtils;
/*import com.konylabs.android.commons.AppUtils;
import com.konylabs.androidsdk.MbaasException;
import com.konylabs.androidsdk.MbaasIntegrationService;
import com.konylabs.androidsdk.MbaasObjectCallback;*/

public class AccountsActivity extends ListActivity {
	String auth_token = null;
	JSONObject accountsListObj = null;
	IntegrationService mbaasint = null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		createAccounts();
		
		}

		public void home(View v) {

			Intent intent = new Intent(this, MenuActivity.class);
			startActivity(intent);
            finish();
		}
		
		private void createAccounts(){
			Log.d("Account", "onCreate");
			View header = (View) getLayoutInflater().inflate(
					R.layout.activity_accounts, null);
			
			ListView lv = getListView();
			lv.addHeaderView(header);
			accountsListObj = AppUtils.getSFAccountsList();
			
			JSONArray ContactObjObjObjObjsList = null;
			try {
				ContactObjObjObjObjsList = accountsListObj.getJSONArray("Account");
			} catch (JSONException e) {
			
				return;

			}
			int numRecords = ContactObjObjObjObjsList.length();
			List<ContactObj> list= new ArrayList<ContactObj>();
		
			
			for (int i = 0; i < numRecords; i++)
				try {
					Log.d("Account", "Iterating Accounts="+((JSONObject) ContactObjObjObjObjsList.get(i)).getString("Name"));
					ContactObj ContactObjObjObjObj = new ContactObj();
					ContactObjObjObjObj.setLine1(((JSONObject) ContactObjObjObjObjsList.get(i)).getString("Name"));
					ContactObjObjObjObj.setImg("account");
					if(!((JSONObject) ContactObjObjObjObjsList.get(i)).isNull("BillingCity")){
				
						
						ContactObjObjObjObj.setLine2(((JSONObject) ContactObjObjObjObjsList.get(i)).getString("BillingCity"));
						
					
					}
					if(!((JSONObject) ContactObjObjObjObjsList.get(i)).isNull("BillingState")){
						ContactObjObjObjObj.setLine2(ContactObjObjObjObj.getLine2()+","+((JSONObject) ContactObjObjObjObjsList.get(i)).getString("BillingState"));
						
					}
					
					if(!((JSONObject) ContactObjObjObjObjsList.get(i)).isNull("Type")){
					ContactObjObjObjObj.setLine3(((JSONObject) ContactObjObjObjObjsList.get(i)).getString("Type"));
					}
				    list.add(ContactObjObjObjObj);
				
				} catch (JSONException e) {
					Log.d("Account", "No Accounts Exception=" +e);
					return;
				}
		
			MyCustomAdapter adapter = new MyCustomAdapter(AccountsActivity.this,(ArrayList<ContactObj>)list);
			setListAdapter(adapter);

			lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
				public void onItemClick(AdapterView<?> parent, View view,
						final int position, long id) {
					Intent intent = new Intent(AccountsActivity.this,
							AccountDetailsActivity.class);
					try {
						intent.putExtra("name", ((JSONObject) accountsListObj
								.getJSONArray("Account").get(position - 1))
								.optString("Name"));
						
						intent.putExtra("phone", ((JSONObject) accountsListObj
								.getJSONArray("Account").get(position - 1))
								.optString("Phone"));
						
						intent.putExtra("baddress", ((JSONObject) accountsListObj
								.getJSONArray("Account").get(position - 1))
								.optString("BillingStreet"));
						intent.putExtra("bcity", ((JSONObject) accountsListObj
								.getJSONArray("Account").get(position - 1))
								.optString("BillingCity"));
						intent.putExtra("bstate", ((JSONObject) accountsListObj
								.getJSONArray("Account").get(position - 1))
								.optString("BillingState"));
						intent.putExtra("industry", ((JSONObject) accountsListObj
								.getJSONArray("Account").get(position - 1))
								.optString("Industry"));
						intent.putExtra("type", ((JSONObject) accountsListObj
								.getJSONArray("Account").get(position - 1))
								.optString("Type"));
				
						intent.putExtra("website", ((JSONObject) accountsListObj
								.getJSONArray("Account").get(position - 1))
								.optString("Website"));
					
						intent.putExtra("email", ((JSONObject) accountsListObj
								.getJSONArray("Account").get(position - 1))
								.optString("Email"));
					 
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
		getMenuInflater().inflate(R.menu.accounts, menu);
		return true;
	}

}
