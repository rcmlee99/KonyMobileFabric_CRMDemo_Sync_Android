package com.kony.mbaas.demo;

//import com.example.androidsdktestapp.R;

import java.io.IOException;

import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

//import com.google.android.gms.common.ConnectionResult;
//import com.google.android.gms.common.GooglePlayServicesUtil;
//import com.google.android.gms.gcm.GoogleCloudMessaging;


import com.kony.sdk.callback.InitCallback;
import com.kony.sdk.callback.LoginCallback;
import com.kony.sdk.client.KonyClient;
import com.kony.sdk.client.KonyFactory;
import com.kony.sdk.client.KonyUser;
import com.kony.sdk.common.IdentityServiceException;
import com.kony.sdk.common.KonyException;
import com.kony.sdk.services.identity.IdentityService;

import com.konylabs.android.commons.AppUtils;

/**
 * The login activity connects to the MBaaS Identity service to authenticate the
 * user for further transactions.
 * 
 * @author Matthew Trevathan
 * 
 */

public class LoginActivity extends Activity {
	  private ProgressDialog progressDialog;
	  // KonyMbaaSClient object that is set in the ApplicationContext as well as add the validate method that will call the authentication services. 
	//KonyClient client  = null;
	public static String regId = null;
	public String regid = null;
	public static Context context = null;
	private final static int PLAY_SERVICES_RESOLUTION_REQUEST = 9000;
	
	//GoogleCloudMessaging gcm;
	
	KonyClient client  = null;
	IdentityService clientAuthentication = null;
	
	
	SharedPreferences preference;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	//	System.out.println("Username = " + AppUtils.getSFUsername());
		setContentView(R.layout.activity_login);
		progressDialog = LoadingDialog.getLoadingDialog(this);
		preference = getGCMPreferences(this);
		((EditText) findViewById(R.id.userid)).setText(AppUtils.SFUSER,
				TextView.BufferType.EDITABLE);
		((EditText) findViewById(R.id.password)).setText(AppUtils.SFPASSWORD,
				TextView.BufferType.EDITABLE);
		//if(AppUtils.getAuthHeader()==null)
		  //  progressDialog.show();
		/*	try {
				// Init Call for KonyClient for authenticating process
				progressDialog.setMessage("initializing..");
				progressDialog.show();
			KonyClient.initInBackground(getApplicationContext(), AppUtils.APPKEY,
     	   AppUtils.APPSECRET, AppUtils.SERVICE_URL, new InitCallback() {
			@Override
			public void onSuccess(JSONObject arg0) {
				// TODO Auto-generated method stub
				System.out.println("MBAAS succ"  );
				if(AppUtils.getAuthHeader()==null)
				progressDialog.cancel();
				progressDialog.cancel();
			}
			@Override
			public void onFailure(KonyException arg0) {
				if(AppUtils.getAuthHeader()==null)
				  progressDialog.cancel();
				AlertDialog.Builder alertDialog=new AlertDialog.Builder(LoginActivity.this,
						AlertDialog.THEME_HOLO_LIGHT);
				alertDialog.setTitle("Info");
				alertDialog.setMessage("unable to initialize\n please try later");
				alertDialog.setNeutralButton("Ok",
						new DialogInterface.OnClickListener() {
							public void onClick(
									DialogInterface dialog,
									int which) {
								progressDialog.cancel();
							}
						});
				alertDialog.show();
				System.out.println("MBAAS fail " + arg0.getMessage());
			}
		});
		} catch (Exception e) {
			System.out.println("MBAAS" + e);
			 progressDialog.cancel();
		}*/
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		// getMenuInflater().inflate(R.menu.login, menu);
		return true;
	}

	
/**
 * GetAuthHeader returns the properly concatenated token for Salesforce
 * that combines the tokentype and access token
 * into a single AuthHeader used for future calls 
 * 
 * @return AuthHeder that is used for future call to MBaaS Integration Services.
 */
	private String getAuthHeader() {
		StringBuilder temp = new StringBuilder();
		JSONObject backendToken = (JSONObject) clientAuthentication.getBackendToken();
		//Log.d("backendtoken", backendToken.toString());
		try {
			JSONObject object = backendToken.getJSONObject("params");
			temp.append(object.getString("token_type"));
			temp.append(" ");
			temp.append(object.getString("access_token"));
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return temp.toString();
	}
/**
 * The validate method performs the calls the the MBaaS authentication service.
 * 
 * @param View The view from the Login activity
 * @exception Throws MBaaS exception when the service cannot connect to MBaaS.
 */
	public void validate(View view) {
		String username = ((EditText) findViewById(R.id.userid)).getText()
				.toString();
		String password = ((EditText) findViewById(R.id.password)).getText()
				.toString();
	//	progressDialog.setTitle("Please wait");
		progressDialog.setMessage("redirecting..");
		progressDialog.show();
		try {
			
			KonyFactory mbaasFactory = new KonyFactory();
// calling Identity service for Validating once authenticated success LoginCallback Success method will execute else Failure.
			clientAuthentication =	mbaasFactory.getIdentityService(AppUtils.IDENTITY_PROVIDER);
			clientAuthentication.loginInBackground(username, password,new LoginCallback() {
				
				@Override
				public void onSuccess(KonyUser arg0) {
					progressDialog.cancel();
					//register();
					Intent intent = new Intent(LoginActivity.this,MenuActivity.class);
					AppUtils.setAuthObject(clientAuthentication);
					startActivity(intent);
					if(preference.getBoolean("login", false))
					   finish();
				}	
				@Override
				public void onFailure(IdentityServiceException exception) {
					// TODO Auto-generated method stub
					progressDialog.cancel();
					JSONObject message = null;
					try {
						message = new JSONObject((String) exception.getMessage());
					} catch (JSONException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					AlertDialog.Builder alertDialog = new AlertDialog.Builder(
							LoginActivity.this);
					alertDialog.setTitle("Initialization Failure");
					try {
						if (message != null)
							alertDialog.setMessage(message
									.getString("message"));
						else
							alertDialog
									.setMessage("Please check your internet connection");
					} catch (JSONException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					alertDialog.setNeutralButton("Ok",
							new DialogInterface.OnClickListener() {
								public void onClick(
										DialogInterface dialog,
										int which) {
									progressDialog.cancel();
								}
							});
					alertDialog.show();
				}
			});
		} catch (KonyException exception) {
			AlertDialog.Builder alertDialog = new AlertDialog.Builder(
					LoginActivity.this);
			alertDialog.setTitle("Init Failure");
			alertDialog.setMessage(exception.getMessage());
			alertDialog.setNeutralButton("Ok",
					new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {
							 progressDialog.cancel();
						}
					});
			alertDialog.show();
		}
	}
	private String getRegistrationId(Context context) {
		final SharedPreferences prefs = getGCMPreferences(context);
		String registrationId = prefs.getString("registration_id", "");
		 SharedPreferences.Editor editor = prefs.edit();
		 editor.putBoolean("login", true);
		    
		    editor.commit();
		if (registrationId.isEmpty()) {
			Log.i("FIRST SCREEN", "Registration not found.");
			return "";
		}
		return registrationId;
	}
	private SharedPreferences getGCMPreferences(Context context) {
		// This sample app persists the registration ID in shared preferences,
		// but
		// how you store the regID in your app is up to you.
		return context.getSharedPreferences("MbaasRegistrationId",Context.MODE_PRIVATE);

	}
	/*	
	public void register()
{
	  context = getApplicationContext();
			if (checkPlayServices()) {
				gcm = GoogleCloudMessaging.getInstance(this);
				regid = getRegistrationId(context);
				registerInBackground();
			} else {
				Log.i("gcm registration","No valid Google Play Services APK found.");
			}
}
private boolean checkPlayServices() {
	int resultCode = GooglePlayServicesUtil.isGooglePlayServicesAvailable(this);
	if (resultCode != ConnectionResult.SUCCESS) {
		if (GooglePlayServicesUtil.isUserRecoverableError(resultCode)) {
			GooglePlayServicesUtil.getErrorDialog(resultCode, this,
					PLAY_SERVICES_RESOLUTION_REQUEST).show();
		} else {
			Log.i("first class", "This device is not supported.");
			finish();
		}
		return false;
	}
	return true;
}
@Override
protected void onResume() {
	// TODO Auto-generated method stub
	super.onResume();
}
@Override
protected void onPause() {
	// TODO Auto-generated method stub
	super.onPause();
}
private void registerInBackground() {
	Log.i("First Screen", "registerInBackground");
	new AsyncTask<Void, Void, Void>() {
		@Override
		protected Void doInBackground(Void... arg0) {
			Log.i("regId-----:::", "entered registerInBackground");
			try {
				if (gcm == null) {
					gcm = GoogleCloudMessaging.getInstance(context);
				}
				regid = gcm.register(AppUtils.getSenderID());
			} catch (IOException ex) {
				Log.i("Exception on recieving regid--:::", ex.toString());

			}
			return null;
		}

	}.execute(null, null, null);

	}*/
}