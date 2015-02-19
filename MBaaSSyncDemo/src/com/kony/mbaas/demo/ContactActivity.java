package com.kony.mbaas.demo;

import java.util.ArrayList;
import java.util.List;

import com.kony.sdk.client.KonyFactory;
import com.kony.sdk.common.KonyException;
import com.kony.sdk.services.sync.Sync;
import com.kony.sdk.services.sync.SyncFactory;
import com.kony.sdk.services.sync.SyncOptions;
import com.kony.sdk.services.sync.callback.SyncObjectListCallback;
import com.kony.sdk.services.sync.codegen.Contact;
import com.kony.sdk.services.sync.listener.SyncBatchContext;
import com.kony.sdk.services.sync.listener.SyncContext;
import com.kony.sdk.services.sync.listener.SyncErrorContext;
import com.kony.sdk.services.sync.listener.SyncListener;
import com.kony.sdk.services.sync.listener.SyncSummaryContext;
import com.kony.sdk.services.sync.listener.SyncUpgradeScriptsContext;
import com.konylabs.android.commons.AppUtils;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ListView;

public class ContactActivity extends Activity {
	ImageButton imBtnSync;
	ListView listViewContact;
	ProgressDialog progressDialog;
	MyCustomAdapter adapter;
	int pos;
	List<ContactObj> contactObjList;
	List<Contact> list;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_contact);
		imBtnSync=(ImageButton)findViewById(R.id.img_btn_sync);
		imBtnSync.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				progressDialog=new LoadingDialog().getLoadingDialog(ContactActivity.this);
				progressDialog.setMessage("sync in progress..");
				progressDialog.show();
				SyncFactory.getSyncDataStoreInstance().bulkSaveInBackground(AppUtils.getContactList(),
					new SyncObjectListCallback<Contact>() {
					private SyncOptions mSyncOptions;
					private Sync mSync;
					@Override
					public void onFailure(KonyException arg0) {
						// TODO Auto-generated method stub
					}
					@Override
					public void onSuccess(List<Contact> arg0) {
						// TODO Auto-generated method stub
						System.out.println("DB updated successfully..");
						try {
							mSyncOptions=new SyncOptions();
							mSync=new KonyFactory().getSyncService();
							//mSync.initSync();
							mSync.setSyncOptions(mSyncOptions);
							mSync.addListener(new SyncListener() {
								@Override
								public void onUploadSuccess(SyncSummaryContext arg0) {
									// TODO Auto-generated method stub
								}
								@Override
								public void onUploadStart(SyncContext arg0) {
									// TODO Auto-generated method stub
								}
								@Override
								public void onUploadError(SyncErrorContext arg0) {
									// TODO Auto-generated method stub
								}
								@Override
								public void onUploadBatchSuccess(SyncBatchContext arg0) {
									// TODO Auto-generated method stub
								}
								@Override
								public void onUploadBatchStart(SyncContext arg0) {
									// TODO Auto-generated method stub
								}
								@Override
								public void onUploadBatchError(SyncErrorContext arg0) {
									// TODO Auto-generated method stub
								}
								@Override
								public void onUpgradeScriptsExecutionSuccess(SyncUpgradeScriptsContext arg0) {
									// TODO Auto-generated method stub
								}
								@Override
								public List<String> onUpgradeScriptsExecutionStart(
									SyncUpgradeScriptsContext arg0) {
									// TODO Auto-generated method stub
									return null;
									}
								@Override
								public void onUpgradeScriptsExecutionError(SyncErrorContext arg0) {
									// TODO Auto-generated method stub
								}
								@Override
								public void onUpgradeScriptsDownloadSuccess(SyncUpgradeScriptsContext arg0) {
									// TODO Auto-generated method stub
								}
								@Override
								public void onUpgradeScriptsDownloadStart(SyncContext arg0) {
									// TODO Auto-generated method stub
								}
								@Override
								public void onUpgradeScriptsDownloadError(SyncErrorContext arg0) {
									// TODO Auto-generated method stub
								}
								@Override
								public void onSyncSuccess(SyncSummaryContext arg0) {
									// TODO Auto-generated method stub
									progressDialog.dismiss();
									System.out.println("sync success..");
								}
								@Override
								public void onSyncStart(SyncContext arg0) {
									// TODO Auto-generated method stub
								}
								@Override
								public void onSyncError(SyncErrorContext arg0) {
									// TODO Auto-generated method stub
								}
								@Override
								public void onRegisterDeviceSuccess(SyncContext arg0) {
									// TODO Auto-generated method stub
								}
								@Override
								public void onRegisterDeviceStart(SyncContext arg0) {
									// TODO Auto-generated method stub
								}
								@Override
								public void onRegisterDeviceError(SyncErrorContext arg0) {
									// TODO Auto-generated method stub
								}
								@Override
								public void onPerformUpgradeSuccess(SyncSummaryContext arg0) {
									// TODO Auto-generated method stub
								}
								@Override
								public void onPerformUpgradeStart(SyncContext arg0) {
									// TODO Auto-generated method stub
								}
								@Override
								public void onPerformUpgradeError(SyncErrorContext arg0) {
									// TODO Auto-generated method stub
								}
								@Override
								public void onIsSchemaUpgradeRequiredSuccess(SyncContext arg0) {
									// TODO Auto-generated method stub
								}
								@Override
								public void onIsSchemaUpgradeRequiredStart(SyncContext arg0) {
									// TODO Auto-generated method stub
								}
								@Override
								public void onIsSchemaUpgradeRequiredError(SyncErrorContext arg0) {
									// TODO Auto-generated method stub
								}
								@Override
								public void onDownloadSuccess(SyncSummaryContext arg0) {
									// TODO Auto-generated method stub
								}
								@Override
								public void onDownloadStart(SyncContext arg0) {
									// TODO Auto-generated method stub
								}
								@Override
								public void onDownloadError(SyncErrorContext arg0) {
									// TODO Auto-generated method stub
								}
								@Override
								public void onDownloadBatchSuccess(SyncBatchContext arg0) {
									// TODO Auto-generated method stub
								}
								@Override
								public void onDownloadBatchStart(SyncContext arg0) {
									// TODO Auto-generated method stub
								}
								@Override
								public void onDownloadBatchError(SyncErrorContext arg0) {
									// TODO Auto-generated method stub
								}
							});
							mSync.startSessionInBackground();
						} catch (KonyException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					});
			}
		});
		listViewContact=(ListView)findViewById(R.id.listView_contact);
		listViewContact.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View view,
					final int position, long id) {
				/*Contact c=AppUtils.getContactList().get(position-1);
				System.out.println("Name:-"+c.getName());
				System.out.println("First Name:-"+c.getFirstName());
				System.out.println("Last Name:-"+c.getLastName());
				System.out.println("Mob:-"+c.getPhone());
				System.out.println("email:-"+c.getEmail());*/
				Intent intent = new Intent(ContactActivity.this,
						ContactDetailsActivity.class);
				pos=position;
				intent.putExtra("position", position);
				startActivity(intent);
			}
		});
		setContact();
	}
	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		//setContact();
		list=AppUtils.getContactList();
		ContactObj contactObj=contactObjList.get(pos);
		contactObj.setLine1((list.get(pos)).getFirstName()+" "+((list.get(pos)).getLastName()));
		contactObj.setImg("contact");
		contactObj.setLine2((list.get(pos)).getTitle());
		contactObj.setLine3(" ");
		adapter.notifyDataSetChanged();
		
	}
	private void setContact(){
		list=AppUtils.getContactList();
		contactObjList=new ArrayList<ContactObj>();
		ContactObj contactObj;
		for (int i = 0; i <list.size(); i++)
		{
				contactObj = new ContactObj();
				contactObj.setLine1((list.get(i)).getFirstName()+" "+((list.get(i)).getLastName()));
				contactObj.setImg("contact");
				contactObj.setLine2((list.get(i)).getTitle());
				contactObj.setLine3(" ");
				contactObjList.add(contactObj);
		}
		adapter = new MyCustomAdapter(ContactActivity.this,(ArrayList<ContactObj>) contactObjList);
		listViewContact.setAdapter(adapter);
	}
}
