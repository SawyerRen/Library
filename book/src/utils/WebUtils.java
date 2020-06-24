package utils;

import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * @ClassName WebUtils
 * @Description TODO
 * @Author SawyerRen
 * @Date 2020/3/26 16:14
 */
public class WebUtils {
    public static<T> T copyParamToBean(Map map, T bean) {
        try {
            BeanUtils.populate(bean, map);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bean;
    }

    public static int parseInt(String s, int defaultValue){
        try {
            return Integer.parseInt(s);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return defaultValue;
    }
}
