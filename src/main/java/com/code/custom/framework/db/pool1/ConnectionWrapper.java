package com.code.custom.framework.db.pool1;

import lombok.Data;
import lombok.experimental.Accessors;

import java.sql.Connection;
import java.time.LocalDateTime;

/**
 * @author danny
 * @date 2021/2/3下午3:38
 */
@Data
@Accessors(chain = true)
public class ConnectionWrapper {
    private Connection connection;
    private LocalDateTime initTime;
}
