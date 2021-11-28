package me.dragonappear.webrtctest.controller;

import lombok.RequiredArgsConstructor;
import me.dragonappear.webrtctest.service.RtcService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@RequiredArgsConstructor
@Controller
public class RtcController {
    private final RtcService rtcService;

    /*@GetMapping({"", "/", "/index", "/home", "/main"})
    public String displayMainPage(final Long id, final String uuid, Model model) {
        return rtcService.displayMainPage(id, uuid,model);
    }

    @PostMapping(value = "/room", params = "action=create")
    public String processRoomSelection(@ModelAttribute("id") final String sid, @ModelAttribute("uuid") final String uuid, final BindingResult binding,Model model) {
        return rtcService.processRoomSelection(sid, uuid, binding,model);
    }

    @GetMapping("/room/{sid}/user/{uuid}")
    public String displaySelectedRoom(@PathVariable("sid") final String sid, @PathVariable("uuid") final String uuid,Model model) {
        return rtcService.displaySelectedRoom(sid, uuid,model);
    }

    @GetMapping("/room/{sid}/user/{uuid}/exit")
    public String processRoomExit(@PathVariable("sid") final String sid, @PathVariable("uuid") final String uuid) {
        return rtcService.processRoomExit(sid, uuid);
    }

    @GetMapping("/room/random")
    public String requestRandomRoomNumber(@ModelAttribute("uuid") final String uuid,Model model) {
        return rtcService.requestRandomRoomNumber(uuid,model);
    }

    @GetMapping("/offer")
    public ModelAndView displaySampleSdpOffer() {
        return new ModelAndView("sdp_offer");
    }

    @GetMapping("/stream")
    public ModelAndView displaySampleStreaming() {
        return new ModelAndView("streaming");
    }*/
}
