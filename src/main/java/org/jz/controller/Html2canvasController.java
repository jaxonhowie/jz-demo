package org.jz.controller;

import org.jz.util.ExecuteUtils;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Hongyi Zheng
 * @date 2018/7/26
 */

@RestController
public class Html2canvasController implements Filter {

    @GetMapping("/phantom")
    public void callBrowserAct() throws IOException {
        String cmd = "phantomjs e:\\IdeaProjects\\jzDemo\\jz-demo\\src\\main\\resources\\static\\js\\test.js http://localhost:8888/test/html2canvas.html";
        System.out.println("执行命令："+ cmd);
        Process process = Runtime.getRuntime().exec(cmd);
        String info = ExecuteUtils.getInputInfo(process);
        System.out.println(info);
    }

    @RequestMapping(value = "/img", method = RequestMethod.POST)
    public String getImgBASE64(@RequestParam String img,Model model){
        System.out.println("success :" + img);
        model.addAttribute("img", img);
        return "templates/show";
    }

    @Override
    public void destroy() {

    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res,
                         FilterChain chain) throws IOException, ServletException {
        HttpServletResponse response = (HttpServletResponse) res;
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Credentials", "true");
        response.setHeader("Access-Control-Allow-Methods", "*");
        response.setHeader("Access-Control-Allow-Headers", "Content-Type,Access-Token");
        response.setHeader("Access-Control-Expose-Headers", "*");
        chain.doFilter(req, res);
    }

    @Override
    public void init(FilterConfig arg0) throws ServletException {

    }
}
