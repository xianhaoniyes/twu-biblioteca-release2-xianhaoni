package Repository;

import java.util.ArrayList;
import java.util.HashMap;

public class RecordRepository {

    private HashMap<String, ArrayList<String>> records;

    public RecordRepository(){

        records = new HashMap<>();
    }

    public void addRecord(String custName, String bookName){

        if(records.containsKey(custName))
            records.get(custName).add(bookName);
        else {
            records.put(custName, new ArrayList<>());
            records.get(custName).add(bookName);
        }
    }

    public int deleteRecord(String custName, String bookName){
        if(!records.containsKey(custName))
            return 0;
        else if (!records.get(custName).contains(bookName))
            return 0;
        else{
            records.get(custName).remove(bookName);
            return 1;
        }
    }

    //this function is only for test usage
    public HashMap<String, ArrayList<String>> Records(){
        return records;
    }



}
