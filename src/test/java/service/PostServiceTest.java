package service;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.junit.Before;
import org.junit.Test;

import kr.or.ddit.post.model.Post;
import kr.or.ddit.post.service.IPostService;
import kr.or.ddit.post.service.PostService;

public class PostServiceTest {

	private IPostService postService;
	private SqlSession sqlSession;

	@Before
	public void setup() {
		postService = new PostService();
	}
	
	/**
	 *
	 * Method : getPostListTest
	 * 작성자 : PC-12
	 * 변경이력 :
	 * Method 설명 : 게시판 번호에 맞는 게시글 출력 테스트
	 */
	@Test
	public void getPostListTest() {
		/***Given***/
		Map<String, Object> paramter = new HashMap<String, Object>();
       paramter.put("page", 1);
       paramter.put("pagesize", 10);
       paramter.put("boardNo", 1);

		/***When***/
       List<Post> postList = postService.getPostList(paramter);

		/***Then***/
       assertEquals(10, postList.size());
	}
	
	/**
	 *
	 * Method : getPostTest
	 * 작성자 : PC-12
	 * 변경이력 :
	 * Method 설명 : 게시글 상세 정보 조회 테스트
	 */
	@Test
	public void getPostTest() {
		/***Given***/
		int postNo = 13;

		/***When***/
		Post post = postService.getPost(postNo);

		/***Then***/
		assertEquals("brown", post.getUserid());
	}
	
	/**
	 *
	 * Method : insertPostTest
	 * 작성자 : PC-12
	 * 변경이력 :
	 * Method 설명 : 새글작성
	 */
	@Test
	public void insertPostTest() {
		/***Given***/
		Post post = new Post();
		post.setBoardno(1);
		post.setPosttitle("테스트");
		post.setPostcontent("테스트글입니다");
		post.setUserid("brown");

		/***When***/
		int insertCnt = postService.insertPost(post);
		sqlSession.commit();

		/***Then***/
		assertEquals(1, insertCnt);
	}
	
	
	/**
	 *
	 * Method : getPostNoTest
	 * 작성자 : PC-12
	 * 변경이력 :
	 * Method 설명 : 신규 게시글의 게시글 번호 조회
	 */
	@Test
	public void getPostNoTest() {
		/***Given***/

		/***When***/
		int postNO = postService.getPostNo();

		/***Then***/
		assertEquals(40, postNO);
	}

	/**
	 *
	 * Method : deletePostTest
	 * 작성자 : PC-12
	 * 변경이력 :
	 * Method 설명 : 게시글 삭제
	 */
	@Test
	public void deletePostTest() {
		/***Given***/
		int postNo = 35;

		/***When***/
		int deletePost = postService.deletePost(postNo);

		/***Then***/
		assertEquals(1, deletePost);
	}
	
	/**
	 *
	 * Method : updatePostTest
	 * 작성자 : PC-12
	 * 변경이력 :
	 * Method 설명 : 게시글 수정
	 */
	@Test
	public void updatePostTest() {
		/***Given***/
		Post post = new Post();
		post.setPostno(1);
		post.setPosttitle("222");
		post.setPostcontent("22");

		/***When***/
		int updateCnt = postService.updatePost(post);

		/***Then***/
		assertEquals(1, updateCnt);
	}
	
	


}
