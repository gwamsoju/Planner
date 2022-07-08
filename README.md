# 개발 환경
IDE : Intellij 2021.3.3 Ultimate<br>
Framawork : Spring Boot 2.6.7<br>
Java : JDK 11<br>
DBMS : Oracle<br>
Build Tool : Gradle<br>

 # 로그인 폼
![image](https://user-images.githubusercontent.com/92564945/177926097-49dbce04-3107-4bec-8bb9-b5e205e7e61c.png)<br>
**- 일반 로그인 기능과 구글 아이디를 이용한 로그인 기능을 지원합니다.(구글 로그인 API를 사용)**<br>
**- 아이디와 비밀번호를 입력하지 않고 로그인을 요청할 경우 입력을 요청하는 알림창이 나타납니다.**<br>

# 회원가입 폼
![image](https://user-images.githubusercontent.com/92564945/177927796-08640e62-6f7f-4c86-b219-5cadd2cf2316.png)<br>
### 아이디 중복 체크 과정 
**- 아이디를 입력하지 않고 아이디 중복 체크 요청시 아이디 입력을 요청하는 알림창이 나타납니다.**<br>
**- 아이디 중복 체크 요청시 비동기 통신으로 데이터 베이스에 해당 아이디가 존재하는지 확인합니다. 그리고 결과값을 받습니다.**

#### 결과값이 0일 경우 
![image](https://user-images.githubusercontent.com/92564945/175857163-8436592f-2e1c-42aa-ba92-30bdbb62aa49.png)<br><br>
#### 결과값이 1일 경우
![image](https://user-images.githubusercontent.com/92564945/177927200-db602000-5ba2-4fab-acf0-fb6eb523035b.png)<br><br>

**- 회원 가입시 필수 입력 항목을 작성하지 않고 요청을 하면 입력을 요청하는 알림창이 나타나고 해당 입력칸에 포커스를 맞춥니다.**<br><br>
**Example)**<br><br>
![image](https://user-images.githubusercontent.com/92564945/175858044-5ef18c37-ee79-4887-8580-550f05bbe4d9.png) <br><br>

### 이메일 인증 과정 
#### 1. 이메일을 입력하고 인증 버튼을 클릭한다.<br><br>
![image](https://user-images.githubusercontent.com/92564945/177928094-c1444a23-deac-4047-8360-ec24d6481f10.png)<br><br>
#### 2. 입력한 이메일로 인증 번호가 전송되었다는 알림창과 함께 인증 번호 입력칸이 나타난다.<br><br>
![image](https://user-images.githubusercontent.com/92564945/177928312-feb01290-9ff0-44bc-a6a2-d63adbd4bee2.png)<br><br>
![image](https://user-images.githubusercontent.com/92564945/177928349-ce1a0d99-0d29-4df5-af10-8ef17a6c5a31.png)<br><br>
#### 3. 받은 이메일을 확인한다.<br><br>
![image](https://user-images.githubusercontent.com/92564945/177928691-8c51fa86-6a46-4cb5-b5b2-6386534ea29e.png)<br><br>
#### 4. 인증 번호를 입력한다.<br><br>
![image](https://user-images.githubusercontent.com/92564945/177928765-c9f17e52-8cea-490b-b1f9-b0ac67351179.png)<br><br>
#### 5. 인증 버튼을 클릭하고 결과를 기다린다.<br><br>
- 인증 번호가 다른 경우 <br><br>
![image](https://user-images.githubusercontent.com/92564945/177928899-884d0bab-0402-4b16-8551-7de9eac4897f.png)<br><br>
- 인증 번호가 같을 경우 <br><br>
![image](https://user-images.githubusercontent.com/92564945/177928944-270a9d10-74d3-43ce-950c-c6e0d35df5e1.png)<br><br>
#### 6. 인증이 완료되면 이메일 인증 버튼을 숨기고 이메일 입력칸을 "readOnly"로 바꾼다.<br><br>
![image](https://user-images.githubusercontent.com/92564945/177929279-1232e1ab-7c61-4bcc-a512-2981e002e0cb.png)<br><br>

**- <input> 태그를 "hidden" 타입으로 설정해놓고 아이디 중복 체크와 이메일 인증에 성공할 경우 값이 들어가도록 구현해놓았습니다. <br>
그래서 아이디 중복 체크와 이메일 인증을 하지 않고 회원 가입 요청을 할 경우 회원 가입 요청이 되지 않도록 했습니다.**<br><br>
- 아이디가 중복 되지 않으면 해당 <input>태그에 값을 넣고 JavaScript로 값의 존재 여부에 따라 요청이 수행되도록 했습니다.<br><br>
![image](https://user-images.githubusercontent.com/92564945/177930192-4f624c86-e0de-41e4-b7a8-bb83e61a2a89.png)<br><br>
- 이메일 인증이 되면 해당 <input>태그에 값이 들어갑니다.<br><br>
![image](https://user-images.githubusercontent.com/92564945/177930310-cd8d67a1-df82-4174-a50e-37148046f0f1.png)<br><br>

**- 회원 가입이 완료되면 로그인 페이지로 redirect해서 바로 로그인할 수 있도록 했습니다.**

# 메인 화면
## 회원 정보 수정
![image](https://user-images.githubusercontent.com/92564945/175858835-9e529cfa-0650-49c5-b489-1fc4c005d82b.png)<br>
**- 처음 가입시 입력한 정보를 수정할 수 있도록 했습니다. (단, 이름과 아이디, 성별, 이메일은 수정할 수 없습니다.)**<br><br>
## 회원 탈퇴
**- 이전 화면에서 회원 탈퇴 버튼을 누르면 회원 탈퇴를 확인하는 페이지가 나타납니다. 탈퇴를 원하면 '회원 탈퇴'를 원하지 않으면 '아니요'를 누르면 됩니다.**<br><br>
![image](https://user-images.githubusercontent.com/92564945/177931689-17ba293b-89ae-4aa0-900e-4cdafed66a12.png)<br><br>
**- 회원 탈퇴가 완료되면 로그인 화면으로 redirect합니다.**

## 일정 보기
![image](https://user-images.githubusercontent.com/92564945/175858085-c5ab1b03-f138-4952-9aea-3ae2cfd250e7.png)<br><br>
**- 메인 화면을 응답해줄 때, 금일 날짜에 맞춰 일정을 볼 수 있도록 했습니다.(예를 들어, 금일 날짜인 2022-06-27의 일정이 나옵니다.)**<br><br>
![image](https://user-images.githubusercontent.com/92564945/175858475-d6849d36-5fd4-4b46-baa0-702ec658c4bf.png)<br><br>
**- 사용자가 다른 날짜의 일정을 보고싶다면 날짜 입력 창에 원하는 날짜를 입력하고 보기 버튼을 클릭하여 해당 날짜의 일정을 볼 수 있도록 구현했습니다.(비동기 통신을 활용하여 구현)**
<br><br>
![image](https://user-images.githubusercontent.com/92564945/175858600-9cefec5a-8967-4a08-a7cb-3d228d6d37ab.png)<br>
**- 일정을 클릭하면 수정 또는 삭제할 수 있도록 구현했습니다.**<br><br>

# 메시지
![image](https://user-images.githubusercontent.com/92564945/175859027-2f577644-1ca1-48eb-bd0b-4eb2a309e908.png)
**- 좌측 상단의 메시지 버튼 클릭시 메시지 기능을 위한 메시지 페이지로 이동합니다.**<br><br>
**- 메시지 작성시 메시지 작성 폼을 요청으로 부르는 게 아닌 JavaScript를 이용하여 display:none -> display:block으로 변경하여 사용자에게 나타나도록 했습니다.**<br><br>
### Ex) 'wodud'이라는 유저에게 메시지를 보내는 과정
![image](https://user-images.githubusercontent.com/92564945/175859865-7e296d24-8fc8-4b1c-89c1-f3b570fc6056.png)<br>
- 'wodud'이라는 유저에게 메시지 작성후 전달.
- 메시지 목록에 쪽지가 도착한 것을 확인.
- 해당 메시지를 클릭하면 답장 또는 삭제 기능을 할 수 있음.

# Spring Security 
**- 인증이 안된 상태에서 인증이 필요한 요청을 하면 로그인 페이지로 이동합니다.**<br>
### Ex) 로그인이 안된 상태에서 '/messages/**' 요청을 할 경우 ?
![image](https://user-images.githubusercontent.com/92564945/176988354-8e7730b7-72f3-473f-969c-b3e251633ab8.png)
<br><br>
**- 회원 가입 요청시 회원을 비밀번호를 암호화하여 DBMS에 저장합니다.**<br><br>
![image](https://user-images.githubusercontent.com/92564945/176988641-c87d7426-9f2d-4d4f-973c-2ca50744a528.png)


## 구글 API를 사용하여 구글 간편 로그인
![image](https://user-images.githubusercontent.com/92564945/176988573-e2f25cf1-d3db-425a-8928-c818bac94ad6.png)
**- 처음 구글 간편 로그인을 이용할 경우 구글로부터 받아온 정보를 가지고 자동으로 회원가입을 진행하여 DB에 저장합니다.**

  
  
