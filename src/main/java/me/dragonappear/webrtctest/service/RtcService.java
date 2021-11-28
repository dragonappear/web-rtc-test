package me.dragonappear.webrtctest.service;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

public interface RtcService {
    String displayMainPage(Long id, String uuid, Model model);
    String processRoomSelection(String sid, String uuid, BindingResult bindingResult, Model model);
    String displaySelectedRoom(String sid, String uuid, Model model);
    String processRoomExit(String sid, String uuid);
    String requestRandomRoomNumber(String uuid,Model model);
}
