package chaudnb.example.validate_song.controller;

import chaudnb.example.validate_song.entity.Song;
import chaudnb.example.validate_song.service.SongService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/songs")
@RequiredArgsConstructor
public class SongController {
    
    private final SongService songService;
    
    @GetMapping
    public String getAllSongs(Model model) {
        List<Song> songs = songService.getAllSongs();
        model.addAttribute("songs", songs);
        return "songs/list";
    }
    
    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("song", new Song());
        model.addAttribute("isEdit", false);
        return "songs/form";
    }
    
    @PostMapping("/add")
    public String addSong(@Valid @ModelAttribute("song") Song song, 
                         BindingResult bindingResult, 
                         Model model,
                         RedirectAttributes redirectAttributes) {
        
        if (bindingResult.hasErrors()) {
            model.addAttribute("isEdit", false);
            return "songs/form";
        }
        
        try {
            songService.saveSong(song);
            redirectAttributes.addFlashAttribute("successMessage", "Thêm bài hát thành công!");
            return "redirect:/songs";
        } catch (Exception e) {
            model.addAttribute("errorMessage", "Có lỗi xảy ra: " + e.getMessage());
            model.addAttribute("isEdit", false);
            return "songs/form";
        }
    }
    
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        try {
            Song song = songService.getSongById(id)
                    .orElseThrow(() -> new RuntimeException("Không tìm thấy bài hát"));
            model.addAttribute("song", song);
            model.addAttribute("isEdit", true);
            return "songs/form";
        } catch (Exception e) {
            return "redirect:/songs?error=" + e.getMessage();
        }
    }
    
    @PostMapping("/edit/{id}")
    public String updateSong(@PathVariable Long id,
                           @Valid @ModelAttribute("song") Song song,
                           BindingResult bindingResult,
                           Model model,
                           RedirectAttributes redirectAttributes) {
        
        if (bindingResult.hasErrors()) {
            model.addAttribute("isEdit", true);
            return "songs/form";
        }
        
        try {
            songService.updateSong(id, song);
            redirectAttributes.addFlashAttribute("successMessage", "Cập nhật bài hát thành công!");
            return "redirect:/songs";
        } catch (Exception e) {
            model.addAttribute("errorMessage", "Có lỗi xảy ra: " + e.getMessage());
            model.addAttribute("isEdit", true);
            return "songs/form";
        }
    }
    
    @GetMapping("/delete/{id}")
    public String deleteSong(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        try {
            songService.deleteSong(id);
            redirectAttributes.addFlashAttribute("successMessage", "Xóa bài hát thành công!");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "Có lỗi xảy ra: " + e.getMessage());
        }
        return "redirect:/songs";
    }
    
    @GetMapping("/")
    public String home() {
        return "redirect:/songs";
    }
}

