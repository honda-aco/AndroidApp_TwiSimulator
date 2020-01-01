package com.ns.aco.sp2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;

import android.content.Context;
import android.content.res.AssetManager;
import com.ns.aco.sp.common.da.DatabaseAdapter;

public class OperateDataBase {
	private Context _context = null;
	private ArrayList<String[]> _sqlResult = null;
	private DatabaseAdapter _dbAdapter = null;
	private AssetManager _assetManager = null;
	private InputStream assetText = null;
	private final String _dbName;
	private final int _dbVersion;
	private final String _sqlFileCreateTbl = "50_Sql/01_CreateTable/01.txt";
	private final String _sqlFileDropTbl = "50_Sql/02_DropTable/01.txt";
	private Integer _recordCount = null;
	private Random _random = new Random();

	public OperateDataBase(Context context){
		_context = context;
		_dbName = _context.getString(R.string.db_name);
		_dbVersion = Integer.parseInt(context.getString(R.string.db_version));
		_dbAdapter = new DatabaseAdapter();

		// 頂点情報を格納したtextファイルを読込む
		_assetManager = context.getResources().getAssets();
	}

	public void Open(){
		_dbAdapter.open(_context, _dbName, _dbVersion);
	}

	public void Close(){
		_dbAdapter.close();
	}

	// テーブルの作成
	public boolean createTable() throws IOException{

		try {
			assetText = _assetManager.open(_sqlFileCreateTbl);
			BufferedReader bufText = new BufferedReader(new InputStreamReader(assetText));
			String[] sqlQuery = bufText.readLine().split(";");
			_dbAdapter.MultiExecuteSql(sqlQuery);
			return true;
		} catch (Exception e) {
			return false;
		} finally{
			assetText.close();
		}
	}

	// テーブルの削除
	public boolean dropTable() throws IOException{

		try {
			assetText = _assetManager.open(_sqlFileDropTbl);
			BufferedReader bufText = new BufferedReader(new InputStreamReader(assetText));
			String[] sqlQuery = bufText.readLine().split(";");
			_dbAdapter.MultiExecuteSql(sqlQuery);
			return true;
		} catch (Exception e) {
			return false;
		} finally{
			assetText.close();
		}
	}

	// ACCOUNTNAMEテーブルデータの初期化
	public void initTbl_ACCOUNTNAME(){
		boolean result = false;
		// キャラクタIDごとにレコードを取得する
		result = _dbAdapter.ExistsSelectSql(
				"SELECT ACCOUNTID, ACOUNTNAME, ACOUNT FROM ACCOUNTNAME WHERE ACCOUNTID = ?",
				new String[]{ "00001" });
		// レコードのないキャラクタIDに対してのみレコードを追加する
		if (result == false){
			_dbAdapter.ExecuteSql(
					"INSERT INTO ACCOUNTNAME (ACCOUNTID, ACOUNTNAME, ACOUNT) VALUES ( ?, '', '')",
					new Object[]{ "00001" });
		}
	}

	// ACCOUNTNAMEテーブルのデータを取得
	public String[] get_ACOUNTNAME(){
		// IDに対応するレコードを取得する
		_sqlResult = _dbAdapter.SelectSql(
				"SELECT ACCOUNTID, ACOUNTNAME, ACOUNT FROM ACCOUNTNAME WHERE ACCOUNTID = ?",
				new String[]{ "00001" },
				3);

		if (_sqlResult.size() > 0){
			return _sqlResult.get(0);
		}else{
			return new String[]{"00001", "", ""};
		}
	}

	// ACCOUNTNAMEテーブルの更新
	public boolean update_ACOUNTNAME(String accountName, String account){
		return _dbAdapter.ExecuteSql(
				"UPDATE ACCOUNTNAME SET ACOUNTNAME = ?, ACOUNT = ? WHERE ACCOUNTID = ?",
				new Object[]{ accountName, account, "00001"});
	}
}
