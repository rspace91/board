package kr.or.ddit.post.repository;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.post.model.Post;
import kr.or.ddit.post.model.PostFile;

public interface IPostDao {

	/**
	 *
	 * Method : getPostList
	 * 작성자 : PC-12
	 * 변경이력 :
	 * @param sqlSession
	 * @param paramter
	 * @return
	 * Method 설명 : 게시판 번호에 맞는 게시글 출력
	 */
	List<Post> getPostList(SqlSession sqlSession, Map<String, Object> paramter);

	/**
	 *
	 * Method : getPost
	 * 작성자 : PC-12
	 * 변경이력 :
	 * @param sqlSession
	 * @param postNo
	 * @return
	 * Method 설명 : 게시글 상세 정보 조회
	 */
	Post getPost(SqlSession sqlSession, int postNo);

	/**
	 *
	 * Method : insertPost
	 * 작성자 : PC-12
	 * 변경이력 :
	 * @param sqlSession
	 * @param post
	 * @return
	 * Method 설명 : 새글작성
	 */
	int insertPost(SqlSession sqlSession, Post post);

	/**
	 *
	 * Method : getPostNo
	 * 작성자 : PC-12
	 * 변경이력 :
	 * @param sqlSession
	 * @return
	 * Method 설명 : 신규 게시글의 게시글 번호 조회
	 */
	int getPostNo(SqlSession sqlSession);

	/**
	 *
	 * Method : deletePost
	 * 작성자 : PC-12
	 * 변경이력 :
	 * @param sqlSession
	 * @param postNo
	 * @return
	 * Method 설명 : 게시글 삭제
	 */
	int deletePost(SqlSession sqlSession, int postNo);

	/**
	 *
	 * Method : insertPostFile
	 * 작성자 : PC-12
	 * 변경이력 :
	 * @param sqlSession
	 * @param postFile
	 * @return
	 * Method 설명 : 게시글 작성 시 파일 저장
	 */
	int insertPostFile(SqlSession sqlSession, PostFile postFile);

	/**
	 *
	 * Method : getPostFileList
	 * 작성자 : PC-12
	 * 변경이력 :
	 * @param sqlSession
	 * @param postNo
	 * @return
	 * Method 설명 : 게시글 번호에 맞는 파일 조회
	 */
	List<PostFile> getPostFileList(SqlSession sqlSession, int postNo);

	/**
	 *
	 * Method : updatePost
	 * 작성자 : PC-12
	 * 변경이력 :
	 * @param sqlSession
	 * @param post
	 * @return
	 * Method 설명 : 게시글 수정
	 */
	int updatePost(SqlSession sqlSession, Post post);

	/**
	 *
	 * Method : deleteFile
	 * 작성자 : PC-12
	 * 변경이력 :
	 * @param sqlSession
	 * @param fileNo
	 * @return
	 * Method 설명 : 파일 삭제
	 */
	int deleteFile(SqlSession sqlSession, int fileNo);

	/**
	 *
	 * Method : getPostTotalCnt
	 * 작성자 : PC-12
	 * 변경이력 :
	 * @param sqlSession
	 * @param boardNo
	 * @return
	 * Method 설명 : 전체 게시글 건수 조회
	 */
	int getPostTotalCnt(SqlSession sqlSession, int boardNo);

	/**
	 *
	 * Method : getPostFile
	 * 작성자 : PC-12
	 * 변경이력 :
	 * @param sqlSession
	 * @param fileNo
	 * @return
	 * Method 설명 : 선택한 파일 정보 조히
	 */
	PostFile getPostFile(SqlSession sqlSession, int fileNo);

}
