package repository;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import kr.or.ddit.post.model.Post;
import kr.or.ddit.post.model.PostFile;
import kr.or.ddit.post.repository.IPostDao;
import kr.or.ddit.post.repository.PostDao;
import kr.or.ddit.util.MybatisUtil;

public class PostDaoTest {
	private static final Logger logger = LoggerFactory.getLogger(PostDaoTest.class);
	private IPostDao postDao;
	private SqlSession sqlSession;
	
	@Before
	public void setup() {
		logger.debug("before");
		postDao = new PostDao();
		sqlSession = MybatisUtil.getSession();
		
	}
	
	@After
	public void tearDown() {
		sqlSession.close();
	}
	
	
	
	
	/**
	 *
	 * Method : getPostListTest
	 * 작성자 : PC-12
	 * 변경이력 :
	 * @param sqlSession
	 * @param paramter
	 * @return
	 * Method 설명 : 게시판 번호에 맞는 게시글 출력
	 */
	@Test
	public void getPostListTest() {
		/***Given***/
		Map<String, Object> paramter = new HashMap<String, Object>();
        paramter.put("page", 1);
        paramter.put("pagesize", 10);
        paramter.put("boardNo",1 );

		/***When***/
		List<Post> postList = postDao.getPostList(sqlSession, paramter);
		/***Then***/
		assertEquals(10, postList.size());
	}
	/**
	 * 
	 * Method : getPostTest
	 * 작성자 : PC-12
	 * 변경이력 :
	 * Method 설명 : 게시글 상세정보 조회테스트
	 */
	@Test
	public void getPostTest() {
		/***Given***/
		int postNo = 10;

		/***When***/
		Post post = postDao.getPost(sqlSession, postNo);

		/***Then***/
		assertEquals("brown", post.getUserid());
		
	}
	/**
	 * Method : insertPostTest
	 * 작성자 : PC-12
	 * 변경이력 :
	 * Method 설명 : 글 새로 작성하기테스트
	 */
	@Test
	public void insertPostTest() {
		
		/***Given***/
		Post post = new Post();
		post.setBoardno(1);
		post.setPosttitle("테스트 게시글");
		post.setPostcontent("테스트 게시글");
		post.setUserid("sally");

		/***When***/
		int insertCnt = postDao.insertPost(sqlSession, post);
		sqlSession.commit();

		/***Then***/
		assertEquals(1, insertCnt);
		
	}
	/**
	 * Method : getPostNoTest
	 * 작성자 : PC-12
	 * 변경이력 :
	 * Method 설명 : 새로운 게시글의 게시글 번호 조회 테스트
	 */
	@Test
	public void getPostNoTest() {
		/***Given***/
		

		/***When***/
		int postNo = postDao.getPostNo(sqlSession);
		/***Then***/
		assertEquals(25, postNo);
	}
	/**
	 * 
	 * Method : deletePostTest
	 * 작성자 : PC-12
	 * 변경이력 :
	 * Method 설명 : 게시글 삭제 테스트
	 */
	@Test
	public void deletePostTest() {
		int postNo = 20;

		/***When***/
		int deletePost = postDao.deletePost(sqlSession, postNo);
		sqlSession.commit();

		/***Then***/
		assertEquals(1, deletePost);
	}
	
	
	
	/**
	 *
	 * Method : updatePostTest
	 * 작성자 : PC-12
	 * 변경이력 :
	 * Method 설명 : 게시글 수정 테스트
	 */
	@Test
	public void updatePostTest() {
		/***Given***/
		Post post = new Post();
		post.setPostno(20);
		post.setPosttitle("222");
		post.setPostcontent("22");

		/***When***/
		int updateCnt = postDao.updatePost(sqlSession, post);

		/***Then***/
		assertEquals(1, updateCnt);
	}
	
	

	
	
	
	
	
	
	
	
	
	

}
