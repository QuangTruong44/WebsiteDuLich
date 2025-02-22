package com.example.dulich.controller;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;



@Controller
public class HomeController {
    @GetMapping({"/","/login"})
    public String getLogin(final HttpServletRequest request){
        request.getSession().setAttribute("role", "none");
        return "Login";
    }
    @GetMapping("/logout")
    public String getLogout(final HttpServletRequest request){
        request.getSession().setAttribute("role", "none");
        return "redirect:/login";
    }
    @GetMapping("/errorRole")
    public String getError(){
        return "pages/Error/Error";
    }
    @GetMapping("/register")
    public String getRegister(){return "pages/Register";}
    @GetMapping("/nav")
    public String getPageView(){
        return "pages/Navbar/Navbar";
    }
    @GetMapping("/home")
    public String getHome(HttpServletRequest request, Model model){
        HttpSession session = request.getSession();
        model.addAttribute("role", session.getAttribute("role"));
        return "pages/Home/Home";
    }
    @GetMapping("/home/tour")
    public String getTourView(){
        return "pages/Detail/TourDetail";
    }
    @GetMapping("/home/list")
    public String getListTourView(){
        return "pages/Detail/DanhSanhTour";
    }
    @GetMapping("/home/tourCart")
    public String getTourCartView(){ return "pages/Detail/TourCart"; }
    @GetMapping("/home/BookingTicket")
    public String getBookVe(){
        return "pages/BookVe/BookVe";
    }
    @GetMapping("/home/Footer")
    public String getFooter(){return "pages/Footer/Footer";}
    @GetMapping("/home/Hotel")
    public String getThueXeView(){return "pages/Hotel/Hotel";}
    @GetMapping("/home/Car")
    public String getHotel(){return "pages/ThueXe/ThueXe";}
    @GetMapping("/admin")
    public String getAdmin(final HttpServletRequest request, Model model){
        request.getSession().getAttribute("role");
        HttpSession session = request.getSession();
        model.addAttribute("role", session.getAttribute("role"));
        return "pages/Admin/admin";
    }
    @GetMapping("/admin/AccountManagement")
    public String getQLTK(){return "pages/Admin/QLTK";}
    @GetMapping("/admin/TourManagement")
    public String getQLTour(){return "pages/Admin/QLTour";}
    @GetMapping("/admin/HotelManagement")
    public String getQLhotel(){return "pages/Admin/QLKS";}
    @GetMapping("/admin/BookTour")
    public String getQLBookTour(){return "pages/Admin/QLBookTour";}
    @GetMapping("/home/News")
    public String getNews() { return "pages/News/News";
    }
    @GetMapping("/home/Feedback")
    public String getFeedback() { return "pages/Feedback/Feedback";
    }
    @GetMapping("/admin/QLFeedback")

    public String getQlFeedback() { return "pages/Admin/QLFeedback";
    }
    @GetMapping("/Bill")
    public String getBill(){return "pages/Admin/Bill";}
}
