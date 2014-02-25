package com.area51.sqlitedb;

import com.area51.utils.Constantes;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class ManageSQLite extends SQLiteOpenHelper {

	public ManageSQLite(Context context, String name, CursorFactory factory,
			int version) {
		super(context, name, factory, version);
		
	}

	@Override
	public void onCreate(SQLiteDatabase db) {

		db.execSQL(Constantes.CREATE_TABLE);

	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {		

		db.execSQL(Constantes.DROP_TABLE);
		db.execSQL(Constantes.CREATE_TABLE);		

	}

}
