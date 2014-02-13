package com.area51.sqlitedb;

import com.area51.utils.Constantes;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class ManageSQLiteOpenHelper extends SQLiteOpenHelper {

	public ManageSQLiteOpenHelper(Context context, String name,
			CursorFactory factory, int version) {
		super(context, name, factory, version);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		
		db.execSQL( Constantes.createTableSql  );		
		
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub		

		db.execSQL( Constantes.dropTableSql  );
		db.execSQL( Constantes.createTableSql  );	
		

	}

}
