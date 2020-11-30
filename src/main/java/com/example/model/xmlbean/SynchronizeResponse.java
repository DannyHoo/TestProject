package com.example.model.xmlbean;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author danny
 * @date 2020/6/18下午3:15
 */
@Data
@Accessors(chain = true)
@JacksonXmlRootElement(localName = "response")
public class SynchronizeResponse {
    private String flag;
    private String code;
    private String message;
    private String itemId;
}
