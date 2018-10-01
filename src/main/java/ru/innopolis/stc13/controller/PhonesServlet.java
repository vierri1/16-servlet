package ru.innopolis.stc13.controller;

import ru.innopolis.stc13.pojo.Mobile;
import ru.innopolis.stc13.service.MobileService;
import ru.innopolis.stc13.service.MobileServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class PhonesServlet extends HttpServlet {
    MobileService mobileService;

    public PhonesServlet() {
        mobileService = new MobileServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String brandId = req.getParameter("id");
        List<Mobile> res = mobileService.getMobilesByBrand(brandId);
        req.setAttribute("mobiles", res);
        req.getRequestDispatcher("/phones.jsp").forward(req, resp);
    }
}
