# 개발 환경
IDE : Intellij 2021.3.3 Ultimate<br>
Framawork : Spring Boot 2.6.7<br>
Java : JDK 11<br>
DBMS : Oracle<br>
Build Tool : Gradle<br>

 # 로그인 폼
![image](https://user-images.githubusercontent.com/92564945/175857087-4cac2bb1-45cd-4587-ae9b-b4e03fd9070f.png)<br>

# 회원가입 폼
![image](https://user-images.githubusercontent.com/92564945/175856916-a64a1c4c-ec32-4d3e-81f2-efbe9d4138ee.png)<br>
![image](https://user-images.githubusercontent.com/92564945/175857163-8436592f-2e1c-42aa-ba92-30bdbb62aa49.png)<br><br>
**- 비동기 통신을 이용하여 아이디 중복 체크 버튼 클릭시 입력한 아이디의 사용 가능 여부를 응답해줌.**<br><br>
![image](https://user-images.githubusercontent.com/92564945/175858044-5ef18c37-ee79-4887-8580-550f05bbe4d9.png) <br><br>
**- 값을 입력하지 않고 회원가입 버튼을 클릭할 경우 입력을 하라는 팝업창을 띄워주고 해당 입력칸에 포커스를 맞춤.**
# 메인 화면
![image](https://user-images.githubusercontent.com/92564945/175858835-9e529cfa-0650-49c5-b489-1fc4c005d82b.png)<br>
**- 회원 정보를 수정 기능 구현.(이름과 아이디, 성별은 값만 볼 수 있고 수정은 할 수 없음.)**<br><br>
![image](https://user-images.githubusercontent.com/92564945/175858085-c5ab1b03-f138-4952-9aea-3ae2cfd250e7.png)<br><br>
**- 메인 화면을 응답해줄 때, 금일 날짜에 맞춰 일정을 볼 수 있도록 함.**<br><br>
![image](https://user-images.githubusercontent.com/92564945/175858475-d6849d36-5fd4-4b46-baa0-702ec658c4bf.png)<br><br>
**- 사용자가 다른 날짜의 일정을 보고싶다면 날짜 입력 창에 원하는 날짜를 입력하고 보기 버튼을 클릭하여 해당 날짜의 일정을 볼 수 있도록 함.(비동기 통신을 활용하여 구현)**
<br><br>
![image](https://user-images.githubusercontent.com/92564945/175858600-9cefec5a-8967-4a08-a7cb-3d228d6d37ab.png)<br>
**- 일정을 클릭하면 수정 또는 삭제할 수 있도록 구현.**<br><br>
# 메시지
![image](https://user-images.githubusercontent.com/92564945/175859027-2f577644-1ca1-48eb-bd0b-4eb2a309e908.png)
**- 좌측 상단의 메시지 버튼 클릭시 메시지 기능을 위한 메시지 페이지로 이동.**<br><br>
**- 메시지 작성시 메시지 작성 폼을 요청으로 부르는 게 아닌 JavaScript를 이용하여 display:none -> display:block으로 변경하여 사용자에게 나타나도록 함.**<br><br>
### Ex) 'wodud'이라는 유저에게 메시지를 보내는 과정
![image](https://user-images.githubusercontent.com/92564945/175859865-7e296d24-8fc8-4b1c-89c1-f3b570fc6056.png)<br>
- 'wodud'이라는 유저에게 메시지 작성후 전달.
- 메시지 목록에 쪽지가 도착한 것을 확인.
- 해당 메시지를 클릭하면 답장 또는 삭제 기능을 할 수 있음.

현재 Spring Security를 적용하는 중입니다! 





  
  
