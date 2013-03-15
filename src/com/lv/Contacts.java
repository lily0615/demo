package com.lv;

public  final class Contacts {

	public  String name;
	public  String phone;
	public  String email;
	public  String address;
	
	public  Contacts(String name,String phone,String email,String address){
		this.name=name;
		this.phone=phone;
		this.email=email;
		this.address=address;
	}
	
	public String get_name() {
		return name;
	}
	public void set_name(String name) {
		this.name = name;
	}
	public String get_phone() {
		return phone;
	}
	public void set_phone(String phone) {
		this.phone = phone;
	}
	public String get_email() {
		return email;
	}
	public void set_email(String email) {
		this.email = email;
	}
	public String get_address() {
		return address;
	}
	public void set_address(String address) {
		this.address = address;
	}
}
