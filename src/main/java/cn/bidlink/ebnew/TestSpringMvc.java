package cn.bidlink.ebnew;

import cn.bidlink.framework.web.action.BidAction;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping(value="/trading")
public class TestSpringMvc extends BidAction{
    @Override
    @RequestMapping(value = "index", method = {RequestMethod.GET,RequestMethod.POST})
    public ModelAndView index(HttpServletRequest request,
                              HttpServletResponse response) {
        TestTask task=new TestTask();
        task.timeSchedule();
        ModelAndView mav=new ModelAndView("/WEB-INF/MyHtml.html");
        return mav;
    }

    @RequestMapping(value = "student", method = {RequestMethod.GET,RequestMethod.POST})
    public void addStudent(HttpServletRequest request,
                              HttpServletResponse response,Student s) {
        System.out.println(s.getStudentName());
        try {
            response.getWriter().print(s.getStudentAge());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
