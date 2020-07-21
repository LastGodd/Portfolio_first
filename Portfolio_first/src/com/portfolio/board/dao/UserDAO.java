package com.portfolio.board.dao;

import java.sql.*;

import com.portfolio.board.vo.UserVO;

public class UserDAO {
	
	public static int join(UserVO param) {
		int result = 0;
		Connection con = null;
		PreparedStatement ps = null;

		String sql = " INSERT INTO t_board " 
				+ " (u_id, u_pw, u_nm, u_gender, u_email) " 
				+ " VALUES "
				+ " (?, ?, ?, ?, ?) ";

		try {
			con = DbCon.getCon();
			ps = con.prepareStatement(sql);
			ps.setNString(1, param.getU_id());
			ps.setNString(2, param.getU_pw());
			ps.setNString(3, param.getU_nm());
			ps.setNString(4, param.getU_gender());
			ps.setNString(5, param.getU_email());
			result = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbCon.close(con, ps);
		}
		return result;
	}
}
