package com.kony.mbaas.demo;

import android.app.ProgressDialog;
import android.content.Context;

public class LoadingDialog {
	
	private static ProgressDialog progressDialog;
	
	public static ProgressDialog getLoadingDialog(Context context)
	{
		 progressDialog=new ProgressDialog(context,ProgressDialog.THEME_HOLO_LIGHT);
		// progressDialog.setMessage("please wait...");
		 progressDialog.setCancelable(false);
		 progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
		 return progressDialog;
	}
}
