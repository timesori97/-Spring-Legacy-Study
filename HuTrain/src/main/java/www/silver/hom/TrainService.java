package www.silver.hom;

import java.util.ArrayList;
import java.util.List;

// 기차 정보를 관리하고 검색하는 서비스 클래스
public class TrainService {
    // 기차 데이터를 저장하는 2차원 배열, 도시, 기차 이름, 출발 시간, 도착 시간으로 구성
    String[][] tdata = {
            {"서울", "인천", "부산", "대구", "대전"},
            {"무궁화", "새마을호", "KTX", "무궁화", "새마을호"},
            {"0910", "0850", "1000", "1200", "0945"},
            {"1010", "1012", "1520", "1350", "1300"}
    };
    
    // 특정 도시 이름을 받아 해당 기차 정보를 반환하는 메서드
    public List<TrainDTO> find(String word) {
        // 기차 정보를 저장할 ArrayList 생성
        List<TrainDTO> l = new ArrayList();
        // 기차 데이터를 담을 TrainDTO 객체 초기화
        TrainDTO tdto = null;
        // tdata 배열을 순회하며 도시 이름을 검색
        for (int i = 0; i < tdata[0].length; i++) {
            // 현재 도시 이름
            String nowcity = tdata[0][i];
            // 입력된 도시 이름과 일치하는지 확인
            if (word.equals(nowcity)) {
                // 일치하면 새로운 TrainDTO 객체 생성
                tdto = new TrainDTO();
                // 도시 이름 설정
                tdto.setCity(tdata[0][i]);
                // 기차 이름 설정
                tdto.setTname(tdata[1][i]);
                // 출발 시간 설정
                tdto.setStarttime(tdata[2][i]);
                // 도착 시간 설정
                tdto.setArrTime(tdata[3][i]);
                // 일치하는 도시를 찾았으므로 루프 종료
                break;
            }
        }
        // TrainDTO 객체를 리스트에 추가 (일치하는 도시가 없으면 null 추가)
        l.add(tdto);
        // 결과 리스트 반환
        return l;
    }
    
    // 모든 기차 정보를 반환하는 메서드
    public List<TrainDTO> allt() {
        // 기차 정보를 저장할 ArrayList 생성
        List<TrainDTO> l = new ArrayList();
        // tdata 배열을 순회하여 모든 기차 정보 추가
        for (int i = 0; i < tdata[0].length; i++) {
            // 새로운 TrainDTO 객체 생성
            TrainDTO tdto = new TrainDTO();
            // 도시 이름 설정
            tdto.setCity(tdata[0][i]);
            // 기차 이름 설정
            tdto.setTname(tdata[1][i]);
            // 출발 시간 설정
            tdto.setStarttime(tdata[2][i]);
            // 도착 시간 설정
            tdto.setArrTime(tdata[3][i]);
            // TrainDTO 객체를 리스트에 추가
            l.add(tdto);	
        }
        // 모든 기차 정보가 담긴 리스트 반환
        return l;
    }
}