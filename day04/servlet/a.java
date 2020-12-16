package demo;

import java.io.*;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloServlet
 */
@WebServlet("/HelloServlet/*")
public class HelloServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public HelloServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String name = req.getParameter("name");
        String age = req.getParameter("age");

        String path = req.getPathInfo();

        res.setCharacterEncoding("GBK");

        PrintWriter w = res.getWriter();

        w.println("path is: " + path.length());

        if (path.equals("/login")) {
            String username = req.getParameter("username");
            String password = req.getParameter("password");

            if (username.equals("abc") && password.equals("def")) {
                String lastTime = this.getCookieByName(req.getCookies(), "lastLoginTime");


                Cookie userLogin = new Cookie("user-login", "abcdef");
                userLogin.setHttpOnly(true);

                Cookie currentTime = new Cookie("last-time", new Date().toString());

                res.addCookie(currentTime);
                res.addCookie(userLogin);
                res.getWriter().println("登录成功!" + " 你上次登录时间是: " + lastTime);
                return;
            }
            res.getWriter().println("登录失败!");
            return;
        }

        System.out.println("path???: " + path);


        w.println("name is: " + name + "age is: " + age + "equal: "  + path == "/login");

        // 使用 GBK 设置中文正常显示
        w.write("菜鸟教程：http://www.runoob.com" );
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }

    public String getCookieByName(Cookie[] cookies, String name) {
        for (int i = 0; i < cookies.length; i++) {
            if (cookies[i].getName().equals(name)) {
                    return cookies[i].getValue();
            }
        }

        return null;
    }

}