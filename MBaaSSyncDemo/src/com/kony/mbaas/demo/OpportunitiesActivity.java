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
/*import com.konylabs.androidsdk.MbaasException;
import com.konylabs.androidsdk.MbaasIntegrationService;
import com.konylabs.androidsdk.MbaasObjectCallback;*/

public class OpportunitiesActivity extends ListActivity {
	String auth_token = null;
	JSONObject opportunityListObj = null;
	IntegrationService mbaasint = null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		createOpportunity();
		
	}

	public void home(View v) {

		Intent intent = new Intent(this, MenuActivity.class);
		startActivity(intent);
		finish();
	}

	private void createOpportunity() {
		Log.d("Opportunity", "onCreate");
		View header = (View) getLayoutInflater().inflate(R.layout.activity_opportunities, null);
		Log.d("Opportunity", "AfterHeader");
		ListView lv = getListView();
		lv.addHeaderView(header);
		opportunityListObj = AppUtils.getSFOpportunityList();
		Log.d("Opportunity", "AfterHeader");
		JSONArray opportunityList = null;
		try {
			opportunityList = opportunityListObj.getJSONArray("Opportunity");
		} catch (JSONException e) {
			Log.d("Opportunity",
					"No Opportunity" + opportunityListObj.toString());
			return;
		}
		int numRecords = opportunityList.length();
		// Opportunity] list = new Opportunity[numRecords];
		List<ContactObj> list = new ArrayList<ContactObj>();

		for (int i = 0; i < numRecords; i++)
			try {
				ContactObj contact = new ContactObj();
				contact.setLine1(((JSONObject) opportunityList.get(i))
						.optString("Name"));
				contact.setImg("opportunity");

				contact.setLine2(((JSONObject) opportunityList.get(i))
						.optString("StageName"));
				contact.setLine3(((JSONObject) opportunityList.get(i))
						.optString("Type"));
				contact.setPercent(((JSONObject) opportunityList.get(i))
						.optString("Probability"));
				list.add(contact);

			} catch (JSONException e) {
				Log.d("Opportunity", "No Opportunitys Exception=" + e);
				return;
			}
		Log.d("Opportunity", "List Adapter");
		MyCustomAdapter adapter = new MyCustomAdapter(
				OpportunitiesActivity.this, (ArrayList<ContactObj>) list);
		setListAdapter(adapter);
	//	lv.setSelector(R.drawable.listselector);
		lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View view,
					final int position, long id) {
				
				//Toast.makeText(getApplicationContext(), "opppp", 3000).show();
				Intent intent = new Intent(OpportunitiesActivity.this,OppDetailsActivity.class);
				// NOTE
				try {
					intent.putExtra("name", ((JSONObject) opportunityListObj
							.getJSONArray("Opportunity").get(position - 1))
							.optString("Name"));
					intent.putExtra("percent", ((JSONObject) opportunityListObj
							.getJSONArray("Opportunity").get(position - 1))
							.optString("Probability"));
					intent.putExtra("type", ((JSONObject) opportunityListObj
							.getJSONArray("Opportunity").get(position - 1))
							.optString("Type"));
					intent.putExtra("amount", ((JSONObject) opportunityListObj
							.getJSONArray("Opportunity").get(position - 1))
							.optString("Amount"));
					intent.putExtra("source", ((JSONObject) opportunityListObj
							.getJSONArray("Opportunity").get(position - 1))
							.optString("LeadSource"));

					intent.putExtra("close", ((JSONObject) opportunityListObj
							.getJSONArray("Opportunity").get(position - 1))
							.optString("CloseDate"));
					intent.putExtra("revenue", ((JSONObject) opportunityListObj
							.getJSONArray("Opportunity").get(position - 1))
							.optString("ExpectedRevenue"));
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
		getMenuInflater().inflate(R.menu.opportunities, menu);
		return true;
	}

}
