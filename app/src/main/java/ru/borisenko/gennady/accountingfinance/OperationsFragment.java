package ru.borisenko.gennady.accountingfinance;


import android.app.ListFragment;
import android.os.Bundle;

import ru.borisenko.gennady.accountingfinance.adapters.OperationsAdapter;
import ru.borisenko.gennady.accountingfinance.enums.OperationType;
import ru.borisenko.gennady.accountingfinance.gui.MenuExpandableList;
import ru.borisenko.gennady.accountingfinance.objects.AppContext;


public class OperationsFragment extends ListFragment {

    private OperationType operationType;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);

    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onActivityCreated(savedInstanceState);

        int type = Integer.valueOf(getArguments().getInt(MenuExpandableList.OPERATION_TYPE));

        switch (type) {
            case 0: {
                this.operationType = OperationType.ALL;
                break;
            }
            case 1: {
                this.operationType = OperationType.INCOME;
                break;
            }
            case 2: {
                this.operationType = OperationType.OUTCOME;
                break;
            }
        }

        OperationsAdapter operationsAdapter = new OperationsAdapter(
                getActivity(), AppContext.getDbAdapter().getOperations(
                operationType), false);

        setListAdapter(operationsAdapter);
    }

}
