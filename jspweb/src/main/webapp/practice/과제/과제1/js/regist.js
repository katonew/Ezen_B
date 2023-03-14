console.log( 'regist 열림');


// 첨부파일 이미지 미리보기
function preimg(e){
	
	let file = new FileReader();
	
	file.readAsDataURL ( e.files[0] )
	file.onload = ( e )=>{
		document.querySelector('.preview').src = e.target.result;
	}
	
}


// 3. select 유효성 검사
function select_check(){
	
	let count = 0;
	
	let part = document.querySelector('.part').value;
	let jobgrade = document.querySelector('.jobgrade').value;
	let type = document.querySelector('.type').value;
	
	if( part != '' ){ count++; }
	if( jobgrade != '' ){ count++; }
	if( type != '' ){ count++ ;}
	
	if( count == 3 ){ return true }
	
}


// 2. 사원명 유효성 검사 [ 한글,영어대소문자만 입력가능 ]
function name_check(){
	console.log('name_check 실행');
	
	let name = document.querySelector('.name').value
	let namej = /^[a-zA-Z가-힣]{2,10}$/
	
	console.log( namej.test( name ) );
	
	if( namej.test( name ) ){
		document.querySelector('.notice').innerHTML = '사용 가능합니다.'
		return true;
	}else{
		document.querySelector('.notice').innerHTML = '한글,영대소문자 2 ~ 10 글자만 입력 가능합니다.'
		return false;
	}
		
}

// 1. 인사등록
function regist(){
	
	console.log('regist() 함수실행')

	if( name_check() && select_check() ){
		// 폼 가져오기
		let reg_form = document.querySelectorAll('.reg_form')[0];
		// form 안에 있는 data 객체 호출
		let reg_formData = new FormData( reg_form );
		
		$.ajax({
			url : "/jspweb/regist",
			method : "post",
			data : reg_formData,
			contentType : false,
			processData : false,
			success : ( r ) => {
				console.log('regist 통신'); console.log( r );	
				alert('등록완료');
				print(0);
				document.querySelector('.name').value = '';
				document.querySelector('.part').value = '';
				document.querySelector('.jobgrade').value = '';
				document.querySelector('.type').value = '';
				document.querySelector('.preview').value = '';
				document.querySelector('.img').value = '';
				document.querySelector('.notice').innerHTML = "";
				
			}
		})
	}else{
		alert('정상적으로 입력되지 않은 데이터가 있습니다. 다시한번 확인바랍니다.')
	}	
}

part_select();
// 2. 부서목록 가져오기 및 select box 에 표시
function part_select(){
	
	$.ajax({
		url : "/jspweb/regist",
		method : "get",
		success : ( r ) => {
			console.log('part_select ajax'); console.log( r );
			
			let html = `<option value=""> 부서를 선택하세요 </option>`;
			
			r.forEach( (o,i) =>{
				
				html +=  `<option> ${ o.partname } </option>`
				
			}) // forEach end
			
			document.querySelector('.part').innerHTML = html;
	
		} // success end 
	})	// ajax end 
}// function end 


								
		



