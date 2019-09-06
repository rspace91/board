package repository;


import static org.junit.Assert.assertEquals;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import kr.or.ddit.board.model.Board;
import kr.or.ddit.board.repository.BoardDao;
import kr.or.ddit.board.repository.IBoardDao;
import kr.or.ddit.util.MybatisUtil;

public class BoardDaoTest {
	private IBoardDao boardDao;
	private SqlSession sqlSession;

	@Before
	public void setup() {
		boardDao = new BoardDao();
		sqlSession = MybatisUtil.getSession();
		
	}

	@After
	public void tearDown() {
		sqlSession.close();
	}
	
	/**
	 * 
	 * Method : getBoardListTest
	 * 작성자 : PC-12
	 * 변경이력 :
	 * Method 설명 : 게시판 불러오기테스트
	 */
	@Test
	public void getBoardListTest() {
		/***Given***/

		/***When***/
		List<Board> boardList = boardDao.getBoardList(sqlSession);

		/***Then***/
		assertEquals(11, boardList.size());
	}

	
	
	/**
	 *
	 * Method : insertBoardTest
	 * 작성자 : PC-12
	 * 변경이력 :
	 * @param sqlSession
	 * @param board
	 * @return
	 * Method 설명 : 게시판 생성 테스트
	 */
	@Test
	public void insertBoardTest() {
		/***Given***/
		Board board = new Board();
		board.setBoardname("테스트 ");
		board.setUseyn(1);

		/***When***/
		int inserCnt = boardDao.insertBoard(sqlSession, board);
		sqlSession.commit();

		/***Then***/
		assertEquals(1, inserCnt);
	}
	
	
	@Test
	public void updateBoardTest() {
		/***Given***/
		Board board = new Board();
		board.setBoardno(7);
		board.setBoardname("테스트게시판");
		board.setUseyn(1);

		/***When***/
		int updateCnt = boardDao.updateBoard(sqlSession, board);
		sqlSession.commit();

		/***Then***/
		assertEquals(1, updateCnt);
	}
	
	
	

}
