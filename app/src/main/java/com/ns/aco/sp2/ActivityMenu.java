package com.ns.aco.sp2;

import com.ns.aco.sp.common.util.UtilityBitmap;
import com.ns.aco.sp.common.util.UtilityFile;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ToggleButton;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static android.text.InputType.TYPE_CLASS_NUMBER;
import static android.widget.ImageView.ScaleType.CENTER_CROP;

public class ActivityMenu extends Activity {

	private List<QuestionList> _listQuestion = new ArrayList<QuestionList>();
    private LinearLayout _linearQuestion = null;
	private FrameLayout _flameImageIcon = null;
	private ImageView _imageAccount = null;
	private ImageView _imageAddMark = null;
	private EditText _editAccountName = null;
	private EditText _editAccount = null;
	private EditText _editMain = null;
	private EditText _editVotes = null;
	private EditText _editUpdateYear = null;
	private EditText _editUpdateMonth = null;
	private EditText _editUpdateDay = null;
	private EditText _editUpdateHour = null;
	private EditText _editUpdateMinute = null;
	private EditText _editCountReTweet = null;
	private EditText _editCountFavo = null;
	private Button _buttonPreview = null;
	private ToggleButton _toggleQuestion = null;
	private String _year = null;
	private String _month = null;
	private String _day = null;
	private String _hour = null;
	private String _minute = null;
	private int _getImageResult = 0;
	private Uri _imageAcountUri = null;
	private Bitmap _bitmapAccount = null;
	private String _filePath = null;
	private OperateDataBase _operateDB = null;

	public final static String _extraName1 = "acountName";
	public final static String _extraName2 = "acount";
	public final static String _extraName3 = "main";
	public final static String _extraName4 = "updateDate";
	public final static String _extraName5 = "countReTweet";
	public final static String _extraName6 = "countFavo";
	public final static String _extraName7 = "questionSwitch";
	public final static String _extraName8 = "question1Switch";
	public final static String _extraName9 = "question1";
	public final static String _extraName10 = "question1Votes";
	public final static String _extraName11 = "question2Switch";
	public final static String _extraName12 = "question2";
	public final static String _extraName13 = "question2Votes";
	public final static String _extraName14 = "question3Switch";
	public final static String _extraName15 = "question3";
	public final static String _extraName16 = "question3Votes";
	public final static String _extraName17 = "question4Switch";
	public final static String _extraName18 = "question4";
	public final static String _extraName19 = "question4Votes";
	public final static String _extraName20 = "votesCount";

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		// window がフォーカスを受けたときに常に soft input area を隠す
		getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

		// DB操作クラスのインスタンスを生成しDBをオープンする
		_operateDB = new OperateDataBase(getBaseContext());
		_operateDB.Open();
		try {
			_operateDB.createTable();
			_operateDB.initTbl_ACCOUNTNAME();
		} catch (IOException e) {
			e.printStackTrace();
		}
		// 前回入力したアカウント情報を取得
		String[] accountInfo = _operateDB.get_ACOUNTNAME();

		// タイトルバーを非表示にする
		requestWindowFeature(android.view.Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_menu_height);

		_flameImageIcon = (FrameLayout)findViewById(R.id.flameImageIcon);
		_imageAddMark = (ImageView)findViewById(R.id.imageAddMark);
        _linearQuestion = (LinearLayout)findViewById(R.id.linearQuestion);
		_imageAccount = (ImageView)findViewById(R.id.imageAccount);
		_editAccountName = (EditText)findViewById(R.id.editAcountName);
		_editAccount = (EditText)findViewById(R.id.editAccount);
		_editMain = (EditText)findViewById(R.id.editMain);
		_editVotes = (EditText)findViewById(R.id.editVotes);
		_editUpdateYear = (EditText)findViewById(R.id.editUpdateYear);
		_editUpdateMonth = (EditText)findViewById(R.id.editUpdateMonth);
		_editUpdateDay = (EditText)findViewById(R.id.editUpdateDay);
		_editUpdateHour = (EditText)findViewById(R.id.editUpdateHour);
		_editUpdateMinute = (EditText)findViewById(R.id.editUpdateMinute);
		_editCountReTweet = (EditText)findViewById(R.id.editCountReTweet);
		_editCountFavo = (EditText)findViewById(R.id.editCountFavo);
		_buttonPreview = (Button)findViewById(R.id.buttonPreview);
		_toggleQuestion = (ToggleButton)findViewById(R.id.toggleQuestion);

		_editVotes.setInputType(TYPE_CLASS_NUMBER);
		_editUpdateYear.setInputType(TYPE_CLASS_NUMBER);
		_editUpdateMonth.setInputType(TYPE_CLASS_NUMBER);
		_editUpdateDay.setInputType(TYPE_CLASS_NUMBER);
		_editCountReTweet.setInputType(TYPE_CLASS_NUMBER);
		_editCountFavo.setInputType(TYPE_CLASS_NUMBER);
		_editUpdateHour.setInputType(TYPE_CLASS_NUMBER);
		_editUpdateMinute.setInputType(TYPE_CLASS_NUMBER);

		if (accountInfo[1].trim().equals("")){
			_editAccountName.setHint("アカウント名");
		}else{
			_editAccountName.setHint(accountInfo[1]);
		}

		if (accountInfo[2].trim().equals("")){
			_editAccount.setHint("アカウント");
		}else{
			_editAccount.setHint(accountInfo[2]);
		}

		_editAccountName.setHintTextColor(Color.LTGRAY);
		_editAccount.setHintTextColor(Color.LTGRAY);
		_editMain.setHintTextColor(Color.LTGRAY);
		_editVotes.setHintTextColor(Color.LTGRAY);
		_editUpdateYear.setHintTextColor(Color.LTGRAY);
		_editUpdateMonth.setHintTextColor(Color.LTGRAY);
		_editUpdateDay.setHintTextColor(Color.LTGRAY);
		_editUpdateHour.setHintTextColor(Color.LTGRAY);
		_editUpdateMinute.setHintTextColor(Color.LTGRAY);
		_editCountReTweet.setHintTextColor(Color.LTGRAY);
		_editCountFavo.setHintTextColor(Color.LTGRAY);

		Date date = new Date();
		SimpleDateFormat year = new SimpleDateFormat("yyyy");
		SimpleDateFormat month = new SimpleDateFormat("MM");
		SimpleDateFormat day = new SimpleDateFormat("dd");
		SimpleDateFormat hour = new SimpleDateFormat("kk");
		SimpleDateFormat minute = new SimpleDateFormat("mm");

		_year = year.format(date);
		_month = month.format(date);
		_day = day.format(date);
		_hour = hour.format(date);
		_minute = minute.format(date);

		_editUpdateYear.setHint(_year);
		_editUpdateMonth.setHint(_month);
		_editUpdateDay.setHint(_day);
		_editUpdateHour.setHint(_hour);
		_editUpdateMinute.setHint(_minute);

		_imageAccount.setOnClickListener(imageViewClick);

		_toggleQuestion.setTextOn("ON");
		_toggleQuestion.setTextOff("OFF");
		_toggleQuestion.setChecked(true);
        _toggleQuestion.setOnCheckedChangeListener(questionlistener);
		_buttonPreview.setOnClickListener(previewListener);

        _listQuestion.add(new QuestionList(this));
        _listQuestion.add(new QuestionList(this));
        _listQuestion.add(new QuestionList(this));
        _listQuestion.add(new QuestionList(this));

        for (QuestionList question : _listQuestion) {
            _linearQuestion.addView(
                    question.get_selectView(),
                    new LinearLayout.LayoutParams(
                        ViewGroup.LayoutParams.WRAP_CONTENT,
                        0));
			question.get_selectView().setBackgroundColor(Color.LTGRAY);
			question.get_toggleEnable().setOnCheckedChangeListener(itemlistener);
			question.get_toggleEnable().setTextOn("ON");
			question.get_toggleEnable().setTextOff("OFF");
			question.get_toggleEnable().setChecked(true);
			question.get_editAnswer().setHintTextColor(Color.TRANSPARENT);
			question.get_editAnswer().setEnabled(false);
			question.get_editVotesPercent().setHintTextColor(Color.TRANSPARENT);
			question.get_editVotesPercent().setEnabled(false);
			question.get_editVotesPercent().setInputType(TYPE_CLASS_NUMBER);
        };

		_buttonPreview.requestFocus();

		// アカウント画像ファイルのパスを取得する
		_filePath = getString(R.string.image_directory) + getString(R.string.image_file);
	}

	private void setViewAfterFocuced(){
		Bitmap bitmapAccount = UtilityBitmap.getBitmapFromFile(_filePath);
		_imageAccount.setImageBitmap(bitmapAccount);
		_imageAccount.setScaleType(CENTER_CROP);
		_bitmapAccount = bitmapAccount;
	}

    @Override
    public void onResume() {
        super.onResume();
    }

	@Override
	public void onPause() {
		super.onPause();
	}

	// 画面の回転を抑止する
	public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);

		// 背景画像を設定
		 setViewAfterFocuced();
    }

	@Override
	public void onDestroy() {
		super.onDestroy();

		// DBをクローズする
		_operateDB.Close();
	}

    private OnCheckedChangeListener itemlistener = new OnCheckedChangeListener() {
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            if (isChecked) {
                for (QuestionList question : _listQuestion) {
                    if (question.get_toggleEnable() == buttonView){
						question.get_editAnswer().setEnabled(false);
						question.get_editAnswer().setHintTextColor(Color.TRANSPARENT);
						question.get_editAnswer().setTextColor(Color.TRANSPARENT);
						question.get_editVotesPercent().setEnabled(false);
						question.get_editVotesPercent().setHintTextColor(Color.TRANSPARENT);
						question.get_editVotesPercent().setTextColor(Color.TRANSPARENT);
						question.get_selectView().setBackgroundColor(Color.DKGRAY);
                    }
                };
            }else{
                for (QuestionList question : _listQuestion) {
                    if (question.get_toggleEnable() == buttonView){
						question.get_editAnswer().setEnabled(true);
						question.get_editAnswer().setHintTextColor(Color.LTGRAY);
						question.get_editAnswer().setTextColor(Color.BLACK);
						question.get_editVotesPercent().setEnabled(true);
						question.get_editVotesPercent().setHintTextColor(Color.LTGRAY);
						question.get_editVotesPercent().setTextColor(Color.BLACK);
						question.get_selectView().setBackgroundColor(Color.TRANSPARENT);
                    }
                };
            }
        }
    };

	// ImageViewクリック時の動作
	private View.OnClickListener previewListener = new View.OnClickListener() {
		public void onClick(View clickView) {
			// インテントのインスタンス生成
			Intent intent = new Intent(ActivityMenu.this, ActivityPreview.class);

			String accountName = null;
			if (_editAccountName.getText().toString().trim().equals("")) {
				accountName = _editAccountName.getHint().toString();
			}else{
				accountName = _editAccountName.getText().toString();
			};
			intent.putExtra(_extraName1, accountName);

			String account = null;
			if (_editAccount.getText().toString().trim().equals("")) {
				account = _editAccount.getHint().toString();
			}else{
				account = _editAccount.getText().toString();
			};
			intent.putExtra(_extraName2, account);

			// アカウント情報を保存
			_operateDB.update_ACOUNTNAME(accountName, account);

			if (_editMain.getText().toString().equals("")) {
				intent.putExtra(_extraName3, "");
			}else{
				intent.putExtra(_extraName3, _editMain.getText().toString());
			};

			String year = null;
			if (_editUpdateYear.getText().toString().equals("")) {
				year = _editUpdateYear.getHint().toString();
			}else{
				year = _editUpdateYear.getText().toString();
			};

			String month = null;
			if (_editUpdateMonth.getText().toString().equals("")) {
				month = _editUpdateMonth.getHint().toString();
			}else{
				month = _editUpdateMonth.getText().toString();
			};

			String day = null;
			if (_editUpdateDay.getText().toString().equals("")) {
				day = _editUpdateDay.getHint().toString();
			}else{
				day = _editUpdateDay.getText().toString();
			};

			String hour = null;
			if (_editUpdateHour.getText().toString().equals("")) {
				hour = _editUpdateHour.getHint().toString();
			}else{
				hour = _editUpdateHour.getText().toString();
			};

			String minute = null;
			if (_editUpdateMinute.getText().toString().equals("")) {
				minute = _editUpdateMinute.getHint().toString();
			}else{
				minute = _editUpdateMinute.getText().toString();
			};

			// 分のみ2桁固定の処理を行う
			minute = FormatNumTextValue(Integer.parseInt(minute), 0, 59);
			if (minute.length() < 2){
				minute = "0" + minute;
			}

			intent.putExtra(_extraName4, FormatNumTextValue(Integer.parseInt(year), 1, 9999)
										 + "年"
										 + FormatNumTextValue(Integer.parseInt(month), 1, 12)
										 + "月"
										 + FormatNumTextValue(Integer.parseInt(day), 1, 31)
										 + "日"
										 + " "
										 + FormatNumTextValue(Integer.parseInt(hour), 1, 23)
										 + ":"
										 + minute);

			String retweet = null;
			if ((_editCountReTweet.getText().toString().equals(""))){
				retweet = "";
			}else{
				if (Integer.parseInt(_editCountReTweet.getText().toString()) == 0){
					retweet = "";
				}else{
					retweet = String.valueOf(Integer.parseInt(_editCountReTweet.getText().toString()));
				}
			}
			intent.putExtra(_extraName5, retweet);

			String favo = null;
			if ((_editCountFavo.getText().toString().equals(""))){
				favo = "";
			}else{
				if (Integer.parseInt(_editCountFavo.getText().toString()) == 0){
					favo = "";
				}else{
					favo = String.valueOf(Integer.parseInt(_editCountFavo.getText().toString()));
				}
			}
			intent.putExtra(_extraName6, favo);

			intent.putExtra(_extraName7, _toggleQuestion.getText().toString());
			intent.putExtra(_extraName8, _listQuestion.get(0).get_toggleEnable().getText().toString());
			intent.putExtra(_extraName9, _listQuestion.get(0).get_editAnswer().getText().toString());
			if (_listQuestion.get(0).get_editVotesPercent().getText().toString().equals("")) {
				intent.putExtra(_extraName10, "0");
			}else{
				intent.putExtra(_extraName10, _listQuestion.get(0).get_editVotesPercent().getText().toString());
			};
			intent.putExtra(_extraName11, _listQuestion.get(1).get_toggleEnable().getText().toString());
			intent.putExtra(_extraName12, _listQuestion.get(1).get_editAnswer().getText().toString());
			if (_listQuestion.get(1).get_editVotesPercent().getText().toString().equals("")) {
				intent.putExtra(_extraName13, "0");
			}else{
				intent.putExtra(_extraName13, _listQuestion.get(1).get_editVotesPercent().getText().toString());
			};
			intent.putExtra(_extraName14, _listQuestion.get(2).get_toggleEnable().getText().toString());
			intent.putExtra(_extraName15, _listQuestion.get(2).get_editAnswer().getText().toString());
			if (_listQuestion.get(2).get_editVotesPercent().getText().toString().equals("")) {
				intent.putExtra(_extraName16, "0");
			}else{
				intent.putExtra(_extraName16, _listQuestion.get(2).get_editVotesPercent().getText().toString());
			};
			intent.putExtra(_extraName17, _listQuestion.get(3).get_toggleEnable().getText().toString());
			intent.putExtra(_extraName18, _listQuestion.get(3).get_editAnswer().getText().toString());
			if (_listQuestion.get(3).get_editVotesPercent().getText().toString().equals("")) {
				intent.putExtra(_extraName19, "0");
			}else{
				intent.putExtra(_extraName19, _listQuestion.get(3).get_editVotesPercent().getText().toString());
			};

			if (_editVotes.getText().toString().equals("")) {
				intent.putExtra(_extraName20, "0");
			}else{
				intent.putExtra(_extraName20, _editVotes.getText().toString());
			};

			if (_imageAcountUri != null){
				File file = new File(_filePath);

				// 存在するファイルは削除する
				if (file.exists()){
					file.delete();
				}

				_bitmapAccount = UtilityBitmap.getBitmapFromUri(ActivityMenu.this, _imageAcountUri);
				UtilityFile.copyFile(ActivityMenu.this, _imageAcountUri, file);
			}
			// アカウントのビットマップイメージを設定
			ActivityPreview.setAccountImage(_bitmapAccount);

			// 次画面のアクティビティ起動
			startActivity(intent);
			//finish();
		}
	};

	private View.OnClickListener imageViewClick = new View.OnClickListener() {
		@Override
		public void onClick(View v) {
			Intent intent = new Intent();
			intent.setType("image/*");
			intent.setAction(Intent.ACTION_GET_CONTENT);
			startActivityForResult(intent, _getImageResult);
		}
	};

    private OnCheckedChangeListener questionlistener = new OnCheckedChangeListener() {
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            if (isChecked) {
                for (QuestionList question : _listQuestion) {
                    question.get_selectView().setLayoutParams(
                        new LinearLayout.LayoutParams(
								LinearLayout.LayoutParams.WRAP_CONTENT,
                            	0));
                };
            }else{
                for (QuestionList question : _listQuestion) {
                    question.get_selectView().setLayoutParams(
                        new LinearLayout.LayoutParams(
								LinearLayout.LayoutParams.WRAP_CONTENT,
								LinearLayout.LayoutParams.WRAP_CONTENT));
                };
            }
        }
    };

	private String FormatNumTextValue(int num, int min, int max){
		if (num > max) {
			return String.valueOf(max);
		}else if  (num < min){
			return String.valueOf(min);
		}else{
			return String.valueOf(num);
		}
	}

	private String FormatNumTextValue(int num, int min, int max, int defaultNum){
		if (num > max) {
			return String.valueOf(defaultNum);
		}else if  (num < min){
			return String.valueOf(defaultNum);
		}else{
			return String.valueOf(num);
		}
	}

	protected void onActivityResult(int requestCode, int resultCode, Intent data){
		if (requestCode == _getImageResult && resultCode == RESULT_OK) {

			try {
				_imageAcountUri = data.getData();
				InputStream inStream = getContentResolver().openInputStream(data.getData());
				Bitmap bitmap = BitmapFactory.decodeStream(inStream);
				inStream.close();

				int height = _imageAccount.getHeight();
				int width = _imageAccount.getWidth();

				_flameImageIcon.removeAllViews();

				ImageView imageView = new ImageView(this);
				imageView.setLayoutParams(new FrameLayout.LayoutParams(height, width));
				imageView.setImageBitmap(bitmap);
				imageView.setScaleType(CENTER_CROP);
				imageView.setOnClickListener(imageViewClick);

				_flameImageIcon.addView(imageView);
				_flameImageIcon.addView(_imageAddMark);

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}