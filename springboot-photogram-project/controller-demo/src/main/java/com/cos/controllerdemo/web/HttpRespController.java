package com.cos.controllerdemo.web;

import org.apache.catalina.users.SparseUserDatabase;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HttpRespController {

    @GetMapping("/txt")
    public String txt() {
        return "a.txt"; // 프레임워크 사용 (틀이 이미 정해져 있음) - 일반 정적 파일들은 resources/static 폴더 내부 디폴트 경로
    }

    @GetMapping("/mus")
    public String mus() {
        return "b"; // 머스태치 템플릿 엔진 라이브러리 등록 완료 - templates 폴더 안에 .mustache을 놔두면 확장자 없이 파일명만 적으면
        // 자동으로 찾아감
    }

    @GetMapping("/jsp")
    public String jsp() {
        return "c"; // jsp 엔진 사용: src/main/webapp 폴더가 디폴트 경로
                    // ViewResolver 발동 -> /WEB-INF/views/c.jsp
    }
}
