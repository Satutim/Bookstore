package week2.harjoitukset.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import week2.harjoitukset.domain.Friend;

@Controller
public class FriendController {

    public static final List<Friend> friends = new ArrayList<>();

    static {
        friends.add(new Friend("Maija", "Meikäläinen"));
        friends.add(new Friend("Matti", "Meikäläinen"));
    }

    @GetMapping("/friends")
    public String showFriends(Model model) {
        model.addAttribute("friends", friends);
        return "/friendList";
    }

    @GetMapping("/add")
    public String getMethodName(Model model) {
    model.addAttribute("friend", new Friend());
    return "/addFriend";
    }

    @PostMapping("/saveFriend")
    public String saveFriendToList(@ModelAttribute Friend ystis) {
    friends.add(ystis);
    return "redirect:/friends";
    }

}