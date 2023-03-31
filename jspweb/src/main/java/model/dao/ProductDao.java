package model.dao;


import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import model.dto.ChatDto;
import model.dto.ProductDto;

public class ProductDao extends Dao{
	
	// 싱글톤
	private static ProductDao dao = new ProductDao();
	private ProductDao() {}
	public static ProductDao getInstance() {return dao;}
	
	// 상품 등록 함수
	public synchronized boolean onwrite(ProductDto dto) {
		// 제품 등록 [ synchronized 사용시(서블릿) 해당 메소드 동시사용불가 await ] 
		String sql = "insert into product(pname,pcomment,pprice,plat,plng,mno) values(?,?,?,?,?,?)";
		try {
			ps = con.prepareStatement( sql, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, dto.getPname());
			ps.setString(2, dto.getPcomment());
			ps.setInt(3, dto.getPprice());
			ps.setString(4, dto.getPlat());
			ps.setString(5, dto.getPlng());
			ps.setInt(6, dto.getMno());
			int count = ps.executeUpdate();
			if(count==1) {
				//insert 후 생성된 제품 PK번호 가져오기
				rs = ps.getGeneratedKeys();
				if(rs.next()) { // 만약에 생성된 제품 PK 번호가 존재하면
					for(String pimgname :  dto.getPimgList()) {
						// dto 내 첨부파일명 반복문 돌려서 하나씩 insert 하기
						sql = "insert into pimg(pimgname,pno) values (?,?)";
						ps = con.prepareStatement(sql);
						ps.setString(1, pimgname);
						ps.setInt(2, rs.getInt(1));
						ps.executeUpdate();
					} // for e
				} // if e
				return true;
			} // if e
		} catch (Exception e) {
			System.out.println("상품등록 오류 : " + e);
		}
		return false;
	}
	
	public synchronized ArrayList<ProductDto> getlist(String 동,String 서,String 남,String 북){
		ArrayList<ProductDto> list = new ArrayList<>();
		String sql ="select p.*,m.mid,m.mimg from product p natural join member m  "
				+ "where ? >= plng and ? <= plng and ? <= plat and ? >= plat ";
		try {
			ps = con.prepareStatement(sql);
			ps.setString( 1 , 동 );	
			ps.setString( 2 , 서 );	
			ps.setString( 3 , 남 );	
			ps.setString( 4 , 북 );
			rs = ps.executeQuery();
			while(rs.next()) {
				// 이미지 리스트 가져오기
				ArrayList<String> pimglist = new ArrayList<>();
				sql = "select *from pimg where pno = " + rs.getInt(1);
				ps = con.prepareStatement(sql);
				ResultSet rs2 = ps.executeQuery();
				while(rs2.next()) {
					// 검색된 이미지의 파일 이름만 담기
					pimglist.add(rs2.getString(2));
				}
				
				ProductDto dto = new ProductDto(
						rs.getInt(1), rs.getString(2), rs.getString(3),
						rs.getInt(4), rs.getInt(5), rs.getString(6), 
						rs.getString(7), rs.getInt(8), rs.getString(9),
						rs.getInt(10), rs.getString(11), rs.getString(12), pimglist);
				list.add(dto);
			}
		} catch (Exception e) {
			System.out.println("상품가져오기 오류 : " + e);
		}
		return list;
	}
	
	// 찜하기 등록/ 취소 
	public synchronized int setplike(int pno,int mno) {
		
		// 1. 찜 등록인지 취소인지 확인
		String sql = "select *from plike where pno = ? and mno =?";
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, pno);
			ps.setInt(2, mno);
			rs = ps.executeQuery();
			if(rs.next()) { // 검색 내용이 있으면 해당 멤버가 이미 찜하기를 했으므로 취소
				sql = "delete from plike where pno = ? and mno =?";
				ps = con.prepareStatement(sql);
				ps.setInt(1, pno);
				ps.setInt(2, mno);
				int count = ps.executeUpdate();
				if(count==1) {return 1;}
			}else { // 찜 안한것이므로 등록
				sql = "insert into plike (pno,mno) values (?,?)";
				ps = con.prepareStatement(sql);
				ps.setInt(1, pno);
				ps.setInt(2, mno);
				int count = ps.executeUpdate();
				if(count==1) {return 2;}
			}
		} catch (Exception e) {
			System.out.println("setplike 오류" + e);
		}
		return 3;
		
	} // setplike e
	
	// 4. 해당 회원이 해당 제품 찜하기 상태인지 확인
	public synchronized boolean getplike(int pno, int mno) {
		String sql = "select *from plike where pno = ? and mno =?";
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, pno);
			ps.setInt(2, mno);
			rs = ps.executeQuery();
			if(rs.next()) {return true;}
		} catch (Exception e) {System.out.println("getplikec 오류" + e);}
		return false;
	} // getplike e
	
	// 5. 제품에 채팅 등록
	public synchronized boolean setChat(ChatDto dto) {
		String sql = "insert into note(ncontent,pno,frommno,tomno) values (?,?,?,?)";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, dto.getNcontent());
			ps.setInt(2, dto.getPno());
			ps.setInt(3, dto.getFrommno());
			ps.setInt(4, dto.getTomno());
			int count = ps.executeUpdate();
			if(count==1) {return true;}
		} catch (Exception e) {	System.out.println("setChat 오류" + e);	}
		return false;
	} // setChat e
	
	// 6. 제품에 등록 채팅 [ 1.채팅목록출력[js.9번함수] 2.채팅방 내 대화출력 [js.10번함수 ] ]
	public synchronized ArrayList<ChatDto> getChatList(int pno , int mno, int chatmno){
		ArrayList<ChatDto> list = new ArrayList<>();
		String sql = "";
		if(chatmno != 0) {
			sql = "select * from note where pno = ? and ((frommno = ? and tomno = ?) or (frommno = ? and tomno = ?))";
		}else {
			sql = "select * from note where pno = ? and (frommno = ? or tomno = ?)";
		}
		
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, pno);
			ps.setInt(2, mno);
			ps.setInt(3, chatmno);
			if(chatmno != 0) {
				ps.setInt(1, pno);
				ps.setInt(2, mno);
				ps.setInt(3, chatmno);
				ps.setInt(4, chatmno);
				ps.setInt(5, mno);
			}else {
				ps.setInt(1, pno);
				ps.setInt(2, mno);
				ps.setInt(3, mno);
			}
			rs = ps.executeQuery();
			while(rs.next()) {
				ChatDto dto = new ChatDto(rs.getInt(1), rs.getString(2), rs.getString(3),
						rs.getInt(4), rs.getInt(5), rs.getInt(6));
				
				// 보낸 회원의 정보를 호출
				sql = "select mid,mimg from member where mno = "+ rs.getInt(5); //rs.getInt(5) ==> frommno
				ps = con.prepareStatement(sql);
				ResultSet rs2 = ps.executeQuery();
				if(rs2.next()) {
					dto.setFrommid(rs2.getString(1));
					dto.setFrommimg(rs2.getString(2));
				}
				list.add(dto);
			}
		} catch (Exception e)  {	System.out.println("getChatList 오류" + e);	}
		return list;
	} // getChatList e
	
	// 7. 날짜별 포인트 충전 내역
	public HashMap<String, Integer> getSumPoint(){
		//ArrayList<String> list; ==> String 타입만 저장
		//HashMap<String, Integer> map ==> String 타입의 키와 Integer 타입의 데이터 저장 가능
		HashMap<String, Integer> map = new HashMap<>();
		String sql = "select sum(if(mpamount>100,mpamount,0)) as 충전된포인트, "
				+ "date_format(mpdate, '%Y%m%d') as 충전날짜  "
				+ "from mpoint group by date_format(mpdate, '%Y%m%d') "
				+ " order by 충전날짜 desc limit 5 ";
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				map.put(rs.getString(2), rs.getInt(1));
			}
		} catch (Exception e) {System.out.println("getSumPoint 오류" + e);}
		return map;
	}
	
	
}


/*
	// 1. 해당 타입의 객체를 여러개 저장할 수 있는 객체 선언
	AraayList<타입> list = new AraayList<>;
	
	
	// 2. 해당 키타입과 데이터 타입에 해당하는 키와 데이터를 여러개 저장 할 수 있는 맵 객체 선언
	HashMap<키타입,데이터타입> map = new HashMap<>;
		데이터 : '유재석=30' , '강호동=10' , '신동엽=90' => 타입 2개
		{'유재석=30' , '강호동=10' , '신동엽=90'}
	
	
	
	
	// JSON = JS 객체
	
	
	
*/
















