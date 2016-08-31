package com.site.action.ajax;

import com.domain.KeyValueData;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: udoluweera
 * Date: 3/1/12
 * Time: 2:59 PM
 * To change this template use File | Settings | File Templates.
 */
public class PieChartAjaxData extends ActionSupport implements ModelDriven<KeyValueData> {

    private KeyValueData keyValueData;
    private List<KeyValueData> keyValueDataList;

    public List<KeyValueData> getKeyValueDataList() {
        return keyValueDataList;
    }

    public void setKeyValueDataList(List<KeyValueData> keyValueDataList) {
        this.keyValueDataList = keyValueDataList;
    }

    public void setKeyValueData(KeyValueData keyValueData) {
        this.keyValueData = keyValueData;
    }

    @Override
    public KeyValueData getModel() {
        return keyValueData;
    }

    
    public String getPositiveNegativeMarketParticipents() {

        keyValueDataList = new ArrayList<KeyValueData>();
        KeyValueData keyValueData1 = new KeyValueData();
        keyValueData1.setKey("POSITIVE CONTRIBUTORS");
        keyValueData1.setValue(56L);
        keyValueDataList.add(keyValueData1);
        KeyValueData keyValueData2 = new KeyValueData();
        keyValueData2.setKey("NEGATIVE CONTRIBUTORS");
        keyValueData2.setValue(127L);
        keyValueDataList.add(keyValueData2);
        
      //  String jsonString = "{\"keyValueDataList\":[{\"key\":\"POSITIVE CONTRIBUTORS\",\"value\":56},{\"key\":\"NEGATIVE CONTRIBUTORS\",\"value\":127}],\"positiveNegativeMarketParticipents\":\"success\"}";
        
        return SUCCESS;
    }




}




