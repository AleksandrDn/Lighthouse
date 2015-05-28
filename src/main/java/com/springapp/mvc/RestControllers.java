package com.springapp.mvc;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.springapp.mvc.entity.Client;
import com.springapp.mvc.entity.News;
import com.springapp.mvc.entity.Reviews;
import com.springapp.mvc.helperEntity.Booking;
import com.springapp.mvc.helperEntity.ReviewForRest;
import com.springapp.mvc.service.AccountService;
import com.springapp.mvc.service.ClientService;
import com.springapp.mvc.service.NewsService;
import com.springapp.mvc.service.ReviewsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@RestController
public class RestControllers {

    @Resource(name="newsService")
    private NewsService newsService;

    @Resource(name="clientService")
    private ClientService clientService;

    @Resource(name="reviewsService")
    private ReviewsService reviewsService;

    @Resource(name="accountService")
    private AccountService accountService;

    /*NEWS*/
    @RequestMapping(value = "/newspager", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE+";charset=UTF-8")
    public ResponseEntity<List<News>> getNews(@RequestParam(value="count") String count,
                          @RequestParam(value="block") String block) {

        //List<News> news = newsService.getAll();
        List<News> news = newsService.getBlock(Integer.valueOf(block), Integer.valueOf(count));
        return new ResponseEntity<List<News>>(news, HttpStatus.OK);
    }
    @RequestMapping(value = "/singlenews", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE+";charset=UTF-8")
    public ResponseEntity<News> getNews(@RequestParam(value="id") String id) {

        //List<News> news = newsService.getAll();
        News news = newsService.get(Long.valueOf(id));
        return new ResponseEntity<News>(news, HttpStatus.OK);
    }

    @RequestMapping(value = "/allnews", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE+";charset=UTF-8")
    public ResponseEntity<List<News>> getAllNews() {

        List<News> news = newsService.getAllReverse();
        return new ResponseEntity<List<News>>(news, HttpStatus.OK);
    }

    @RequestMapping(value = "/deletenews", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE+";charset=UTF-8")
    public String deleteNews(@RequestParam(value="id") String id) {
        newsService.delete(Integer.valueOf(id));
        return "okay master";
    }
    /*END NEWS*/
    /*CLIENTS*/
    @RequestMapping(value = "/allclients", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE+";charset=UTF-8")
    public ResponseEntity<List<Client>> getAllClients() {

        List<Client> clients = clientService.getAll();
        return new ResponseEntity<List<Client>>(clients, HttpStatus.OK);
    }
    /*END CLIENTS*/
    /*CHECK BOOKING*/
    @RequestMapping(value = "/checkBooking", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE+";charset=UTF-8")
    public String getPayFormFill(@RequestParam(value="jsonInfo") String jsonInfo) {
        Booking booking;
        Gson gson = new Gson();
        try {
            booking = gson.fromJson(jsonInfo, new TypeToken<Booking>() {}.getType());
        } catch (Exception e){return "not";};
        return "free"; //RETURN TOKEN, add him to id button, get info from server with him(paste in param of payForm)
    }
    /*CHECK BOOKING*/
    /*REVIEWS*/
    @RequestMapping(value = "/reviewspager", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE+";charset=UTF-8")
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

    @RequestMapping(value = "/allreviews", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE+";charset=UTF-8")
    public ResponseEntity<List<Reviews>> getAllReviews() {

        List<Reviews> reviews = reviewsService.getAllReverse();
        return new ResponseEntity<List<Reviews>>(reviews, HttpStatus.OK);
    }

    @RequestMapping(value = "/deletereviews", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE+";charset=UTF-8")
    public String deleteReviews(@RequestParam(value="id") String id) {
        reviewsService.delete(Integer.valueOf(id));
        return "okay master";
    }

    @RequestMapping(value = "/sendreview", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE+";charset=UTF-8")
    public String sendReview(@RequestParam(value="email") String email,
                             @RequestParam(value="content") String content,
                             @RequestParam(value="rate") String rate) {
        Reviews newReview = new Reviews();
        newReview.setContent(content);
        if (accountService.getAccountFromEmail(email).size() == 0) return "fail";
        newReview.setAccount(accountService.getAccountFromEmail(email).get(0));
        java.util.Calendar cal = java.util.Calendar.getInstance();
        java.util.Date utilDate = cal.getTime();
        java.sql.Date sqlDate = new Date(utilDate.getTime());
        newReview.setReview_date(sqlDate);
        newReview.setRate(Integer.valueOf(rate));
        reviewsService.add(newReview);
        return "okay master";
    }
    /*END REVIEWS*/
}
