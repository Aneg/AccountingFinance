package ru.borisenko.gennady.accountingfinance.objects;

import android.app.Application;

import ru.borisenko.gennady.accountingfinance.database.DbAdapter;

public class AppContext extends Application {

    @Override
    public void onCreate() {
        // TODO Auto-generated method stub
        super.onCreate();
        dbAdapter = new DbAdapter(this);
    }


    private static DbAdapter dbAdapter;


    public static DbAdapter getDbAdapter() {
        return dbAdapter;
    }



}
