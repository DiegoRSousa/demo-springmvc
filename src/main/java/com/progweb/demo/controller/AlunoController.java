package com.progweb.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.progweb.demo.dao.AlunoDAO;
import com.progweb.demo.model.Aluno;


@Controller
@RequestMapping("/alunos")
public class AlunoController {

	private AlunoDAO alunoDAO = new AlunoDAO();
	
	@GetMapping
	public ModelAndView listar() {
		ModelAndView mv = new ModelAndView("Alunos");
		mv.addObject("alunos", alunoDAO.listar());
		mv.addObject(new Aluno());
		return mv;
	}
	
	@PostMapping
	public String salvar(Aluno aluno) {
		this.alunoDAO.salvar(aluno);
		return "redirect:/alunos";
	}
}
