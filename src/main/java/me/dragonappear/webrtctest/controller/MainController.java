package me.dragonappear.webrtctest.controller;

import lombok.RequiredArgsConstructor;
import me.dragonappear.webrtctest.service.MainService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RequiredArgsConstructor
@Controller
@ControllerAdvice
public class MainController {    
    private final MainService mainService;

    @GetMapping({"", "/", "/index", "/home", "/main"})
    public ModelAndView displayMainPage(final Long id, final String uuid) {
        return mainService.displayMainPage(id, uuid);
    }

    @PostMapping(value = "/room", params = "action=create")
    public ModelAndView processRoomSelection(@ModelAttribute("id") final String sid, @ModelAttribute("uuid") final String uuid, final BindingResult binding) {
        return mainService.processRoomSelection(sid, uuid, binding);
    }

    @GetMapping("/room/{sid}/user/{uuid}")
    public ModelAndView displaySelectedRoom(@PathVariable("sid") final String sid, @PathVariable("uuid") final String uuid) {
        return this.mainService.displaySelectedRoom(sid, uuid);
    }

    @GetMapping("/room/{sid}/user/{uuid}/exit")
    public ModelAndView processRoomExit(@PathVariable("sid") final String sid, @PathVariable("uuid") final String uuid) {
        return mainService.processRoomExit(sid, uuid);
    }

    @GetMapping("/room/random")
    public ModelAndView requestRandomRoomNumber(@ModelAttribute("uuid") final String uuid) {
        return mainService.requestRandomRoomNumber(uuid);
    }

    @GetMapping("/offer")
    public ModelAndView displaySampleSdpOffer() {
        return new ModelAndView("sdp_offer");
    }

    @GetMapping("/stream")
    public ModelAndView displaySampleStreaming() {
        return new ModelAndView("streaming");
    }
}
