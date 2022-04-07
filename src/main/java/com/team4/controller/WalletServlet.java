package com.team4.controller;

import com.team4.model.CurrencyWallet;
<<<<<<< HEAD
import com.team4.model.UserWallet;
import com.team4.model.Wallet;
=======
import com.team4.model.User;
import com.team4.model.Wallet;
import com.team4.service.currency.CurrencyService;
import com.team4.service.currency.ICurrencyService;
>>>>>>> duong
import com.team4.service.user.IUserService;
import com.team4.service.user.UserService;
import com.team4.service.wallet.IWalletService;
import com.team4.service.wallet.WalletService;
<<<<<<< HEAD
import com.team4.service.wallet.currency.CurrencyService;
import com.team4.service.wallet.currency.ICurrencyService;
import com.team4.service.wallet.users.IUserWalletService;
import com.team4.service.wallet.users.UserWalletService;
=======
>>>>>>> duong

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "WalletServlet", value = "/wallets")
public class WalletServlet extends HttpServlet {
    ICurrencyService currencyService = new CurrencyService();
<<<<<<< HEAD
    IUserWalletService userWalletService = new UserWalletService();
=======
    IWalletService walletService = new WalletService();
    IUserService userService = new UserService();
>>>>>>> duong

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                showNewForm(request, response);
                break;
            default:
                listWallet(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
<<<<<<< HEAD
        try {
            switch (action) {
                case "create":
                    insertWallet(request, response);
                    break;
                case "edit":
                    updateWallet(request, response);
                    break;
            }
        } catch (SQLException e) {
            e.printStackTrace();
=======
        switch (action) {
            case "create":
                insertWallet(request, response);
                break;
>>>>>>> duong
        }
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("currencies", currencyService.selectAll());
        request.setAttribute("users", userService.selectAll());
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("wallet/create.jsp");
        requestDispatcher.forward(request, response);
    }

    private void listWallet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Wallet> wallets = walletService.selectAll();
        request.setAttribute("wallets", wallets);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("wallet/list.jsp");
        requestDispatcher.forward(request, response);
    }

<<<<<<< HEAD
    private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("currencies", currencyService.selectAll());
        request.setAttribute("userWallet", userWalletService.selectAll());
        RequestDispatcher dispatcher = request.getRequestDispatcher("wallet/create.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Wallet wallet = walletService.getById(id);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("wallet/edit.jsp");
        request.setAttribute("editingWallet", wallet);
        requestDispatcher.forward(request, response);
    }

    private void insertWallet(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        String name = request.getParameter("name");
        int a = Integer.parseInt(request.getParameter("currencies"));
        CurrencyWallet currencyWallet = currencyService.getById(a);
        int b = Integer.parseInt(request.getParameter("user"));
        UserWallet userWallet = userWalletService.getById(b);
        double balance = Double.parseDouble(request.getParameter("balance"));
        String description = request.getParameter("description");
        Wallet wallet = new Wallet(name, currencyWallet, userWallet, balance, description);
=======
    private void insertWallet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String name = request.getParameter("name");
        String idCurrencyStr = request.getParameter("id_cur");
        int idCur = Integer.parseInt(idCurrencyStr);
        String nameUser = (String) session.getAttribute("loginuser");
        int idUser = userService.getUserIdByName(nameUser);
        String amountStr = request.getParameter("current_amount");
        double currentAmount = Double.parseDouble(amountStr);
        String description = request.getParameter("description");
        User user = new User(idUser, nameUser);
        CurrencyWallet currencyWallet = new CurrencyWallet(idCur);
        Wallet wallet = new Wallet(name, currentAmount, description, user, currencyWallet);
>>>>>>> duong
        walletService.insert(wallet);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("wallet/create.jsp");
        requestDispatcher.forward(request, response);
    }

    private void updateWallet(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        double balance = Double.parseDouble(request.getParameter("balance"));
        String description = request.getParameter("description");

        Wallet editingWallet = new Wallet(id, name, balance, description);
        walletService.update(editingWallet);
        RequestDispatcher dispatcher = request.getRequestDispatcher("wallet/edit.jsp");
        dispatcher.forward(request, response);
    }
}
