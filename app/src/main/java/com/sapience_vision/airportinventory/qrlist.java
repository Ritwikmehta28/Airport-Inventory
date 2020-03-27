package com.sapience_vision.airportinventory;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class qrlist extends ArrayAdapter<QRDATAS> {
    private Activity context;
    private List<QRDATAS> qrList;

    public qrlist(Activity context, List<QRDATAS> qrList){

        super(context, R.layout.listlayout, qrList);
        this.context = context;
        this.qrList = qrList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();

        View listViewItem = inflater.inflate(R.layout.listlayout,null,true);

        TextView MaintainDate = (TextView) listViewItem.findViewById(R.id.MaintainDate);
        TextView PersonM = (TextView) listViewItem.findViewById(R.id.PersonM);
        TextView Details1 = (TextView) listViewItem.findViewById(R.id.Details1);
        TextView Details2 = (TextView) listViewItem.findViewById(R.id.Details2);

        QRDATAS QRDataS = qrList.get(position);

        MaintainDate.setText(QRDataS.getMaintainname());
        PersonM.setText(QRDataS.getPersonM());
        Details1.setText(QRDataS.getDetails1());
        Details2.setText(QRDataS.getDetails2());

        return listViewItem;

    }

}
