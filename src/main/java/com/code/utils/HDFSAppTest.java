package com.code.utils;

/**
 * @date 2020/11/18下午5:00
 * Hadoop
 */

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.*;
import org.apache.hadoop.io.IOUtils;
import org.apache.hadoop.util.Progressable;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.*;
import java.net.URI;

/**
 * Java调用Hadoop的API
 * https://www.cnblogs.com/james-roger/p/12699268.html
 */
public class HDFSAppTest {

    public static final String HDFS_PATH = "hdfs://hadoop000:9000";
    FileSystem fileSystem = null;
    Configuration configuration = null;

    @Before
    public void setUp() throws Exception {
        System.out.println("--------setup-------");
        configuration = new Configuration();
        configuration.set("dfs.replication", "1");//设置副本为1
        fileSystem = FileSystem.get(new URI(HDFS_PATH), configuration, "dannyhoo");
    }

    @Test
    public void mkdir() throws Exception {
        Path path = new Path("/hdfsapi/test");
        boolean result = fileSystem.mkdirs(path);
        System.out.println(result);
    }

    /**
     * 查看HDFS内容
     */
    @Test
    public void text() throws Exception {
        FSDataInputStream in = fileSystem.open(new Path("/a.txt"));
        IOUtils.copyBytes(in, System.out, 1024);
    }

    /**
     * 创建文件
     */
    @Test
    public void create() throws Exception {
        FSDataOutputStream out = fileSystem.create(new Path("/hdfsapi/test/b.txt"));
        out.writeUTF("hello hdfs b");
        out.flush();
        out.close();
    }

    /**
     * 修改文件名
     *
     * @throws Exception
     */
    @Test
    public void rename() throws Exception {
        Path oldPath = new Path("/hdfsapi");
        Path newPath = new Path("/HdfsTest");
        boolean result = fileSystem.rename(oldPath, newPath);
        System.out.println(result);
    }

    /**
     * 拷贝本地文件到hdfs文件系统
     *
     * @throws Exception
     */
    @Test
    public void copyFromLocal() throws Exception {
        Path src = new Path("D:/test.txt");
        Path dst = new Path("/hdfsapi/test");
        fileSystem.copyFromLocalFile(src, dst);
    }

    /**
     * 拷贝本地大文件到hdfs文件系统，进行进度显示
     *
     * @throws Exception
     */
    @Test
    public void copyBigFromLocal() throws Exception {
        InputStream in = new BufferedInputStream(new FileInputStream(new File("E:\\test.zip")));
        FSDataOutputStream out = fileSystem.create(new Path("/hdfsapi/test/vm.zip"), new Progressable() {
            @Override
            public void progress() {
                System.out.print(".");
            }
        });

        IOUtils.copyBytes(in, out, 4096);
    }

    /**
     * 从hdfs拷贝文件到本地
     *
     * @throws Exception
     */
    @Test
    public void copyToLocalFile() throws Exception {
        Path src = new Path("/hdfsapi/test/c.txt");
        Path dst = new Path("E:/sh");
        fileSystem.copyToLocalFile(false, src, dst, true);
    }

    /**
     * 获取文件夹下的所有文件
     *
     * @throws Exception
     */
    @Test
    public void listFile() throws Exception {

        FileStatus[] statuses = fileSystem.listStatus(new Path("/hdfsapi/test"));
        for (FileStatus status : statuses) {
            System.out.println(status.getPermission().toString());
            System.out.println(status.isDirectory());
            System.out.println(status.getBlockSize());
            System.out.println(status.getOwner());
            System.out.println(status.isFile());
            System.out.println(status.getLen());
            System.out.println(status.getPath());
            System.out.println("----------------");
        }
        System.out.println(statuses);

    }

    /**
     * 递归获取文件夹下的所有文件
     *
     * @throws Exception
     */
    @Test
    public void listFileRecusive() throws Exception {

        RemoteIterator<LocatedFileStatus> files = fileSystem.listFiles(new Path("/hdfsapi/test"), true);
        while (files.hasNext()) {
            LocatedFileStatus status = files.next();
            System.out.println(status.getPermission().toString());
            System.out.println(status.isDirectory());
            System.out.println(status.getBlockSize());
            System.out.println(status.getOwner());
            System.out.println(status.isFile());
            System.out.println(status.getLen());
            System.out.println(status.getPath());
            System.out.println("----------------");
        }
    }

    /**
     * 查看文件块信息
     *
     * @throws Exception
     */
    @Test
    public void getFileBlockLocations() throws Exception {
        FileStatus fileStatus = fileSystem.getFileStatus(new Path("/jdk-8u211-linux-x64.tar.gz"));
        BlockLocation[] blockLocations = fileSystem.getFileBlockLocations(fileStatus, 0, fileStatus.getLen());
        for (BlockLocation blockLocation : blockLocations) {
            for (String name : blockLocation.getNames()) {
                System.out.println(name + " : " + blockLocation.getOffset() + " : " + blockLocation.getLength());
            }
        }
    }

    @Test
    public void delete() throws Exception {
        boolean result = fileSystem.delete(new Path("/hdfsapi"), true);
        System.out.println(result);
    }

    @After
    public void tearDown() {
        configuration = null;
        fileSystem = null;
        System.out.println("-------shutdown-----------");
    }

//    public static void main(String[] args) throws IOException, URISyntaxException, InterruptedException {
//        Configuration configuration = new Configuration();
//        FileSystem fileSystem = FileSystem.get(new URI("hdfs://rocketmq-nameserver1:9000"), configuration, "root");
//        Path path = new Path("/hdfsapi/test");
//        boolean result = fileSystem.mkdirs(path);
//        System.out.println(result);
//    }

}
