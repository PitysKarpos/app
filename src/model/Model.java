package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Model {

	private Map<String, User> userMap = new HashMap<>();
	private List<User> userMapList = new ArrayList<>();

	//データ一覧表のためのMap
	public void searchData() {
		try {
			//↓↓データベースに対する処理
			System.out.println("読み込めたよ");
			String sql = "SELECT id,name,addr,tell,age FROM person_info ";

			PreparedStatement pstmt = DbAccess.conn.prepareStatement(sql);

			System.out.println("おああああああああ");
			ResultSet rset = pstmt.executeQuery();

			System.out.println("よいしょー！");
			System.out.println(rset);
			while (rset.next()) {
				User user = new User();
				int id = rset.getInt("ID");
				String name = rset.getString("NAME");
				String addr = rset.getString("ADDR");
				String tel = rset.getString("TELL");
				String age = rset.getString("AGE");
				String num = String.valueOf(id);
				user.setId(num);
				user.setName(name);
				user.setAddr(addr);
				user.setTell(tel);
				user.setAge(age);
				userMap.put(user.getName(), user);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	//コントローラーに呼び出される前提のメソッド
	public User searchUser(String name) {
		return userMap.get(name);

	}

	//名前を一覧表示するためのリスト
	public void userData() {

		try {
			//↓↓データベースに対する処理
			System.out.println("読み込めたよ");
			String sql = "SELECT id,name,addr,tell,age FROM person_info WHERE act=1";

			PreparedStatement pstmt = DbAccess.conn.prepareStatement(sql);

			System.out.println("おああああああああ");
			ResultSet rset = pstmt.executeQuery();

			System.out.println("よいしょー！");
			System.out.println(rset);
			while (rset.next()) {
				User user = new User();
				int id = rset.getInt("ID");
				String num = String.valueOf(id);
				String name = rset.getString("NAME");
				String addr = rset.getString("ADDR");
				String tel = rset.getString("TELL");
				String age = rset.getString("AGE");
				user.setId(num);
				user.setName(name);
				user.setAddr(addr);
				user.setTell(tel);
				user.setAge(age);
				userMapList.add(user);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	//userMapListを他でも使えるように
	public List<User> getUsers() {
		return userMapList;
	}

	//DELETE画面で一覧表示する名前
	public void actData() {
		try {
			//↓↓データベースに対する処理
			System.out.println("読み込めたよ");
			String sql = "SELECT id,name,addr,tell,age FROM person_info WHERE act=0";

			PreparedStatement pstmt = DbAccess.conn.prepareStatement(sql);

			System.out.println("おああああああああ");
			ResultSet rset = pstmt.executeQuery();

			System.out.println("よいしょー！");
			System.out.println(rset);
			while (rset.next()) {
				User user = new User();
				int id = rset.getInt("ID");
				String num = String.valueOf(id);
				String name = rset.getString("NAME");
				String addr = rset.getString("ADDR");
				String tel = rset.getString("TELL");
				String age = rset.getString("AGE");
				user.setId(num);
				user.setName(name);
				user.setAddr(addr);
				user.setTell(tel);
				user.setAge(age);
				userMapList.add(user);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	//	//userMapを他でも使えるように
	//	public Map<String, User> getAllUsers() {
	//		return userMap;
	//
	//	}

	//登録画面(INSERT)用のメソッド
	public void insertUser(String name, String addr, String tell, String age) {
		try {
			//↓↓データベースに対する処理
			System.out.println("読み込めたよ");
			String sql = "INSERT INTO person_info (name,addr,tell,age) VALUES(?,?,?,?)";

			PreparedStatement pstmt = DbAccess.conn.prepareStatement(sql);

			pstmt.setString(1, name);
			pstmt.setString(2, addr);
			pstmt.setString(3, tell);
			pstmt.setString(4, age);

			//INSERT文を実行する
			int i = pstmt.executeUpdate();

			//処理件数を表示する
			System.out.println("結果：" + i);
			System.out.print("登録完了");

			pstmt.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	//削除（論理削除）用のメソッド
	public void lojicDelete(String name) {
		try {
			String sql = "UPDATE person_info SET act = ? WHERE name = ?";

			PreparedStatement pstmt = DbAccess.conn.prepareStatement(sql);

			pstmt.setInt(1, 0);
			pstmt.setString(2, name);

			//UPDATE文を実行する
			int num = pstmt.executeUpdate();

			//処理件数を表示する
			System.out.println("結果：" + num);
			System.out.print("論理削除");

			pstmt.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	//削除（物理削除）用のメソッド
	public void physicsDelete(String name) {
		try {
			String sql = "DELETE FROM person_info WHERE act=? AND name=? LIMIT 1";

			PreparedStatement pstmt = DbAccess.conn.prepareStatement(sql);

			pstmt.setInt(1, 0);
			pstmt.setString(2, name);

			//DELETE文を実行する
			int num = pstmt.executeUpdate();

			//処理件数を表示する
			System.out.println("結果：" + num);
			System.out.print("物理削除");

			pstmt.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	//更新（UPDATE）用のメソッド
	public void updateSql(String name, String addr) {
		try {
			String sql = "UPDATE person_info SET addr = ? WHERE name = ?";

			PreparedStatement pstmt = DbAccess.conn.prepareStatement(sql);

			pstmt.setString(1, addr);
			pstmt.setString(2, name);

			//UPDATE文を実行する
			int num = pstmt.executeUpdate();

			//処理件数を表示する
			System.out.println("結果：" + num);
			System.out.print("更新できた！");

			pstmt.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}