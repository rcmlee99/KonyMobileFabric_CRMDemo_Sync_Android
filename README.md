KonyMobileFabric_Demo_Android
==================

This Application showcases how to use Kony MobileFabric SDK's for building a Native Android app using SalesForce Authentication.


# To run this app

1. Download the project
2. Import project to your Android Developement Environemnt
3. In the project,go to com.konylabs.android.commons under src folder and open AppUtils.java file
4. Configure your app secret,app id, service URL that you got from your Kony MobileFabric console after app configuration
5. Build and run the app
 

AppUtils.java:


 	//salesforce app key
 	 public static String APPKEY="<Enter Your KonyMobileFabric App Key>";
 	 
	//salesforce app secret
	public static String APPSECRET="<Enter Your KonyMobileFabric App Secret>";
	
	//salesforce service url
	public static String SERVICE_URL="<Enter Your KonyMobileFabric Service-URL>";
	
	 //salesforce Provider/Identity Service name
	public static String IDENTITY_PROVIDER="<Enter Your KonyMobileFabric App IDentity Service Name>";
	
	//contact Integration service
	public static String CONTACT_INTEGRATION_SERVICE="<Enter Your KonyMobileFabric App contact Integration Service Name>";
	
	//Opportunity Integration service
	public static String OPPORTUNITY_INTEGRATION_SERVICE="<Enter Your KonyMobileFabric App opportunity Integration Service Name>";
	
	//Account Integration Service
	public static String ACCOUNT_INTEGRATION_SERVICE="<Enter Your KonyMobileFabric App account Integration Service Name>";
	
	//Lead Integration service
	public static String LEAD_INTEGRATION_SERVICE="<Enter Your KonyMobileFabric App lead Integration Service Name>";
	
	// same as salesforce username and password+SecurityToken - Auto populated in Login Screen
	public static String SFUSER="<Enter Your SalesForce Account Username>";
	public static String SFPASSWORD="<Enter Your SalesForce Account Password+SecurityToken>";
	
	// GCM sender id or project id obtained from google console
	private final static String SENDER_ID = "<Enter your GCM senderid>";

	

**Note:**
You need to setup and configure your Kony MobileFabric environment before running the app. Follow these tutorials at  http://docs.kony.com/tutorials/MobileFabric/ to know how to set up Kony MobileFabric environment
