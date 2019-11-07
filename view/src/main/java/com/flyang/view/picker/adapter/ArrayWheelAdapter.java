package com.flyang.view.picker.adapter;

import com.flyang.view.wheel.adapter.WheelAdapter;

import java.util.List;


public class ArrayWheelAdapter<T> implements WheelAdapter {

    private List<T> items;

    public ArrayWheelAdapter(List<T> items) {
        this.items = items;
    }

    @Override
    public Object getItem(int index) {
        if (index >= 0 && index < items.size()) {
            return items.get(index);
        }
        return "";
    }

    @Override
    public int getItemsCount() {
        return items.size();
    }

    @Override
    public int indexOf(Object o) {
        return items.indexOf(o);
    }

}
