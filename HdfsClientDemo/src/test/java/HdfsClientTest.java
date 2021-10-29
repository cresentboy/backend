import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.*;
import org.junit.Test;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;


/**
 * HDFS客户端
 */
public class HdfsClientTest {
    /**
     * 获取文件系统
     * @return
     * @throws IOException
     * @throws InterruptedException
     * @throws URISyntaxException
     */
    private FileSystem getFileSystem()  {

        Configuration configuration = new Configuration();

        FileSystem fs = null;
        try {
            fs = FileSystem.get(new URI("hdfs://hadoop102:8020"),configuration,"formalhuat");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return fs;
    }

    /**
     * 创建文件夹
     * @throws URISyntaxException
     * @throws IOException
     * @throws InterruptedException
     */
    @Test
    public void testMkDirs() {
        FileSystem fs = getFileSystem();

        //创建目录
        try {
            fs.mkdirs(new Path("/xiyou/huaguoshan"));
            //关闭资源
            fs.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * 文件上传
     */
    @Test
    public void testCopyFromLocalFIle(){

        FileSystem fileSystem = getFileSystem();

        try {
            fileSystem.copyFromLocalFile(new Path("d:/test.txt"),new Path("/xiyou/huaguoshan"));

            fileSystem.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 重命名
     */
    @Test
    public void testRename(){
        FileSystem fileSystem = getFileSystem();

        try {
            fileSystem.rename(new Path("/xiyou/huaguoshan/test.txt"), new Path("/xiyou/huaguoshan/test1.txt"));

            fileSystem.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 删除文件和目录
     */
    @Test
    public void testDelete(){
        FileSystem fileSystem = getFileSystem();

        try {
            fileSystem.delete(new Path("/xiyou"), true);

            fileSystem.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取文件详情
     */
    @Test
    public void testListFiles(){

        FileSystem fileSystem = getFileSystem();

        try {
            //获取文件详情
            RemoteIterator<LocatedFileStatus> listFiles = fileSystem.listFiles(new Path("/"), true);

            while (listFiles.hasNext()){
                LocatedFileStatus fileStatus = listFiles.next();

                System.out.println("======"+ fileStatus.getPath() + "=====");
                System.out.println(fileStatus.getPermission());
                System.out.println(fileStatus.getOwner());
                System.out.println(fileStatus.getGroup());
                System.out.println(fileStatus.getLen());
                System.out.println(fileStatus.getModificationTime());
                System.out.println(fileStatus.getReplication());
                System.out.println(fileStatus.getBlockSize());
                System.out.println(fileStatus.getPath().getName());

                //获取块信息
                BlockLocation[] blockLocations = fileStatus.getBlockLocations();
                System.out.println(Arrays.toString(blockLocations));
            }

            fileSystem.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testListStatus(){
        FileSystem fileSystem = getFileSystem();

        try {
            //判断是文件夹还是文件
            FileStatus[] listStatus = fileSystem.listStatus(new Path("/"));

            for (FileStatus fileStatus : listStatus) {

                if (fileStatus.isFile()){
                    System.out.println("f:" + fileStatus.getPath().getName());
                }else {
                    System.out.println("d:" + fileStatus.getPath().getName());
                }
            }
            fileSystem.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
