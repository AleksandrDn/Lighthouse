package com.springapp.mvc.adminController;

import com.springapp.mvc.entity.News;
import com.springapp.mvc.entity.Phone;
import com.springapp.mvc.service.NewsService;
import com.springapp.mvc.service.PhoneService;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.util.Collection;
import java.util.Map;
import java.util.Set;


@Controller
public class AdminPhonesController {


    @Resource(name="phoneService")
    private PhoneService phoneService;

    @RequestMapping(value="/admin/phonesAdm",method = RequestMethod.GET)
    public ModelAndView geNewsAdmPage() {
        return loadPhones();
    }

    @RequestMapping(value = "/admin/receptionPhoneAdm",method = RequestMethod.POST)
    public ModelAndView updateReceptionPhone(
            @RequestParam("reception") String receptionPhone) {
        phoneService.edit("reception", receptionPhone);
        return loadPhones();
    }
    @RequestMapping(value = "/admin/administrationPhoneAdm",method = RequestMethod.POST)
    public ModelAndView updateAdministrPhone(
            @RequestParam("administrator") String administratorPhone) {
        phoneService.edit("administrator", administratorPhone);
        return loadPhones();
    }

    public ModelAndView loadPhones()
    {
        ModelAndView modelAndView = new ModelAndView("admin/phonesAdm");
        modelAndView.addObject("administrator", phoneService.getPhone("administrator"));
        modelAndView.addObject("reception", phoneService.getPhone("reception"));
        modelAndView.addAllObjects(showStatistic());
        return modelAndView;
    }

    public ModelMap showStatistic()
    {
        ModelMap model = new ModelMap();
        model.addAttribute("campers", "50");
        model.addAttribute("rooms", "35");
        model.addAttribute("employees", "85");
        return model;
    }
}
