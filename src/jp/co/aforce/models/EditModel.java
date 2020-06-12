package jp.co.aforce.models;

import java.sql.Connection;
import java.sql.PreparedStatement;

import jp.co.aforce.beans.MemberBean;
import jp.co.aforce.util.DBUtil;

public class EditModel {

	public int update(MemberBean memberBean) {
		int processingNumber = 0;
		String sql = "UPDATE members SET name = ?, age = ?, birth_year = ?, birth_month = ?, birth_day = ? WHERE member_no = ?";

		try (Connection conn = DBUtil.makeConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql)) {

			DBUtil.makeStatement();

            String member_no = memberBean.getMember_no();
			String name = memberBean.getName();
			int age = memberBean.getAge();
			int birth_year = memberBean.getBirth_year();
			int birth_month = memberBean.getBirth_month();
			int birth_day = memberBean.getBirth_day();

			// SQLを実行

			pstmt.setString(1, name);
			pstmt.setInt(2, age);
			pstmt.setInt(3, birth_year);
			pstmt.setInt(4, birth_month);
			pstmt.setInt(5, birth_day);
			pstmt.setString(6, member_no);

			processingNumber = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeConnection();
		}
		return processingNumber;

	}
}



