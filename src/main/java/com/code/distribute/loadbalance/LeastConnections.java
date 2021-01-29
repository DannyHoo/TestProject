package com.code.distribute.loadbalance;

/**
 * 最少连接数
 */
public class LeastConnections extends BaseLoadBalance{

    public static void main(String[] args) {
        for (int i = 1; i <= 20; i++) {
            ConnectionsServer server = getServer();
            System.out.println(server.getUrl());
        }
    }

    public static ConnectionsServer getServer() {
        ConnectionsServer connectionsServer=null;
        for (ConnectionsServer server:connectionsServerList){
            if (connectionsServer==null){
                connectionsServer=server;
            }else if(server.getConnections()<connectionsServer.getConnections()){
                connectionsServer=server;
            }
        }
        connectionsServer.setConnections(connectionsServer.getConnections()+1);
        return connectionsServer;
    }
}
