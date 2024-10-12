package com.example.englishlessions.AccountSetup;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.englishlessions.R;

import java.util.ArrayList;
import java.util.List;

public class ItemListAdapter extends ArrayAdapter<String> {
    private final boolean[] selectedItems;
    private final List<String> items;
    private  final Context context;

    public ItemListAdapter(Context context, List<String> items) {
        super(context, 0, items);
        this.items = items;
        this.context = context;
        this.selectedItems = new boolean[items.size()];
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.list_items, parent, false);
            view = LayoutInflater.from(context).inflate(R.layout.list_items_with_icon, parent, false);
        }

        TextView itemTextView = view.findViewById(R.id.itemTextView);
        itemTextView.setText(items.get(position));

        if (selectedItems[position]) {
            view.setBackgroundResource(R.drawable.selected_item_bg);
        } else {
            view.setBackgroundResource(R.drawable.list_item_bg);
        }

        return view;
    }


    public void toggleSelection(int position) {

        if (selectedItems[position]) {
            selectedItems[position] = false;
        } else {

            for (int i = 0; i < selectedItems.length; i++) {
                selectedItems[i] = false;
            }
            selectedItems[position] = true;
        }
        notifyDataSetChanged();
    }


    public List<String> getSelectedItems() {
        List<String> selectedItemsList = new ArrayList<>();
        for (int i = 0; i < selectedItems.length; i++) {
            if (selectedItems[i]) {
                selectedItemsList.add(items.get(i));
            }
        }
        return selectedItemsList;
    }


}

