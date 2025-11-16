package controller;

import model.User;
import model.UserProfile;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Optional;

@WebServlet("/profile")
public class ProfileServlet extends HttpServlet {
    private UserService userService;

    @Override
    public void init() {
        userService = new UserService();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");

        if (user != null) {
            Optional<UserProfile> profileOpt = userService.getUserProfile(user.getId());
            profileOpt.ifPresent(profile -> request.setAttribute("userProfile", profile));

            request.getRequestDispatcher("/profile.jsp").forward(request, response);
        } else {
            response.sendRedirect(request.getContextPath() + "/login.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");

        if (user == null) {
            response.sendRedirect(request.getContextPath() + "/login.jsp");
            return;
        }

        // Update user basic information
        user.setEmail(request.getParameter("email"));
        user.setFirstName(request.getParameter("firstName"));
        user.setLastName(request.getParameter("lastName"));

        // Update or create profile
        UserProfile profile = new UserProfile();
        profile.setUserId(user.getId());
        profile.setPhone(request.getParameter("phone"));
        profile.setAddress(request.getParameter("address"));

        String dob = request.getParameter("dateOfBirth");
        if (dob != null && !dob.isEmpty()) {
            profile.setDateOfBirth(LocalDate.parse(dob));
        }

        boolean success = userService.updateUserProfile(user, profile);

        if (success) {
            request.setAttribute("success", "Profile updated successfully!");
        } else {
            request.setAttribute("error", "Failed to update profile");
        }

        request.setAttribute("userProfile", profile);
        request.getRequestDispatcher("/profile.jsp").forward(request, response);
    }
}