package com.notice;



import java.io.IOException;
import java.util.List;



import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse;





/**
* Servlet implementation class DeleteNotice
*/
@WebServlet("/DeleteNotice")
public class DeleteNotice extends HttpServlet {
    private static final long serialVersionUID = 1L



   
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String noticeid = request.getParameter("noticeid");
        boolean isTrue
        
        isTrue = NoticeDBUtil.deletenotice(noticeid);
        
        if(isTrue == true) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("noticeaccount.jsp");
            dispatcher.forward(request, response)
        }
        else {
            List<Notice> noticeDetails = NoticeDBUtil.getNoticeDetails(noticeid);
            request.setAttribute("noticeDetails", noticeDetails);
            
            RequestDispatcher dispatcher = request.getRequestDispatcher("noticeinsert.jsp");
            dispatcher.forward(request response);
        }
    }



   



}
