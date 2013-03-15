package com.lv;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteCursorDriver;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteQuery;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ContactsList extends Activity {
	
	private TextView name,phone,email,address;
	
	private Button add_button,reset_button;
	private DatabaseHelper db=null;
	private Contacts Con;
	private Intent intent= new Intent();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.add_contacts);
		db=new DatabaseHelper(this);
		initViews();
	}
	
	private void initViews() {
		 name= (TextView)findViewById(R.id.name);
		 phone= (TextView)findViewById(R.id.phone);
		 email= (TextView)findViewById(R.id.email);
		 address= (TextView)findViewById(R.id.address);
		 
		 add_button=(Button)findViewById(R.id.add);
		 reset_button=(Button)findViewById(R.id.reset);
		 
		 add_button.setOnClickListener(buttonViewClickListener);
		
		 intent.setClass(this, Database.class);
	}
	
	private View.OnClickListener buttonViewClickListener = new View.OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			switch (v.getId()) {
				case R.id.add:
					Con=new Contacts( name.getText().toString(), phone.getText().toString(), email.getText().toString(), address.getText().toString());
					db.AddContacts(Con);
					startActivity(intent);
					break;
				case R.id.reset:
					name.setText("");
					phone.setText("");
					email.setText("");
					address.setText("");
					break;
			}
			
		}
	};
}
