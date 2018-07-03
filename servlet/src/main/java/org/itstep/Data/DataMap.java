package org.itstep.Data;


import java.util.HashMap;
import java.util.Map;

public class DataMap  {


    Map<Integer, String> repo = new HashMap<>();
    public DataMap(){
        repo.put(1, "Test1");
        repo.put(2, "Test2");
        repo.put(3, "Test3");
    }

    public String getTest(Integer key){
        return repo.get(key);
    }
    public void setTest(Integer key, String value){
        repo.put(key, value);
    }
}
