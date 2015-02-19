package com.kony.mbaas.demo;


/*import com.konylabs.androidsdk.MbaasAuthenticationService;

import com.konylabs.androidsdk.MbaasBooleanCallback;
import com.konylabs.androidsdk.MbaasException;*/

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONObject;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;

import com.kony.sdk.callback.InitCallback;
import com.kony.sdk.callback.IntegrationServiceCallback;
import com.kony.sdk.callback.LoginCallback;
import com.kony.sdk.callback.LogoutCallback;
import com.kony.sdk.client.KonyClient;
import com.kony.sdk.client.KonyFactory;
import com.kony.sdk.client.KonyUser;
import com.kony.sdk.common.IdentityServiceException;
import com.kony.sdk.common.IntegrationServiceException;
import com.kony.sdk.common.KonyException;
import com.kony.sdk.services.identity.IdentityService;
import com.kony.sdk.services.integration.IntegrationService;
import com.kony.sdk.services.sync.Sync;
import com.kony.sdk.services.sync.SyncFactory;
import com.kony.sdk.services.sync.SyncOptions;
import com.konylabs.android.commons.AppUtils;
import com.kony.sdk.services.sync.callback.SyncCallback;
import com.kony.sdk.services.sync.codegen.Contact;
import com.kony.sdk.services.sync.listener.SyncBatchContext;
import com.kony.sdk.services.sync.listener.SyncContext;
import com.kony.sdk.services.sync.listener.SyncErrorContext;
import com.kony.sdk.services.sync.listener.SyncListener;
import com.kony.sdk.services.sync.listener.SyncSummaryContext;
import com.kony.sdk.services.sync.listener.SyncUpgradeScriptsContext;

public class MenuActivity extends Activity {
	IntegrationService mbaasint = null;
	  private ProgressDialog progressDialog;
	  private JSONObject jsonobj = null;
	  IdentityService mIdentityService;
	  Sync mSync;
	  SyncOptions mSyncOptions;
	  Map<String, String> parameters = new HashMap<String, String>();
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_menu);
		progressDialog = LoadingDialog.getLoadingDialog(this);
	}
	@Override
	public void onBackPressed() {
	return;
	}
	public void contacts(View v) {
		if(MyApplication.iSEmpty){
			System.out.println("db is empty");
			progressDialog.setMessage("preparing database..");
			progressDialog.show();
			syncReset();
		}else{
			Intent intent = new Intent(MenuActivity.this, ContactActivity.class);
			startActivity(intent);
		}
	}
	/*public void initSync(){
		try{
			System.out.println("Initializing KonyClient in background.");
	        KonyClient.initInBackground(MenuActivity.this,AppUtils.APPKEY,AppUtils.APPSECRET
	        		,AppUtils.SERVICE_URL,new InitCallback() {
				@Override
				public void onSuccess(JSONObject arg0) {
					// TODO Auto-generated method stub
					System.out.println("Init success:-");
					loginSync();
				}
				@Override
				public void onFailure(KonyException arg0) {
					// TODO Auto-generated method stub
					System.out.println("init failed.");
				}
			});
		}
		catch (KonyException exception) {
			exception.printStackTrace();
		}
	}*/
	/*public void loginSync(){
		LoginCallback ic=   new LoginCallback() {
            public void onSuccess(KonyUser serviceDoc) {
            	System.out.println("Success in mbaas Login:toString is:"+serviceDoc.toString()+":getEmail:"+serviceDoc.getEmail()+":getFirstName:"+serviceDoc.getFirstName()+":getLastName:"+serviceDoc.getLastName()+":getUserId:"+serviceDoc.getUserId());
            	syncReset();
            }
            public void onFailure(IdentityServiceException error) {
            	System.out.println("failed in mbaas Login");
            }
		};
		try {
			mIdentityService= new KonyFactory().getIdentityService("SForceIdentity");
			mIdentityService.loginInBackground("sreenivasn@gmail.com", "Kony@(877uJ8SgCQtfWM8h64QgzSUJxu",ic);
		} catch (KonyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}*/
	public void syncReset(){
		try {
			mSync = new KonyFactory().getSyncService();
			mSync.resetSyncInBackground(new SyncCallback() {
				@Override
				public void onFailure(KonyException e) {
					System.out.println("Reset failure"+e.getMessage());
				}
				@Override
				public void onSuccess() {
					System.out.println("Reset success");
					progressDialog.setMessage("Sync in progress..");
					doSync();
				}
			});
		} catch (KonyException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	public void doSync(){
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
				//	progressDialog.setMessage("uploading..");
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
					System.out.println("sync success");
					//getContactFromDB();
				//	progressDialog.setMessage("fetching data..");
					List<Contact> contacts;
					
					try {
						contacts=SyncFactory.getSyncDataStoreInstance().getAll(Contact.class);
						AppUtils.setContactList(contacts);
						Intent intent = new Intent(MenuActivity.this, ContactActivity.class);
						startActivity(intent);
						progressDialog.dismiss();
						MyApplication.iSEmpty=false;
					} catch (KonyException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				@Override
				public void onSyncStart(SyncContext arg0) {
					// TODO Auto-generated method stub
			//		progressDialog.setMessage("Sync in progress..");
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
				//	progressDialog.setMessage("downloading..");
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
	/*public void getContactFromDB(){
		//getting object.
		List<Contact> cntcs;
		try {
			System.out.println("getting object..");
			cntcs = SyncFactory.getSyncDataStoreInstance().getAll(Contact.class);
			System.out.println("Size="+cntcs.size());
			Contact aa;
			for (int i=0;i<cntcs.size();i++){
				 aa = cntcs.get(i);
				 System.out.println("Name is:-"+aa.getFirstName()+",Id:-"+aa.getId()); 
				// Contact c=AppUtils.getContactList().get(i);
					System.out.println("Name:-"+aa.getName());
					System.out.println("First Name:-"+aa.getFirstName());
					System.out.println("Last Name:-"+aa.getLastName());
					System.out.println("Mob:-"+aa.getPhone());
					System.out.println("email:-"+aa.getEmail());
			}
		} catch (KonyException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}*/
	public void leads(View v) {

		getDataFromService("getLead");
	}
	public void opportunities(View v) {
		getDataFromService("getOpportunity");
	}

	public void accounts(View v) {
		getDataFromService("getAccount");
	}
	public void logout(View v) {
		 IdentityService mbaasauth = AppUtils.getAuthObject();
		 mbaasauth.logoutInBackground(new LogoutCallback() {
			@Override
			public void onSuccess(boolean arg0) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(MenuActivity.this,
				LoginActivity.class);
				startActivity(intent);
				SharedPreferences prefs = getSharedPreferences("MbaasRegistrationId",Context.MODE_PRIVATE);
				SharedPreferences.Editor editor = prefs.edit();
				editor.putBoolean("login", false);
			    editor.commit();
				finish();
			}
			@Override
			public void onFailure(IdentityServiceException arg0) {
				// TODO Auto-generated method stub
			}
		});
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.menu, menu);
		return true;
	}
	public void getDataFromService(final String item){
		KonyFactory mbaasFactory = new KonyFactory();
        /*if(item.equalsIgnoreCase("getContact")){
        	// calling Contacts integration service with a queryString
        	try {
        		mbaasint = mbaasFactory.getIntegrationService("SFContact");
        	} catch (KonyException e) {
        		// TODO Auto-generated catch block
        		e.printStackTrace();
        	}
        	jsonobj = AppUtils.getSFContactsList();
        	parameters.put("queryString", "SELECT ID,NAME,FIRSTNAME,LASTNAME,TITLE,PHONE,EMAIL FROM Contact");
         }
         else*/ 
		if(item.equalsIgnoreCase("getOpportunity")){
        	try {
        		mbaasint = mbaasFactory.getIntegrationService(AppUtils.OPPORTUNITY_INTEGRATION_SERVICE);
        	} catch (KonyException e) {
        		// TODO Auto-generated catch block
        		e.printStackTrace();
        	}
        	jsonobj = AppUtils.getSFOpportunityList();
        	parameters.put("queryString", "SELECT name,Amount,CloseDate,Type,LeadSource,StageName,ExpectedRevenue,Probability from Opportunity");
         }
         else if(item.equalsIgnoreCase("getAccount")){
        	 try {
				mbaasint = mbaasFactory.getIntegrationService(AppUtils.ACCOUNT_INTEGRATION_SERVICE);
        	 } catch (KonyException e) {
        		 // TODO Auto-generated catch block
        		 e.printStackTrace();
        	 }
        	 jsonobj = AppUtils.getSFAccountsList();
        	 parameters.put("queryString", "SELECT name,type,BillingCity,BillingState,AnnualRevenue,website,Industry,phone,BillingStreet from Account where type!=null");
         }
         else if(item.equalsIgnoreCase("getLead"))
         {
        	 try {
				mbaasint = mbaasFactory.getIntegrationService(AppUtils.LEAD_INTEGRATION_SERVICE);
			} catch (KonyException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	 parameters.put("queryString", "SELECT ID,NAME,FIRSTNAME,LASTNAME,TITLE,PHONE,EMAIL FROM Lead");
             jsonobj = AppUtils.getSFLeadsList();
         }
         if (jsonobj == null) {
        	 progressDialog.setMessage("fetching data..");
			 progressDialog.show();
			
		//	parameters.put("Authorization", AppUtils.getAuthHeader());
			// Invoking opration on Integration service and retrieving data. 
			mbaasint.invokeOperationInBackground(item, null, parameters, new IntegrationServiceCallback() {
				
				@Override
				public void onSuccess(JSONObject response) {
					Log.d(item, item+" Response="+ response);
					progressDialog.cancel();
					/* if(item.equalsIgnoreCase("getContact"))
					 {
							AppUtils.setSFContactsList(response);
							Intent intent = new Intent(MenuActivity.this, ContactActivity2.class);
							startActivity(intent);
					 }*/
					if(item.equalsIgnoreCase("getOpportunity"))
					 {
						    AppUtils.setSFOpportunityList(response);
							Intent intent = new Intent(MenuActivity.this, OpportunitiesActivity.class);
							startActivity(intent);
					 }
					  else if(item.equalsIgnoreCase("getAccount"))
					  {
						    AppUtils.setSFAccountsList(response);
							Intent intent = new Intent(MenuActivity.this, AccountsActivity.class);
							startActivity(intent);
					  }
					  else if(item.equalsIgnoreCase("getLead"))
					  {
						    AppUtils.setSFLeadsList(response);
							Intent intent = new Intent(MenuActivity.this, LeadsActivity.class);
							startActivity(intent);
					  }
				}
				@Override
				public void onFailure(IntegrationServiceException arg0) {
					// TODO Auto-generated method stub
					progressDialog.cancel();
					AlertDialog.Builder alertDialog = new AlertDialog.Builder(
							MenuActivity.this);
					alertDialog.setTitle("Service Error");
					alertDialog.setMessage(arg0.getMessage());
					alertDialog.setNeutralButton("Ok",
							new DialogInterface.OnClickListener() {
								public void onClick(
										DialogInterface dialog,
										int which) {
								}
							});
					alertDialog.show();
				}
			});
		
		} 
		else
		{
			/* if(item.equalsIgnoreCase("getContact"))
			  {
 			        Intent intent = new Intent(MenuActivity.this, ContactActivity2.class);
			        startActivity(intent);
			  }
			  else*/ if(item.equalsIgnoreCase("getOpportunity"))
			  {
					Intent intent = new Intent(MenuActivity.this, OpportunitiesActivity.class);
					startActivity(intent);
			  }
			  else if(item.equalsIgnoreCase("getAccount"))
			  {
					Intent intent = new Intent(MenuActivity.this, AccountsActivity.class);
					startActivity(intent);
			  }
			  else if(item.equalsIgnoreCase("getLead"))
			  {
					Intent intent = new Intent(MenuActivity.this, LeadsActivity.class);
					startActivity(intent);
			  }
		}
	}
	/*public void getOpportunities()
	{
		if (AppUtils.getSFOpportunityList() == null) {
			progressDialog.show();
			HashMap<String, String> parameters = new HashMap<String, String>();
			//parameters.put("Authorization", AppUtils.getAuthHeader());
			KonyFactory mbaasFactory = new KonyFactory();
            mbaasint = mbaasFactory.getIntegrationService("SalesForceDetails");
             mbaasint.invokeOperationInBackground("getOpportunity", parameters,new IntegrationServiceCallback() {
				@Override
				public void onSuccess(JSONObject response) {
					// TODO Auto-generated method stub
					progressDialog.cancel();
					AppUtils.setSFOpportunityList(response);
					Log.d("Opportunity", "Opportunity Response="+ response);
					Intent intent = new Intent(MenuActivity.this, OpportunitiesActivity.class);
					startActivity(intent);
				}
				@Override
				public void onFailure(IntegrationServiceException arg0) {
					// TODO Auto-generated method stub
					progressDialog.cancel();
					AlertDialog.Builder alertDialog = new AlertDialog.Builder(
							MenuActivity.this);
					alertDialog.setTitle("Service Error");
					alertDialog.setMessage(arg0.getMessage());
					alertDialog.setNeutralButton("Ok",
							new DialogInterface.OnClickListener() {
								public void onClick(
										DialogInterface dialog,
										int which) {
								}
							});
					alertDialog.show();
				}
			});
		} else {
			Intent intent = new Intent(MenuActivity.this, OpportunitiesActivity.class);
			startActivity(intent);
		}
	}
	public void getAccounts()
	{
		if (AppUtils.getSFAccountsList()==null){
			 progressDialog.show();
			Map<String, String> parameters = new HashMap<String, String>();
			parameters.put("Authorization", AppUtils.getAuthHeader());
			KonyFactory mbaasFactory = new KonyFactory();
            mbaasint = mbaasFactory.getIntegrationService("SalesForceDetails");
			mbaasint.invokeOperationInBackground("getAccount", parameters, new IntegrationServiceCallback() {
				
				@Override
				public void onSuccess(JSONObject response) {
					progressDialog.cancel();
					AppUtils.setSFAccountsList(response);
					Intent intent = new Intent(MenuActivity.this, AccountsActivity.class);
					startActivity(intent);
					
				}
				
				@Override
				public void onFailure(IntegrationServiceException arg0) {
					progressDialog.cancel();
					AlertDialog.Builder alertDialog = new AlertDialog.Builder(
							MenuActivity.this);
					alertDialog.setTitle("Service Error");
					alertDialog.setMessage(arg0.getMessage());
					alertDialog.setNeutralButton("Ok",
							new DialogInterface.OnClickListener() {
								public void onClick(
										DialogInterface dialog,
										int which) {
								}
							});
					alertDialog.show();

				}
			});
		
			}else{
				Intent intent = new Intent(MenuActivity.this, AccountsActivity.class);
				startActivity(intent);
			}
	}
	
	public void getLeads()
	{
		if (AppUtils.getSFLeadsList()==null){
			 progressDialog.show();
			Map<String, String> parameters = new HashMap<String, String>();
		//	parameters.put("Authorization", AppUtils.getAuthHeader());
			Log.d("LEADS", "AboveSalesForceLeads");
			KonyFactory mbaasFactory = new KonyFactory();
	        mbaasint = mbaasFactory.getIntegrationService("SalesForceDetails");
			Log.d("LEADS", "BelowSalesForceLeads");
	         mbaasint.invokeOperationInBackground("getLead", parameters, new IntegrationServiceCallback() {
				
				@Override
				public void onSuccess(JSONObject response) {
					progressDialog.cancel();
					Log.d("Leads Response=",response.toString());
					AppUtils.setSFLeadsList(response);
					
					Intent intent = new Intent(MenuActivity.this, LeadsActivity.class);
					startActivity(intent);
				}
				
				@Override
				public void onFailure(IntegrationServiceException exception) {
					progressDialog.cancel();
					AlertDialog.Builder alertDialog = new AlertDialog.Builder(
							MenuActivity.this);
					alertDialog.setTitle("Service Error");
					alertDialog.setMessage(exception.getMessage());
					alertDialog.setNeutralButton("Ok",
							new DialogInterface.OnClickListener() {
								public void onClick(
										DialogInterface dialog,
										int which) {
								}
							});
					alertDialog.show();
				}
			});
			
			}else{
				Intent intent = new Intent(MenuActivity.this, LeadsActivity.class);
				startActivity(intent);
			}
		
	}*/
}
