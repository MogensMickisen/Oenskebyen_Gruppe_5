package com.example.wishlist.controller;

import com.example.wishlist.model.User;
import com.example.wishlist.model.Wish;
import com.example.wishlist.model.Wishlist;
import com.example.wishlist.repository.WishlistRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class WishlistController {

    private final WishlistRepository wishlistRepository;

    public WishlistController(WishlistRepository wishlistRepository) {
        this.wishlistRepository = wishlistRepository;
    }

    @GetMapping("/")
    public String index() {
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password, HttpSession session) {
        // Simpelt login-tjek til MVP (Bør valideres mod DB i UserRepository)
        if ("testuser".equals(username) && "password123".equals(password)) {
            User user = new User(1, "testuser", "password123", "test@test.dk");
            session.setAttribute("user", user);
            return "redirect:/dashboard";
        }
        return "redirect:/";
    }

    @GetMapping("/dashboard")
    public String dashboard(HttpSession session, Model model) {
        User user = (User) session.getAttribute("user");
        if (user == null) return "redirect:/";

        model.addAttribute("user", user);
        model.addAttribute("wishlists", wishlistRepository.findByUserId(user.getUserId()));
        return "dashboard";
    }

    @GetMapping("/wishlist/{id}")
    public String viewWishlist(@PathVariable int id, Model model, HttpSession session) {
        if (session.getAttribute("user") == null) return "redirect:/";

        model.addAttribute("wishlist", wishlistRepository.findById(id));
        model.addAttribute("wishes", wishlistRepository.findWishesByWishlistId(id));
        return "wishlist";
    }

    @PostMapping("/wishlist/{id}/add")
    public String addWish(@PathVariable int id, @ModelAttribute Wish wish) {
        wish.setWishlistId(id);
        wishlistRepository.addWish(wish);
        return "redirect:/wishlist/" + id;
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }
}