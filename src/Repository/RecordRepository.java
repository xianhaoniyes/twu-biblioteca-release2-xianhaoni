package Repository;

import java.util.ArrayList;
import java.util.HashMap;

public class RecordRepository {

    private HashMap<String, ArrayList<String>> records;

    public RecordRepository(){

        records = new HashMap<>();
    }

    public void addRecord(String custName, String itemName){

        if(records.containsKey(custName))
            records.get(custName).add(itemName);
        else {
            records.put(custName, new ArrayList<>());
            records.get(custName).add(itemName);
        }
    }

    public int deleteRecord(String custName, String itemName){
        if(!records.containsKey(custName))
            return 0;
        else if (!records.get(custName).contains(itemName))
            return 0;
        else{
            records.get(custName).remove(itemName);
            if (records.get(custName).isEmpty())
                records.remove(custName);
            return 1;
        }
    }

    //this function is only for test usage
    public HashMap<String, ArrayList<String>> records(){
        return records;
    }



}
