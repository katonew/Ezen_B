//1.userbox,logbox,monbox DOM객체 가져오기
let userbox = document.querySelector('.userbox')
let logbox = document.querySelector('.logbox')
let logbox2 = document.querySelector('.logbox2')
let monbox = null;
// userbox[기본] 위치
let u_left = 10;	//유저의 처음 위치
let m_left = 0;
let user_hp = 100;	//캐릭터의 처음 체력
let mob_hp = 0;	//몬스터의 처음 체력
let full_mobhp = 0;
let mob_exp = 0;
// 몬스터 배열 생성
let user = {
	img: 'mario1.png',
	left:10,
	exp: 0,
	level: 1,
	power: 20,
	state: true
}

let mobList = [
	{ m_img : 'mob.gif' , hp : 100, left : 910, exp : 50, size : 50},
	{ m_img : 'mob2.gif' , hp : 500, left : 910, exp : 150, size : 60},
	{ m_img : 'mob3.gif' , hp : 1000, left : 910, exp : 300, size : 70},
]
//js 열릴때 시작할 함수
mobPrint(user.level-1)	// 첫 몬스터 출력함수
userinfo()				// 유저 정보 출력함수

//2. 이동 이벤트
document.addEventListener('keydown' , (e)=>{
	let key = e.keyCode;	//입력된 키 코드를 변수에 저장
	if(key==83){	//s키 입력되었을때
		user.state = !(user.state)
		if(user.state==false){
			document.querySelector('.textbox').innerHTML =`방어태세로 전환합니다.`
		}else{document.querySelector('.textbox').innerHTML =`공격태세로 전환합니다.`}
		userinfo()
	}
	else if(key==37){ //왼쪽키 입력되었을때
		u_left -= 10;
		u_left = u_left < 0 ? u_left=0 : u_left ;	//만약 차감된 왼쪽 좌표가 0보다 작으면 0으로 고정, 아니면 전진
		userbox.style.backgroundImage = `url(img/mario3.png)`
		userbox.style.backgroundSize = `120%`;
	}else if(key==39){ //오른쪽키 입력 되었을 때
		u_left += 10;
		u_left = u_left>910 ? 910 : u_left 
		userbox.style.backgroundImage = `url(img/mario2.png)`	//이동모션이미지
		userbox.style.backgroundSize = `110%`;
	}else if(key==65){	//a키가 입력되었을때 -> 공격
		if(user.state==false){
			document.querySelector('.textbox').innerHTML =`방어태세일때는 공격할 수 없습니다.`
		}else{
			userbox.style.backgroundImage = `url(img/mario7.png)`	//공격모션이미지
			userbox.style.backgroundSize = `110%`;
			//a키 눌렀을때 몬스터가 타격사거리 안에 있으면 몬스터의 HP 감소
			if((m_left-u_left)<100&&(u_left-m_left)<30){
				mob_hp -= user.power;
				document.querySelector('.textbox').innerHTML =`데미지 ${user.power}을 주었습니다.`
				if(mob_hp<=0){
					document.querySelector('.textbox').innerHTML ='다음 레벨로 갑니다'
					user.exp += mob_exp
					//유저의 경험치가 100을 넘는다면 레벨업하고 경험치는 -100한 후 출력
					if(user.exp>user.level*100){
						user.exp= user.exp-user.level*100;
						user.level++
						user.power = user.level*20;
						user_hp = 100;
					}
					//몬스터리스트의 길이만큼 곱하여 리스트 수중 하나의 수가 나올 수 있게 랜덤한 수 생성
					let rand = parseInt(Math.random()*mobList.length)
					//랜덤으로 몬스터 생성
					mobPrint(rand);
					//유저정보 업데이트
					userinfo()
				}
			}
		
			document.querySelector('.mobHP').style.width = (mob_hp/full_mobhp)*100 +'%'
		}
		//*
	}
	userbox.style.left = `${u_left}px`	/* 키 입력후에 css : left 변경 */
})

//2. 문서 안에서 키 떼었을때 이벤트
document.addEventListener('keydown' , (e)=>{
	let key = e.keyCode;	//입력된 키 코드를 변수에 저장
	if(user.state==false){
		userbox.style.backgroundImage = `url(img/mario4.png)`
	}else if(key!=83&&key!=37&&key!=39&&key!=65){
		userbox.style.backgroundImage = `url(img/mario1.png)`
		userbox.style.backgroundSize = `100%`;
	}
})

// 3. 몬스터 이동 난수 [ 랜덤 -> 1초마다 이동]
// 특정시간마다 함수 실행 : setInterval( ()=>{} , 밀리초(1000/1초))
setInterval( mon_moving , 1000)

//방어태세 전환 시 0.1초마다 확인하여 출력 이미지 교체
/*
setInterval( ()=>{
	if(user.state==false){userbox.style.backgroundImage = `url(img/mario4.png)`
	}else{userbox.style.backgroundImage = `url(img/mario1.png)`}
} , 1000)*/

// 3. 몬스터 이동 함수 [ 랜덤 -> 1초마다 이동]
function mon_moving(){
	//1.난수 +-10
	let rand = parseInt(Math.random()*50+1); //1과 50 사이의 실수	//이동거리
	let rand2 = parseInt(Math.random()*2);	//0또는1				//이동방향
	// 랜덤으로 이동방향을 설정
	if(rand2==1){m_left += rand;}
	else{m_left -= rand;}
	//2. 화면 밖으로 나갈 수 없게
	if(m_left < 0) m_left=0;
	else if(m_left > 910){ m_left=910;}
	//3. 움직임을 화면에 출력
	monbox.style.left = `${m_left}px`
	//몬스터가 움직일때 유저의 캐릭터가 가까우면 캐릭터의 hp 감소
	if((m_left-u_left)<80&&(u_left-m_left)<40){
		if(user.state==false){
		document.querySelector('.textbox').innerHTML ='공격을 방어하였습니다.'
		} //if안의 if end
		else{
			user_hp -= 10;
			document.querySelector('.textbox').innerHTML ='데미지 10을 받았습니다.'
			document.querySelector('.userHP').style.width = user_hp+'%'
			//유저의 체령기 0보다 작다면 게임오버 모든 박스들 삭제
			if(user_hp<=0){
				document.querySelector('.userbox').style.display ='none'
				document.querySelector('.userHP').style.display = 'none'
				document.querySelector('.monsterbox').style.display ='none'
				document.querySelector('.mobHP').style.display = 'none'
				document.querySelector('.textbox').innerHTML ='GAME OVER'
			} // if안의 else안의 if e
		} //if 안의 else e
	}//if e
}//몬스터 움직임 함수 e


//몬스터 출력함수
function mobPrint(i){
	//몬스터가 출력될때 몬스터 배역에 있는 객체의 속성들을 가져와 출력
	let html = `<div class="monbox" 
				style="background-image: url('img/${mobList[i].m_img}'); 
				left: ${mobList[i].left}px; 
				background-size: ${mobList[i].size}%;">
				</div>`
	document.querySelector('.monsterbox').innerHTML = html;
	monbox = document.querySelector('.monbox')
	
	m_left = Number(mobList[i].left)
	//위의 체력바를 퍼센테이지로 만들기 위해 기초체력과 타격시 적어질 체력 둘다 입력
	mob_hp = Number(mobList[i].hp)
	full_mobhp = Number(mobList[i].hp)
	// 몬스터를 처치 할 시 유저에게 주어질 경험치
	mob_exp = mobList[i].exp
	return ;
}


//유저 정보 출력함수 
function userinfo(){
	document.querySelector('.userinfo').innerHTML = `레벨 : ${user.level} / 파워 : ${user.power} / 경험치 : ${user.exp} / 태세 : ${user.state ? `공격모드` : `방어모드`}`
}






/*
	함수 형태
		1. 일반함수 : function 함수명(){ }
		2. 익명함수 : function(){ }
		3. 람다식함수 : ()=>{ }
		4. 변수함수 : let 변수명 = () => {  }
	Math.random()
		Math.random() 		: 0~1 사이의 실수
		Math.random()*10 	: 0~10 사이의 실수	
		Math.random()*10+1	: 1~10 사이의 실수
 */
























