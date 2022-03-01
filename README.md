## 1. 클라이언트와 서버

<details>
<summary>클라이언트와 서버란?</summary>
<div markdown="1">

<br>
	
- 클라이언트(client) : 서비스를 **요청**하는 애플리케이션(컴퓨터)  
- 서버(server) : 서비스를 **제공**하는 애플리케이션(컴퓨터)

서버의 종류는 여러가지(Email server, File server 등)가 있지만, 우리가 지금 배우려고 하는 것은 웹서버(Web Server)이다.  
한 대의 PC에는 여러가지 서버가 존재한다. 어떤 서버를 사용할지는 포트 번호로 정한다.  
웹서버는 기본적으로 포트번호가 80이고 생략이 가능하다. 톰캣은 기본 포트번호가 8080!  
(즉, 우리는 공부할 때 대부분 톰캣의 기본 포트번호인 8080을 사용하기 때문에 서버를 킨 후 localhost8080 ... 이라고 입력해서 프로젝트를 실행시키는데, 설정파일에서 포트번호를 80으로 바꿔주면 포트번호를 생략할 수 있다! )

**참고 0~1023까지는 이미 예약되어있는 포트번호이다.

#### WAS란?
- Web Application Server로 서버에 프로그램을 설치해 놓고, 클라이언트가 그 프로그램을 사용할 수 있게 해준다.

#### 톰캣의 내부구조
- 클라이언트가 요청을 보내면 서버의 톰캣에서는 미리 만들어진 쓰레드(Thread Pool)를 거쳐 Service로 요청을 보낸다.  
- Service에는 Connector가 들어있는데, 프로토콜 종류에 따라서 처리할 Connector가 정해진다.  
- 그럼 이 Connector는 요청을 다시 엔진(Catalina)한테 전달한다.  
- 엔진 안에는 호스트가 있는데 호스트 안에는 Context가 있다. Context는 웹애플리케이션을 뜻하는데, 당연히 여러개가 있을 수 있다!(스프링 프로젝트 하나가 Context하나)  
- Context안에는 서블릿이 있다. 서블릿이란 작은 서버 프로그램이라고 이해하면 되는데, 이 서블릿까지 요청이 와야 비로소 main메서드의 매개변수에 요청이 전달된다.


**참고1 보통 하나의 톰캣한에 한개의 호스트가 있지만 경우에 따라서 여러개를 둘 수도 있다.(도메인 네임이 다른 호스트를 여러개 둘 수 있다는 뜻)  
**참고2 톰캣안의 서비스 안의 엔진 안의 Host 안의 Context 안의 서블릿

#### 톰캣의 설정파일
- server.xml
: Tomcat의 서버 설정 파일
- web.xml
: Tomcat의 공통설정 파일과 개인 설정 파일 두 개가 있다.

</div>
</details>

## 2. HTTP 요청과 응답

<details>
<summary>HTTP 요청과 응답이란?</summary>
<div markdown="1">

<br>
	
**프로토콜이란?**
- 서로간의 통신을 위한 약속, 규칙. 주고 받을 데이터에 대한 형시을 정의한 것

**HTTP란?**
- 텍스트 기반의 프로토콜이기 때문에 단순하고 읽기가 쉽다. 또한 상태를 유지하지 않는다.(stateless )
- 즉, 클라이언트 정보를 저장하지 않는다는 것인데, 이 부분은 쿠키와 세션으로 해결할 수 있다.
- 확장 가능하다. 커스텀 헤더를 추가할 수 있다.

**HTTP 메시지**
 - 우리가 URL을 보내면 톰캣은 HttpServletRequest객체를 만든다고 했는데, 이 전에 사실 브라우저는 HTTP요청메시지를 만들어서 톰갯에 보낸다.

**HTTP 메서드**
 - get 
   - 서버의 리소스를 가져오기 위해 설계
   - QUERY STRING을 통해	데이터를 전달 (소용량)
   - URL에 데이터 노출되므로 보안에 취약
   - 데이터 공유에 유리
   - ex) 검색엔진에서 검색단어 전송에 이용
  - POST
    - 서버에 데이터를 올리기 위해 설계됨
    - 전송 데이터 크기의 제한이 없음(대용량)
    - 데이터를 요청 메시지의 body에 담아서 전송
    - 보안에 유리, 데이터 공유에는 불리
    - ex) 게시판에 글쓰기, 로그인, 회원가입

</div>
</details>

## 3. 관심사의 분리 (MVC 패턴)

<details>
<summary>관심사의 분리란?</summary>
<div markdown="1">

<br>
	
**MVC** 패턴이란?
- **M**odel : Controller와 View 사이에서 데이터를 전달해 주는 역할을 한다.  
- **V**iew : Controller에서 처리한 데이터를 Model을 통해 전달 받고, 이 데이터를 화면에 출력해주는 역할을 한다.  
- **C**ontroller : 사용자의 요청이 들어오면 사용자가 원하는 데이터를 Model에 담아 보내는 역할을 한다.  

**참고 : Model은 DispatcherServlet이 생성해서 Controller에 넘겨주는데, DispatcherServlet은 뒤에서 자세하게 다룰 예정.

</div>
</details>

## 4. Servlet과 JSP

<details>
<summary>Servlet과 JSP란?</summary>
<div markdown="1">

<br>
	
**0) 간단 정리**
- 역할의 차이일 뿐 기능적인 차이는 없다.(하는 일은 동일)
- Servlet : java코드 안에 html코드
- JSP : html코드 안에 java코드

**1) Servlet**
- Servlet을 발전시킨 것이 spring

|구분|servlet|spring|
|---|---|---|
|Annotation|@WebServlet|@Controller + @RequestMapping|
|Mapping|클래스 단위|메서드 단위, 때문에 하나의 클래스에 여러개의 매핑 가능|
|상속|HttpServlet상속|상속 안받음 (자바는 단일상속이기 때문에 상속을 안받는 것이 좋다. 이런점이 spring에서 개선이 된 것)|
|메서드명|Override된 init(), service(), destroy()등|마음대로|
|매개변수|HttpServletRequest, HttpServletResponse를 무조건 매개변수로 받아야함|필요한 것만 매개변수로 받음|

- 서블릿은 기본적으로 init(), service(), distroy() 이 세개의 메서드를 사용한다.
	- init() : 서블릿 초기화. 서블릿이 생성, 또는 리로딩될 때 단 한 번만 수행됨
	- service() : 호출될 때 마다 반복적으로 수행됨
	- destroy() : 뒷정리 작업. 서블릿이 제거(unload) 될 때 단 한 번만 수행됨

- 즉, 클라이언트가 요청을 보내면 ServletContext가 서블릿 인스턴스의 존재를 확인한다.
일치하는 인스턴스가 있다면 service() 메서드를 호출하고, 없다면 서블릿 클래스를 로딩하고 새로운 서블릿 인스턴스를 생성한다. 이 때 init() 메서드가 호출이 된다. 그 후 요청부터는 인스턴스가 만들어진 상태이기 때문에 service() 메서드만 호출이 되고, 프로그램이 갱신되거나 애플리케이션이 종료가 되서 서블릿이 메모리에서 내려갈 때 destroy() 메서드가 호출이 된다.

**참고 : 서블릿은 기본적으로 singleton패턴이기 때문에 한 개의 인스턴스만 생성이 된다.

**2) JSP**
- jsp파일은 언제, 어떻게 servlet으로 변환이 될까?
	- *.jsp 요청이 들어오면, jspServlet이 서블릿 인스턴스가 있는지 확인한다. 
	- 없으면 이 파일을 서블릿으로 변환하는데, 이 때 *_jsp.java로 변환이 된다.
	- 이렇게 변환된 java파일을 컴파일 하면 *_jsp.class파일이 만들어지고, 인스턴스가 생성된다.
	- 이제 서블릿과 마찬가지로 초기화 메서드 _jspInit()과 실행 메서드 _jspsService()가 호출되며 응답을 준다.
	- 처음에 변환과 컴파일을 해야하기 때문에 시간이 걸린다.(지연된 초기화)

**3) Servlet과 JSP의 차이**
- Servlet
	- java코드 안에 HTML 코드 (하나의 클래스)
	- data processing(Controller)에 좋다.
	- 즉 DB와의 통신, Business Logic 호출, 데이터를 읽고 확인하는 작업 등에 유용하다.
	- Servlet이 수정된 경우 Java 코드를 컴파일(.class 파일 생성)한 후 동적인 페이지를 처리하기 때문에 전체 코드를 업데이트하고 다시 컴파일한 후 재배포하는 작업이 필요하다. (개발 생산성 저하)
- JSP
	- HTML 코드 안에 Java 코드
	- presentation(View)에 좋다.
	- 즉, 요청 결과를 나타내는 HTML 작성하는데 유용하다.
	- JSP가 수정된 경우 재배포할 필요가 없이 WAS가 알아서 처리한다. (쉬운 배포)


**4) 유효범위와 속성**
- Http는 상태정보를 저장하지 않는 stateless라는 특징이 있다.
- 그렇기 때문에 저장소가 필요한데, 접근범위와 생존기간에 따른 4개의 저장소가 있다. 사용 목적에 따라 알맞은 저장소를 사용하면 된다. 저장소는 Map형태로 제공된다.
	- pageContext 저장소 : 해당 jsp페이지 내부에서만 접근가능. 다른 jsp페이지에서는 접근할 수 없다.
		- 지역변수와 기본객체(request, response 등)를 저장
		- EL태그를 쓰려면 꼭 이 저장소에 저장을 해야한다.
	- application 저장소 : Servlet Context전체에서 접근가능. 
		- 이 저장소는 딱 1개 있다.(공통저장소)
	- session 저장소 : 클라이언트마다 가지고 있는 개별 저장소. 모든 페이지에서 접근가능. 
		- 클라이언트가 10000명이면 세션 객체도 10000개가 필요하기때문에 편리하지만 메모리 부담이 크다.
		- 그래서 session엔 최소한의 정보만 저장한다.
	- request : 요청이 처리되는 동안만 존재.
		- 데이터를 다른 페이지로 넘길 때 사용 (forword)

**5) URL패턴**
- @WebServlet으로 서블릿을 URL에 매핑할 때 사용
- 우선순위
	- 1 - 정확히 일치하는 것(exact mapping)
	- 2 - 경로를 와일드카드로 처리(path mapping)
	- 3 - 확장자를 적고, 파일명을 와일드카드로 처리(extension mapping)
	- 4 - 모든 주소와 매핑이 된다(default mapping)

**6) Filter**
- 공통적인 요청(전처리, 후처리)에 사용한다. ex) 로깅, 인코딩 등

</div>
</details>

## 5. @RequestParam과 @ModelAttribute

<details>
<summary>@RequestParam과 @ModelAttribute란?</summary>
<div markdown="1">

<br>
	
**@RequestParam**
- 요청의 파라미터를 연결할 매개변수에 붙이는 어노테이션
- 기본값 : @RequestParam(name="파라미터명", required=false) 생략가능하다.
- @RequestParam만 쓰고 뒤에 옵션을 안붙여주면 (name="파라미터명", required=true)가 생략된 것이다.
- 매개변수의 타입이 String인지, int인지에 따라 생각을 조금 해봐야한다.
	- String
		- equired= false일 때 : 파라미터를 안넘기거나 빈 문자열을 넘겨도 에러 안남. null과 ""를 자동으로 String 타입으로 바꿔주기 때문
		- required=true일 때  : 파라미터를 안넘기면 400에러남. 꼭 넘겨야 하는데, 클라이언트가 안넘긴거라서! 빈 문자열을 넘기면 에러 안남.
	- int
		- required=false일 때 : 파라미터를 안넘기면 500에러난다. 필수입력이 아니라서 안넘긴긴건 클라이언트의 잘못이 아니다. 파라미터를 안넘기면 null이 들어오는데, 이 null을 int 타입으로 바꿀 수 없기 때문에 500에러가 난다.
		- 그러나 빈 문자열을 넘기면 400에러가 난다. 클라이언트가 값을 넘기긴 넘겼는데 잘못 넘겼기 때문에! 역시 빈 문자열""을 int타입으로 바꿀 수 없기 때문에 에러가 나는 것.
		- 때문에 매개변수가 int타입이고,  required가 false일 땐 defaultValue 옵션을 써서 기본값을 넘겨주어야 한다. (ex) defaultValue="1")
		- required=true일 때 : 파라미터를 안넘기거나 빈 문자열로 넘기면 400에러가 난다. 꼭 넘겨야 하는 파라미터인데, 클라이언트가 잘못넘긴 것이므로.

**@ModelAttribute**
- 이 어노테이션이 붙은 대상은 Model의 속성으로 자동 추가를 해준다.
- 컨트롤러 메서드의 매개변수와 반환타입에 어노테이션을 적용할 수 있다.
- 예를 들어 (@ModelAttribute MyDate date, Model m)을 매개변수로 받으면, m.addAttribute("myDate", date)로 모델에 key와 value를 넘기지 않아도 자동으로 추가를 해준다. key는 타입의 앞글자를 소문자로 변환한 후 저장해준다.
- 반환타입 앞에 붙여주면, 그 메서드의 호출 결과를 Model에 저장하여 반환한다. 이 때는 key를 직접 지정해주어야하며, value에는 반환값이 들어간다.
- 그런데 사실 컨트롤러의 매개변수가 참조형일 땐 @ModelAttribute가 생략 가능하다.
- 그래서 위 예시에서 따로 어노테이션을 붙이지 않아도 m.addattribute를 쓰지 않아도 된다.

**WebDataBinder**
- 쿼리스트링으로 받은 문자열 value를 컨트롤러 메서드의 int타입의 매개변수로 받아야 하는 상황이 있다. 이때 중간에서 타입 변환을 해주는 애가 WebDataBinder이다.
- WebDataBinder는 타입을 변환한 후 결과를 BindingResult에 저장한다. 변환 중 에러가 생겨도 그 에러를 BidingResult에 저장한다.
- 타입을 변환한 후에는 데이터를 검증(Validation)한다. 이 때 또 결과나 에러를 BindingResult에 저장한다.
- 그리고 BindingResult에 담긴 값들을 컨트롤러에 넘겨줘서 컨트롤러의  로직에 따라 처리된다.
- BindingResult는 바인딩할 객체의 바로 뒤에 위치해야 한다.

</div>
</details>

## 6. redirect와 forward

<details>
<summary>redirect와 forward란?</summary>
<div markdown="1">

<br>
	
**redirect**
- 브라우저가 다른 URL로 재요청. mapping으로 컨트롤러가 실행되게 하고, 유효성 검사를 통과하지 못하면 redirect로 다른 매핑으로 넘겨준다. 그럼 그 다음 매핑에서 view로 넘겨주겠지???
- 처음 요청이 GET이던 POST이던 redirect는 GET으로 재요청이 된다. 
- 스프링에서는?
	- 클라이언트가 요청을 하면 그 요청을 DispatcherServlet이 받고, 이 요청을 수행할 수 있는 Controller를 호출한다. 거기서 어떠한 이유(유효성 검사를 통과 못한다던가 등)로 redirect를 만나면 view이름 대신에 다른 매핑을 반환한다. Controller가 다른 매핑을 반환하면 DispatcherServlet은 이 반환값에 redirect가 들어있기 때문에 redirectView한테 전달을 한다. 그럼 redirectView는 응답 헤더를 만든다. 클라이언트는 이 응답을 받아서 아 재요청을 해야하는 구나 하고 브라우저가 응답헤더에 있는 Location경로로 재요청을 한다. 

**forward**
- 클라이언트가 요청한 것을 request객체에 담아서 다른 view로 그대로 전달
- 클라이언트가 요청을 하면 그 요청을 DispatcherServlet이 받고, 이 요청을 수행할 수 있는 Controller를 호출한다. 거기서 어떠한 이유(유효성 검사를 통과 못한다던가 등)로 forward를 만나면 DispatcherServlet은 반환값을 InternalResourceView로 넘긴다. DispatcherServlet은 forward뒤의 매핑에 맞는 메서드를 찾아간다.
	
</div>
</details>

## 7. cookie와 session

<details>
<summary>cookie와 session이란?</summary>
<div markdown="1">

<br>
	
**cookie**
- name과 value를 한 쌍으로 저장하는 것
- id, domain, path, 유효기간 등도 다 저장할 수 있다.
- 쿠키에는 아스키 문자만 가능.
- 서버에서 생성해서 브라우저에 저장한다. -> 브라우저에 저장하는거라 사용자가 쿠키를 삭제할 수도 있고, 서버에서 발급해주는 쿠키를 거부할 수도 있다.
- 쿠키가 여러개 있을 땐 domain, path가 일치하는 경우에만 자동 전송해준다.
- 쿠키 생성하는 법
	- Cookie cookie = new Cookie("name", "value"); //쿠키 생성
	- cookie.setMaxAge(60 * 60 * 24); //유효기간은 초 단위 설정이 가능하다.
	- response.addCookie(cookie); //응답(response)에 쿠키 추가
- 쿠키 삭제하는 법
	- Cookie cookie = new Cookie("name"); //변경(삭제)할 쿠키와 같은 이름의 쿠키 생성
	- cookie.setMaxAge(0); //유효기간을 0으로 설정 -> 삭제
	- response.addCookie(cookie); //응답(response)에 쿠키 추가

**참고 : @CookieValue라는 어노테이션이 있는데, 값을 가져오고싶은 쿠키이름을 적어주면 값을 받아올 수 있다. (매개변수에 @CookieValue("JSESSIONID") String sessionId 이런식으로)

**session**
- 서로 관련된 요청들을 하나로 묶은 것 - 쿠키를 이용
- 서버에서는 browser마다 개별 저장소(session)객체를 제공해준다. 즉, 세션은 서버에 저장! - 왜 브라우저마다 제공? 쿠키를 이용했기 때문에!(쿠키는 브라우저에 저장된다.)
- 세션의 생성과정
	- 처음에 브라우저가 요청을 하면 서버는 무조건 세션 객체(저장소)를 만든다.
	- 그 세션 객체는  세션 ID를 가지고 있다.(JSESSIONID)
	- 서버는 응답헤더에 그 세션ID를 담아서(set-Cookie) 응답을 보낸다.
	- 그럼 브라우저에 쿠키가 저장된다.
	- 그 다음부터는 요청을 보낼 때 마다 쿠키가 따라다닌다.
	- 서버는 쿠키에 담긴 JSESSIONID를 보고 같은 브라우저에서 보낸 요청인지 판별한다.
- 세션 생성하는 법
	- HttpSession session = request.getSession(); //생성
	- session.setAttribute("key", "value"); // 값 저장
- 세션 종료하기
	- HttpSession session = request.getSession();
	- session.invalidate(); //세션을 즉시 종료 - 수동종료
	- session.setMaxInactiveInterval(60*30) //예약 종료(초단위) - 수동종료
	- 자동종료는 web.xml에 설정해주어야한다.

|쿠키(Cookie)|세션(HttpSession)|
|---|---|
|브라우저에 저장|서버에 저장|
|서버에 부담 없음|서버 부담 있음|
|보안에 불리|보안에 유리|
|서버 다중화에 유리|서버 다중화에 불리|

**참고 : 세션은 서버에 부담이 많이 가기 때문에 세션이 필요없는 페이지에서는 세션을 꺼주는게(?) 좋다. 세션이 시작하지 않아도 되는 jsp에서 <%@ page session="false" %> 를 작성해주면 해당 페이지에서는 세션 객체를 만들지 않는다. 이 때, 다른 페이지에서 세션 객체를 생성하고 이 페이지로 넘어와도 세션은 끊기지 않는다! '생성' 만 못하게 할 뿐!
	
</div>
</details>

## 8. 예외처리하기

<details>
<summary>spring에서의 예외처리</summary>
<div markdown="1">

<br>
	
**해당 컨트롤러에서 처리**
- 컨트롤러에서 예외가 발생했다면 1. try-catch블럭으로 예외를 잡아주거나, 
- 여러 예외가 반복된다면 2. 예외처리 메서드를 따로 만들어서 처리해주면 코드의 중복을 줄일 수 있다.
- 예외처리를 하는 메서드에는 @ExceptionHandler 어노테이션을 붙여주면 된다.
	```java
	@ExceptionHandler({NullPointerException.class,FileNotFoundException.class}) 
	//하나의 핸들러 메서드로 두 개 이상의 예외를 처리하고 싶을 땐 이렇게 배열로 써주면 된다.
	public String catcher2(Exception ex, Model model) {
		model.addAttribute("ex", ex);
		return "error";
	}
	```

**예외처리 클래스를 따로 만들어서 처리하기**
- 예외처리를 할 클래스에 @ControllerAdvice("패키지") 어노테이션을 붙여주면  지정한 패키지의 예외를 모두 여기서 처리할 수 있다. 디폴트 값은 모든 패키지이다.
- 이 클래스를 전역 예외처리 클래스 라고 한다.
- 마찬가지로 예외처리를 할 메서드에는 @ExceptionHandler 어노테이션을 붙여준다.

**참고 : 만약 예외처리 클래스를 따로 만들었는데 컨트롤러에 예외처리 메서드가 있다면, 그 컨트롤러에서 예외를 처리한다.

**@ResponseStatus**
- 응답메세지의 상태코드를 변경할 때 사용한다.
- 디폴트 값은 500번이다. (INTERNAL_SERVER_ERROR)
- @ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED), @	ResponseStatus(HttpStatus.BAD_REQUEST) 등등

**에러 페이지 꾸미기(?) - 상태 코드별 뷰 Mapping**
- 톰캣이 만들어준 에러화면이 아니라, 내가 만든 에러페이지를 뜨게 하고 싶으면?
- web.xml에서 jsp파일을 지정해주면 된다.
	 ```xml
	<!-- 에러 페이지 만들기 -->
	<error-page>
		<error-code>400</error-code>
		<location>/error400.jsp</location>
	</error-page>

	<error-page>
		<error-code>500</error-code>
		<location>/error500.jsp</location>
	</error-page>
	<!-- 에러 페이지 만들기 끝 -->
	```
- 이 때, 지정해준 jsp파일의 경로는 src - main - webapp 이 된다.

**예외처리 과정**
- 클라이언트가 요청을 보내면 DispatcherServlet이 받아서 Controller에 넘겨준다.
- Controller에서 예외가 발생하면 try-catch로 처리를 해주거나 떠넘겨야한다.
- 떠넘기게 된다면 DispatcherServlet은 handlerExceptionResolvers로 등록이 되어있는 애들을 살펴본다.
- 스프링이 제공하는 예외처리 기본전략에 의해 3개의 ExceptionResolver가 자동으로 등록되어 있다. (ExceptionHandler, ResponseStatus, DefaultHandler 이 순서대로 살펴봄)
- 즉, 예외가 발생하면 먼저 @ExceptionHandler가 붙은 메서드를 찾아서 예외처리를 시도하고, 없다면 @ResponseStatus가 붙은 메서드를 찾아서 예외처리를 시도한다.
	
</div>
</details>

## 9. 제목

<details>
<summary>제목이란?</summary>
<div markdown="1">

<br>
	
내용
	
</div>
</details>
