package com.code.distribute.loadbalance;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class BaseLoadBalance {

    protected final static List<Server> serverList = new ArrayList<>();

    protected final static List<WeightServer> weightServerList = new ArrayList<>();

    protected final static List<SmoothWeightServer> smoothWeightServerList = new ArrayList<>();

    protected final static List<ConnectionsServer> connectionsServerList = new ArrayList<>();

    static {
        // init serverList
        serverList.add(new Server("192.168.1.1"));
        serverList.add(new Server("192.168.1.2"));
        serverList.add(new Server("192.168.1.3"));

        // init weightServerList
        List<WeightServer> weightServerTempList = new ArrayList<>();
        weightServerTempList.add(new WeightServer("192.168.1.1", 1));
        weightServerTempList.add(new WeightServer("192.168.1.2", 2));
        weightServerTempList.add(new WeightServer("192.168.1.3", 3));
        for (WeightServer weightServer:weightServerTempList){
            for (int i=0;i<weightServer.getWeight();i++){
                weightServerList.add(weightServer);
            }
        }

        // init smoothWeightServerList
        smoothWeightServerList.add(new SmoothWeightServer("192.168.1.1", 1,1));
        smoothWeightServerList.add(new SmoothWeightServer("192.168.1.2", 2,2));
        smoothWeightServerList.add(new SmoothWeightServer("192.168.1.3", 3,3));

        // init connectionsServerList
        connectionsServerList.add(new ConnectionsServer("192.168.1.1", 5));
        connectionsServerList.add(new ConnectionsServer("192.168.1.2", 7));
        connectionsServerList.add(new ConnectionsServer("192.168.1.3", 3));

    }

    @Data
    @AllArgsConstructor
    public static class Server {
        private String url;
    }

    @Data
    @AllArgsConstructor
    public static class WeightServer {
        private String url;
        private Integer weight = 1; // 服务器权重
    }

    @Data
    @AllArgsConstructor
    public static class SmoothWeightServer {
        private String url;
        private Integer originalWeight = 1; // 服务器默认权重
        private Integer currentWeight = 1; // 服务器权重
    }

    @Data
    @AllArgsConstructor
    public static class ConnectionsServer {
        private String url;
        private Integer connections = 1; // 当前服务器连接数
    }
}
