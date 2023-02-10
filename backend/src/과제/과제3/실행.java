package 과제.과제3;

import java.util.ArrayList;
import java.util.Scanner;


public class 실행 {
	public static void main(String[] args) { //main s
		
		Scanner scanner = new Scanner(System.in);
		ArrayList<Book> bookList = new ArrayList<>();
		ArrayList<Member> memberList = new ArrayList<>();
		
		로그인 : while(true) {	//while 1 s
			System.out.println("회원 목록 현황");
			System.out.println("아이디\t이름\t대여중인도서목록");
			for(int i=0;i<memberList.size();i++) {
				System.out.print(memberList.get(i).id+"\t"+ memberList.get(i).name + "\t");
				if(memberList.get(i).rentList.size()==0) {
					System.out.println("");
				}else {
					for(int j=0;j<memberList.get(i).rentList.size();j++) {
						if(j==memberList.get(i).rentList.size()-1) {
							System.out.print("["+memberList.get(i).rentList.get(j).name+"]\n");
						}else {
							System.out.print("["+memberList.get(i).rentList.get(j).name+"]");
						}
					}
				}
				
			}
			System.out.print("1.로그인 2.회원가입 : "); 
			int inputlogin = scanner.nextInt();
			if(inputlogin==1) {
				System.out.print("아이디 : "); 
				String inputid = scanner.next();
				System.out.print("비밀번호 : ");
				String inputpassword = scanner.next();
				for(int i=0; i<memberList.size();i++) {
					if((memberList.get(i).id).equals(inputid)) {
						if((memberList.get(i).password).equals(inputpassword)) {
							System.out.println("로그인되었습니다");
							while(true) {	//while 2 s
								System.out.println("번호\t도서명\t도서장르\t대여여부\t대여한사람");
								for(int j=0;j<bookList.size();j++) {
									System.out.println( j+"\t"+
														bookList.get(j).name+"\t"+ 
														bookList.get(j).category+"\t"+
														(bookList.get(j).state?"가능":"불가능")+"\t"+
														bookList.get(j).bookingname);
								}
								System.out.print("1.도서대여 2.도서반납 3.도서등록[관리자] 4.로그아웃 : "); 
								int inputno = scanner.nextInt();
								if(inputno==1) {
									System.out.print("대여할 도서의 번호를 입력해주세요 : ");
									int no1 = scanner.nextInt();
									if(!bookList.get(no1).state) {
										System.err.println("대여불가");
										continue;
									}else {
										bookList.get(no1).state = false;
										bookList.get(no1).bookingname = memberList.get(i).id;
										memberList.get(i).rentList.add(bookList.get(no1));
										System.out.println("대여하였습니다.");
										continue;
									}
								}else if(inputno==2) {
									System.out.print("반납할 도서의 번호를 입력해주세요 : ");
									int no2 = scanner.nextInt();
									if(bookList.get(no2).state) {
										System.err.println("반납불가");
										continue;
									}else {
										System.out.println("반납완료");
										bookList.get(no2).bookingname = "";
										bookList.get(no2).state = true;
										memberList.get(i).rentList.remove(bookList.get(no2).name);
										continue;
									}
								}
								else if(inputno==3){
									System.out.print("도서명 : ");	
									String bookname = scanner.next();
									System.out.print("장르 : ");	
									String category = scanner.next();
									
									Book Book = new Book();
									Book.name = bookname;
									Book.category = category;
									Book.state = true;
									Book.bookingname = "";
									bookList.add(Book);
									System.out.println("책이 등록되었습니다.");
								}else if(inputno==4) {
									System.out.println("로그아웃 되었습니다.");
									continue 로그인;
								}
								else {	System.out.println("잘못입력하였습니다."); continue;	}
							} //while  2 e
						}else {System.out.println("비밀번호가 틀렸습니다.");break;}
					}
					System.out.println("일치하는 id가 없습니다.");
				} //for e
			}else if(inputlogin==2) {
				System.out.print("아이디 : ");	
				String id = scanner.next();
				System.out.print("비밀번호 : ");	
				String password = scanner.next();
				System.out.print("이름 : ");	
				String name = scanner.next();
				System.out.print("핸드폰번호 : ");	
				String phone = scanner.next();
				
				Member member = new Member();
				member.id = id;
				member.password = password;
				member.name = name;
				member.phone = phone;
				memberList.add(member);
				System.out.println("회원가입 되었습니다.");
			}else {	System.out.println("잘못입력하였습니다."); continue;}
		
			
		} //while 1 e		
	}//main e
} //class e
