package cn.bidlink.ebnew;

import cn.bidlink.framework.web.action.BidAction;
import net.sf.json.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(value = "/testJson")
public class TestJson extends BidAction {

    @RequestMapping(value = "footMark")
    public Map<String, Object> footMark(HttpServletRequest request,
                                        HttpServletResponse response) {
            Map<String, Object> resultMap = new HashMap<String, Object>();
            StringBuffer strb = new StringBuffer();
            strb.append("http://testnbl.ebnew.com/elkinterfaces/elkinterfaces/track/behavior");
            strb.append("?");
            strb.append("operationType=1&start=0&limit=8");
            HttpClient client = HttpClients.createDefault();
            HttpGet hrequest = new HttpGet(strb.toString());
            hrequest.setHeader("Accept", "application/json");
            HttpResponse hresponse;
            String result = "";
            JSONObject jsStr = null;
            String charset = "UTF-8";
            try {
                hresponse = client.execute(hrequest);
                HttpEntity entity = hresponse.getEntity();
                String result1 = "";
                JSONObject jsStr1 = null;
                result1 = EntityUtils.toString(entity, charset);
                jsStr1 = JSONObject.fromObject(result1.toString());
                System.out.println(((Map<String, Object>) ((Map<String, Object>) (jsStr1.get("params"))).get("obj")).get("referer"));
                System.out.println(jsStr1);
//            JSONObject json = new JSONObject();
//            json.accumulate("adList", list);
//            ResponseUtils.responseJson(response, json.toString());
                resultMap.put("data", jsStr1);
                return resultMap;
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

    @Override
    @RequestMapping(value = "index", method = RequestMethod.GET)
    public ModelAndView index(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView mav = new ModelAndView("errors/error");
        return mav;
    }
}

