package org.zerock.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zerock.domain.BoardVO;
import org.zerock.mapper.BoardMapper;

import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
@AllArgsConstructor
public class BoardServiceImpl implements BoardService{
	//spring 4.3 이상에서 자동 처리
	
	@Setter(onMethod_ = @Autowired)
	private BoardMapper mapper;
	
	@Override
	public void register(BoardVO board) {
		log.info("register........." + board);
		mapper.insertSelectKey(board);
	}

	@Override
	public BoardVO get(Long bno) {
		log.info("register........." + bno);
		return mapper.read(bno);
	}

	@Override
	public boolean modify(BoardVO board) {
		return false;
	}

	@Override
	public boolean remove(Long bno) {
		return false;
	}

	@Override
	public List<BoardVO> getList() {
		log.info("getList.........");
		return mapper.getList();
	}
}
