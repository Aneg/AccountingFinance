package ru.borisenko.gennady.accountingfinance.gui;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import ru.borisenko.gennady.accountingfinance.OperationsFragment;
import ru.borisenko.gennady.accountingfinance.R;
import ru.borisenko.gennady.accountingfinance.adapters.ExpandableListAdapter;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.view.Gravity;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnChildClickListener;
import android.widget.ExpandableListView.OnGroupClickListener;
import android.widget.ExpandableListView.OnGroupCollapseListener;
import android.widget.ExpandableListView.OnGroupExpandListener;

public class MenuExpandableList {

    public static final String OPERATION_TYPE = "ru.javabegin.training.android.money.gui.MenuExpandableList.operationType";

    private Activity context;

    private DrawerLayout navDrawer;

    private ExpandableListAdapter listAdapter;
    private ExpandableListView expListView;

    private List<String> listGroup;// родительские пункты
    private HashMap<String, List<String>> mapChild; // дочерние пункты

    public MenuExpandableList(final Activity context) {
        this.context = context; // ссылка на активити
        expListView = (ExpandableListView) context.findViewById(R.id.expLvMenu);
        navDrawer = (DrawerLayout) context.findViewById(R.id.drawer_layout);

        fillMenu();// заполнить пункты меню

        listAdapter = new ExpandableListAdapter(context, listGroup, mapChild);

        expListView.setAdapter(listAdapter);

        // нажатие на родительский пункт
        expListView.setOnGroupClickListener(new OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView parent, View v,
                                        int groupPosition, long id) {return false;}
        });

        // разворачивание родительского пункта
        expListView.setOnGroupExpandListener(new OnGroupExpandListener() {
            @Override
            public void onGroupExpand(int groupPosition) {}
        });


        // сворачивание родительского пункта
        expListView.setOnGroupCollapseListener(new OnGroupCollapseListener() {
            @Override
            public void onGroupCollapse(int groupPosition) {}
        });


        // нажатие на дочернее меню
        expListView.setOnChildClickListener(new OnChildClickListener() {

            @Override
            public boolean onChildClick(ExpandableListView parent, View v,
                                        int groupPosition, int childPosition, long id) {

                Fragment fragment = new OperationsFragment();
                Bundle args = new Bundle();
                args.putInt(OPERATION_TYPE, childPosition);
                fragment.setArguments(args);

                FragmentManager fragmentManager = context.getFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.content_frame, fragment).commit();


                navDrawer.closeDrawer(Gravity.LEFT);
                return true;
            }
        });
    }

    private void fillMenu() {
        listGroup = new ArrayList<String>();
        mapChild = new HashMap<String, List<String>>();

        listGroup.add(context.getResources().getString(R.string.menu1));
        listGroup.add(context.getResources().getString(R.string.menu2));
        listGroup.add(context.getResources().getString(R.string.menu3));


        List<String> menu1 = new ArrayList<String>();
        for (String child : context.getResources().getStringArray(R.array.operations)) {
            menu1.add(child);
        }

        List<String> menu2 = new ArrayList<String>();
        for (String child : context.getResources().getStringArray(R.array.menu2_childs)) {
            menu2.add(child);
        }

        List<String> menu3 = new ArrayList<String>();
        for (String child : context.getResources().getStringArray(R.array.menu3_childs)) {
            menu3.add(child);
        }



        mapChild.put(listGroup.get(0), menu1);
        mapChild.put(listGroup.get(1), menu2);
        mapChild.put(listGroup.get(2), menu3);
    }

}


