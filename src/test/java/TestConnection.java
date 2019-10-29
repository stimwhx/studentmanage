import org.junit.Test;
import v5.ConnectUtil;

public class TestConnection {

    @Test
    public void testConn(){
        ConnectUtil connectUtil = new ConnectUtil();
        connectUtil.getConnection();
    }
}
