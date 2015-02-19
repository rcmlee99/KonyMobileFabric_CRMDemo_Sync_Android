package com.kony.sdk.services.sync.codegen;

import com.kony.sdk.services.sync.model.SyncObject; 

/**
 * Generated code : Contact
 *
 */

public class Contact extends SyncObject {
	
	public Contact() {
		super("Contact");
	}
	
	public Contact(long refid) {
		super(refid);
	}
	
	public String getAccountId(){
		return getString("AccountId");
	}
	public void setAccountId(String AccountId){
		setString("AccountId", AccountId);
	}
	public String getAssistantName(){
		return getString("AssistantName");
	}
	public void setAssistantName(String AssistantName){
		setString("AssistantName", AssistantName);
	}
	public String getAssistantPhone(){
		return getString("AssistantPhone");
	}
	public void setAssistantPhone(String AssistantPhone){
		setString("AssistantPhone", AssistantPhone);
	}
	public String getBirthdate(){
		return getString("Birthdate");
	}
	public void setBirthdate(String Birthdate){
		setString("Birthdate", Birthdate);
	}
	public String getCleanStatus(){
		return getString("CleanStatus");
	}
	public void setCleanStatus(String CleanStatus){
		setString("CleanStatus", CleanStatus);
	}
	public String getCreatedById(){
		return getString("CreatedById");
	}
	public void setCreatedById(String CreatedById){
		setString("CreatedById", CreatedById);
	}
	public String getCreatedDate(){
		return getString("CreatedDate");
	}
	public void setCreatedDate(String CreatedDate){
		setString("CreatedDate", CreatedDate);
	}
	public String getDepartment(){
		return getString("Department");
	}
	public void setDepartment(String Department){
		setString("Department", Department);
	}
	public String getDescription(){
		return getString("Description");
	}
	public void setDescription(String Description){
		setString("Description", Description);
	}
	public String getEmail(){
		return getString("Email");
	}
	public void setEmail(String Email){
		setString("Email", Email);
	}
	public String getEmailBouncedDate(){
		return getString("EmailBouncedDate");
	}
	public void setEmailBouncedDate(String EmailBouncedDate){
		setString("EmailBouncedDate", EmailBouncedDate);
	}
	public String getEmailBouncedReason(){
		return getString("EmailBouncedReason");
	}
	public void setEmailBouncedReason(String EmailBouncedReason){
		setString("EmailBouncedReason", EmailBouncedReason);
	}
	public String getFax(){
		return getString("Fax");
	}
	public void setFax(String Fax){
		setString("Fax", Fax);
	}
	public String getFirstName(){
		return getString("FirstName");
	}
	public void setFirstName(String FirstName){
		setString("FirstName", FirstName);
	}
	public String getHomePhone(){
		return getString("HomePhone");
	}
	public void setHomePhone(String HomePhone){
		setString("HomePhone", HomePhone);
	}
	public String getId(){
		return getString("Id");
	}
	public Boolean getIsDeleted(){
		return getBoolean("IsDeleted");
	}
	public void setIsDeleted(Boolean IsDeleted){
		setBoolean("IsDeleted", IsDeleted);
	}
	public Boolean getIsEmailBounced(){
		return getBoolean("IsEmailBounced");
	}
	public void setIsEmailBounced(Boolean IsEmailBounced){
		setBoolean("IsEmailBounced", IsEmailBounced);
	}
	public String getJigsaw(){
		return getString("Jigsaw");
	}
	public void setJigsaw(String Jigsaw){
		setString("Jigsaw", Jigsaw);
	}
	public String getJigsawContactId(){
		return getString("JigsawContactId");
	}
	public void setJigsawContactId(String JigsawContactId){
		setString("JigsawContactId", JigsawContactId);
	}
	public String getLanguages__c(){
		return getString("Languages__c");
	}
	public void setLanguages__c(String Languages__c){
		setString("Languages__c", Languages__c);
	}
	public String getLastActivityDate(){
		return getString("LastActivityDate");
	}
	public void setLastActivityDate(String LastActivityDate){
		setString("LastActivityDate", LastActivityDate);
	}
	public String getLastCURequestDate(){
		return getString("LastCURequestDate");
	}
	public void setLastCURequestDate(String LastCURequestDate){
		setString("LastCURequestDate", LastCURequestDate);
	}
	public String getLastCUUpdateDate(){
		return getString("LastCUUpdateDate");
	}
	public void setLastCUUpdateDate(String LastCUUpdateDate){
		setString("LastCUUpdateDate", LastCUUpdateDate);
	}
	public String getLastModifiedById(){
		return getString("LastModifiedById");
	}
	public void setLastModifiedById(String LastModifiedById){
		setString("LastModifiedById", LastModifiedById);
	}
	public String getLastModifiedDate(){
		return getString("LastModifiedDate");
	}
	public void setLastModifiedDate(String LastModifiedDate){
		setString("LastModifiedDate", LastModifiedDate);
	}
	public String getLastName(){
		return getString("LastName");
	}
	public void setLastName(String LastName){
		setString("LastName", LastName);
	}
	public String getLastReferencedDate(){
		return getString("LastReferencedDate");
	}
	public void setLastReferencedDate(String LastReferencedDate){
		setString("LastReferencedDate", LastReferencedDate);
	}
	public String getLastViewedDate(){
		return getString("LastViewedDate");
	}
	public void setLastViewedDate(String LastViewedDate){
		setString("LastViewedDate", LastViewedDate);
	}
	public String getLeadSource(){
		return getString("LeadSource");
	}
	public void setLeadSource(String LeadSource){
		setString("LeadSource", LeadSource);
	}
	public String getLevel__c(){
		return getString("Level__c");
	}
	public void setLevel__c(String Level__c){
		setString("Level__c", Level__c);
	}
	public String getMailingAddress(){
		return getString("MailingAddress");
	}
	public void setMailingAddress(String MailingAddress){
		setString("MailingAddress", MailingAddress);
	}
	public String getMailingCity(){
		return getString("MailingCity");
	}
	public void setMailingCity(String MailingCity){
		setString("MailingCity", MailingCity);
	}
	public String getMailingCountry(){
		return getString("MailingCountry");
	}
	public void setMailingCountry(String MailingCountry){
		setString("MailingCountry", MailingCountry);
	}
	public String getMailingLatitude(){
		return getString("MailingLatitude");
	}
	public void setMailingLatitude(String MailingLatitude){
		setString("MailingLatitude", MailingLatitude);
	}
	public String getMailingLongitude(){
		return getString("MailingLongitude");
	}
	public void setMailingLongitude(String MailingLongitude){
		setString("MailingLongitude", MailingLongitude);
	}
	public String getMailingPostalCode(){
		return getString("MailingPostalCode");
	}
	public void setMailingPostalCode(String MailingPostalCode){
		setString("MailingPostalCode", MailingPostalCode);
	}
	public String getMailingState(){
		return getString("MailingState");
	}
	public void setMailingState(String MailingState){
		setString("MailingState", MailingState);
	}
	public String getMailingStreet(){
		return getString("MailingStreet");
	}
	public void setMailingStreet(String MailingStreet){
		setString("MailingStreet", MailingStreet);
	}
	public String getMasterRecordId(){
		return getString("MasterRecordId");
	}
	public void setMasterRecordId(String MasterRecordId){
		setString("MasterRecordId", MasterRecordId);
	}
	public String getMobilePhone(){
		return getString("MobilePhone");
	}
	public void setMobilePhone(String MobilePhone){
		setString("MobilePhone", MobilePhone);
	}
	public String getName(){
		return getString("Name");
	}
	public void setName(String Name){
		setString("Name", Name);
	}
	public String getOtherAddress(){
		return getString("OtherAddress");
	}
	public void setOtherAddress(String OtherAddress){
		setString("OtherAddress", OtherAddress);
	}
	public String getOtherCity(){
		return getString("OtherCity");
	}
	public void setOtherCity(String OtherCity){
		setString("OtherCity", OtherCity);
	}
	public String getOtherCountry(){
		return getString("OtherCountry");
	}
	public void setOtherCountry(String OtherCountry){
		setString("OtherCountry", OtherCountry);
	}
	public String getOtherLatitude(){
		return getString("OtherLatitude");
	}
	public void setOtherLatitude(String OtherLatitude){
		setString("OtherLatitude", OtherLatitude);
	}
	public String getOtherLongitude(){
		return getString("OtherLongitude");
	}
	public void setOtherLongitude(String OtherLongitude){
		setString("OtherLongitude", OtherLongitude);
	}
	public String getOtherPhone(){
		return getString("OtherPhone");
	}
	public void setOtherPhone(String OtherPhone){
		setString("OtherPhone", OtherPhone);
	}
	public String getOtherPostalCode(){
		return getString("OtherPostalCode");
	}
	public void setOtherPostalCode(String OtherPostalCode){
		setString("OtherPostalCode", OtherPostalCode);
	}
	public String getOtherState(){
		return getString("OtherState");
	}
	public void setOtherState(String OtherState){
		setString("OtherState", OtherState);
	}
	public String getOtherStreet(){
		return getString("OtherStreet");
	}
	public void setOtherStreet(String OtherStreet){
		setString("OtherStreet", OtherStreet);
	}
	public String getOwnerId(){
		return getString("OwnerId");
	}
	public void setOwnerId(String OwnerId){
		setString("OwnerId", OwnerId);
	}
	public String getPhone(){
		return getString("Phone");
	}
	public void setPhone(String Phone){
		setString("Phone", Phone);
	}
	public String getPhotoUrl(){
		return getString("PhotoUrl");
	}
	public void setPhotoUrl(String PhotoUrl){
		setString("PhotoUrl", PhotoUrl);
	}
	public String getReportsToId(){
		return getString("ReportsToId");
	}
	public void setReportsToId(String ReportsToId){
		setString("ReportsToId", ReportsToId);
	}
	public String getSalutation(){
		return getString("Salutation");
	}
	public void setSalutation(String Salutation){
		setString("Salutation", Salutation);
	}
	public String getSystemModstamp(){
		return getString("SystemModstamp");
	}
	public void setSystemModstamp(String SystemModstamp){
		setString("SystemModstamp", SystemModstamp);
	}
	public String getTitle(){
		return getString("Title");
	}
	public void setTitle(String Title){
		setString("Title", Title);
	}
	public Boolean getbooleancheck__c(){
		return getBoolean("booleancheck__c");
	}
	public void setbooleancheck__c(Boolean booleancheck__c){
		setBoolean("booleancheck__c", booleancheck__c);
	}
	public String getdatecheck__c(){
		return getString("datecheck__c");
	}
	public void setdatecheck__c(String datecheck__c){
		setString("datecheck__c", datecheck__c);
	}
	public String getdatetimeCheck__c(){
		return getString("datetimeCheck__c");
	}
	public void setdatetimeCheck__c(String datetimeCheck__c){
		setString("datetimeCheck__c", datetimeCheck__c);
	}
	public String geterrorCode(){
		return getString("errorCode");
	}
	public void seterrorCode(String errorCode){
		setString("errorCode", errorCode);
	}
	public String getmessage(){
		return getString("message");
	}
	public void setmessage(String message){
		setString("message", message);
	}
	public String getqueryString(){
		return getString("queryString");
	}
	public void setqueryString(String queryString){
		setString("queryString", queryString);
	}

	@Override
	protected void finalize() throws Throwable {
		super.finalize();
	}
	
}
