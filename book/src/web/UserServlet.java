package web;

import pojo.User;
import service.UserService;
import service.impl.UserServiceImpl;
import utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;

import static com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY;

public class UserServlet extends BaseServlet {
    private UserService userService = new UserServiceImpl();

    protected void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User loginUser = userService.login(new User(null, username, password, null));
        if (loginUser == null) {
            request.setAttribute("msg", "用户名或密码错误");
            request.setAttribute("username", username);
            request.getRequestDispatcher("/pages/user/login.jsp").forward(request, response);
        } else {
            request.getSession().setAttribute("user", loginUser);
            request.getRequestDispatcher("/pages/user/login_success.jsp").forward(request, response);
        }
    }

    protected void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getSession().invalidate();
        response.sendRedirect(request.getContextPath());
    }

    protected void register(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String token = (String) request.getSession().getAttribute(KAPTCHA_SESSION_KEY);
        request.getSession().removeAttribute(KAPTCHA_SESSION_KEY);
        //获取请求的参数
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String code = request.getParameter("code");

        User user = WebUtils.copyParamToBean(request.getParameterMap(), new User());
        //检查验证码是否正确
        if (token != null && token.equalsIgnoreCase(code)) {
            //检查用户名是否可用
            if (userService.existUsername(username)) {
                System.out.println("用户名已存在");
                request.setAttribute("msg", "用户名已存在");
                request.setAttribute("username", username);
                request.setAttribute("email", email);

                request.getRequestDispatcher("/pages/user/regist.jsp").forward(request, response);
            } else {
                userService.registerUser(new User(null, username, password, email));

                request.getRequestDispatcher("/pages/user/regist_success.jsp").forward(request, response);
            }
        } else {
            //跳回注册页面
            request.setAttribute("msg", "验证码错误");
            request.setAttribute("username", username);
            request.setAttribute("email", email);
            System.out.println("验证码错误");
            request.getRequestDispatcher("/pages/user/regist.jsp").forward(request, response);
        }
    }
}
