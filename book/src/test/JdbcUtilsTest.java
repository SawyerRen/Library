package test;

import org.junit.Test;
import utils.JdbcUtils;

/**
 * @ClassName JdbcUtilsTest
 * @Description TODO
 * @Author SawyerRen
 * @Date 2020/3/22 14:53
 */
public class JdbcUtilsTest {
    @Test
    public void testJdbcUtils(){
        System.out.println(JdbcUtils.getConnection());
    }
}
