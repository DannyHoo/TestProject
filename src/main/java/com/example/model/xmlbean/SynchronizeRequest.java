package com.example.model.xmlbean;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author danny
 * @date 2020/6/18下午2:48
 */
@Data
@Accessors(chain = true)
@JacksonXmlRootElement(localName = "request")
public class SynchronizeRequest {

    // 【必填】
    @JacksonXmlProperty(localName = "actionType")
    private String actionType;

    // 仓库编码【必填】
    @JacksonXmlProperty(localName = "warehouseCode")
    private String warehouseCode;

    // 货主编码【必填】
    @JacksonXmlProperty(localName = "ownerCode")
    private String ownerCode;

    // 供应商编码【必填】
    @JacksonXmlProperty(localName = "supplierCode")
    private String supplierCode;

    // 供应商名称【必填】
    @JacksonXmlProperty(localName = "supplierName")
    private String supplierName;

    // 商品【必填】
    @JacksonXmlProperty(localName = "item")
    @JacksonXmlElementWrapper(useWrapping = false)
    private Item item;

    // 扩展属性
    @JacksonXmlProperty(localName = "extendProps")
    @JacksonXmlElementWrapper(useWrapping = false)
    private ExtendProp extendProp;

    @Data
    @Accessors(chain = true)
    public static class Item{
        // 商品编码【必填】
        @JacksonXmlProperty(localName = "itemCode")
        private String itemCode;

        // 仓储系统商品编码【条件为商品同步接口更新时，必填】
        @JacksonXmlProperty(localName = "itemId")
        private String itemId;

        // 商品名称【必填】
        @JacksonXmlProperty(localName = "itemName")
        private String itemName;

        // 商品简称
        @JacksonXmlProperty(localName = "shortName")
        private String shortName;

        // 商品英文名称
        @JacksonXmlProperty(localName = "englishName")
        private String englishName;

        // 条形码【必填】
        @JacksonXmlProperty(localName = "barCode")
        private String barCode;

        // 商品标题
        @JacksonXmlProperty(localName = "title")
        private String title;

        // 品牌编码
        @JacksonXmlProperty(localName = "brandCode")
        private String brandCode;

        // 品牌名称
        @JacksonXmlProperty(localName = "brandName")
        private String brandName;

        // 商品属性 (如红色, XXL)
        @JacksonXmlProperty(localName = "skuProperty")
        private String skuProperty;

        // 长（厘米）
        @JacksonXmlProperty(localName = "length")
        private Double length;

        // 宽（厘米）
        @JacksonXmlProperty(localName = "width")
        private Double width;

        // 高（厘米）
        @JacksonXmlProperty(localName = "height")
        private Double height;

        // 体积（升）
        @JacksonXmlProperty(localName = "volume")
        private Double volume;

        // 毛重（千克）
        @JacksonXmlProperty(localName = "grossWeight")
        private Double grossWeight;

        // 货号
        @JacksonXmlProperty(localName = "goodsCode")
        private String goodsCode;

        // 颜色
        @JacksonXmlProperty(localName = "color")
        private String color;

        // 年份
        @JacksonXmlProperty(localName = "year")
        private String year;

        // 价格
        @JacksonXmlProperty(localName = "purchasePrice")
        private String purchasePrice;

        // 尺寸
        @JacksonXmlProperty(localName = "size")
        private String size;

        // 款式
        @JacksonXmlProperty(localName = "style")
        private String style;

        // 商品类别id
        @JacksonXmlProperty(localName = "categoryId")
        private String categoryId;

        // 商品类别名称【必填】
        @JacksonXmlProperty(localName = "categoryName")
        private String categoryName;

        // 商品类别1
        @JacksonXmlProperty(localName = "categoryName1")
        private String categoryName1;

        // 商品类别2
        @JacksonXmlProperty(localName = "categoryName2")
        private String categoryName2;

        // 商品类型 (ZC=正常商品, FX=分销商品, ZH=组合商品, ZP=赠品, BC=包材, HC=耗材, FL=辅料, XN=虚拟品, FS=附属品, CC=残次品, OTHER=其它)
        @JacksonXmlProperty(localName = "itemType")
        private String itemType;

        // 单位（比如千克、个）
        @JacksonXmlProperty(localName = "stockUnit")
        private String stockUnit;

        // 保质期
        @JacksonXmlProperty(localName = "shelfLife")
        private Double shelfLife;

        // 创建时间
        @JacksonXmlProperty(localName = "createTime")
        private String createTime;

        // 更新时间
        @JacksonXmlProperty(localName = "updateTime")
        private String updateTime;
    }

    /**
     * 扩展属性
     */
    @Data
    @Accessors(chain = true)
    public static class ExtendProp{
        // 自定义字段1
        @JacksonXmlProperty(localName = "key1")
        private String key1;

        // 自定义字段2
        @JacksonXmlProperty(localName = "key2")
        private String key2;

        // 自定义字段3
        @JacksonXmlProperty(localName = "key3")
        private String key3;

        // 自定义字段4
        @JacksonXmlProperty(localName = "key4")
        private String key4;

        // 自定义字段5
        @JacksonXmlProperty(localName = "key5")
        private String key5;
    }
}
