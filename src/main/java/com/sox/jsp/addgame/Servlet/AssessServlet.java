package com.sox.jsp.addgame.Servlet;

import com.sox.jsp.addgame.AssessmentManager;
import com.sox.jsp.addgame.DAO.AnswerDAO;
import com.sox.jsp.addgame.DAO.QuestionDAO;
import com.sox.jsp.addgame.DTO.AnswerDTO;
import com.sox.jsp.addgame.DTO.QuestionDTO;
import org.json.JSONObject;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.ArrayList;

@WebServlet(name = "AssessServlet", value = "/AssessServlet")
public class AssessServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        AssessmentManager assessmentManager = AssessmentManager.getInstance();
        QuestionDAO questionDAO = QuestionDAO.getInstance();
        AnswerDAO answerDAO = AnswerDAO.getInstance();

        /* DB - answer에 넣기 위해 가져옴 */
        String code = (String)session.getAttribute("game_code");

        ArrayList<QuestionDTO> questionDTOS = questionDAO.selectQuestion(code);

        /* game.jsp에서 입력한 값 */
        /* 현재 request.getParameterValues()는 String[]형태로 넘어옴 */
        String[] answers = request.getParameterValues("answer");

        /* 입력값 json 형태로 변환 */
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("answer", answers);

        int score = assessmentManager.assess(questionDTOS, answers);

        /* DB - answer 저장 */
        AnswerDTO answerDTO = new AnswerDTO();
        answerDTO.setInputAnswer(jsonObject.toString());
        answerDTO.setScore(score);
        answerDTO.setGameCode(code);

        answerDAO.insertAnswer(answerDTO);

        /* game_result.jsp로 데이터 보내기 */
        /* answerDTO로 보내면 jsp에서 input_ans를 JSON으로 변환해야함 */
        request.setAttribute("questions", questionDTOS);
        request.setAttribute("input_ans", jsonObject);
        request.setAttribute("score", answerDTO.getScore());
        request.getRequestDispatcher("/game_result.jsp").forward(request, response);

        /* 게임이 끝나 맞춘 갯수 초기화 */
        assessmentManager.setScore(0);
    }
}
