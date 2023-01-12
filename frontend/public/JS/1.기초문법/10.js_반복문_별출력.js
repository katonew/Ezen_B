/*
	- 출력
		콘솔 출력 : console.log( )
		알람 	: alert( )
		HTML출력 : 
			1. document.write( )
			2. document.querySelector( ).innerHTML
	- 입력
		1. 알람메시지 입력 	: prompt( )
		2. html입력		: document.querySelector( ).value
		3. 
*/
// 예시 1) 입력받은 수 만큼 * 출력
/*let output = '' //출력 변수
let s1 = Number(prompt('예시1) 별 개수'))
for(let i = 1 ; i<=s1; i++){
	// i 는 1부터 입력받은 수까지 1씩 증가반복
	output += '*';
}
console.log(output)
*/
//예시2) 입력받은 수 만큼 * 출력 [ 3줄(3배수)마다 줄바꿈)]
/*let s2 = Number(prompt('예시2) 별 개수'))
output = ''	//앞에서 사용한 변수를 초기화
for(let j = 1 ; j<=s2; j++){
// j 는 1부터 입력받은 수까지 1씩 증가반복
	output += '*';
	if(j%3==0){ output += '\n'}
}
console.log(output)
*/

// 1. 입력받은 줄수[line] 만큼 출력
/*let line1 = Number(prompt('문제1) 줄수'))
output = ''	//앞에서 사용한 변수를 초기화
for(let i = 1 ; i<=line1; i++){
	for(let k = 1 ; k<=i; k++){
		output += '*'
	}
	output += '\n'
}
console.log(output)

// 2.입력받은 줄 수 만큼 출력 역순으로
let line2 = Number(prompt('문제2) 줄수'))
output = ''	//앞에서 사용한 변수를 초기화
for(let i = 1 ; i<=line2; i++){
	for(let k = line2 ; k>=i; k--){
		output += '*'
	}
	output += '\n'
}
console.log(output)

// 3.입력받은 줄 수 만큼 출력 오른쪽정렬
let line3 = Number(prompt('문제3) 줄수'))
output = ''	//앞에서 사용한 변수를 초기화
for(let i = 1 ; i<=line3; i++){
	for(let k = line3 ; k<=line3-i; k--){
		output += ' '	
	}
	for(let j = 1 ; j<=i; j++){
		output += '*'
	}
	output += '\n'
}
console.log(output)

// 4.입력받은 줄 수 만큼 출력 오른쪽정렬 역순

let line4 = Number(prompt('문제4) 줄수'))
output = ''	//앞에서 사용한 변수를 초기화
for(let i = 1 ; i<=line4; i++){
	for(let j = 1 ; j<i; j++){
		output += ' '
	}
	for(let k = line4 ; k>=i; k--){
		output += '*'
	}

	output += '\n'
}
console.log(output)

// 5.입력받은 홀수 줄 수 만큼 출력 [피라미드 만들기]
let line5 = Number(prompt('문제5) 줄수'))
output = ''	//앞에서 사용한 변수를 초기화
for(let i = 1 ; i<=line5; i++){
	for(let k = 1 ; k<=line5-i; k++){
		output += ' '
	}
	for(let j = 1 ; j<=i*2-1; j++){
		output += '*'
	}
	output += '\n'
}
console.log(output)

// 6.입력받은 홀수 줄 수 만큼 출력 [ X 자 만들기]

let line6 = Number(prompt('문제6) 줄수'))
output = ''	//앞에서 사용한 변수를 초기화
for(let i = 1 ; i<=line6; i++){
	for(let s = 1 ; s<=line6; s++){
		if(s==i || s+i==line6+1) {output += '*';}
		else{output += ' ';}
	}
	output += '\n'
}
console.log(output)

*/
// 과제1.입력받은 홀수 줄 수 만큼 출력 [ 다이아 모양 만들기]

let output = ''
let line7 = Number(prompt('문제5) 줄수'))
for(let i = 1 ; i<=line7/2; i++){
	for(let k = 1 ; k<=line7/2-i; k++){
		output += ' '
	}
	for(let j = 1 ; j<=i*2-1; j++){
		output += '*'
	}
	output += '\n'
}
for(let i = 1 ; i<=line7/2; i++){
	for(let k = line7 ; k>line7-i+1; k--){
		output += ' '
	}
	for(let j = line7 ; j>=i*2; j--){
		output += '*'
	}
	output += '\n'
}
console.log(output)






 
 
 
 