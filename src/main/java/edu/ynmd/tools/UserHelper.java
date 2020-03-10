package edu.ynmd.tools;



import edu.ynmd.model.SysUser;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @Author:lb
 * @date:2020/3/6 17:12
 * @description:session存储
 */
public class UserHelper {

    public static void  setSession(HttpServletRequest request, SysUser user){
        HttpSession session= request.getSession();
        session.setAttribute("user",user);
    }

    public static SysUser getSession(HttpServletRequest request){
        HttpSession session= request.getSession();
        return  (SysUser)session.getAttribute("user");
    }

    public static void removeSession(HttpServletRequest request){
        HttpSession session= request.getSession();
        session.removeAttribute("user");
    }
}
