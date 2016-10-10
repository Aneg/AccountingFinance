package ru.borisenko.gennady.accountingfinance.adapters;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import ru.borisenko.gennady.accountingfinance.R;
import ru.borisenko.gennady.accountingfinance.database.DbAdapter;

public class OperationsAdapter extends CursorAdapter {

    private Context context;

    public OperationsAdapter(Context context, Cursor c, boolean autoRequery) {
        super(context, c, autoRequery);
        this.context = context;
        layoutInflater = LayoutInflater.from(context);
    }

    private LayoutInflater layoutInflater;


    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        ViewHolder holder = (ViewHolder) view.getTag();


        holder.amount.setText(cursor.getString(cursor
                .getColumnIndex(DbAdapter.ALIAS_AMOUNT)));
        holder.source.setText(cursor.getString(cursor
                .getColumnIndex(DbAdapter.ALIAS_SOURCE)));
        holder.type.setText(cursor.getString(cursor
                .getColumnIndex(DbAdapter.ALIAS_TYPE)));
        holder.currency.setText(cursor.getString(cursor
                .getColumnIndex(DbAdapter.ALIAS_CURRENCY)));
    }



    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {

        View view = layoutInflater.inflate(R.layout.listview_row_operation, parent, false);

        ViewHolder holder = new ViewHolder();
        holder.source = (TextView) view.findViewById(R.id.txt_oper_source);
        holder.date = (TextView) view.findViewById(R.id.txt_oper_date);
        holder.image = (ImageView) view.findViewById(R.id.img_source);
        holder.time = (TextView) view.findViewById(R.id.txt_oper_time);
        holder.amount = (TextView) view.findViewById(R.id.txt_oper_amount);
        holder.type = (TextView) view.findViewById(R.id.txt_oper_type);
        holder.currency = (TextView) view.findViewById(R.id.txt_oper_currency);

        view.setTag(holder);

        return view;

    }

    static class ViewHolder {
        public TextView date;
        public ImageView image;
        public TextView time;
        public TextView amount;
        public TextView source;
        public TextView type;
        public TextView currency;
    }
}