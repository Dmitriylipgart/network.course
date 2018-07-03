package org.itstep.Data;

import java.util.ArrayList;
import java.util.List;

public class DataList {
    List<String> list = new ArrayList<>();

    public String getListValue(Integer index){
        return list.get(index);
    }

    public void addListValue(String value){
        this.list.add(value);
    }

    public DataList(List<String> list) {
        list.add("String1");
        list.add("String2");
        list.add("String3");
    }
}
