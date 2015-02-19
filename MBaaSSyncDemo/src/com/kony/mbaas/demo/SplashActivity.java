package com.kony.mbaas.demo;

import org.json.JSONObject;

import com.kony.sdk.callback.InitCallback;
import com.kony.sdk.client.KonyClient;
import com.kony.sdk.common.KonyException;
import com.konylabs.android.commons.AppUtils;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;

public class SplashActivity extends Activity {
Intent intent;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_splash);
		intent=new Intent(SplashActivity.this, LoginActivity.class);
		try {
			//Init Call for KonyClient for authenticating process
			KonyClient.initInBackground(getApplicationContext(), AppUtils.APPKEY,
				AppUtils.APPSECRET, AppUtils.SERVICE_URL, new InitCallback() {
				@Override
				public void onSuccess(JSONObject arg0) {
					// TODO Auto-generated method stub
					System.out.println("MBAAS succ"  );
					//if(AppUtils.getAuthHeader()==null)
					//progressDialog.cancel();
					startActivity(intent);
					finish();
				}
				@Override
				public void onFailure(KonyException arg0) {
					//	if(AppUtils.getAuthHeader()==null)
					//  progressDialog.cancel();
					AlertDialog.Builder alertDialog=new AlertDialog.Builder(SplashActivity.this,
					AlertDialog.THEME_HOLO_LIGHT);
					alertDialog.setMessage("unable to initialize\n please try later");
					alertDialog.setNeutralButton("Ok",null);
					alertDialog.show();
					System.out.println("MBAAS fail " + arg0.getMessage());
				}
			});
		} catch (Exception e) {
		System.out.println("MBAAS" + e);
		}
		/*new Handler().postDelayed(new Runnable() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					// Init Call for KonyClient for authenticating process
					KonyClient.initInBackground(getApplicationContext(), AppUtils.APPKEY,
						AppUtils.APPSECRET, AppUtils.SERVICE_URL, new InitCallback() {
						@Override
						public void onSuccess(JSONObject arg0) {
							// TODO Auto-generated method stub
							System.out.println("MBAAS succ"  );
							//if(AppUtils.getAuthHeader()==null)
							//progressDialog.cancel();
							startActivity(intent);
							finish();
						}
						@Override
						public void onFailure(KonyException arg0) {
							//	if(AppUtils.getAuthHeader()==null)
							//  progressDialog.cancel();
							AlertDialog.Builder alertDialog=new AlertDialog.Builder(SplashActivity.this,
							AlertDialog.THEME_HOLO_LIGHT);
							alertDialog.setMessage("unable to initialize\n please try later");
							alertDialog.setNeutralButton("Ok",null);
							alertDialog.show();
							System.out.println("MBAAS fail " + arg0.getMessage());
						}
					});
				} catch (Exception e) {
				System.out.println("MBAAS" + e);
				}
			}
		},100);*/
	}
}
