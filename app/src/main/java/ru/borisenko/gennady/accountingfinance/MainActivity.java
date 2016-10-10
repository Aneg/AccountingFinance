package ru.borisenko.gennady.accountingfinance;


import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;

import ru.borisenko.gennady.accountingfinance.gui.MenuExpandableList;

public class MainActivity extends Activity {

    private static MenuExpandableList menuExpandableList;// хранит левое меню на протяжении всей программы

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (menuExpandableList==null){ // левое меню создаем только 1 раз
            menuExpandableList = new MenuExpandableList(this);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
}

