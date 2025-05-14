package www.silver.hom;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

// Spring MVC 컨트롤러 클래스, 기차 정보 관련 요청을 처리
@Controller
public class TrainController {
    
    // TrainService 객체를 생성하여 기차 데이터 조회 로직 사용
    TrainService ts = new TrainService();
    
    // "/t" 경로로 GET 요청이 들어올 때 호출되는 메서드
    @RequestMapping(value = "/t", method = RequestMethod.GET)
    public String home1(Locale locale, Model model) {
        // 클라이언트의 로케일 정보를 받아 뷰 렌더링에 활용 가능
        // Model 객체를 통해 뷰에 데이터를 전달할 수 있음
        // "train/train" 뷰(예: JSP 페이지)를 반환하여 기차 정보 입력 페이지 표시
        return "train/train";
    }
    
    // "/allt" 경로로 GET 요청이 들어올 때 호출되는 메서드
    @RequestMapping(value = "/allt", method = RequestMethod.GET)
    public String allt(Locale locale, Model model) {
        // TrainService의 allt 메서드를 호출하여 모든 기차 정보를 조회
        List<TrainDTO> l = ts.allt();
        // 조회된 기차 정보 리스트를 "train_list"라는 이름으로 Model에 추가
        model.addAttribute("train_list", l);
        // "train/train" 뷰를 반환하여 모든 기차 정보를 표시
        return "train/train";
    }
    
    // "/find" 경로로 GET 요청이 들어올 때 호출되는 메서드
    @RequestMapping(value = "/find", method = RequestMethod.GET)
    public String selectCity(
            // 요청 파라미터 "word" (도시 이름)를 받아옴, 필수 아님
            @RequestParam(required = false) String word,
            // 요청 파라미터 "id"를 받아옴, 필수 아님
            @RequestParam(required = false) String id,
            // 뷰에 데이터를 전달하기 위한 Model 객체
            Model model) {
        
        // TrainService의 find 메서드를 호출하여 입력된 도시 이름에 해당하는 기차 정보 조회
        List<TrainDTO> l = ts.find(word);        
        // 조회된 기차 정보 리스트를 "train_list"라는 이름으로 Model에 추가
        model.addAttribute("train_list", l);
        // "train/train" 뷰를 반환하여 검색된 기차 정보를 표시
        return "train/train";
    }
}