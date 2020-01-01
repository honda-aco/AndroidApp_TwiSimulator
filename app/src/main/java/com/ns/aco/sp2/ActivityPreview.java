package com.ns.aco.sp2;

import com.ns.aco.sp.common.util.UtilityBitmap;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ActivityPreview extends Activity {

	private Boolean _processStart = true;

	private LinearLayout _linearCountPV = null;
	private LinearLayout _linearQuestion1PV = null;
	private LinearLayout _linearQuestion2PV = null;
	private LinearLayout _linearQuestion3PV = null;
	private LinearLayout _linearQuestion4PV = null;

	private ImageView _imageLeftArrow = null;
	private ImageView _imageSearch = null;
	private ImageView _imageFollowPV = null;
	private ImageView _imageAccount = null;
	private ImageView _imageIconReplyPV = null;
	private ImageView _imageIconRetweetPV = null;
	private ImageView _imageIconFavoritePV = null;
	private ImageView _imageIconMailPV = null;

	private TextView _textHeader = null;
	private TextView _textAcountNamePV = null;
	private TextView _textAcountPV = null;
	private TextView _textMainPV = null;
	private TextView _textUpdateDatePV = null;
	private TextView _textCountReTweetPV = null;
	private TextView _textCountFavoPV = null;
	private TextView _textReTweetPV = null;
	private TextView _textFavoPV = null;
	private TextView _textAccountReply = null;
	private ImageView _imageQuestionLeft1 = null;
	private ImageView _imageQuestionCenter1 = null;
	private ImageView _imageQuestionRight1 = null;
	private ImageView _imageQuestionLeft2 = null;
	private ImageView _imageQuestionCenter2 = null;
	private ImageView _imageQuestionRight2 = null;
	private ImageView _imageQuestionLeft3 = null;
	private ImageView _imageQuestionCenter3 = null;
	private ImageView _imageQuestionRight3 = null;
	private ImageView _imageQuestionLeft4 = null;
	private ImageView _imageQuestionCenter4 = null;
	private ImageView _imageQuestionRight4 = null;
	private TextView _textQuestion1PV = null;
	private TextView _textQuestion2PV = null;
	private TextView _textQuestion3PV = null;
	private TextView _textQuestion4PV = null;
	private TextView _textPercent1PV = null;
	private TextView _textPercent2PV = null;
	private TextView _textPercent3PV = null;
	private TextView _textPercent4PV = null;
	private TextView _textVotesCountPV = null;
	int _percent[] = null;

	private int _drawLeftArrow = 0;
	private int _drawSearch = 0;
	private int _drawSetting = 0;
	private int _drawFollowPV = 0;
	private int _drawAccount = 0;
	private int _drawIconReplyPV = 0;
	private int _drawIconRetweetPV = 0;
	private int _drawIconFavoritePV = 0;
	private int _drawIconMailPV = 0;

	private static Bitmap _bitmapAccount = null;

	public static void setAccountImage(Bitmap bitmap){
		_bitmapAccount = bitmap;
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		// タイトルバーを非表示にする
		requestWindowFeature(android.view.Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_preview_height);

		_linearCountPV = (LinearLayout) findViewById(R.id.linearCountPV);
		_linearQuestion1PV = (LinearLayout) findViewById(R.id.linearQuestion1PV);
		_linearQuestion2PV = (LinearLayout) findViewById(R.id.linearQuestion2PV);
		_linearQuestion3PV = (LinearLayout) findViewById(R.id.linearQuestion3PV);
		_linearQuestion4PV = (LinearLayout) findViewById(R.id.linearQuestion4PV);

		_imageAccount = (ImageView) findViewById(R.id.imageAccountPV);
		_imageLeftArrow = (ImageView) findViewById(R.id.imageLeftArrow);
		_imageSearch = (ImageView) findViewById(R.id.imageSearch);
		_imageIconReplyPV = (ImageView) findViewById(R.id.imageIconReplyPV);
		_imageIconRetweetPV = (ImageView) findViewById(R.id.imageIconRetweetPV);
		_imageIconFavoritePV = (ImageView) findViewById(R.id.imageIconFavoritePV);
		_imageIconMailPV = (ImageView) findViewById(R.id.imageIconMailPV);

		_textHeader = (TextView) findViewById(R.id.textHeader);
		_textAcountNamePV = (TextView) findViewById(R.id.textAcountNamePV);
		_textAcountPV = (TextView) findViewById(R.id.textAcountPV);
		_textMainPV = (TextView) findViewById(R.id.textMainPV);
		_textUpdateDatePV = (TextView) findViewById(R.id.textUpdateDatePV);
		_textCountReTweetPV = (TextView) findViewById(R.id.textCountReTweetPV);
		_textCountFavoPV = (TextView) findViewById(R.id.textCountFavoPV);
		_textReTweetPV = (TextView) findViewById(R.id.textReTweetPV);
		_textFavoPV = (TextView) findViewById(R.id.textFavoPV);
		_textAccountReply = (TextView) findViewById(R.id.textAccountReply);

		_imageQuestionLeft1 = (ImageView) findViewById(R.id.imageQuestionLeft1);
		_imageQuestionCenter1 = (ImageView) findViewById(R.id.imageQuestionCenter1);
		_imageQuestionRight1 = (ImageView) findViewById(R.id.imageQuestionRight1);
		_imageQuestionLeft2 = (ImageView) findViewById(R.id.imageQuestionLeft2);
		_imageQuestionCenter2 = (ImageView) findViewById(R.id.imageQuestionCenter2);
		_imageQuestionRight2 = (ImageView) findViewById(R.id.imageQuestionRight2);
		_imageQuestionLeft3 = (ImageView) findViewById(R.id.imageQuestionLeft3);
		_imageQuestionCenter3 = (ImageView) findViewById(R.id.imageQuestionCenter3);
		_imageQuestionRight3 = (ImageView) findViewById(R.id.imageQuestionRight3);
		_imageQuestionLeft4 = (ImageView) findViewById(R.id.imageQuestionLeft4);
		_imageQuestionCenter4 = (ImageView) findViewById(R.id.imageQuestionCenter4);
		_imageQuestionRight4 = (ImageView) findViewById(R.id.imageQuestionRight4);

		_textQuestion1PV = (TextView) findViewById(R.id.textQuestion1PV);
		_textQuestion2PV = (TextView) findViewById(R.id.textQuestion2PV);
		_textQuestion3PV = (TextView) findViewById(R.id.textQuestion3PV);
		_textQuestion4PV = (TextView) findViewById(R.id.textQuestion4PV);
		_textPercent1PV = (TextView) findViewById(R.id.textPercent1PV);
		_textPercent2PV = (TextView) findViewById(R.id.textPercent2PV);
		_textPercent3PV = (TextView) findViewById(R.id.textPercent3PV);
		_textPercent4PV = (TextView) findViewById(R.id.textPercent4PV);
		_textVotesCountPV = (TextView) findViewById(R.id.textVotesCountPV);

		_textCountReTweetPV.setTypeface(Typeface.DEFAULT_BOLD, Typeface.NORMAL);
		_textCountFavoPV.setTypeface(Typeface.DEFAULT_BOLD, Typeface.NORMAL);
		_textUpdateDatePV.setTypeface(Typeface.SANS_SERIF, Typeface.NORMAL);

		_drawLeftArrow = R.drawable.icon_leftarrow;
		_drawSearch = R.drawable.icon_search;
		_drawSetting = R.drawable.icon_setting;
		_drawIconReplyPV = R.drawable.icon_reply;
		_drawIconRetweetPV = R.drawable.icon_retweet;
		_drawIconFavoritePV = R.drawable.icon_favorite;
		_drawIconMailPV = R.drawable.icon_mail;

		Intent intent = getIntent();
		_textAcountNamePV.setText(intent.getStringExtra(ActivityMenu._extraName1));
		_textAcountNamePV.setGravity(Gravity.LEFT);
		_textAcountPV.setText("@" + intent.getStringExtra(ActivityMenu._extraName2));
		_textMainPV.setText(intent.getStringExtra(ActivityMenu._extraName3));
		_textUpdateDatePV.setText(intent.getStringExtra(ActivityMenu._extraName4));
		_textAccountReply.setText(_textAcountNamePV.getText().toString() + "さんに返信");

		String retweet = intent.getStringExtra(ActivityMenu._extraName5);
		String favorite = intent.getStringExtra(ActivityMenu._extraName6);

		// リツイート、お気に入り数を出すか
		if ((retweet.equals("")) && favorite.equals("")) {
			_linearCountPV.setLayoutParams(
					new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 0));
		}else if(retweet.equals("")){
			_textCountReTweetPV.setLayoutParams(
					new LinearLayout.LayoutParams(0, 0));
			_textReTweetPV.setLayoutParams(
					new LinearLayout.LayoutParams(0, 0));
		}else if(favorite.equals("")){
			_textCountFavoPV.setLayoutParams(
					new LinearLayout.LayoutParams(0, 0));
			_textFavoPV.setLayoutParams(
					new LinearLayout.LayoutParams(0, 0));
		}
		_textCountReTweetPV.setText(retweet);
		_textCountFavoPV.setText(favorite);

		// アンケートの背景画像を設定
		_imageQuestionLeft1.setImageDrawable(getResources().getDrawable(R.drawable.question_left1));
		_imageQuestionCenter1.setImageDrawable(getResources().getDrawable(R.drawable.question_center1));
		_imageQuestionRight1.setImageDrawable(getResources().getDrawable(R.drawable.question_right1));
		_imageQuestionLeft1.setScaleType(ImageView.ScaleType.FIT_XY);
		_imageQuestionCenter1.setScaleType(ImageView.ScaleType.FIT_XY);
		_imageQuestionRight1.setScaleType(ImageView.ScaleType.FIT_XY);

		_imageQuestionLeft2.setImageDrawable(getResources().getDrawable(R.drawable.question_left1));
		_imageQuestionCenter2.setImageDrawable(getResources().getDrawable(R.drawable.question_center1));
		_imageQuestionRight2.setImageDrawable(getResources().getDrawable(R.drawable.question_right1));
		_imageQuestionLeft2.setScaleType(ImageView.ScaleType.FIT_XY);
		_imageQuestionCenter2.setScaleType(ImageView.ScaleType.FIT_XY);
		_imageQuestionRight2.setScaleType(ImageView.ScaleType.FIT_XY);

		_imageQuestionLeft3.setImageDrawable(getResources().getDrawable(R.drawable.question_left1));
		_imageQuestionCenter3.setImageDrawable(getResources().getDrawable(R.drawable.question_center1));
		_imageQuestionRight3.setImageDrawable(getResources().getDrawable(R.drawable.question_right1));
		_imageQuestionLeft3.setScaleType(ImageView.ScaleType.FIT_XY);
		_imageQuestionCenter3.setScaleType(ImageView.ScaleType.FIT_XY);
		_imageQuestionRight3.setScaleType(ImageView.ScaleType.FIT_XY);

		_imageQuestionLeft4.setImageDrawable(getResources().getDrawable(R.drawable.question_left1));
		_imageQuestionCenter4.setImageDrawable(getResources().getDrawable(R.drawable.question_center1));
		_imageQuestionRight4.setImageDrawable(getResources().getDrawable(R.drawable.question_right1));
		_imageQuestionLeft4.setScaleType(ImageView.ScaleType.FIT_XY);
		_imageQuestionCenter4.setScaleType(ImageView.ScaleType.FIT_XY);
		_imageQuestionRight4.setScaleType(ImageView.ScaleType.FIT_XY);

		_percent = new int[]{
				Integer.parseInt(intent.getStringExtra(ActivityMenu._extraName10)),
				Integer.parseInt(intent.getStringExtra(ActivityMenu._extraName13)),
				Integer.parseInt(intent.getStringExtra(ActivityMenu._extraName16)),
				Integer.parseInt(intent.getStringExtra(ActivityMenu._extraName19))};

		int maxNum = 0;
		for (int i = 0; i < _percent.length; i++){
			if (maxNum < _percent[i]){
				maxNum = _percent[i];
			}
		}

		if (intent.getStringExtra(ActivityMenu._extraName7).equals("OFF")){
			if (intent.getStringExtra(ActivityMenu._extraName8).equals("OFF")){
				String question = intent.getStringExtra(ActivityMenu._extraName9);
				if (question.length() > 16){
					question = question.substring(0, 16) + "…";
				}
				_textQuestion1PV.setText(question);
				_textPercent1PV.setText(String.valueOf(_percent[0]) + "%");
				if (maxNum == _percent[0]){
					_imageQuestionLeft1.setImageDrawable(getResources().getDrawable(R.drawable.question_left2));
					_imageQuestionCenter1.setImageDrawable(getResources().getDrawable(R.drawable.question_center2));
					_imageQuestionRight1.setImageDrawable(getResources().getDrawable(R.drawable.question_right2));
					_textPercent1PV.setTypeface(Typeface.DEFAULT_BOLD, Typeface.NORMAL);
				}
			}else{
				_linearQuestion1PV.setLayoutParams(
						new LinearLayout.LayoutParams(0, 0));
			}

			if (intent.getStringExtra(ActivityMenu._extraName11).equals("OFF")){
				String question = intent.getStringExtra(ActivityMenu._extraName12);
				if (question.length() > 16){
					question = question.substring(0, 16) + "…";
				}
				_textQuestion2PV.setText(question);
				_textPercent2PV.setText(String.valueOf(_percent[1]) + "%");
				if (maxNum == _percent[1]){
					_imageQuestionLeft2.setImageDrawable(getResources().getDrawable(R.drawable.question_left2));
					_imageQuestionCenter2.setImageDrawable(getResources().getDrawable(R.drawable.question_center2));
					_imageQuestionRight2.setImageDrawable(getResources().getDrawable(R.drawable.question_right2));
					_textPercent2PV.setTypeface(Typeface.DEFAULT_BOLD, Typeface.NORMAL);
				}
			}else{
				_linearQuestion2PV.setLayoutParams(
						new LinearLayout.LayoutParams(0, 0));
			}

			if (intent.getStringExtra(ActivityMenu._extraName14).equals("OFF")){
				String question = intent.getStringExtra(ActivityMenu._extraName15);
				if (question.length() > 16){
					question = question.substring(0, 16) + "…";
				}
				_textQuestion3PV.setText(question);
				_textPercent3PV.setText(String.valueOf(_percent[2]) + "%");
				if (maxNum == _percent[2]){
					_imageQuestionLeft3.setImageDrawable(getResources().getDrawable(R.drawable.question_left2));
					_imageQuestionCenter3.setImageDrawable(getResources().getDrawable(R.drawable.question_center2));
					_imageQuestionRight3.setImageDrawable(getResources().getDrawable(R.drawable.question_right2));
					_textPercent3PV.setTypeface(Typeface.DEFAULT_BOLD, Typeface.NORMAL);
				}
			}else{
				_linearQuestion3PV.setLayoutParams(
						new LinearLayout.LayoutParams(0, 0));
			}

			if (intent.getStringExtra(ActivityMenu._extraName17).equals("OFF")){
				String question = intent.getStringExtra(ActivityMenu._extraName18);
				if (question.length() > 16){
					question = question.substring(0, 16) + "…";
				}
				_textQuestion4PV.setText(question);
				_textPercent4PV.setText(String.valueOf(_percent[3]) + "%");
				if (maxNum == _percent[3]){
					_imageQuestionLeft4.setImageDrawable(getResources().getDrawable(R.drawable.question_left2));
					_imageQuestionCenter4.setImageDrawable(getResources().getDrawable(R.drawable.question_center2));
					_imageQuestionRight4.setImageDrawable(getResources().getDrawable(R.drawable.question_right2));
					_textPercent4PV.setTypeface(Typeface.DEFAULT_BOLD, Typeface.NORMAL);
				}
			}else{
				_linearQuestion4PV.setLayoutParams(
						new LinearLayout.LayoutParams(0, 0));
			}

			int votesCount = Integer.parseInt(intent.getStringExtra(ActivityMenu._extraName20));
			_textVotesCountPV.setText(String.valueOf(votesCount) + "票・最終結果");

		}else{
			_linearQuestion1PV.setLayoutParams(
					new LinearLayout.LayoutParams(0, 0));
			_linearQuestion2PV.setLayoutParams(
					new LinearLayout.LayoutParams(0, 0));
			_linearQuestion3PV.setLayoutParams(
					new LinearLayout.LayoutParams(0, 0));
			_linearQuestion4PV.setLayoutParams(
					new LinearLayout.LayoutParams(0, 0));
			_textVotesCountPV.setLayoutParams(
					new LinearLayout.LayoutParams(0, 0));
		}
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

		if (_processStart){
			// 背景画像を設定
			setViewAfterFocuced();
			_processStart = false;
		}
	}

	private void setViewAfterFocuced(){
		// アカウント画像を設定
		if (_bitmapAccount != null){
			Bitmap bitmapAccount = UtilityBitmap.trimSquare(_bitmapAccount);
			_imageAccount.setImageBitmap(UtilityBitmap.getCroppedBitmap(bitmapAccount));
		}

		ImageView[] imageQuestionList = new ImageView[]{
				_imageQuestionCenter1,
				_imageQuestionCenter2,
				_imageQuestionCenter3,
				_imageQuestionCenter4};

		for (int i = 0; i < _percent.length; i++){
			if (_percent[i] >= 0 && _percent[i] < 100){
				int width = (imageQuestionList[i].getWidth() * _percent[i]) / 100;
				int height = imageQuestionList[i].getHeight();

				LinearLayout.LayoutParams param = new LinearLayout.LayoutParams(width, height);
				DisplayMetrics metrics = this.getResources().getDisplayMetrics();

				if (i == 0){
					param.setMargins(0, (int)(13 * metrics.density), 0, (int)(2 * metrics.density));
				}else{
					param.setMargins(0, (int)(3 * metrics.density), 0, (int)(2 * metrics.density));
				}
				imageQuestionList[i].setLayoutParams(param);
				imageQuestionList[i].requestLayout();
			}
		}
    }

	@Override
	public void onDestroy() {
		super.onDestroy();
	}

//	private void setBitmapResize(ImageView imageView, int drawableId){
//		Bitmap bitmap = UtilityImageView.getBitmapSize(
//				getApplicationContext(),
//				drawableId,
//				imageView.getWidth(),
//				imageView.getHeight()
//		);
//		bitmap = Bitmap.createScaledBitmap(bitmap, imageView.getWidth(), imageView.getHeight(), false);
//		imageView.setImageBitmap(bitmap);
//		imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
//	}
}