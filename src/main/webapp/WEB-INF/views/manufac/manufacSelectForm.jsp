<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	request.setCharacterEncoding("UTF-8");
%>
<c:set var="contextPath" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<!-- 합쳐지고 최소화된 최신 자바스크립트 -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<!-- 우편주소 받는거 -->
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script src="/resources/js/addressapi.js"></script>
<script>
	function execPostCode() {
		new daum.Postcode({
			oncomplete : function(data) {
				// 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

				// 도로명 주소의 노출 규칙에 따라 주소를 조합한다.
				// 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
				var fullRoadAddr = data.roadAddress; // 도로명 주소 변수
				var extraRoadAddr = ''; // 도로명 조합형 주소 변수

				// 법정동명이 있을 경우 추가한다. (법정리는 제외)
				// 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
				if (data.bname !== '' && /[동|로|가]$/g.test(data.bname)) {
					extraRoadAddr += data.bname;
				}
				// 건물명이 있고, 공동주택일 경우 추가한다.
				if (data.buildingName !== '' && data.apartment === 'Y') {
					extraRoadAddr += (extraRoadAddr !== '' ? ', '
							+ data.buildingName : data.buildingName);
				}
				// 도로명, 지번 조합형 주소가 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
				if (extraRoadAddr !== '') {
					extraRoadAddr = ' (' + extraRoadAddr + ')';
				}
				// 도로명, 지번 주소의 유무에 따라 해당 조합형 주소를 추가한다.
				if (fullRoadAddr !== '') {
					fullRoadAddr += extraRoadAddr;
				}

				// 우편번호와 주소 정보를 해당 필드에 넣는다.
				console.log(data.zonecode);
				console.log(fullRoadAddr);

				document.getElementById('manuAddr').value = fullRoadAddr;

				/* document.getElementById('signUpUserPostNo').value = data.zonecode; //5자리 새우편번호 사용
				document.getElementById('signUpUserCompanyAddress').value = fullRoadAddr;
				document.getElementById('signUpUserCompanyAddressDetail').value = data.jibunAddress; */
			}
		}).open();
	}
</script>
<head>
<style>
.container {
	margin: 0 auto;
	background-color: #f2f2f2;
	border: 1px solid lightgrey;
	border-radius: 3px;
}

input[type=text] {
	width: 100%;
	margin-bottom: 20px;
	padding: 12px;
	border: 1px solid #ccc;
	border-radius: 3px;
}

label {
	margin-bottom: 10px;
	display: block;
}

.icon-container {
	margin-bottom: 20px;
	padding: 7px 0;
	font-size: 24px;
}

.btn {
	background-color: #4CAF50;
	color: white;
	padding: 12px;
	margin: 10px 0;
	border: none;
	width: 100%;
	border-radius: 3px;
	cursor: pointer;
	font-size: 17px;
}

#use1 {
	width: 250px;
	height: 20px;
	line-height: 3px;
	background : grey;
}

span.price {
	float: right;
	color: grey;
}

#btnSignup {
	width: 120px;
	height: 50px;
	margin: 0 auto;
}

#btnCancel {
	width: 120px;
	height: 50px;
	margin: 0 auto;
}

body>div>div>div>form>div>div:nth-child(2)>textarea {
	margin-left: 5px;
	padding-left: 10px;
}

body>div>form>div>input[type=text] {
	width: 300px;
}

body>div>form>div>div>div>input[type=text] {
	width: 500px;
}

body > div > form > div:nth-child(2) > button{
	width : 100px;
	height : 30px;
	line-height : 5px; 
	background : #acd3e6;
}

}
</style>
<meta charset="UTF-8">
<title>제조업체 수정창</title>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
</head>
<body>
	<div class="container"
		style=" margin: 0 auto; padding-left: 30px; width: 50%; height: 1200px; margin-bottom:200px; ">
		<form method="post" action="${contextPath}/manufac/updatemanufac.do"
			enctype="multipart/form-data">

			<div style="width: 45%; float: left; padding-left: 20px; ">
				<h3>제조업체 수정창</h3>
				<label for="fname"><i class="fa fa-user"></i> 아이디</label>
				<input type="text" name="id" value="${manufacVO.id}" readonly><br>
				
				<label for="fname"><i class="fa fa-user"></i> 사업자 번호</label>
				<input type="text" name="manuBizNo" value="${manufacVO.manuBizNo}"><br>
					
				<label for="adr"><i class="fa fa-address-card-o"></i> 대표 이름</label>
				<input type="text" name="manuCeoName" value="${manufacVO.manuCeoName}"><br> 
				
				<label for="adr"><i class="fa fa-address-card-o"></i> 회사 이름</label>
				<input type="text" name="manuName" value="${manufacVO.manuName}"><br>
				
				<label	for="email"><i class="fa fa-envelope"></i> 이메일</label>
				<input type="text" name="manuEmail" value="${manufacVO.manuEmail}"><br>
				
				<label	for="email"><i class="fa fa-envelope"></i>업종</label>
				<input type="text" name="manuBizType" value="${manufacVO.manuBizType}" readonly><br>
				

				<div class="row">
					<div class="col-50">
						<img src="${contextPath}/download.do?id=${manufacVO.id}&imageFileName=${manufacVO.manuImg}" id="preview" style="height:220px; width:150px;"/><br>
						<input type="button" class="btn btn-warning" id="use1" onClick="enable();" value="사진을 수정하려면 누르세요"><br>
					    <input type="file" name="manuImg" id="i_manuImg" onchange="readURL(this);" disabled/>
					</div>
				</div>
			</div>

			<div style="width: 45%; float: left; padding-left: 20px;">
				<h3>         　</h3>
				<label for="cname">비밀번호</label>
				<input type="text" name="pwd" placeholder="새로운 비밀번호 입력"><br> <label for="ccnum">전화번호</label>
				<input type="text" name="manuTel" value="${manufacVO.manuTel}"><br>

				<label for="expyear">업종</label>
				<input type="text"	name="manuBizType" value="${manufacVO.manuBizType}"><br>
				
				<label for="cvv">경력</label>
				<input type="text" name="manuStart"	value="${manufacVO.manuStart}"><br>
				
				<button type="button" class="btn btn-default" onclick="execPostCode();"><i class="fa fa-search"></i> 주소검색</button>                   
				<input class="form-control"  placeholder="${manufacVO.manuAddr}" value="${manufacVO.manuAddr}" name="manuAddr" id="manuAddr" type="text" readonly="readonly" ><br>
    		
				<label for="cname">상세주소</label>
				<input class="form-control"  value="${manufacVO.manuDetailAddr}" name="manuDetailAddr" id="manuDetailAddr" type="text" value="상세주소"/>
				
				

    
				<label for="cname">상세정보</label>
				<textarea cols=45px; rows=2px; name="manuDetail">${manufacVO.manuDetail}</textarea><br>
				
				<input type="hidden" name="manuAuth" value="o">
				
				<label for="email"><b>최소 발주 금액</b></label>
    			<input type="range" min="100" step="10" max="1000" value="50" class="slider" name="productPrice" id="myRange">
    			<p> <span id="demo"></span>만원</p>
			  	<script>
				  	var slider = document.getElementById("myRange");
				  	var output = document.getElementById("demo");
				  	output.innerHTML = slider.value;
					
				  	slider.oninput = function() {
				  	  output.innerHTML = this.value;
				  	 
				  	var price = parseInt(productPrice);
				  	}
			  	</script>
				
			</div>
			<div style="width: 30%; padding-left=20px;"> 
				<button type="submit" class="btn btn-sm btn-primary" id="btnSignup">수정완료</button>
				<button type="button" class="btn btn-sm btn-primary" id="btnCancel" onclick="history.go(-1);">취소</button>
				<input type="button" value="탈퇴" onclick="delete_button();" class="btn btn-danger btn-xs">
			</div>
		</form>
	</div>
<script type="text/javascript">
function delete_button(){

if (confirm("정말 삭제하시겠습니까??") == true){    //확인

    location.href="${contextPath}/manufac/deletemanufac.do?id=${manufacVO.id}";

}else{   //취소

    return;

}
}
</script>	
	
<script type="text/javascript">
  
	function readURL(input){
		if(input.files && input.files[0]){
			var reader = new FileReader();
			reader.onload=function(e){
				$('#preview').attr('src', e.target.result);
			}
			reader.readAsDataURL(input.files[0]);
		}
	}

	function enable(){
		var enable2 = document.getElementById('i_manuImg');
		enable2.disabled=false;
	}
</script>    


</body>
</html>