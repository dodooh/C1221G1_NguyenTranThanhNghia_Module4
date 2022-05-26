package com.codegym.controller;


import com.codegym.model.Song;
import com.codegym.model.SongForm;
import com.codegym.service.ISongService;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.mock.web.MockMultipartFile;
@Controller
@RequestMapping("/music")
public class SongController {

    @Value("${file_upload}")
    private String fileUpload;

    @Autowired
    private ISongService iSongService;

    @GetMapping("")
    public String index(Model model) {
        List<Song> musics = iSongService.findAll();
        System.out.println(musics.size());
        model.addAttribute("musics", musics);
        return "/index";
    }


    @GetMapping("/create")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("/create");
        modelAndView.addObject("musicForm", new SongForm());
        return modelAndView;
    }

    @GetMapping("/edit/{id}")
    public ModelAndView showEditForm(@PathVariable Long id) throws IOException {
        ModelAndView modelAndView = new ModelAndView("/edit");

        Song song = iSongService.findById(id);
        File file = new File(fileUpload + song.getPathFile());
        FileInputStream input = new FileInputStream(file);
        System.out.println(song.getPathFile());
        MultipartFile multipartFile = new MockMultipartFile(song.getPathFile(),
            file.getName(), "audio/mpeg", IOUtils.toByteArray(input));
        System.out.println(multipartFile.getSize());
        SongForm songForm = new SongForm(song.getName(), song.getArtist(), song.getGenre(), multipartFile);

        modelAndView.addObject("song", songForm);
        return modelAndView;
    }

    @PostMapping("/save")
    public ModelAndView saveProduct(@ModelAttribute SongForm songForm) {
        MultipartFile multipartFile = songForm.getFile();
        String fileName = multipartFile.getOriginalFilename();
        try {
            FileCopyUtils.copy(songForm.getFile().getBytes(), new File(fileUpload + fileName));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        Song song = new Song(songForm.getName(),
            songForm.getArtist(), songForm.getGenre(), fileName);
        iSongService.save(song);
        ModelAndView modelAndView = new ModelAndView("/create");
        modelAndView.addObject("musicForm", songForm);
        modelAndView.addObject("message", "Created new product successfully !");
        return modelAndView;
    }

    @PostMapping("/delete")
    public String deleteProduct(@RequestParam Long id) {
        iSongService.remove(id);
        return "redirect:/music/";
    }
}
