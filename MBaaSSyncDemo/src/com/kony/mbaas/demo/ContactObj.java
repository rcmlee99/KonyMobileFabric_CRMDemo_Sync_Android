package com.kony.mbaas.demo;

public class ContactObj {

	private String line1 ="";
	private String line2 ="";
	private String line3 ="";
	private String percent ="";
	private String img ="";
	
	public void setLine1(String line1){
		this.line1 = line1;
	}
	public void setLine2(String line2){
	this.line2= line2;
	}
	public void setLine3(String line3){
		this.line3=line3;
	}

	public void setImg(String i){
		this.img= i;
	}	
	
	public void setPercent(String p){
		this.percent= p;
	}
	
	public String getLine1(){
		return this.line1;
	}
	public String getLine2(){
		return this.line2;
		
	}
	public String getLine3(){
		return this.line3;
	}
	public String getImg(){
		return this.img;
	}
	public String getPercent(){
		return this.percent;
	}


}
