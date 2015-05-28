package com.springapp.mvc.adminController;

import com.springapp.mvc.entity.News;
import com.springapp.mvc.service.NewsService;
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


@Controller
@RequestMapping("/admin/newsAdm")
public class AdminNewsController {

    private String NEWS_IMG_PATH = "/news_images/";
    @Autowired
    private ServletContext servletContext;

    @Resource(name="newsService")
    private NewsService newsService;

    @RequestMapping(method = RequestMethod.GET)
    public String geNewsAdmPage(ModelMap model) {
        model = showStatistic(model);
        return "admin/newsAdm";
    }

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView processUploadPreview(
            @RequestParam("file") MultipartFile file,
            @RequestParam("content") String content,
            @RequestParam("title") String title)
    {
        ModelAndView modelAndView = new ModelAndView("admin/newsAdm");
        String contentExtension;
        String[] contentType;
        String filePath = "";
        contentType = file.getContentType().split("/");
        if (file.getSize() > 9999999) {
            modelAndView.addObject("isSuccessful", "Ошибка. Изображение не должно превышать 10Мб " + content);
            return modelAndView;
        }
        if (!contentType[0].equals("image")) {
            modelAndView.addObject("isSuccessful", "Ошибка. Прикреплять только графический файл.");
            return modelAndView;
        }
        contentExtension = contentType[1];
        try {
            Long timestamp = System.currentTimeMillis();
            filePath = NEWS_IMG_PATH
                    + timestamp + "." + contentExtension;
            File f = new File(servletContext.getRealPath("/") + NEWS_IMG_PATH
                    + timestamp + "." + contentExtension);

            FileUtils.writeByteArrayToFile(f, file.getBytes());

        } catch (IOException e) {
            modelAndView.addObject("isSuccessful", "Файл не удалось загрузить");
            return modelAndView;
        }
        addToDB(title, content, filePath);
        modelAndView.addObject("isSuccessful", "Новость добавлена");
        return modelAndView;
    }

    public boolean addToDB(String title, String content, String imgPath)
    {
        int shortContentLength = 30;
        if (content.length() < shortContentLength)
            shortContentLength = content.length() - 1;
        News newNewsItem = new News();
        newNewsItem.setTitle(title);
        newNewsItem.setContent(content);
        newNewsItem.setShort_content(content.substring(0, shortContentLength) + "...");
        newNewsItem.setImage(imgPath);
        //date
        java.util.Calendar cal = java.util.Calendar.getInstance();
        java.util.Date utilDate = cal.getTime();
        java.sql.Date sqlDate = new Date(utilDate.getTime());
        newNewsItem.setDate_news(sqlDate);
        //time
        java.util.Date today = new java.util.Date();
        System.out.println(new java.sql.Timestamp(today.getTime()));
        newNewsItem.setTime_news(new java.sql.Time(today.getTime()));

        newsService.add(newNewsItem);
        return true;
    }

    public ModelMap showStatistic(ModelMap model)
    {
        model.addAttribute("campers", "50");
        model.addAttribute("rooms", "35");
        model.addAttribute("employees", "85");
        return model;
    }
}
