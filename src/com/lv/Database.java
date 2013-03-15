package com.lv;




import java.util.ArrayList;


import java.util.Map;


import java.util.HashMap;



import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

public class Database extends Activity {
    /** Called when the activity is first created. */
	private static DatabaseHelper db;
	private static Cursor myCursor;
	public static ArrayList<Map<String, Object>> arraylistmap = new ArrayList<Map<String,Object>>();
	public static HashMap<String, Object> mymap = new HashMap<String, Object>();;


	// Menu item IDs
	public static final int MENU_ITEM_LIST = 1;
	public static final int MENU_ITEM_ADD = 2;
	public static final int MENU_ITEM_EXIT = 3;
	
	private ListView grid;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        grid=(ListView)findViewById(R.id.list);
        db=new DatabaseHelper(this);
        
        myCursor=db.getAllContacts();
        setTitle("总共有"+db.getCount()+"条数据");
        show_one();
        String [] from=new String []{"Pname","Pphone","Pemail","Paddress"};
		int [] to=new int [] {R.id.Pname,R.id.Pphone,R.id.Pemail,R.id.Paddress};
        ListView listView = new ListView(this);
        SimpleAdapter adapter = new SimpleAdapter(this,arraylistmap, R.layout.gridrow, from,to);
        listView.setAdapter(adapter);
        setContentView(listView);

//		SimpleCursorAdapter sca=new SimpleCursorAdapter(this,R.layout.gridrow,myCursor,from,to);
//		grid.setAdapter(sca);
    }

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
		super.onCreateOptionsMenu(menu);
		
		menu.add(0, MENU_ITEM_LIST, 0, R.string.menu_list)
		        .setIcon(android.R.drawable.ic_menu_agenda);
		menu.add(0, MENU_ITEM_ADD, 0, R.string.menu_add)
		        .setIcon(android.R.drawable.ic_menu_add);
	    menu.add(0, MENU_ITEM_EXIT, 0, R.string.menu_exit)
	            .setIcon(android.R.drawable.ic_menu_close_clear_cancel);
		
        return true;

	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
	    Intent intent = new Intent();
		switch (item.getItemId()) {
			case MENU_ITEM_LIST:
				
				break;
			case MENU_ITEM_ADD:
				intent.setClass(Database.this, ContactsList.class);
				startActivity(intent);
				break;
			case MENU_ITEM_EXIT:
				finish();
				break;
	
			default:return true;
		}
		return false;
	}
	
	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		db.close();
		super.onDestroy();
	}
	
	 public void show_one() {

   	  int first = myCursor.getColumnIndex("Pname");
   	  int second = myCursor.getColumnIndex("Pphone");
   	  int three = myCursor.getColumnIndex("Pemail");
   	  int four = myCursor.getColumnIndex("Paddress");

   	  Toast.makeText(this, first+" ,"+second+" ,"+three+" ,"+four, Toast.LENGTH_LONG).show();
   	  arraylistmap.clear();
   	  if (myCursor.moveToFirst()) {
 
   	   do {

   		 String  Pname = myCursor.getString(first);
   		 String  Pphone = myCursor.getString(second);
   		 String  Pemail = myCursor.getString(three);
   		 String  Paddress = myCursor.getString(four);


   	    mymap.put("Pname", Pname);
   	    mymap.put("Pphone", Pphone);
   	    mymap.put("Pemail", Pemail);
   	    mymap.put("Paddress", Paddress);
   	    
   	    arraylistmap.add(mymap);

   	   } while (myCursor.moveToNext());

   	  }
   }

}
