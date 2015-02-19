package com.konylabs.android.commons;

import java.util.List;

import org.json.JSONObject;

import android.content.Context;
import android.provider.Settings.Secure;
import android.util.Log;

import com.kony.sdk.services.identity.IdentityService;
import com.kony.sdk.services.integration.IntegrationService;
import com.kony.sdk.services.messaging.MessagingService;
/*import com.konylabs.androidsdk.MbaasAuthenticationService;
import com.konylabs.androidsdk.MbaasIntegrationService;
import com.konylabs.androidsdk.MbaasMessagingService;*/
import com.kony.sdk.services.sync.codegen.Contact;

/**
 * @author Aditya Sirna
 * This class is used to provide credentials
 */
public class AppUtils {
	
	static IdentityService authClient=null;
	static IntegrationService integClient=null;
	static MessagingService messagingClient=null;
	static String[][] messageList=null;
	static JSONObject sfContactsList=null;
	static JSONObject sfLeadsList=null;
	static JSONObject sfAccountsList=null;
	static JSONObject sfOpportunityList=null;
	static List<Contact> contactList=null;
	public static String authHeader=null;
	// salesforce appkey
	public static String APPKEY="36ec426e04c1fc18c3ec4b43e68f9037";
	//salesforce app secret
	public static String APPSECRET="981b9ab4ba03e795de15e4650c31ce6a";
	//salesforce service url
	public static String SERVICE_URL="https://100003520.auth.konycloud.com/appconfig";
	//salesforce username and password
	//public static String USERNAME="sreenivasn@gmail.com";
	//public static String PASSWORD="Kony@(877uJ8SgCQtfWM8h64QgzSUJxu";
	//salesforce Provider
	public static String IDENTITY_PROVIDER="SForceIdentity";
	//contact Integration service
	public static String CONTACT_INTEGRATION_SERVICE="SForceContact";
	//Opportunity Integration service
	public static String OPPORTUNITY_INTEGRATION_SERVICE="SForceOpportunity";
	//Account Integration Service
	public static String ACCOUNT_INTEGRATION_SERVICE="SForceAccount";
	//Lead Integration service
	public static String LEAD_INTEGRATION_SERVICE="SForceLead";
	//same as salesforce usernam and password
	public static String SFUSER="sreenivasn@gmail.com";
	public static String SFPASSWORD="Kony@(877uJ8SgCQtfWM8h64QgzSUJxu";
	//GCM sender id or project id that you got from gogole app console
	private final static String SENDER_ID = "<Enter Your GCM Sender/Project ID>";
	
     public static String getSenderID()
	{
		return SENDER_ID;
	}
	
	public static String getDeviceID(Context context)
	{
		return Secure.getString(context.getContentResolver(), Secure.ANDROID_ID);
	}
    
	public static void setAuthObject(IdentityService client){
		authClient=client;
	}
	
	
	public static IdentityService getAuthObject(){
		return authClient;
	}
	
	public static void setIntegrationObject(IntegrationService client){
		integClient=client;
	}
	
	public static IntegrationService getIntegrationObject(){
		return integClient;
	}
	
	public static void setMessagingObject(MessagingService client){
		messagingClient=client;
	}
	
	public static MessagingService getMessagingObject(){
		return messagingClient;
	}
	
	public static void setMessageContent(String [][] list){
		messageList=list;
	}
	
	public static String[][] getMessageContent(){
		return messageList;
	}
	
	public static void setSFContactsList(JSONObject contactsList){
		sfContactsList=contactsList;
	}
	
	public static JSONObject getSFContactsList(){
		return sfContactsList;
	}
	public static void setSFLeadsList(JSONObject contactsList){
		Log.d("contact","setting sfleads");
		sfLeadsList=contactsList;
	}
	
	public static JSONObject getSFLeadsList(){
		Log.d("contact","getting sfleads");
		return sfLeadsList;
	}
	public static void setSFAccountsList(JSONObject contactsList){
		sfAccountsList=contactsList;
	}
	
	public static JSONObject getSFAccountsList(){
		return sfAccountsList;
	}
	
	public static void setSFOpportunityList(JSONObject contactsList){
		sfOpportunityList=contactsList;
	}
	public static String getUserAccount()
	{
		return SFUSER;
	}
	public static JSONObject getSFOpportunityList(){
		return sfOpportunityList;
	}
	public static void setAuthHeader(String authorizationHeader){
		authHeader=authorizationHeader;
	}
	
	public static String getAuthHeader(){
		return authHeader;
	}
	
	/**
	 * @return password for salesforce provider
	 */
	public static String getSFPassword(){
		return SFPASSWORD;
	}
	public static void setContactList(List<Contact> cntctList){
		contactList=cntctList;
		System.out.println("contact length:-"+contactList.size());
	}
	public static List<Contact> getContactList(){
		return contactList;
	}
	
	
}
