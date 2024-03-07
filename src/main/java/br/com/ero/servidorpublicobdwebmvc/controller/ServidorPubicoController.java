package br.com.ero.servidorpublicobdwebmvc.controller;


import br.com.ero.servidorpublicobdwebmvc.service.ServidorPublicoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ServidorPubicoController {

    @Autowired
    private ServidorPublicoService servidorPublicoService;

    @GetMapping("/listarServidores")
    public String listarServidores(Model model)
    {
        model.addAttribute("servidorespublicos",servidorPublicoService.listAll());
        return "servidorespublicos";
    }
    @GetMapping("/listarServidor/{matricula}")
    public String listarServidor(@PathVariable long matricula, Model model){
        model.addAttribute("servidorpublico",servidorPublicoService.listByMatricula(matricula).get());
        return "servidorpublico";

    }


}
