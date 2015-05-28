package com.springapp.mvc.adminController;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;


@Controller
public class AdministratorController {
    @RequestMapping("admin/indexAdm")
    public String geAdminPage(ModelMap model) {
        model = showStatistic(model);
        return "admin/indexAdm";
    }

    @RequestMapping("admin/clientAdm")
    public String getClientsPage(ModelMap model) {
        model = showStatistic(model);
        return "admin/clientAdm";
    }

    @RequestMapping("admin/reviewsAdm")
    public String getReviewsPage(ModelMap model) {
        model = showStatistic(model);
        return "admin/reviewsAdm";
    }

    public ModelMap showStatistic(ModelMap model)
    {
        model.addAttribute("campers", "50");
        model.addAttribute("rooms", "35");
        model.addAttribute("employees", "85");
        return model;
    }
}
