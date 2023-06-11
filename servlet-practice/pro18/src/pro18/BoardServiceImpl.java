package pro18;

public class BoardServiceImpl implements BoardService {

	BoardDAO boardDAO;
	public BoardService() {
		boardDAO = new BoardOracleDAOImpl();
	}
}
