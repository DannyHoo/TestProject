package com.example.controller;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @date 2020/6/23上午10:32
 */
@Data
@Accessors(chain = true)
@JacksonXmlRootElement(localName = "request")
public class XmlRequest {

}
