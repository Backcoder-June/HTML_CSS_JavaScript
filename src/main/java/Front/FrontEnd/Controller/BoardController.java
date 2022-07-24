package Front.FrontEnd.Controller;

import Front.FrontEnd.Entity.Board;
import Front.FrontEnd.Entity.BoardDTO;
import Front.FrontEnd.Service.boardDAO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class BoardController {

    private final boardDAO boardDAO;

    public BoardController(Front.FrontEnd.Service.boardDAO boardDAO) {
        this.boardDAO = boardDAO;
    }


    @GetMapping("/")
    public String boardhome(){
        return "/board/boardstart.html";
    }


    @GetMapping("/allboard")
    public String selectAll(Model model){

        List<Board> boards = boardDAO.selectAll();
        model.addAttribute("boards", boards);

        return "/board/boardlist";
    }

    @GetMapping("/writeboard")
    public String writing() {
        return "/board/boardwrite";
    }

    @PostMapping("/writeboard")
    public String saving(BoardDTO dto){


        Board board = dto.toEntity();

        boardDAO.saving(board);




        return "redirect:/";
    }






}
