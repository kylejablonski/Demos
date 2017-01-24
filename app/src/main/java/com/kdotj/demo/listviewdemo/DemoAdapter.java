package com.kdotj.demo.listviewdemo;

import android.content.Context;
import android.support.v7.widget.AppCompatTextView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;
import java.util.Locale;

/**
 * Demo Adapter with Custom View
 */

public class DemoAdapter extends BaseAdapter {

    private LayoutInflater mInflater;
    private Context mContext;
    private List<ContactObject> mContacts;


    static class ViewHolder{
        AppCompatTextView mTvName;
        AppCompatTextView mTvAddress;
        AppCompatTextView mTvPhone;
    }

    public DemoAdapter(Context context){
        mContext = context;
        mInflater = LayoutInflater.from(context);
        mContacts = ContactObject.getContactList();
    }

    @Override
    public int getCount() {
        return mContacts.size();
    }

    @Override
    public Object getItem(int i) {
        return mContacts.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {

        ViewHolder viewHolder;
        if(convertView == null){
            viewHolder = new ViewHolder();
            convertView = mInflater.inflate(R.layout.contact_row, viewGroup, false);
            viewHolder.mTvName = (AppCompatTextView) convertView.findViewById(R.id.name);
            viewHolder.mTvAddress = (AppCompatTextView) convertView.findViewById(R.id.address);
            viewHolder.mTvPhone = (AppCompatTextView) convertView.findViewById(R.id.phone);
            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) convertView.getTag();
        }

        final ContactObject contactObject = mContacts.get(position);

        viewHolder.mTvName.setText(String.format(Locale.getDefault(), "%s %s", contactObject.firstName, contactObject.lastName));
        viewHolder.mTvAddress.setText(contactObject.address);
        viewHolder.mTvPhone.setText(contactObject.phone);
        return convertView;
    }
}
