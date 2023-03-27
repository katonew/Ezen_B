package controller.product;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import model.dao.MemberDao;
import model.dao.ProductDao;
import model.dto.ProductDto;


@WebServlet("/product/info")
public class Pinfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public Pinfo() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		String 동 = request.getParameter("동");
		String 서 = request.getParameter("서");
		String 남 = request.getParameter("남");
		String 북 = request.getParameter("북");
		
		
		ArrayList<ProductDto> result =  ProductDao.getInstance().getlist(동,서,남,북);
		
		ObjectMapper mapper = new ObjectMapper();

		String json= mapper.writeValueAsString(result);

		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		response.getWriter().print(json);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// ---commons.jar 사용시
		request.setCharacterEncoding("UTF-8");
		// 1. 다운로드 할 서버 경로
		String 저장경로 = request.getSession().getServletContext().getRealPath("/product/pimg");
		// 2. 해당 경로의 파일 / 폴더 객체화 [ setRepository에 대입하기 위해 형변환]
		File 저장경로객체 = new File(저장경로);
		
		// 3. 업로드할 저장소 객체 생성
		DiskFileItemFactory 파일저장소 = new DiskFileItemFactory();
		파일저장소.setRepository(저장경로객체);			// 파일 저장소 위치 대입
		파일저장소.setSizeThreshold(1024*1024*10);	// 파일 저장소에 저장할 수 있는 최대용량
		파일저장소.setDefaultCharset("UTF-8");		// 파일 저장소 한글 인코딩 타입
		
		// 4. 파일 업로드 객체
		ServletFileUpload 파일업로드객체 = new ServletFileUpload(파일저장소);
		
		
		try {
			// 5.  매개변수 요청하여 리스트에 담기 [ 무조건 예외처리 발생 ]
			List<FileItem> 파일아이템목록 =  파일업로드객체.parseRequest(request);
			List<String> 일반필드목록 = new ArrayList<>();
			List<String> 파일필드목록 = new ArrayList<>();
			// 6. 
			for(FileItem item : 파일아이템목록) { // 요청 된 모든 매개변수들을 반복문 돌려서 확인
				if(item.isFormField()) { // . isFormField() : 첨부파일이 아니면 true 첨부파일이면 false
					일반필드목록.add(item.getString()); // 리스트 저장
				}else { // 첨부파일만
					// 9. 첨부파일 이름 식별이름 변경 
						// 1. 파일명에 공백인 존재하면 _로 변경[.replaceAll("기존문자","새로운문자") :  문자열 치환함수]
						// UUID : 범용 고유 식별자 [ 중복이 없는 식별자 만들기 ]
						// 최종식별 파일명 : UUID 파일명
					String filename = UUID.randomUUID()+" "+item.getName().replaceAll(" ", "_");
					파일필드목록.add(filename); // 첨부된 파일의 이름을 요청해서 리스트 저장
					// 7. 저장할 경로 +/+파일명의 파일을 객체화
					File 업로드할파일 = new File( 저장경로 +"/"+filename);
					// 8. 해당 파일에 item 업로드하기
					item.write(업로드할파일);
				} // if else e
			} // for e
			//
			// 제품 등록한 회원번호 가져오기
			int mno =  MemberDao.getInstance().getMno((String)request.getSession().getAttribute("login"));
			ProductDto dto = new ProductDto(일반필드목록.get(0), 일반필드목록.get(1), Integer.parseInt(일반필드목록.get(2)),
					일반필드목록.get(3), 일반필드목록.get(4),mno,파일필드목록);
			boolean result = ProductDao.getInstance().onwrite(dto);
			response.getWriter().print(result);
		} catch (Exception e) {
			System.out.println("post 오류 : " + e);
		}
		
		
		
		
		
		
		
		
		/* -- cos.jar 사용시
		
		String path = request.getSession().getServletContext().getRealPath("/product/pimg");
		MultipartRequest multi = new MultipartRequest(
				request,						// 1. 요청 방식
				path ,							// 2. 첨부파일을 가져와서 저장할 서버 내 폴더
				1024*1024*10,					// 3. 첨부파일의 허용 범위 용량 [ 바이트 단위 ] 10MB
				"UTF-8",						// 4. 첨부파일 한글 인코딩
				new DefaultFileRenamePolicy()	// 5. 동일한 첨부파일명이 있으면 뒤에 숫자를 붙여줌
				);
		
		String pname = multi.getParameter("pname");
		String pcomment = multi.getParameter("pcomment");
		int pprice = Integer.parseInt(multi.getParameter("pprice"));
		String plat = multi.getParameter("plat");
		String plng = multi.getParameter("plng");
		
		// 첨부파일 1개 이름 가져오기
		//String pfiles = multi.getFilesystemName("pfiles");
		//System.out.println("pfiles : " + pfiles);
		
		// 첨부파일 여러개 이름 가져오기
			// multipul input에 등록된 여러 사진들의 이름 가져오기 불가능 [ cos.jar 제공 X ] 
			// 다른 라이브러리 사용
		
		Enumeration pfiles = multi.getFileNames();
		while(pfiles.hasMoreElements()) { 	// 해당 목록에 요소가 존재하면 true / 없으면 false
			String s = (String)pfiles.nextElement();			// 다음요소 가져오기
			System.out.println("가져온 파일 이름 : " +  s);
		}
		
		ProductDto dto = new ProductDto(pname, pcomment, pprice, plat, plng);
		
		*/
		
		
		
	}

	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
