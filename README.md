## 설명
- 해당 코드는 스프링에서 타임리프 템플릿을 이용하여 메일전송하는 예제코드입니다. 이 예제코드에서는 다음과 같은 기능을 다룹니다.
  - HTML문서에 샘플데이터를 바인딩하여 메일을 전송합니다.
  
<br>

## 프로젝트 환경
- 프로젝트 환경구성은 다음과 같습니다.
  - JAVA 11
  - Spring Boot 2.6.1
  - Thymeleaf

<br>

## 테스트 하는법
- naver 이메일 환경설정
  - 본인의 naver 이메일로 로그인하셔서 naver 이메일 환경설정을 수정해야 합니다. 자세한 내용은 <a href='https://kim-jong-hyun.tistory.com/43'>여기</a>에서 확인하시면 됩니다. 
  
- username, password값 세팅
  - ```diff
    - naver의 접속계정은 노출이 되면 보안에 취약한 데이터입니다.
    # 그래서 username, password는 프로젝트 내부에 직접 세팅하는 것 보단 외부에서 값을 주입해주는 방식이 더 안전합니다. 
    # application.yml을 보면 naver 접속정보를 System Property에서 가져오게끔 구성해두었습니다.
    # 테스트코드 작성된 곳을 가셔서 본인의 naver 접속정보를 System Property에 세팅하신 후 테스트해보시면 됩니다.
    ```
    
