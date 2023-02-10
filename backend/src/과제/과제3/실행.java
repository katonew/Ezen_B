package 과제.과제3;

import java.util.ArrayList;
import java.util.Scanner;


public class 실행 {
	public static void main(String[] args) { //main s
		
		Scanner scanner = new Scanner(System.in);	//입력 객체
		//ArrayList 두개 : 책들, 회원들
		ArrayList<Book> bookList = new ArrayList<>();
		ArrayList<Member> memberList = new ArrayList<>();
		//무한루프 에 로그인이라는 이름을 넣어 continue에 이용
		로그인 : while(true) {	//while 1 s
			System.out.println("회원 목록 현황");
			System.out.println("아이디\t이름\t대여중인도서목록");
			//회원들의 수만큼 반복해 출력
			for(int i=0;i<memberList.size();i++) {
				//회원들의 id와 이름 출력 / 같은줄에 대여한 책까지 출력하기 위해 print로 출력
				System.out.print(memberList.get(i).id+"\t"+ memberList.get(i).name + "\t");
				// 만약 대여한 책이 없다면 공백(한줄띄움) 출력
				if(memberList.get(i).rentList.size()==0) {
					System.out.println("");
				}else {	//대여한 책이 있다면
					for(int j=0;j<memberList.get(i).rentList.size();j++) {
						// 회원이 대여한 책의 수량만큼 반복문
						if(j==memberList.get(i).rentList.size()-1) {
							// 대여한 책순서가 마지막 순서라면 마지막에 줄바꿈 추가
							System.out.print("["+memberList.get(i).rentList.get(j).name+"]\n");
							// 대여한 책 순서가 마지막 순서가 아니라면 그냥 출력
						}else {
							System.out.print("["+memberList.get(i).rentList.get(j).name+"]");
						}//else e
					} // 대여한 책 출력 for e
				} //else e
			} // in출력 for e
			System.out.print("1.로그인 2.회원가입 : "); // 시작 출력
			int inputlogin = scanner.nextInt();	// 입력 받음
			if(inputlogin==1) {	//로그인을 눌렀을때 아이디와 비밀번호를 입력받음
				System.out.print("아이디 : "); 
				String inputid = scanner.next();
				System.out.print("비밀번호 : ");
				String inputpassword = scanner.next();
				
				for(int i=0; i<memberList.size();i++) {
					//회원의 수만큼 반복문
					if((memberList.get(i).id).equals(inputid)) { //만약 입력받은 아이디와 같은 아이디가 있다면
						if((memberList.get(i).password).equals(inputpassword)) { // 비밀번호도 같은지 확인
							System.out.println("로그인되었습니다");	//같으면 로그인 후 대여 무한루프 출력
							while(true) {	//while 2 s
								System.out.println("번호\t도서명\t도서장르\t대여여부\t대여한사람"); //기본출력
								for(int j=0;j<bookList.size();j++) { //책 리스트의 크기만큼 반복
									//책 이름,장르,대여여부,대여한사람 출력
									System.out.println( j+"\t"+
														bookList.get(j).name+"\t"+ 
														bookList.get(j).category+"\t"+
														(bookList.get(j).state?"가능":"불가능")+"\t"+
														bookList.get(j).bookingname);
								}
								System.out.print("1.도서대여 2.도서반납 3.도서등록[관리자] 4.로그아웃 : "); //기본출력
								int inputno = scanner.nextInt();
								if(inputno==1) {	//도서대여를 선택했다면
									System.out.print("대여할 도서의 번호를 입력해주세요 : ");
									int no1 = scanner.nextInt();
									//대여하려는 책이 대여중이라면 대여불가
									if(!bookList.get(no1).state) {
										System.err.println("대여불가");
										continue;
									}else {	//대여가능하다면
										//대여 불가능으로 바꿈
										bookList.get(no1).state = false;
										//책리스트의 대여한 사람에 현재 로그인되어있는 사람의 id를 입력
										bookList.get(no1).bookingname = memberList.get(i).id;
										//로그인 되어있는 사람의 대여목록에 선택한 책의 객체 대입
										memberList.get(i).rentList.add(bookList.get(no1));
										//대여했다고 출력 후 무한루프 돌아가기
										System.out.println("대여하였습니다.");
										continue;
									}
								}else if(inputno==2) {	//도서 반납을 선택했을때
									System.out.print("반납할 도서의 번호를 입력해주세요 : ");
									int no2 = scanner.nextInt();
									if(bookList.get(no2).state) { // 대여상태가 가능이라면 에러출력 후 무한루프로 돌아가기
										System.err.println("대여 되지 않은 책입니다.");
										continue;
									}else if(bookList.get(no2).bookingname!=memberList.get(i).id) { 
										// 대여되어있지만 대여한 사람의 이름이 현재 로그인 되어있는 id와 다를때 에러
										System.err.println("본인이 대여한 책이 아닙니다.");
										continue;
									}else { // 본인이 대여한게 맞을 시 
										System.out.println("반납완료");
										//대여한 사람의 이름을 공백으로 바꿈
										bookList.get(no2).bookingname = "";
										//대여상태를 가능으로 바꿈
										bookList.get(no2).state = true;
										//로그인 되어 있는 아이디의 대여목록에서 선택한 책의 객체를 지움
										memberList.get(i).rentList.remove(bookList.get(no2));
										continue;
									} //else e
								} // else if e
								else if(inputno==3){	// 도서등록을 선택했을 시
									// 도서명과 장르를 입력받음
									System.out.print("도서명 : ");	
									String bookname = scanner.next();
									System.out.print("장르 : ");	
									String category = scanner.next();
									//book 객체 선언
									Book book = new Book();
									//이름, 카레고리 입력
									book.name = bookname;
									book.category = category;
									// 등록시에는 대여가능으로 설정
									book.state = true;
									// 대여한 이름은 공백 대입
									book.bookingname = "";
									// 입력한 값들을 책목록에 추가
									bookList.add(book);
									System.out.println("책이 등록되었습니다.");
								}else if(inputno==4) { // 로그아웃을 눌렀을 시
									System.out.println("로그아웃 되었습니다.");
									// 도서목록 무한루프에서 나가 로그인 무한루프로 돌아가기
									continue 로그인;
								}else {	System.out.println("잘못입력하였습니다."); continue;	}	//그외가 입력되었을때
							} //while  2 e
						}else {System.out.println("비밀번호가 틀렸습니다.");break;}	//id는 같은게 있으나 비밀번호는 틀렸을때
					}System.out.println("일치하는 id가 없습니다.");	//일치하는 id가 없을때
				} //for e
			}else if(inputlogin==2) {	//회원가입을 눌렀을때
				//필요한 값들 입력받기
				System.out.print("아이디 : ");	
				String id = scanner.next();
				System.out.print("비밀번호 : ");	
				String password = scanner.next();
				System.out.print("이름 : ");	
				String name = scanner.next();
				System.out.print("핸드폰번호 : ");	
				String phone = scanner.next();
				// member 객체 선언
				Member member = new Member();
				//각각에 넣어주기
				member.id = id;
				member.password = password;
				member.name = name;
				member.phone = phone;
				//회원리스트에 추가
				memberList.add(member);
				System.out.println("회원가입 되었습니다.");
			}else {	System.out.println("잘못입력하였습니다."); continue;} //그외가 입력되었을때
		
			
		} //while 1 e		
	}//main e
} //class e
