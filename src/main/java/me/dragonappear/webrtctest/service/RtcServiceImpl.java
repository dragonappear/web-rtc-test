package me.dragonappear.webrtctest.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.dragonappear.webrtctest.domain.Room;
import me.dragonappear.webrtctest.domain.RoomService;
import me.dragonappear.webrtctest.util.Parser;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;


@Slf4j
@RequiredArgsConstructor
@Service
public class RtcServiceImpl implements RtcService{
    private static final String REDIRECT = "redirect:/";
    private final RoomService roomService;
    private final Parser parser;

    @Override
    public String displayMainPage(Long id, String uuid, Model model) {
        model.addAttribute("id", id);
        model.addAttribute("rooms", roomService.getRooms());
        model.addAttribute("uuid", uuid);
        return "main";
    }

    @Override
    public String processRoomSelection(String sid, String uuid, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return REDIRECT;
        }
        Optional<Long> optionalId = parser.parseId(sid);
        optionalId.ifPresent(id -> Optional.ofNullable(uuid).ifPresent(name -> roomService.addRoom(new Room(id))));
        return this.displayMainPage(optionalId.orElse(null), uuid,model);
    }

    @Override
    public String displaySelectedRoom(String sid, String uuid, Model model) {
        String result = REDIRECT;

        if (parser.parseId(sid).isPresent()) {
            Room room = roomService.findRoomByStringId(sid).orElse(null);
            if(room != null && uuid != null && !uuid.isEmpty()) {
                log.debug("User {} is going to join Room #{}", uuid, sid);
                result += "chat_room";
                model.addAttribute("uuid", uuid);
                model.addAttribute("id", sid);
            }
        }
        return result;
    }

    @Override
    public String processRoomExit(String sid, String uuid) {
        if(sid != null && uuid != null) {
            log.debug("User {} has left Room #{}", uuid, sid);
        }
        return REDIRECT;
    }

    @Override
    public String requestRandomRoomNumber(String uuid,Model model) {
        return this.displayMainPage(randomValue(), uuid,model);
    }

    private Long randomValue() {
        return ThreadLocalRandom.current().nextLong(0, 100);
    }
}
