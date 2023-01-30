
console.log('js 실행')


let qnalist = [
	{no:1 , title: '가나다', writer : '유재석', date: '23-01-30', click: '124', state : true, compliteTime: ''},
	{no:2 , title: '라마바', writer : '박명수', date: '23-01-29', click: '154', state : true, compliteTime: ''},
	{no:3 , title: '사아자', writer : '하하', date: '23-01-28', click: '412', state : false, compliteTime: ''},
	{no:4 , title: '차카타', writer : '정형돈', date: '23-01-27', click: '124', state : false, compliteTime: ''},
	{no:5 , title: 'abc', writer : '정준하', date: '23-01-26', click: '765', state : false, compliteTime: ''}
]

listPrint()


function listPrint(){
	let html = ''
	for(let i=0; i<qnalist.length;i++){
		html += `<tr>
					<td>${qnalist[i].no}</td>
					<td><a href="view.html">${qnalist[i].title}</a></td>
					<td>${qnalist[i].writer}</td>
					<td>${qnalist[i].date}</td>
					<td>${qnalist[i].click}</td>
					<td>${
						qnalist[i].state?
						`접수`:`완료`}</td>
					<td>${qnalist[i].compliteTime}</td>
				</tr>`
	}
	document.querySelector('.listbox').innerHTML = html
}


function serch(){
	let serch = document.querySelector('.serch').value
	console.log('검색값 : ' + serch)
}