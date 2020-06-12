package jp.co.aforce.models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jp.co.aforce.beans.MemberBean;
import jp.co.aforce.util.DBUtil;

public class DisplayModel {

	public  MemberBean display(String member_no) {

		MemberBean memberBean = new MemberBean();

		String sql = "SELECT * FROM members WHERE member_no = ?";

		try (Connection conn = DBUtil.makeConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql)) {

			DBUtil.makeStatement();

			pstmt.setString(1, member_no);

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				memberBean.setMember_no(rs.getString("member_no"));
				memberBean.setName(rs.getString("name"));
				memberBean.setAge(rs.getInt("age"));
				memberBean.setBirth_year(rs.getInt("birth_year"));
				memberBean.setBirth_month(rs.getInt("birth_month"));
				memberBean.setBirth_day(rs.getInt("birth_day"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeConnection();
		}
		return memberBean;

	}

}
