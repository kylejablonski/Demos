/*
    Copyright 2017 Kyle Jablonski

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
 */
package com.kdotj.demo.listviewdemo;

import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.List;
import java.util.Locale;

/**
 * Demo RecyclerView Adapter
 */

class DemoAdapter extends RecyclerView.Adapter<DemoAdapter.ContactHolder> {

    private List<ContactObject> mContacts;

    DemoAdapter(){
        mContacts = ContactObject.getContactList();
    }

    @Override
    public int getItemCount() {
        return mContacts.size();
    }

    @Override
    public ContactHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ContactHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.contact_row, parent, false));
    }

    @Override
    public void onBindViewHolder(ContactHolder holder, int position) {

        final ContactObject contactObject = mContacts.get(position);
        holder.mTvName.setText(String.format(Locale.getDefault(), "%s %s", contactObject.firstName, contactObject.lastName));
        holder.mTvAddress.setText(contactObject.address);
        holder.mTvPhone.setText(contactObject.phone);

        /*
            Listener is added to the root of the Layout
         */
        holder.mRootView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(), String.format(Locale.getDefault(), "%s %s selected!", contactObject.firstName, contactObject.lastName), Toast.LENGTH_SHORT).show();
            }
        });
    }

    static class ContactHolder extends RecyclerView.ViewHolder{

        View mRootView;
        AppCompatTextView mTvName;
        AppCompatTextView mTvAddress;
        AppCompatTextView mTvPhone;

        ContactHolder(View itemView) {
            super(itemView);

            mRootView = itemView;
            mTvName = (AppCompatTextView) itemView.findViewById(R.id.name);
            mTvAddress = (AppCompatTextView) itemView.findViewById(R.id.address);
            mTvPhone = (AppCompatTextView) itemView.findViewById(R.id.phone);
        }
    }
}
