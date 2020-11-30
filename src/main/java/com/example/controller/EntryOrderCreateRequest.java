package com.example.controller;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * @date 2020/6/23下午6:09
 */
@Data
@Accessors(chain = true)
@JacksonXmlRootElement(localName = "request")
public class EntryOrderCreateRequest extends XmlRequest {

    private EntryOrder entryOrder;

    private List<OrderLine> orderLines;

    @Data
    public static class EntryOrder{
        private String entryOrderCode;
        private String ownerCode;
        private String warehouseCode;
        private String orderCreateTime;
        private String orderType;
        private String expectStartTime;
        private String logisticsName;
        private String expressCode;
        private String supplierCode;
        private String supplierName;
        private String documentMaker;
        private String remark;
        private String outBizCode;
    }

    @Data
    public static class OrderLine{
        private String ownerCode;
        private String itemCode;
        private String itemId;
        private String itemName;
        private Float planQty;
        private String virtualWarehouse;
        private String inventoryType;
        private String productDate;
        private String expireDate;
        private String batchCode;
        private String stockinDate;
        private String userDefined1;
        private String userDefined2;
        private String userDefined3;
        private String userDefined4;
        private Integer lineNo;
        private String customJson;
        private String customField1;
        private String customField2;
        private String customField3;
        private String customField4;
        private String customField5;
        private String customField6;
        private String customField7;
        private String customField8;
    }
}
