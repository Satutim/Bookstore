package week2.harjoitukset.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import week2.harjoitukset.domain.Friend;

@Controller
public class FriendListController {

    @GetMapping("/friends2")
    public String showFriends(Model model) {
        model.addAttribute("friends", FriendController.friends);
        model.addAttribute("friend", new Friend());
        return "friendlist2";
    }

    @PostMapping("/saveFriend2")
    public String saveFriendToList(@ModelAttribute Friend ystis) {
        FriendController.friends.add(ystis);
        return "redirect:/friends2";
    }
}