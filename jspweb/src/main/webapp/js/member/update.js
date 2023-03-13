
if(memberinfo==null){
	alert('로그인 되지 않았습니다.')
	location.href="/jspweb/member/login.jsp";
}

document.querySelector('.mid').innerHTML = memberinfo.mid
document.querySelector('.memail').innerHTML = memberinfo.memail
document.querySelector('.mimg').src = `/jspweb/member/pimg/${memberinfo.mimg==null? 'default.webp' : memberinfo.mimg }`


function setupdate(){
	console.log('setupdate 눌림')
	// 2. 첨부파일 있을때
	let updateForm = document.querySelectorAll('.updateForm')[0];
	let updateFormData = new FormData(updateForm);
	// 3. 폼에 데이터 추가
		// 1. 체크여부 확인
	let defaultimg = document.querySelector('.defaultimg').checked
	console.log("defaultimg : "+defaultimg)
	updateFormData.set("defaultimg" , defaultimg)
	$.ajax({
		url : "/jspweb/member",
		method : "put",
		data : updateFormData,
		contentType : false,
		processData : false,
		success : (r)=>{
			console.log('통신')
			console.log(r)
			if(r=='true'){
				alert('회원정보 수정 완료 : 다시 로그인 하십시오')
				location.href="/jspweb/member/logout.jsp";
			}else{
				alert('회원정보 수정 실패')
			}
		}
	})
	
}


/*
	//1. 첨부파일 없을때
	let info = {
			mpwd : document.querySelector('.mpwd').value,
			newmpwd : document.querySelector('.newmpwd').value,
			memail : document.querySelector('.memail').value
		}
	console.log(info);
	$.ajax({
		url : "/jspweb/member",
		method : "put",
		data : info,
		success : (r)=>{
			console.log('통신')
			console.log(r)
		}
	})



 */