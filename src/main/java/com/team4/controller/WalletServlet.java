package com.team4.controller;

import com.team4.model.Wallet;
import com.team4.service.user.IUserService;
import com.team4.service.user.UserService;
import com.team4.service.wallet.IWalletService;
import com.team4.service.wallet.WalletService;
import com.team4.service.wallet.currency.CurrencyService;
import com.team4.service.wallet.currency.ICurrencyService;
import com.team4.service.wallet.users.IUserWalletService;
import com.team4.service.wallet.users.UserWalletService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "WalletServlet", urlPatterns = "/wallets")
public class WalletServlet extends HttpServlet {
    IWalletService walletService = new WalletService();
    ICurrencyService currencyService = new CurrencyService();
    IUserWalletService userWalletService = new UserWalletService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        try {
            switch (action) {
                case "create":
                    showNewForm(request, response);
                    break;
                case "edit":
                    showEditForm(request, response);
                    break;
                default:
                    listWallets(request, response);
                    break;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        try {
            switch (action) {
                case "create":
                    insertWallet(request, response);
                    break;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void listWallets(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, SQLException, IOException {
        List<Wallet> wallets = walletService.selectAll();
        request.setAttribute("wallets", wallets);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("wallet/list.jsp");
        requestDispatcher.forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("currencies", currencyService.selectAll());
        request.setAttribute("userWallet", userWalletService.selectAll());
        RequestDispatcher dispatcher = request.getRequestDispatcher("wallet/create.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));

    }

    private void insertWallet(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        String name = request.getParameter("name");
        double balance = Double.parseDouble(request.getParameter("balance"));
        String description = request.getParameter("description");
        Wallet wallet = new Wallet(name, balance, description);
        walletService.insert(wallet);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("wallet/create.jsp");
        requestDispatcher.forward(request, response);
    }
}
