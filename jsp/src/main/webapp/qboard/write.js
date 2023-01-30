let 문의사항 = []

function qna_write(){
	let qboard={
		qtitle : document.querySelector('.qtitle').value,
		qcontent: document.querySelector('.qcontent').value,
		qwriter : document.querySelector('.qwriter').value,
		qpassword : document.querySelector('.qpassword').value
	}
	let writeform = document.querySelector('.writeform');
	let formdata = new FormData(writeform)
	
	문의사항.push(qboard)
	console.log(문의사항)
	console.log(formdata)
	let result = false;
	if(result) {location.href = 'list.html';}
	else{}
}

