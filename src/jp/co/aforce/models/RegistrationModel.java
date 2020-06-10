package jp.co.aforce.models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.util.Date;

import jp.co.aforce.beans.MemberBean;
import jp.co.aforce.util.DBUtil;

public class RegistrationModel {

	public int insert(MemberBean memberBean) {
		int processingNumber = 0;
		String sql = "INSERT INTO members VALUES(?,?,?,?,?,?)";

		try (Connection conn = DBUtil.makeConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql)) {

			DBUtil.makeStatement();

			String name = memberBean.getName();
			int age = memberBean.getAge();
			int birth_year = memberBean.getBirth_year();
			int birth_month = memberBean.getBirth_month();
			int birth_day = memberBean.getBirth_day();

			// SQLを実行

			Date date = new Date();
			SimpleDateFormat df = new SimpleDateFormat("yyMMddHHmmss");
			String member_no = df.format(date);

			pstmt.setString(1, "A"+ member_no);
			pstmt.setString(2, name);
			pstmt.setInt(3, age);
			pstmt.setInt(4, birth_year);
			pstmt.setInt(5, birth_month);
			pstmt.setInt(6, birth_day);

			processingNumber = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			//DBUtil.closeConnection();
		}
		return processingNumber;

	}
}
