package com.springapp.mvc;

import com.google.gson.Gson;
import com.springapp.mvc.entity.*;
import com.springapp.mvc.helperEntity.ReviewForRest;
import com.springapp.mvc.service.*;
import javassist.bytecode.ByteArray;
import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class ApiController {

    protected static Logger logger = Logger.getLogger("controller");

    @Resource(name="newsService")
    private NewsService newsService;

    @Resource(name="reviewsService")
    private ReviewsService reviewsService;

    @Resource(name="galleryService")
    private GalleryService galleryService;

    @Resource(name="accountService")
    private AccountService accountService;

    @Resource(name="phoneService")
    private PhoneService phoneService;

    @RequestMapping(value = "/androidAPI/news", produces = MediaType.APPLICATION_JSON_VALUE+";charset=UTF-8")
    public String getNews(@RequestParam(value="count") String count,
                          @RequestParam(value="block") String block) {

        //List<News> news = newsService.getAll();
        List<News> news = newsService.getBlock(Integer.valueOf(block), Integer.valueOf(count));
        Gson gson = new Gson();
        String response = gson.toJson(news);
        return response;
    }

    @RequestMapping(value = "/androidAPI/addNews", produces = MediaType.APPLICATION_JSON_VALUE+";charset=UTF-8")
    public String addNews(@RequestParam(value="title") String title,
                          @RequestParam(value="content") String content) {

        News news = new News();
        news.setTitle(title);
        news.setContent(content);
        newsService.add(news);

        return "OK";
    }

    @RequestMapping(value = "/androidAPI/gallery", produces = MediaType.APPLICATION_JSON_VALUE+";charset=UTF-8")
    public String getGallery() {

        List<Gallery> gallery = galleryService.getAll();

        ArrayList<String> responseArray = new ArrayList<String>();
        for (Gallery item : gallery)
            responseArray.add(item.getImage_url());
        Gson gson = new Gson();
        String response = gson.toJson(responseArray);
        return response;
    }

    @RequestMapping(value = "/androidAPI/login", produces = MediaType.APPLICATION_JSON_VALUE+";charset=UTF-8")
    public String checkAccount(@RequestParam(value="email") String email,
                               @RequestParam(value="pass") String pass) {
        List<Account> acc = accountService.getAccountFromEmail(email);

        if(acc.size() == 0)
            return "ERR_not_exists";
        if (acc.get(0).getPassword().equals(pass))
        {
            Gson gson = new Gson();
            String response = gson.toJson(acc.get(0).getClient());
            return response;
        }
        else
            return "ERR_wrong_password";

    }

    @RequestMapping(value = "/androidAPI/phone", produces = MediaType.APPLICATION_JSON_VALUE+";charset=UTF-8")
    public String getPhone(@RequestParam(value="type") String type) {
        List<Phone> phone = phoneService.getPhone(type);

        return phone.get(0).toString();
    }
    /*REVIEWS*/
    @RequestMapping(value = "/androidAPI/reviewspager", produces = MediaType.APPLICATION_JSON_VALUE+";charset=UTF-8")
    public ResponseEntity<List<ReviewForRest>> getReviews(@RequestParam(value="count") String count,
                                                          @RequestParam(value="block") String block) {

        List<Reviews> reviews = reviewsService.getBlock(Integer.valueOf(block), Integer.valueOf(count));
        ArrayList<ReviewForRest> result = new ArrayList<ReviewForRest>();
        for (Reviews r : reviews)
        {
            ReviewForRest item = new ReviewForRest();
            item.setFirst_name(r.getAccount().getClient().getFirst_name());
            item.setContent(r.getContent());
            item.setDate(r.getReview_date());
            item.setAvatar(accountService.getAvatar(r.getAccount().getEmail()));
            item.setRate(r.getRate());
            item.setId(r.getId_review());
            result.add(item);
        }
        return new ResponseEntity<List<ReviewForRest>>(result, HttpStatus.OK);
    }
}
